package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.*;
import ua.alex.task.model.servise.ActivitiesService;
import ua.alex.task.model.servise.DayTimeLineService;
import ua.alex.task.model.servise.Organizer;

import java.util.*;

public class WorkDayOrganizer implements Organizer {
    private Day day;
    private ActivitiesService activitiesService;
    private DayTimeLineService dayTimeLineService;
    private final int MAX_PRIORITY_LEVEL = 3;

    public WorkDayOrganizer(Day day, ActivitiesService activitiesService, DayTimeLineService dayTimeLineService) {
        this.day = day;
        this.activitiesService = activitiesService;
        this.dayTimeLineService = dayTimeLineService;
    }

    @Override
    public void formDay() {
        List<Activity> temp;
        List<Activity> currentActivitiesList;
        for (int i = 1; i <= MAX_PRIORITY_LEVEL; i++) {
            temp = activitiesService.getAllSuitableActivitiesByPriority(i);
            currentActivitiesList = dayTimeLineService.createDayTimeLine(temp);
            day.addActivitiesList(currentActivitiesList);
        }
    }
}
