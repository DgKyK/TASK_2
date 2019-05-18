package ua.alex.task.model;

import ua.alex.task.model.entity.WorkDay;
import ua.alex.task.model.servise.Impl.WorkDayOrganizer;

public class MyDebuger {
    public static void main(String[] args) {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        System.out.println(day.getActivityList());

    }
}
