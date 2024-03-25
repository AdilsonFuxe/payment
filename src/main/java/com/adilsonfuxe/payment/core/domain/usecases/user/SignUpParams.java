package com.adilsonfuxe.payment.core.domain.usecases.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignUpParams {
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;
  private final String password;
}
