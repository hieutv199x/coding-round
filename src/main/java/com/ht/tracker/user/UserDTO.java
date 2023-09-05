package com.ht.tracker.user;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO implements Serializable {

  private Long id;
  private String name;
  private String phoneNumber;
  private BigDecimal steps;
}
