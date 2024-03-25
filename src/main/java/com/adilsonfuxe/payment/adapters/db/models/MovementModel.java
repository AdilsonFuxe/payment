package com.adilsonfuxe.payment.adapters.db.models;

import com.adilsonfuxe.payment.core.domain.models.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movements")
public class MovementModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "transaction_id")
  TransactionModel transaction;
  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountModel account;
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;
  private Double amount;

}
