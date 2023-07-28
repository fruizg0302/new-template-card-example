package com.paloit.card.core.mappers;

import com.paloit.card.core.domain.CardDO;
import com.paloit.card.persistence.jpa.entities.CardEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CardMapper {

    CardEntity domainToEntity(CardDO card);

    CardDO entityToDomain(CardEntity cardEntity);
}