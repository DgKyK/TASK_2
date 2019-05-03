package ua.alex.task.model;

import java.time.LocalTime;

public class Read extends Activity {

    public Read() {
        this.duration = LocalTime.of(1,0);
        this.timesPerDay = 1;
        this.periodicity = LocalTime.of(24,0);
    }
}
