package ua.alex.task.model.entity;

import ua.alex.task.model.Activity;

import java.time.LocalTime;

public class MiddleImportantActivity extends Activity {

    public MiddleImportantActivity() {

    }

    public MiddleImportantActivity(String name, LocalTime duration, int timesPerDay,LocalTime periodicity, int priority) {
        super(name, duration, periodicity, priority);
    }
}
