package ua.alex.task.model;

import java.time.LocalTime;

public abstract class Activity {
    protected LocalTime duration;
    protected int timesPerDay;
    protected LocalTime periodicity;

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public LocalTime getPeriodicity() {
        return periodicity;
    }

    public LocalTime getDuration() {
        return duration;
    }
}
