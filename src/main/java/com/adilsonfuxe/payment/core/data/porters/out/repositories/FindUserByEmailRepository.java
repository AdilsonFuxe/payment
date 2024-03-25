package com.adilsonfuxe.payment.core.data.porters.out.repositories;

import com.adilsonfuxe.payment.core.domain.models.User;

public interface FindUserByEmailRepository {
  public User findByEmail(String email);
}
