package ua.alex.task.model;

import java.time.LocalTime;
import java.util.*;

public class WorkDayOrganizer implements Organizer {
    private Day day;

    public WorkDayOrganizer(Day day) {
        this.day = day;
    }

    @Override
    public void formDay() {
        LocalTime startTime = day.getStartOfDay();
        List<Activity> activities = getAllActivities();
        Activity currentActivity;
        LocalTime tempTime;
        for(int i = 0; i < activities.size() || !startTime.equals(day.getEndOfDay()); i++) {
            currentActivity = activities.get(i);
            tempTime = startTime;
            if (isBetweenStartEndOfDay(startTime) || enoughTimeForActivity(startTime, currentActivity)) {
                if (checkIsTimeFree(startTime)) {
                    day.addActivities(startTime, currentActivity);
                    startTime = startTime.plusHours(currentActivity.getDuration().getHour());
                    if (currentActivity.getTimesPerDay() == 2 ||
                                    checkIsTimeFree(startTime.plusHours(currentActivity.getDuration().getHour()))) {
                        tempTime = startTime.plusHours(currentActivity.getDuration().getHour());
                        day.addActivities(tempTime, currentActivity);
                    }
                }
            }
        }
    }

    private List<Activity> getAllActivities() {
        List<Activity> result = new LinkedList<>();
        result.add(new Read());
        result.add(new Clean());
        result.add(new WorkOut());
        result.add(new Job());
        return result;
    }

    private boolean isBetweenStartEndOfDay(LocalTime time) {
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
