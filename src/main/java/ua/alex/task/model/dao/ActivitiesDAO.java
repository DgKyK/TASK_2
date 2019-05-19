package ua.alex.task.model.dao;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;

import java.util.List;

public interface ActivitiesDao extends Dao<Activity> {
    List<Activity> getSuitableActivitiesByPriority(Day day, int priorityLevel);
}
