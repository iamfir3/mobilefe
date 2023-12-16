package com.mobilebe.repository;

import com.mobilebe.entity.RoomDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomDetailEntity,Long> {
    @Query("SELECT r FROM RoomDetailEntity r WHERE r.id NOT IN " +
            "(SELECT b.id FROM BookingEntity b WHERE b.check_in_date <= :endDate AND b.check_out_date >= :startDate)")
    List<RoomDetailEntity> findAvailableRooms(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
