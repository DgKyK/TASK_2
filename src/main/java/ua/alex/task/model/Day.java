package ua.alex.task.model;

import java.time.LocalTime;
import java.util.*;

public abstract class Day {
    private List<Activity> activityList;
    private LocalTime startOfDay;
    private LocalTime endOfDay;
    private Map<LocalTime, Activity> schedule; // TODO you have to implement this without map because it provides

    public Day() {
        startOfDay = LocalTime.of(12,0);
        endOfDay = LocalTime.of(20,0);
        activityList = new LinkedList<>();
        schedule = new TreeMap<>();             // TODO create interface Schedule and than implement it by WorDaySchedule
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

    public void addActivities(LocalTime time, Activity activity) {          // TODO it`s have to be at WorDaySchedule
        activityList.add(activity);
        schedule.put(time, activity);
    }

    @Override
    public String toString() {                                  // TODO present another toString , it`s already old
        return "Day{" +
                "schedule=" + schedule +
                '}';
    }
}
