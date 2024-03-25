package com.adilsonfuxe.payment.ports.db.repositories.user;

import com.adilsonfuxe.payment.core.data.protocols.repositories.AddUserRepository;
import com.adilsonfuxe.payment.core.data.protocols.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.usecases.user.SignUpParams;
import com.adilsonfuxe.payment.ports.db.models.UserModel;


public class UserRepository implements FindUserByEmailRepository, AddUserRepository {

  private JpaUserRepository jpaUserRepository;
  @Override
  public User findByEmail(String email) {
    return jpaUserRepository.findByEmail(email);
  }

  @Override
  public User AddUser(SignUpParams params) {
    var data = UserModel.builder()
        .firstName(params.getFirstName())
        .lastName(params.getLastName())
        .email(params.getEmail())
        .phone(params.getPhone())
        .build();
    return toUser(jpaUserRepository.save(data));
  }


  private User toUser(UserModel user) {
    return new User(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getPhone(),
        user.getRole(),
        user.getCreatedAt(),
        user.getUpdatedAt());
  }
}
