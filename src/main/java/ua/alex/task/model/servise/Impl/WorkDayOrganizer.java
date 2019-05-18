package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.dao.ActivitiesDao;
import ua.alex.task.model.*;
import ua.alex.task.model.servise.ActivitiesService;
import ua.alex.task.model.servise.Organizer;

import java.util.*;

public class WorkDayOrganizer implements Organizer {
    private Day day;
    private ActivitiesDao dao;
    private ActivitiesService activitiesService;

    public WorkDayOrganizer(Day day) {
        this.activitiesService = new ActivitiesServiceImpl();
        this.day = day;
    }

    @Override
    public void formDay() {
        List<Activity> activities = activitiesService.getAllSuitableActivities(day);
        int timeLeft = day.getDurationOfDayInHours();
        ActivitiesSorter sorter = new ActivitiesSorter();
        sorter.sortByPriority(activities);
        for (int i = 0; i < activities.size() && timeLeft > 0; i++) {
            day.addActivities(activities.get(i));
            timeLeft -= activities.get(i).getDuration().getHour();
        }

    }

}
