package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.Calendar;
import com.packt.cardatabase.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public List<Calendar> getList() {
        return this.calendarRepository.findAll();
    }

    public boolean saveGuestIfDatesAvailable(Calendar guest) {
        List<Calendar> conflictingGuests = calendarRepository.findByIndateBetweenOrOutdateBetween(
                guest.getIndate(), guest.getOutdate(), guest.getIndate(), guest.getOutdate()
        );
        if (conflictingGuests.isEmpty()) {
            calendarRepository.save(guest);
            return true;
        }
        return false;
    }

}
