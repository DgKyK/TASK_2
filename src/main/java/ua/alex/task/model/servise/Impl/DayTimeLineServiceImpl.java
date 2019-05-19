package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.servise.DayTimeLineService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DayTimeLineServiceImpl implements DayTimeLineService {
    private ActivitiesSorter sorter;
    private Day day;

    public DayTimeLineServiceImpl(Day day) {
        sorter = new ActivitiesSorter();
        this.day = day;
    }

    @Override
    public List<Activity> createDayTimeLine(List<Activity> activityList) {
        List<Activity> resultList = new ArrayList<>();
        sorter.sortByStartTime(activityList);
        LocalTime actualTime = day.getStartOfDay();
        for (int i = 0; i < activityList.size() && actualTime != day.getEndOfDay(); i++) {
            Activity currentActivity = activityList.get(i);
            if(currentActivity.getStartTime().isAfter(actualTime) ||
                    currentActivity.getStartTime() == actualTime) {
                resultList.add(currentActivity);
                actualTime = actualTime.plusHours(currentActivity.getDuration().getHour());
            }
        }
        return resultList;
    }
}
