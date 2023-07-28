package com.paloit.card.server.grpc;

import com.google.protobuf.StringValue;
import com.paloit.card.core.service.CardService;
import com.paloit.card.grpc.*;
import com.paloit.card.server.grpc.CardServiceGrpcImpl.CardGrpcMapper;

import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CardServiceGrpcImplTest {

    private static CardService serviceCore;
    private static CardServiceGrpcImpl service;


    private static StreamObserver<CreateCardResponse> createStreamObserver;
    private static StreamObserver<GetCardResponse> getStreamObserver;
    private static StreamObserver<GetCardsResponse> getSStreamObserver;
    private static StreamObserver<UpdateCardResponse> updateCardObserver;

    private static CreateCardResponse createCardResponse;
    private static GetCardResponse getCardResponse;
    private static GetCardsResponse getCardsResponse;
    private static UpdateCardResponse updateCardResponse;


    private static final UUID gUUID = UUID.randomUUID();


    @BeforeAll
    public static void setUp(){
        serviceCore = Mockito.mock(CardService.class);
        CardGrpcMapper mapper = Mappers.getMapper( CardGrpcMapper.class );

        service = new CardServiceGrpcImpl(serviceCore,mapper);

        CardDto accountDtoRes = CardDto.newBuilder()
                .setName("Card1")
                .setId(StringValue.of(gUUID.toString()))
                .build();

        createCardResponse = CreateCardResponse.newBuilder()
                .setCard(accountDtoRes)
                .build();

        updateCardResponse = UpdateCardResponse.newBuilder()
                .build();


        getCardResponse = GetCardResponse.newBuilder()
                .setCard(accountDtoRes)
                .build();

        getCardsResponse = GetCardsResponse.newBuilder()
                .build();

        createStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(CreateCardResponse createCardResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };

        getStreamObserver= new StreamObserver<>() {
            @Override
            public void onNext(GetCardResponse getCardResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };

        getSStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(GetCardsResponse getCardsResponse) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };

        updateCardObserver = new StreamObserver<>() {
            @Override
            public void onNext(UpdateCardResponse updateCardResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };



    }

}