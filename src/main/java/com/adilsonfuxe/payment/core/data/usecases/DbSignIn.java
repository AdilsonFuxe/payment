package com.adilsonfuxe.payment.core.data.usecases;

import com.adilsonfuxe.payment.core.data.protocols.cryptography.Encrypt;
import com.adilsonfuxe.payment.core.data.protocols.cryptography.PasswordHashCompare;
import com.adilsonfuxe.payment.core.data.protocols.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignIn;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignInParams;


public class DbSignIn implements SignIn {
  private final FindUserByEmailRepository findUserByEmailRepository;
  private final PasswordHashCompare passwordHashCompare;
  private final Encrypt encrypt;

  public DbSignIn(FindUserByEmailRepository findUserByEmailRepository, PasswordHashCompare passwordHashCompare, Encrypt encrypt) {
    this.findUserByEmailRepository = findUserByEmailRepository;
    this.passwordHashCompare = passwordHashCompare;
    this.encrypt = encrypt;
  }

  @Override
  public String signIn(SignInParams params) {
    var user = findUserByEmailRepository.findByEmail(params.getEmail());
    if (user != null) {
      boolean isValid = passwordHashCompare.hashCompare(params.getPassword(), user.getPassword());
      if (isValid) {
        return encrypt.encrypt(user.getId().toString());
      }
    }
    return null;
  }
}
