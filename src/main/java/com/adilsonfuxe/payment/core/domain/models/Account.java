package com.adilsonfuxe.payment.core.domain.models;

import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;

import java.util.UUID;

public class Account {
  private UUID id;
  private User user;
  private CurCode curCode;
}
