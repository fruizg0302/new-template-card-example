package com.paloit.card.server.grpc;

import com.paloit.card.core.domain.CardDO;
import com.paloit.card.core.service.CardService;
import com.paloit.card.grpc.*;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;
import org.mapstruct.Mapper;

@GRpcService
@RequiredArgsConstructor
public class CardServiceGrpcImpl extends CardServiceGrpc.CardServiceImplBase {

    private final CardService service;
    private final CardGrpcMapper mapper;

    @Override
    public void createCard(CardDto request, StreamObserver<CreateCardResponse> responseObserver) {
        CardDO response = service.createCard(
                                    mapper.fromCreateCardRequestToDomain(request));

        CreateCardResponse createCardResponse = CreateCardResponse.newBuilder()
                                                    .setCard(mapper.fromDomainToCardDto(response) )
                                                    .build();
        responseObserver.onNext(createCardResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getCard(GetCardRequest request, StreamObserver<GetCardResponse> responseObserver) {
        CardDO response = service.findById(request.getId());
        GetCardResponse getCardResponse = GetCardResponse.newBuilder()
                                                    .setCard(mapper.fromDomainToCardDto(response) )
                                                    .build();

        responseObserver.onNext(getCardResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getCards(GetCardsRequest request, StreamObserver<GetCardsResponse> responseObserver) {
        responseObserver.onCompleted();
    }

    @Override
    public void updateCard(CardDto request, StreamObserver<UpdateCardResponse> responseObserver) {
        responseObserver.onCompleted();
    }

    @Mapper(uses = {ProtobufMapper.class})
    public interface CardGrpcMapper {
        CardDO fromCreateCardRequestToDomain(CardDto request);
        CardDto fromDomainToCardDto (CardDO domain );
    }
}
