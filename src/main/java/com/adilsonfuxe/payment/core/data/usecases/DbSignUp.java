package com.adilsonfuxe.payment.core.data.usecases;

import com.adilsonfuxe.payment.core.data.protocols.cryptography.PasswordHash;
import com.adilsonfuxe.payment.core.data.protocols.repositories.AddUserRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignUp;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignUpParams;

public class DbSignUp implements SignUp {
  private final PasswordHash passwordHash;
  private final AddUserRepository addUserRepository;

  public DbSignUp(PasswordHash passwordHash, AddUserRepository addUserRepository) {
    this.passwordHash = passwordHash;
    this.addUserRepository = addUserRepository;
  }

  @Override
  public User signUp(SignUpParams params) {
    String hashedPassword = passwordHash.hashPassword(params.getPassword());
    return addUserRepository.AddUser(new SignUpParams(
            params.getFirstName(),
            params.getLastName(),
            params.getEmail(),
            params.getPhone(),
            hashedPassword
        )
    );
  }
}
