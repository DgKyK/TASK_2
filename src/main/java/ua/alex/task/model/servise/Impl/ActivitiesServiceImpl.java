package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.dao.ActivitiesDao;
import ua.alex.task.model.dao.DaoFactory;
import ua.alex.task.model.servise.ActivitiesService;

import java.util.List;

public class ActivitiesServiceImpl implements ActivitiesService {
    private ActivitiesDao dao;
    private Day day;

    public ActivitiesServiceImpl(Day day) {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.createActivityDao();
        this.day = day;
    }

    @Override
    public List<Activity> getAllSuitableActivitiesByPriority(int priority) {
        return dao.getSuitableActivitiesByPriority(day, priority);
    }
}
