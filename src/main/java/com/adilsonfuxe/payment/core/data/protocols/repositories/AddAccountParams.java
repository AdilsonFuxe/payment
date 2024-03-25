package com.adilsonfuxe.payment.core.data.protocols.repositories;

import com.adilsonfuxe.payment.core.domain.models.User;
import com.adilsonfuxe.payment.core.domain.models.enums.CurCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddAccountParams {
  private final User user;
  private final CurCode curCode;
}
