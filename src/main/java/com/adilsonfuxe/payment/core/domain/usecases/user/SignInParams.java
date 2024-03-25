package com.adilsonfuxe.payment.core.domain.usecases.user;

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
