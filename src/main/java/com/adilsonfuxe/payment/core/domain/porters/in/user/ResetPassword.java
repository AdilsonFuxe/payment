package com.adilsonfuxe.payment.core.domain.porters.in.user;

import com.adilsonfuxe.payment.core.domain.porters.in.user.dtos.ResetPasswordParams;

public interface ResetPassword {
  public void resetPassword(ResetPasswordParams resetPasswordParams);
}
