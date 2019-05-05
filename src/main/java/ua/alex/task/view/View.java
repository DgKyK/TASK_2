package ua.alex.task.view;

import ua.alex.task.model.Activity;

import java.time.LocalTime;
import java.util.Map;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String stringBuilder(String...V) {
        StringBuilder string = new StringBuilder();
        for (String current : V) {
            string.append(current);
        }
        return new String(string);
    }

    public void showSchedule(Map<LocalTime, Activity> schedule) {
        StringBuilder scheduleAsString = new StringBuilder("Your schedule : \n");
        for(LocalTime key : schedule.keySet()) {
            scheduleAsString.append(key + " --> " + schedule.get(key) + "\n");
        }
        printMessage(new String(scheduleAsString));
    }
}
