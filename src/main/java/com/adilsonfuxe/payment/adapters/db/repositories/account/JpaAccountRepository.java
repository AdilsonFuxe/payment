package com.adilsonfuxe.payment.adapters.db.repositories.account;

import com.adilsonfuxe.payment.adapters.db.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAccountRepository extends JpaRepository<AccountModel, UUID> {
}
