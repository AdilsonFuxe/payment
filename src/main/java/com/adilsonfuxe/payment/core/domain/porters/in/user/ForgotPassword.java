package com.adilsonfuxe.payment.core.domain.porters.in.user;

import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.ForgotPasswordParams;
import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.ForgotPasswordResponse;

public interface ForgotPassword {
  public ForgotPasswordResponse forgotPassword(ForgotPasswordParams params);
}
