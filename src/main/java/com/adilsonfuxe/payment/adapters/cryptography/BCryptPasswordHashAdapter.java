package com.adilsonfuxe.payment.adapters.cryptography;

import com.adilsonfuxe.payment.core.data.porters.out.cryptography.PasswordHash;
import com.adilsonfuxe.payment.core.data.porters.out.cryptography.PasswordHashCompare;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordHashAdapter implements PasswordHash, PasswordHashCompare {

  @Override
  public String hashPassword(String password) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
    return encoder.encode(password);
  }

  @Override
  public boolean hashCompare(String password, String hash) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
    return encoder.matches(password, hash);
  }
}
