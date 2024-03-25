package com.adilsonfuxe.payment.ports.db.repositories.user;

import com.adilsonfuxe.payment.core.data.protocols.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.ports.db.models.UserModel;


public class UserRepository implements FindUserByEmailRepository {

  private JpaUserRepository jpaUserRepository;
  @Override
  public User findByEmail(String email) {
   return null;
  }
}
