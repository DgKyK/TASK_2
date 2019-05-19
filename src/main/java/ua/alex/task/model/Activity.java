package ua.alex.task.model;

import java.time.LocalTime;

public abstract class Activity {
    private String name;
    private LocalTime duration;
    private LocalTime periodicity;
    private int priority;
    private LocalTime startTime;

    public Activity() {
        name = "none";
        duration = LocalTime.of(0,0);
        periodicity = LocalTime.of(0,0);
    }

    public Activity(String name, LocalTime startTime, LocalTime duration, LocalTime periodicity, int priority) {
        this.name = name;
        this.startTime = startTime;
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

    public int getPriority() {
        return priority;
    }

    public LocalTime getStartTime() {
        return startTime;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return  "name=" + name +
                " duration=" + duration +
                ", priority=" + priority +
                "start time=" + startTime +
                "\n";
    }
}
