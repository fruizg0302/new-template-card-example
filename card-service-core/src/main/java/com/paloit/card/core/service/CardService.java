package com.paloit.card.core.service;

import com.paloit.card.core.domain.CardDO;

public interface CardService {
    CardDO createCard(CardDO card);
    CardDO findById(String id);
    void deleteById(String id);
}

