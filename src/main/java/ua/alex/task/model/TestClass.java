package ua.alex.task.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        LocalTime one = LocalTime.of(13,0);
        LocalTime two = LocalTime.of(13,0);
        System.out.println(one.isAfter(two));
    }
}
