package com.adilsonfuxe.payment.core.data.porters.out.repositories;

import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignUpParams;

public interface AddUserRepository {
  public User AddUser(SignUpParams params);
}
