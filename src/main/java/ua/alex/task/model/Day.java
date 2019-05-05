package ua.alex.task.model;

import java.time.LocalTime;
import java.util.*;

public abstract class Day {
    private List<Activity> activityList;
    private LocalTime startOfDay;
    private LocalTime endOfDay;
    private Map<LocalTime, Activity> schedule;

    public Day() {
        startOfDay = LocalTime.of(12,0);
        endOfDay = LocalTime.of(20,0);
        activityList = new LinkedList<>();
        schedule = new TreeMap<>();
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

    public Map<LocalTime, Activity> getSchedule() {
        return schedule;
    }

    public void addActivities(LocalTime time, Activity activity) {
        activityList.add(activity);
        schedule.put(time, activity);
    }

    @Override
    public String toString() {
        return "Day{" +
                "schedule=" + schedule +
                '}';
    }
}
