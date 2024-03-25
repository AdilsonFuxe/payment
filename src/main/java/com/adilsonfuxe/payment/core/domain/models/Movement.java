package com.adilsonfuxe.payment.core.domain.models;

import com.adilsonfuxe.payment.core.domain.models.enums.TransactionType;

import java.util.UUID;

public class Movement {
  private UUID id;
  private Transaction transaction;
  private Account account;
  private TransactionType transactionType;
  private Double amount;
}
