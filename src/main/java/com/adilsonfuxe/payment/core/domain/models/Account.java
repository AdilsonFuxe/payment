package com.adilsonfuxe.payment.core.domain.models;

import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Account {
  private UUID id;
  private User user;
  private CurCode curCode;
  private String acctId;
  private Double amount;
}
