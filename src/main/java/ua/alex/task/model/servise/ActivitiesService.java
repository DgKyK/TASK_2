package ua.alex.task.model.servise;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;

import java.util.List;

public interface ActivitiesService {
    List<Activity> getAllSuitableActivities(Day day);
}
