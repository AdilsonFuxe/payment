package com.adilsonfuxe.payment.core.domain.porters.in.user;

import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignUpParams;

public interface SignUp {
  public User signUp(SignUpParams params);
}
