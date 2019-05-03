package ua.alex.task.model;

import java.time.LocalTime;

public class Job extends Activity {

    public Job() {
        this.duration = LocalTime.of(5,0);
    }
}
