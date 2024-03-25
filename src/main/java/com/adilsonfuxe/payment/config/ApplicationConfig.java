package com.adilsonfuxe.payment.config;


import com.adilsonfuxe.payment.adapters.cryptography.BCryptPasswordHashAdapter;
import com.adilsonfuxe.payment.adapters.cryptography.JwtEncryptAdapter;
import com.adilsonfuxe.payment.adapters.db.repositories.user.UserRepository;
import com.adilsonfuxe.payment.core.data.usecases.DbSignIn;
import com.adilsonfuxe.payment.core.data.usecases.DbSignUp;
import com.adilsonfuxe.payment.core.domain.porters.in.user.SignIn;
import com.adilsonfuxe.payment.core.domain.porters.in.user.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {


  @Autowired
  private UserRepository userRepository;
  @Autowired
  private BCryptPasswordHashAdapter bCryptPasswordHash;
  @Autowired
  private JwtEncryptAdapter jwtEncryptAdapter;

  @Bean
  public SignUp signUp() {
    return new DbSignUp(
        bCryptPasswordHash,
        userRepository
    );
  }

  @Bean
  public SignIn signIn() {
    return new DbSignIn(
        userRepository,
        bCryptPasswordHash,
        jwtEncryptAdapter
    );
  }
}
