package com.mobilebe.repository;

import com.mobilebe.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    @Query("SELECT b FROM BookingEntity b WHERE b.check_in_date <= :endDate AND b.check_out_date >= :startDate")
    List<BookingEntity> findBookingsInDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
