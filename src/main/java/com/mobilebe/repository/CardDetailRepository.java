package com.mobilebe.repository;

import com.mobilebe.entity.CardDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardDetailRepository extends JpaRepository<CardDetailEntity,Long> {
    Optional<CardDetailEntity> findByCardNum(String cardNum);
}
