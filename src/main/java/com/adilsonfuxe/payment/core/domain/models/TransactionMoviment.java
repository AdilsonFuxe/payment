package com.adilsonfuxe.payment.core.domain.models;

import com.adilsonfuxe.payment.core.domain.models.enums.TransactionType;

import java.util.UUID;

public class TransactionMoviment {
  private UUID id;
  private Transaction transaction;
  private User from;
  private User to;
  private TransactionType transactionType;
}
