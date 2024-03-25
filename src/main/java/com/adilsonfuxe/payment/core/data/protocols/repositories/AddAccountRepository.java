package com.adilsonfuxe.payment.core.data.protocols.repositories;

import com.adilsonfuxe.payment.core.domain.models.Account;

public interface AddAccountRepository {
  public Account AddAccount(AddAccountParams params);

}
