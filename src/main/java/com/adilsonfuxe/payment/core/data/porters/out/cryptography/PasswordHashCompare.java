package com.adilsonfuxe.payment.core.data.porters.out.cryptography;

public interface PasswordHashCompare {
  public boolean hashCompare(String password, String hash);
}
