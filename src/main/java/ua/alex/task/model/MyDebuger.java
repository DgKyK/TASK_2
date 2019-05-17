package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.WorkDayOrganizer;

import java.time.LocalTime;

public class MyDebuger {
    public static void main(String[] args) {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        System.out.println(day.getActivityList());

    }
}
