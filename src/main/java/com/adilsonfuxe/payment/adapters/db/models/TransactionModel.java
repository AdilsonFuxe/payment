package com.adilsonfuxe.payment.adapters.db.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @CreationTimestamp
  private Instant createdAt;
  @OneToMany(mappedBy = "transaction")
  private List<MovementModel> movements = new ArrayList<>();
}
