package com.adilsonfuxe.payment.core.domain.porters.in.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignInParams {
  private final String email;
  private final String password;
}
