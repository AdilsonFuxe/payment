package com.adilsonfuxe.payment.ports.db.repositories.user;

import com.adilsonfuxe.payment.ports.db.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserModel, UUID> {
}
