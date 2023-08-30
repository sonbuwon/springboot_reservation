package com.packt.cardatabase;

import com.packt.cardatabase.domain.Calendar;
import com.packt.cardatabase.repository.CalendarRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class CalendarTest {

    @Autowired
    CalendarRepository calendarRepository;

    @Test
    public void testCalendar() {

    }
}
