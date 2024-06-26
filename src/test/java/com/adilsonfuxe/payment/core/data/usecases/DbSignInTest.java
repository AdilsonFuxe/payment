package com.adilsonfuxe.payment.core.data.usecases;

import com.adilsonfuxe.payment.core.data.porters.out.cryptography.Encrypt;
import com.adilsonfuxe.payment.core.data.porters.out.cryptography.PasswordHashCompare;
import com.adilsonfuxe.payment.core.data.porters.out.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.models.enums.Role;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignInParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.UUID;

@DisplayName("Test SignIn use case")
public class DbSignInTest {
  @Mock
  FindUserByEmailRepository findUserByEmailRepository;
  @Mock
  PasswordHashCompare passwordHashCompare;
  @Mock
  Encrypt encrypt;

  @InjectMocks
  DbSignIn dbSignIn;

  @BeforeEach
  void init_mocks() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  @DisplayName("Should call findUserByEmailRepository with correct email")
  void testFindUserByEmailRepository() {
     var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    dbSignIn.signIn(signUpParams);
    Mockito.verify(findUserByEmailRepository).findByEmail(signUpParams.getEmail());
  }

  @Test
  @DisplayName("Should return null if findUserByEmailRepository returns null")
  void testFindUserByEmailRepositoryReturnNull() {
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    Mockito.when(findUserByEmailRepository.findByEmail(signUpParams.getEmail())).thenReturn(null);

    var result = dbSignIn.signIn(signUpParams);
    Assertions.assertNull(result);
  }

  @Test
  @DisplayName("Should call passwordHashCompare with correct params")
  void  testPasswordHashCompareWasCalledWithCorrectParams(){
    var user = mockUserData();
    user.setPassword("any_hashed_password");
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    Mockito.when(findUserByEmailRepository.findByEmail(signUpParams.getEmail())).thenReturn(user);

    dbSignIn.signIn(signUpParams);
    Mockito.verify(passwordHashCompare).hashCompare(signUpParams.getPassword(), user.getPassword());
  }

  @Test
  @DisplayName("Should return null if passwordHashCompare return false")
  void testPasswordHashCompareReturnFalse() {
    var user = Mockito.mock(User.class);
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    Mockito.when(findUserByEmailRepository.findByEmail(signUpParams.getEmail())).thenReturn(user);
    Mockito.when(passwordHashCompare.hashCompare(signUpParams.getPassword(), user.getPassword())).thenReturn(false);
    var result = dbSignIn.signIn(signUpParams);
    Assertions.assertNull(result);
  }

  @Test
  @DisplayName("Should call Encrypt with correct userId")
  void testCallEncryptWithCorrectUserId(){
    var user = mockUserData();
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    Mockito.when(findUserByEmailRepository.findByEmail(signUpParams.getEmail())).thenReturn(user);
    Mockito.when(passwordHashCompare.hashCompare(signUpParams.getPassword(), user.getPassword())).thenReturn(true);
    dbSignIn.signIn(signUpParams);
    Mockito.verify(encrypt).encrypt(user.getId().toString());
  }

  @Test
  @DisplayName("Should return a JWT accessToken on success")
  void testDbSignInReturnTokenOnSuccess() {
    var user = mockUserData();
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    Mockito.when(findUserByEmailRepository.findByEmail(signUpParams.getEmail())).thenReturn(user);
    Mockito.when(passwordHashCompare.hashCompare(signUpParams.getPassword(), user.getPassword())).thenReturn(true);
    Mockito.when(encrypt.encrypt(user.getId().toString())).thenReturn("any_token");
    var result = dbSignIn.signIn(signUpParams);
    Assertions.assertSame("any_token", result);
  }



  User mockUserData() {
    return  User.builder()
        .id(UUID.randomUUID())
        .firstName("any_first_name")
        .lastName("any_last_name")
        .email("any_mail@mail.com")
        .password("any_hashed_password")
        .role(Role.User)
        .phone("any_phone")
        .createdAt(new Date().toInstant())
        .updatedAt(new Date().toInstant())
        .build();
  }

}
