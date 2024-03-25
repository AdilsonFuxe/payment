package com.adilsonfuxe.payment.adapters.db.repositories.user;

import com.adilsonfuxe.payment.adapters.db.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserModel, UUID> {
  UserModel findByEmail(String email);
}
