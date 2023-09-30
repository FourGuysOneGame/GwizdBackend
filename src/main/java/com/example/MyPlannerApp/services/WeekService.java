package com.example.MyPlannerApp.services;

import com.example.MyPlannerApp.models.Week;
import com.example.MyPlannerApp.repositories.WeekRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WeekService {
    private final WeekRepository weekRepository;

    public List<Week> getWeeks() {
        return weekRepository.findAll();
    }

    public Week getWeek(LocalDate startDate, LocalDate endDate) {
        return weekRepository.findWeeksByStartDateAndEndDate(startDate, endDate).orElseThrow(
                () -> new IllegalStateException("Week from: " + startDate + "to: " + endDate + " does not exist")
        );
    }

    public void addWeek(Week week) {
        Optional<Week> weekByEmail = weekRepository.findWeeksByStartDateAndEndDate(week.getStartDate(), week.getEndDate());
        if (weekByEmail.isPresent()) {
            throw new IllegalStateException("Already in database");
        }
        weekRepository.save(week);
    }

    public void deleteWeek(UUID weekId) {
        boolean exists = weekRepository.existsById(weekId);
        if (!exists) {
            throw new IllegalStateException("week with id: " + weekId + " does not exist");
        }
        weekRepository.deleteById(weekId);
    }

    @Transactional
    public void updateWeek(UUID weekId, LocalDate startDate, LocalDate endDate) {
        Week week = weekRepository.findById(weekId).orElseThrow(
                () -> new IllegalStateException("week with id: " + weekId + " does not exist")
        );
        if (startDate != null && !Objects.equals(week.getStartDate(), startDate)) {
            week.setStartDate(startDate);
        }
        if (endDate != null && !Objects.equals(week.getEndDate(), endDate)) {
            week.setEndDate(endDate);
        }
    }
}
