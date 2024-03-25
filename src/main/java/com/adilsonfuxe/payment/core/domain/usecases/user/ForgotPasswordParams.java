package com.adilsonfuxe.payment.core.domain.usecases.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ForgotPasswordParams {
  private final UUID userId;
}
