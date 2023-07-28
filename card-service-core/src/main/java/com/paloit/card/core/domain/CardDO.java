package com.paloit.card.core.domain;

import java.time.Instant;

import com.paloit.card.core.enums.CardStatus;

import lombok.Data;

@Data
public class CardDO {
  private String id;
  private String name;
  private CardStatus status;
  private Instant createdDatetime;
  private Instant lastModifiedDatetime;
}