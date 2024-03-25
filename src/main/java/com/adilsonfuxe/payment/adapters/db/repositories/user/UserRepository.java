package com.adilsonfuxe.payment.adapters.db.repositories.user;

import com.adilsonfuxe.payment.adapters.db.models.AccountModel;
import com.adilsonfuxe.payment.adapters.db.repositories.account.JpaAccountRepository;
import com.adilsonfuxe.payment.core.data.porters.out.repositories.AddUserRepository;
import com.adilsonfuxe.payment.core.data.porters.out.repositories.FindUserByEmailRepository;
import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.SignUpParams;
import com.adilsonfuxe.payment.adapters.db.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements FindUserByEmailRepository, AddUserRepository {

  private final JpaUserRepository jpaUserRepository;
  private final JpaAccountRepository jpaAccountRepository;

  @Autowired
  public UserRepository(JpaUserRepository jpaUserRepository, JpaAccountRepository jpaAccountRepository) {
    this.jpaUserRepository = jpaUserRepository;
    this.jpaAccountRepository = jpaAccountRepository;
  }

  @Override
  public User findByEmail(String email) {
    var user = jpaUserRepository.findByEmail(email);
    return toUser(user);
  }

  @Override
  public User AddUser(SignUpParams params) {
    UserModel user =new UserModel(params.getFirstName(),params.getLastName(), params.getEmail(), params.getPhone(), params.getPassword());
    AccountModel account = new AccountModel(CurCode.AOA, user);
    user.getAccounts().add(account);
    var result = jpaUserRepository.save(user);
    jpaAccountRepository.save(account);
    return toUser(result);
  }


  private User toUser(UserModel user) {
    return new User(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getPhone(),
        user.getPassword(),
        user.getRole(),
        user.getCreatedAt(),
        user.getUpdatedAt());
  }
}
