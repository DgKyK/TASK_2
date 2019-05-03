package ua.alex.task.model;

import java.time.LocalTime;

public class Job extends Activity {

    public Job() {
        this.duration = LocalTime.of(5,0);
        this.timesPerDay = 1;
        this.periodicity = LocalTime.of(24,0);
    }
}
