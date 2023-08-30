package com.packt.cardatabase.controller;

import com.packt.cardatabase.domain.Calendar;
import com.packt.cardatabase.repository.CalendarRepository;
import com.packt.cardatabase.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cal")
@Controller
@RequiredArgsConstructor
public class CalController {

    private final CalendarService calendarService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", this.calendarService.getList());
        return "calendar/temp";
    }

    @PostMapping
    public String saveDate(Calendar calendar, Model model) {

        model.addAttribute("cant", this.calendarService.saveGuestIfDatesAvailable(calendar));

        return "redirect:/cal";
    }
}
