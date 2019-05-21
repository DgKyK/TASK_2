package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.ActivitiesService;
import ua.alex.task.model.servise.DayTimeLineService;
import ua.alex.task.model.servise.Impl.ActivitiesServiceImpl;
import ua.alex.task.model.servise.Impl.DayTimeLineServiceImpl;
import ua.alex.task.model.servise.Organizer;
import ua.alex.task.model.servise.Impl.WorkDayOrganizer;

import java.util.List;

public class Model {
    private Organizer organizer;
    private Day day;
    public Model() {
        day = new WorkDay();
        ActivitiesService activitiesService = new ActivitiesServiceImpl(day);
        DayTimeLineService dayTimeLineService = new DayTimeLineServiceImpl(day);
        organizer = new WorkDayOrganizer(day, activitiesService, dayTimeLineService);
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
