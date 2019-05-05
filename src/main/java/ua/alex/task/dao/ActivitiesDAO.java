package ua.alex.task.dao;

import ua.alex.task.model.ActivitiesFactory;
import ua.alex.task.model.Activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class ActivitiesDAO extends AbstractDAO {
    private static final String SQL_SELECT_ALL_ACTIVITIES = "SELECT * FROM mydb.activities";

    public ActivitiesDAO() {
        this.connector = new WrapperConnector();
    }

    public List<Activity> getAllActivities() {
        List<Activity> resultListOfActivities = new LinkedList<>();
        Statement st = null;
        try {
            st = connector.getStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ACTIVITIES);
            while (rs.next()) {
                Activity activity = null;
                ActivitiesFactory factory = new ActivitiesFactory();
                if(rs.getInt("Priority") == 1) {
                    activity = factory.createHighImportantActivity();
                } else if (rs.getInt("Priority") == 2) {
                    activity = factory.createMiddleImportantActivity();
                } else if(rs.getInt("Priority") == 3) {
                    activity = factory.createLowImportantActivity();
                }
                if (activity != null) {
                    buildActivity(activity,rs.getString("name"),rs.getInt("Priority"),
                            rs.getInt("Duration"), rs.getInt("Periodicity"),
                            rs.getInt("TimesPerDay"));
                } else throw new SQLException("Not found appropriate priority...");
                resultListOfActivities.add(activity);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                this.closeStatement(st);
            }
        }
        return resultListOfActivities;
    }

    private void buildActivity(Activity activity, String name, int priority,
                               int duration, int periodicity, int timesPerDay) {
        activity.setName(name);
        activity.setPriority(priority);
        activity.setDuration(LocalTime.of(duration,0));
        activity.setPeriodicity(LocalTime.of(periodicity,0));
        activity.setTimesPerDay(timesPerDay);
    }
}
