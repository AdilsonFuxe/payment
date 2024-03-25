package com.adilsonfuxe.payment.adapters.db.models;

import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
  @Column(unique = true, nullable = false)
  private String acctId;
  @Enumerated(EnumType.STRING)
  private CurCode curCode;
  private Double amount = 0.0;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel user;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;
  @OneToMany(mappedBy = "account")
  private List<MovementModel> movements = new ArrayList<>();

  public AccountModel(CurCode curCode, UserModel user, String acctId) {
    this.curCode = curCode;
    this.user = user;
    this.acctId = acctId;
  }
}
