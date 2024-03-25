package com.adilsonfuxe.payment.core.domain.models;

import com.adilsonfuxe.payment.core.domain.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String password;
  private Role role;
  private Instant createdAt;
  private Instant updatedAt;
}
