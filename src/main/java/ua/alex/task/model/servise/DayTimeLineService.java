package ua.alex.task.model.servise;

import ua.alex.task.model.Activity;
import java.util.List;

public interface DayTimeLineService {
    List<Activity> createDayTimeLine(List<Activity> activitiesList);
}
