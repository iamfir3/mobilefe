package com.mobilebe.repository;

import com.mobilebe.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserEntity,Long> {
    Optional<SystemUserEntity> findByUsername(String username);

    @Query("SELECT u FROM SystemUserEntity u " +
            "WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SystemUserEntity> searchByUsername(@Param("keyword") String keyword);
    @Query("SELECT u FROM SystemUserEntity u " +
            "WHERE LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<SystemUserEntity> searchByLastname(@Param("keyword") String keyword);
}
