package com.adilsonfuxe.payment.ports.db.models;

import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserModel {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID Id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String password;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;
  @Enumerated(EnumType.STRING)
  private Role role;
  @OneToMany(mappedBy = "user")
  private List<AccountModel> accounts = new ArrayList<>();
}
