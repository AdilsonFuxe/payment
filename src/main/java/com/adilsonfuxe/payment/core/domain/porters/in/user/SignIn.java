package com.adilsonfuxe.payment.core.domain.porters.in.user;

import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignInParams;

public interface SignIn {
  public String signIn(SignInParams params);
}
