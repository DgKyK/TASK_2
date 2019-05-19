package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.Organizer;
import ua.alex.task.model.servise.Impl.WorkDayOrganizer;

import java.util.List;

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

    public List<List<Activity>> getDayActivitiesLists() {
        return day.getActivitiesByPriorityList();
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
