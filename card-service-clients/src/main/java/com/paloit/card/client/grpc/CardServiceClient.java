package com.paloit.card.client;

import io.grpc.ManagedChannelBuilder;
import com.paloit.card.grpc.*;


public class CardServiceClient  {

  CardServiceGrpc.CardServiceBlockingStub stub;

    public static CardServiceClient of(String host, int port) {
        return new CardServiceClient(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    private CardServiceClient(ManagedChannelBuilder<?> channelBuilder) {
        this.stub = CardServiceGrpc.newBlockingStub(channelBuilder.build());
    }

    public CreateCardResponse createCard(CardDto card) {
        return stub.createCard(card);
    }

    public GetCardsResponse getCards(GetCardsRequest request) {
        return stub.getCards(request);
    }

    public GetCardResponse getCard(GetCardRequest request) {
        return stub.getCard(request);
    }

    public UpdateCardResponse updateCard(CardDto card) {
        return stub.updateCard(card);
    }

}
