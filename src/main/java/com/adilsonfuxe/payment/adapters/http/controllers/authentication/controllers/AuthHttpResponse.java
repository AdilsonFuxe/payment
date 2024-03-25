package com.adilsonfuxe.payment.adapters.http.controllers.authentication.controllers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthHttpResponse {
  private final String accessToken;
}
