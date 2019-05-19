package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.Activity;

import java.util.Comparator;
import java.util.List;

public class ActivitiesSorter {

    public void sortByPriority(List<Activity> activityList) {
        activityList.sort(Comparator.comparingInt(Activity::getPriority));
    }

    public void sortByStartTime(List<Activity> activityList) {
        activityList.sort ( (first, second) -> first.getStartTime().getHour() - second.getStartTime().getHour());
    }
}
