package com.paloit.card.persistence.jpa.repositories;

import com.paloit.card.persistence.jpa.entities.CardEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardJpaRepository extends JpaRepository<CardEntity, String> {

    
    @Modifying
    @Query("update #{#entityName} set status = :status where id = :id")
    int updateStatus(String status, String id);
    

}