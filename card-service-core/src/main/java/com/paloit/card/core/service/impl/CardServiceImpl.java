package com.paloit.card.core.service.impl;

import java.time.Instant;

import com.paloit.card.core.domain.CardDO;
import com.paloit.card.core.enums.CardStatus;
import com.paloit.card.core.exceptions.ResourceNotFoundException;
import com.paloit.card.core.mappers.CardMapper;
import com.paloit.card.core.service.CardService;
import com.paloit.card.persistence.jpa.entities.CardEntity;
import com.paloit.card.persistence.jpa.repositories.CardJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardJpaRepository repository;
    private final CardMapper mapper;

    @Override
    public CardDO createCard(CardDO card) {
        CardEntity entity = mapper.domainToEntity(card);
        entity.setStatus(CardStatus.ACTIVE.toString());
        entity.setCreatedDatetime(Instant.now());
        entity.setLastModifiedDatetime(Instant.now());
        entity = repository.save(entity);
    
        return mapper.entityToDomain(entity);   
    }

    @Override
    public CardDO findById(String id) {
    return repository.findById(id)
        .map(mapper::entityToDomain)
        .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteById(String id){
        repository.updateStatus(CardStatus.DELETED.toString(),id);
    }

}
