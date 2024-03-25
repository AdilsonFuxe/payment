package com.adilsonfuxe.payment.core.domain.porters.in.user.dtos;

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
