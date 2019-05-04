package ua.alex.task.model;

import ua.alex.task.DAO.ActivitiesDAO;
import ua.alex.task.servise.WorkDayOrganizer;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyDebuger {
    public static void main(String[] args) {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        System.out.println(day.getActivityList());
    }
}
