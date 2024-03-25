package com.adilsonfuxe.payment.adapters.db.models;

import com.adilsonfuxe.payment.core.domain.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID Id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String phone;
  @Column(nullable = false)
  private String password;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role = Role.User;
  @JsonManagedReference
  @OneToMany(mappedBy = "user")
  private List<AccountModel> accounts = new ArrayList<>();

  public UserModel(UUID id, String firstName, String lastName, String email, String phone, String password, Role role) {
    Id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.role = role;
  }

  public UserModel(String firstName, String lastName, String email, String phone, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
