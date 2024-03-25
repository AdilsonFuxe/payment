package com.adilsonfuxe.payment.core.data.protocols.repositories;

import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignUpParams;

public interface AddUserRepository {
  public User AddUser(SignUpParams params);
}
