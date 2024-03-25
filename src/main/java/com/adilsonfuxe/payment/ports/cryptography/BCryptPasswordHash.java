package com.adilsonfuxe.payment.ports.cryptography;

import com.adilsonfuxe.payment.core.data.protocols.cryptography.PasswordHash;
import com.adilsonfuxe.payment.core.data.protocols.cryptography.PasswordHashCompare;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordHash implements PasswordHash, PasswordHashCompare {
  @Override
  public String hashPassword(String password) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    return encoder.encode(password);
  }

  @Override
  public boolean hashCompare(String password, String hash) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    return encoder.matches(password, hash);
  }
}
