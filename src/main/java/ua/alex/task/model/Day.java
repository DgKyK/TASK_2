package ua.alex.task.model;

import java.time.LocalTime;
import java.util.*;

public abstract class Day {
    private List<List<Activity>> activitiesByPriorityList;
    private LocalTime startOfDay;
    private LocalTime endOfDay;
    private int durationOfDayInHours;


    public Day() {
        startOfDay = LocalTime.of(12,0);
        endOfDay = LocalTime.of(20,0);
        activitiesByPriorityList = new ArrayList<>();
        durationOfDayInHours = endOfDay.minusHours(startOfDay.getHour()).getHour();
    }

    public List<List<Activity>> getActivitiesByPriorityList() {
        return activitiesByPriorityList;
    }

    public LocalTime getStartOfDay() {
        return startOfDay;
    }

    public LocalTime getEndOfDay() {
        return endOfDay;
    }

    public int getDurationOfDayInHours() {
        return durationOfDayInHours;
    }

    public void addActivitiesList(List<Activity> activityList) {
        activitiesByPriorityList.add(activityList);
    }

    @Override
    public String toString() {
        return "Day{" +
                "activitiesByPriorityList=" + activitiesByPriorityList +
                ", startOfDay=" + startOfDay +
                ", endOfDay=" + endOfDay +
                ", durationOfDayInHours=" + durationOfDayInHours +
                '}';
    }
}
