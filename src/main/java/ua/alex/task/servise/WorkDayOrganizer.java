package ua.alex.task.servise;

import ua.alex.task.dao.ActivitiesDAO;
import ua.alex.task.model.*;

import java.time.LocalTime;
import java.util.*;

public class WorkDayOrganizer implements Organizer {
    private Day day;
    private ActivitiesDAO dao;

    public WorkDayOrganizer(Day day) {
        this.dao = new ActivitiesDAO();
        this.day = day;
    }

    @Override
    public void formDay() {
        LocalTime startTime = day.getStartOfDay();
        List<Activity> activities = getAllActivities();
        activities.sort( Comparator.comparingInt(Activity::getPriority) );
        Activity currentActivity;
        LocalTime tempTime;
        for(int i = 0; i < activities.size() && !startTime.equals(day.getEndOfDay()); i++) {
            currentActivity = activities.get(i);
            tempTime = startTime;
            if (isBetweenStartEndOfDay(startTime) && enoughTimeForActivity(startTime, currentActivity) &&
                            checkIsTimeFree(startTime)) {
                    day.addActivities(startTime, currentActivity);
                    startTime = startTime.plusHours(currentActivity.getDuration().getHour());
                    tempTime = startTime.plusHours(currentActivity.getPeriodicity().getHour());
                    if (currentActivity.getTimesPerDay() == 2 &&
                                    checkIsTimeFree(tempTime) && isBetweenStartEndOfDay(tempTime) &&
                                    enoughTimeForActivity(tempTime,currentActivity)) {
                        day.addActivities(tempTime, currentActivity);
                    }
            }
        }
    }

    private List<Activity> getAllActivities() {
        return dao.getAllActivities();
    }

    /*Below access identifier is public for tests*/
    public boolean isBetweenStartEndOfDay(LocalTime time) {
        return time.getHour() >= day.getStartOfDay().getHour() && time.isBefore(day.getEndOfDay());
    }

    private boolean checkIsTimeFree(LocalTime time) {
        Activity temp = day.getSchedule().get(time);
        return temp == null;
    }

    private boolean enoughTimeForActivity(LocalTime startTime, Activity activity) {
        int duration = activity.getDuration().getHour();
        Map<LocalTime, Activity> schedule = day.getSchedule();
        Activity temp;
        for (int i = 0; i < duration; i++) {
            temp = schedule.get(startTime);
            if(temp != null) {
                return false;
            }
            startTime = startTime.plusHours(1);
        }
        return true;
    }
}
