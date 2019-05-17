package ua.alex.task.model;

import java.time.LocalTime;
import java.util.*;

public abstract class Day {
    private List<Activity> activityList;
    private LocalTime startOfDay;
    private LocalTime endOfDay;
    private int durationOfDayInHours;


    public Day() {
        startOfDay = LocalTime.of(12,0);
        endOfDay = LocalTime.of(20,0);
        activityList = new LinkedList<>();
        activityList = new ArrayList<>();
        durationOfDayInHours = endOfDay.minusHours(startOfDay.getHour()).getHour();
    }

    public List<Activity> getActivityList() {
        return activityList;
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

    public void addActivities(Activity activity) {
        activityList.add(activity);
    }

    @Override
    public String toString() {
        return "Day{" +
                "activities=" +
                '}';
    }
}
