package ua.alex.task.model;

import java.time.LocalTime;

public abstract class Activity {
    protected LocalTime duration;

    public LocalTime getDuration() {
        return duration;
    }
}
