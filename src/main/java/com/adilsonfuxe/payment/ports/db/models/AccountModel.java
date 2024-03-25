package com.adilsonfuxe.payment.ports.db.models;

import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class AccountModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Enumerated(EnumType.STRING)
  private CurCode curCode;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel user;
}
