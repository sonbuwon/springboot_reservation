package com.packt.cardatabase.repository;

import com.packt.cardatabase.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByIndateBetweenOrOutdateBetween(LocalDate checkinStart, LocalDate checkinEnd, LocalDate checkoutStart, LocalDate checkoutEnd);

}
