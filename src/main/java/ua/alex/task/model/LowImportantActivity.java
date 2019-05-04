package ua.alex.task.model;

import java.time.LocalTime;

public class LowImportantActivity extends Activity {

    public LowImportantActivity() {

    }

    public LowImportantActivity(String name, LocalTime duration, int timesPerDay,LocalTime periodicity, int priority) {
        super(name, duration, timesPerDay, periodicity, priority);
    }
}
