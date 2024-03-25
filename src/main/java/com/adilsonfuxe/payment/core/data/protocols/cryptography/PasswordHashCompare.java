package com.adilsonfuxe.payment.core.data.protocols.cryptography;

public interface PasswordHashCompare {
  public boolean hashCompare(String password, String hash);
}
