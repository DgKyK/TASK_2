package ua.alex.task.model.servise;

import ua.alex.task.model.dao.ActivitiesDao;
import ua.alex.task.model.*;
import ua.alex.task.model.dao.DaoFactory;

import java.util.*;

public class WorkDayOrganizer implements Organizer {
    private Day day;
    private ActivitiesDao dao;

    public WorkDayOrganizer(Day day) {
        DaoFactory factory = DaoFactory.getInstance();
        this.dao = factory.createActivityDao();
        this.day = day;
    }

    @Override
    public void formDay() {
        List<Activity> activities = getAllActivities();
        int timeLeft = day.getDurationOfDayInHours();
        ActivitiesSorter sorter = new ActivitiesSorter();
        sorter.sortByPriority(activities);
        for (int i = 0; i < activities.size() && timeLeft > 0; i++) {
            day.addActivities(activities.get(i));
            timeLeft -= activities.get(i).getDuration().getHour();
        }

    }


    private List<Activity> getAllActivities() {
        return dao.getSuitableActivities(day);
    }

}
