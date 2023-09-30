package com.example.MyPlannerApp.controllers;

import com.example.MyPlannerApp.models.Week;
import com.example.MyPlannerApp.services.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/weeks")
public class WeekController {
    private final WeekService weekService;

    @GetMapping
    public Week getWeeks(@RequestParam("startDate") LocalDate startDate,
                         @RequestParam("endDate") LocalDate endDate) {
        return weekService.getWeek(startDate, endDate);
    }

    @PostMapping
    public void addWeek(@RequestBody Week week) {
        weekService.addWeek(week);
    }

    @DeleteMapping(path = "{IdWeek}")
    public void deleteWeek(@PathVariable("IdWeek") UUID weekId) {
        weekService.deleteWeek(weekId);
    }

    @PutMapping(path = "{IdWeek}")
    public void updateWeek(
            @PathVariable("IdWeek") UUID weekId,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        weekService.updateWeek(weekId, startDate, endDate);
    }
}
