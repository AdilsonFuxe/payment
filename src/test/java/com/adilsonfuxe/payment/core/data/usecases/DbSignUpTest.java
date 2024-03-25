package com.adilsonfuxe.payment.core.data.usecases;

import com.adilsonfuxe.payment.core.data.porters.out.cryptography.PasswordHash;
import com.adilsonfuxe.payment.core.data.porters.out.repositories.AddUserRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignUpParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@DisplayName("Test SignUp use case")
public class DbSignUpTest {
  @Mock
  PasswordHash passwordHash;
  @Mock
  AddUserRepository addUserRepository;
  @InjectMocks
  DbSignUp dbSignUp;

  @BeforeEach
  void init_mocks() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should call HashPassword with correct param")
  void testCallHashPasswordWithCorrectParam(){
    var params = SignUpParams.builder()
        .firstName("any_first_name")
        .lastName("any_last_name")
        .email("any_email@mail.com")
        .password("any_password")
        .phone("any_phone")
        .build();

    dbSignUp.signUp(params);
    Mockito.verify(passwordHash).hashPassword(params.getPassword());
  }

  @Test
  @DisplayName("Should call addUserRepository with correct params")
  void testCallAddUserRepositoryWithCorrectParams(){
    var params = SignUpParams.builder()
        .firstName("any_first_name")
        .lastName("any_last_name")
        .email("any_email@mail.com")
        .password("any_password")
        .phone("any_phone")
        .build();
    String hashedPassword = "any_hashed_password";
    Mockito.when(passwordHash.hashPassword(params.getPassword())).thenReturn(hashedPassword);
    dbSignUp.signUp(params);
    var serializedSignupParams = SignUpParams.builder()
        .firstName("any_first_name")
        .lastName("any_last_name")
        .email("any_email@mail.com")
        .password(hashedPassword)
        .phone("any_phone")
        .build();
    Mockito.verify(addUserRepository).AddUser(serializedSignupParams);
  }

  @Test
  @DisplayName("Should return a new User on success signup")
  void testReturnUserOnSuccessSignUp() {
    var user = Mockito.mock(User.class);
    var params = SignUpParams.builder()
        .firstName("any_first_name")
        .lastName("any_last_name")
        .email("any_email@mail.com")
        .password("any_password")
        .phone("any_phone")
        .build();
    Mockito.when(addUserRepository.AddUser(Mockito.any(SignUpParams.class))).thenReturn(user);
    var result = dbSignUp.signUp(params);
    Assertions.assertSame(user, result);
  }
}
