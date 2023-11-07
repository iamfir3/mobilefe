package com.mobilebe.repository;

import com.mobilebe.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserEntity,Long> {
    Optional<SystemUserEntity> findByUsername(String username);
}
