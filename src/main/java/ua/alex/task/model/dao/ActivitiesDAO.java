package ua.alex.task.model.dao;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.dao.Dao;

import java.util.List;

public interface ActivitiesDao extends Dao<Activity> {
    List<Activity> getSuitableActivities(Day day);
}
