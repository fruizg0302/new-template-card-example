package com.paloit.card.persistence.jpa.entities;

import java.time.Instant;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cards")
public class CardEntity {

    @Id
    @UuidGenerator
    @Column(name = "card_id")
    private String id;
    private String name;
    private String status;
    private Instant lastModifiedDatetime;
    private Instant createdDatetime;

    @Version
    protected Short version;

}
