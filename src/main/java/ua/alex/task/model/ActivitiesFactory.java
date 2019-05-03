package ua.alex.task.model;

public class ActivitiesFactory {
    public Clean createClean() {
        return new Clean();
    }

    public Job createJob() {
        return new Job();
    }

    public WorkOut createWorkOut() {
        return new WorkOut();
    }

    public Read createRead() {
        return new Read();
    }
}
