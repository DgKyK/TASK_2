package ua.alex.task.model;

import ua.alex.task.model.entity.HighImportantActivity;
import ua.alex.task.model.entity.LowImportantActivity;
import ua.alex.task.model.entity.MiddleImportantActivity;

public class ActivitiesFactory {

    public MiddleImportantActivity createMiddleImportantActivity() {
        return new MiddleImportantActivity();
    }

    public HighImportantActivity createHighImportantActivity() {
        return new HighImportantActivity();
    }

    public LowImportantActivity createLowImportantActivity() {
        return new LowImportantActivity();
    }
}
