package ua.alex.task.model;

import java.time.LocalTime;

public abstract class Activity {
    protected String name;
    protected LocalTime duration;
    protected int timesPerDay;
    protected LocalTime periodicity;
    protected int priority;

    public Activity() {
        name = "none";
        duration = LocalTime.of(0,0);
        periodicity = LocalTime.of(0,0);
    }

    public Activity(String name, LocalTime duration, int timesPerDay,LocalTime periodicity, int priority) {
        this.name = name;
        this.duration = duration;
        this.timesPerDay = timesPerDay;
        this.periodicity = periodicity;
        this.priority = priority;
    }

    public int getTimesPerDay() {
        return timesPerDay;
    }

    public LocalTime getPeriodicity() {
        return periodicity;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public void setPeriodicity(LocalTime periodicity) {
        this.periodicity = periodicity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return  name +
                " : duration=" + duration +
                ", timesPerDay=" + timesPerDay +
                ", priority=" + priority +
                "\n";
    }
}
