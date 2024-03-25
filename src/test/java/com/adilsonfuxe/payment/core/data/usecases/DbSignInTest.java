package com.adilsonfuxe.payment.core.data.usecases;

import com.adilsonfuxe.payment.core.data.protocols.cryptography.Encrypt;
import com.adilsonfuxe.payment.core.data.protocols.cryptography.PasswordHashCompare;
import com.adilsonfuxe.payment.core.data.protocols.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.models.enums.Role;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignInParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
    Mockito.when(findUserByEmailRepository.findByEmail(String.valueOf(String.class))).thenReturn(null);
    var signUpParams = new SignInParams(
        "any_email@mail.com",
        "any_password"
    );
    var result = dbSignIn.signIn(signUpParams);
    Assertions.assertNull(result);
  }
}
