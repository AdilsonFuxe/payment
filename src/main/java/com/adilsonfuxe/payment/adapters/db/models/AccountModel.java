package com.adilsonfuxe.payment.adapters.db.models;

import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Enumerated(EnumType.STRING)
  private CurCode curCode;
  private Double amount = 0.0;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel user;

  public AccountModel(CurCode curCode, UserModel user) {
    this.curCode = curCode;
    this.user = user;
  }
}
