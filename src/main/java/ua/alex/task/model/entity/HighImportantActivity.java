package ua.alex.task.model.entity;

import ua.alex.task.model.Activity;

import java.time.LocalTime;

public class HighImportantActivity extends Activity {

    public HighImportantActivity() {

    }

    public HighImportantActivity(String name, LocalTime duration, LocalTime periodicity, int priority) {
        super(name, duration, periodicity, priority);
    }
}
