package ua.alex.task.model;

import java.time.LocalTime;

public class MiddleImportantActivity extends Activity {

    public MiddleImportantActivity() {

    }

    public MiddleImportantActivity(String name, LocalTime duration, int timesPerDay,LocalTime periodicity, int priority) {
        super(name, duration, timesPerDay, periodicity, priority);
    }
}
