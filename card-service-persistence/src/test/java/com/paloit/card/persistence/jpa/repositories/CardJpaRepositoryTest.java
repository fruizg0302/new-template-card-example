package com.paloit.card.persistence.jpa.repositories;

import com.paloit.card.persistence.jpa.entities.CardEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CardJpaRepositoryTest {
    
    private static CardJpaRepository gCardJpaRepository;
    private static CardEntity gCardEntity;


    @BeforeAll
    static void setUp(){
       
    }

    @Test
    void test_createCard(){
        
    }


    @Test
    void test_getCardById(){


    }


}