package ua.alex.task.model.servise.Impl;

import ua.alex.task.model.Activity;
import ua.alex.task.model.Day;
import ua.alex.task.model.dao.ActivitiesDao;
import ua.alex.task.model.dao.DaoFactory;
import ua.alex.task.model.servise.ActivitiesService;

import java.util.List;

public class ActivitiesServiceImpl implements ActivitiesService {
    private ActivitiesDao dao;

    public ActivitiesServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.createActivityDao();
    }

    @Override
    public List<Activity> getAllSuitableActivities(Day day) {
        return dao.getSuitableActivities(day);
    }
}
