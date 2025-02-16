package com.br.minsait.models.entities;

import java.util.Arrays;

public enum ContactType {
  PHONE(0),
  SMARTPHONE(1);

  private final int code;

  ContactType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static ContactType fromCode(int code) {
    return Arrays.stream(ContactType.values())
        .filter(ct -> ct.getCode() == code)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid ContactType code: " + code));
  }
}
