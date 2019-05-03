package ua.alex.task.model;

import java.time.LocalTime;

public class Clean extends Activity {

    public Clean() {
        duration = LocalTime.of(1,0);
        timesPerDay = 1;
        periodicity = LocalTime.of(24,0);
    }
}
