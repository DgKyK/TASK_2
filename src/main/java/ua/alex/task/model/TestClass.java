package ua.alex.task.model;

import ua.alex.task.servise.WorkDayOrganizer;

public class TestClass {
    public static void main(String[] args) {
        Day day = new WorkDay();
        WorkDayOrganizer test = new WorkDayOrganizer(day);
        test.formDay();
        System.out.println(day);
    }
}
