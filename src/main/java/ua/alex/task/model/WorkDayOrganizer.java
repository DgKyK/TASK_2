package ua.alex.task.model;

import java.time.LocalTime;
import java.util.Random;

public class WorkDayOrganizer implements Organizer {
    private Day day;

    public WorkDayOrganizer(Day day) {
        this.day = day;
    }

    @Override
    public void formDay() {
        ActivitiesFactory factory = new ActivitiesFactory();



    }

    private int randomBeetwenStartEndOfDay() {
        return new Random().nextInt(day.getEndOfDay().getHour()) + day.getStartOfDay().getHour();
    }
}
