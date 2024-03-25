package com.adilsonfuxe.payment.core.domain.usecases.user;

import com.adilsonfuxe.payment.core.domain.models.User;

public interface SignUp {
  public User signUp(SignUpParams params);
}
