package ua.alex.task.model;

import java.time.LocalTime;

public abstract class Activity {
    protected String name;
    protected LocalTime duration;
    protected LocalTime periodicity;
    protected int priority;

    public Activity() {
        name = "none";
        duration = LocalTime.of(0,0);
        periodicity = LocalTime.of(0,0);
    }

    public Activity(String name, LocalTime duration, LocalTime periodicity, int priority) {
        this.name = name;
        this.duration = duration;
        this.periodicity = periodicity;
        this.priority = priority;
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
                ", priority=" + priority +
                "\n";
    }
}
