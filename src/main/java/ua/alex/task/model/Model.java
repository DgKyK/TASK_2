package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.Organizer;
import ua.alex.task.model.servise.WorkDayOrganizer;

import java.time.LocalTime;
import java.util.Map;

public class Model {
    private Organizer organizer;
    private Day day;
    public Model() {
        day = new WorkDay();
        organizer = new WorkDayOrganizer(day);
    }

    public void formDaySchedule() {
        organizer.formDay();
    }

    public Map<LocalTime, Activity> getDaySchedule() {
        return day.getSchedule();
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
