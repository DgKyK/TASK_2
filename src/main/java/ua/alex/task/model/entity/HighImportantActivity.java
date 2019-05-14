package ua.alex.task.model.entity;

import ua.alex.task.model.Activity;

import java.time.LocalTime;

public class HighImportantActivity extends Activity {

    public HighImportantActivity() {

    }

    public HighImportantActivity(String name, LocalTime duration, int timesPerDay,LocalTime periodicity, int priority) {
        super(name, duration, timesPerDay, periodicity, priority);
    }
}
