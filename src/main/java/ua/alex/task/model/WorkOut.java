package ua.alex.task.model;

import java.time.LocalTime;

public class WorkOut extends Activity {
    /*private LocalTime restTime = LocalTime.of(6,0);*/

    public WorkOut() {
        this.duration = LocalTime.of(1,0);
        this.timesPerDay = 2;
        this.periodicity = LocalTime.of(6,0);
    }
}
