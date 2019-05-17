package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.Organizer;
import ua.alex.task.model.servise.WorkDayOrganizer;

import java.time.LocalTime;
import java.util.List;
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

    public List<Activity> getDayActivities() {
        return day.getActivityList();
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
