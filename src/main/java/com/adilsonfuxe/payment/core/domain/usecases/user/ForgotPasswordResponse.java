package com.adilsonfuxe.payment.core.domain.usecases.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ForgotPasswordResponse {
  private final String token;
  private final Instant expiresIn;
}
