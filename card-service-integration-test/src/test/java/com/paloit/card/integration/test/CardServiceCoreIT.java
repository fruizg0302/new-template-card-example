package com.paloit.card.integration.test;

import com.paloit.card.grpc.CardDto;
import com.paloit.card.grpc.GetCardRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardServiceCoreIT extends CardServiceBaseIT{

    @Test
    public void createCard(){
     var createRequest= CardDto.newBuilder().setName("test").build();
        var response=client.createCard(createRequest);
        Assertions.assertTrue(response.getCard().getId().isInitialized());
    }

    @Test
    public void findCard(){
        var createCard= CardDto.newBuilder().setName("test").build();
        var response=client.createCard(createCard);
        var getCardRequest=GetCardRequest.newBuilder().setId(response.getCard().getId().getValue()).build();
        var getCardResponse=client.getCard(getCardRequest);
        Assertions.assertTrue(getCardResponse.hasCard());
        Assertions.assertTrue(getCardResponse.getCard().getId().isInitialized());
    }

}