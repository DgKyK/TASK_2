package ua.alex.task.model;

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
