package ua.alex.task.model.dao.Impl;

import ua.alex.task.model.*;
import ua.alex.task.model.dao.ActivitiesDao;


import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JDBCActivitiesDao implements ActivitiesDao {
    private Connection connection;
    private static final String SQL_SELECT_ALL_ACTIVITIES = "SELECT * FROM activities";
    private static final String SQL_SELECT_ACTIVITIES_BETWEEN_TIME = "SELECT * FROM activities" +
            " JOIN activities_time ON activities_time.name = activities.name" +
            " WHERE day_time >= ? AND day_time < ?";


    public JDBCActivitiesDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Activity> getAll() {
        List<Activity> resultList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ACTIVITIES);
            while(rs.next()) {
                Activity temp = buildActivity(rs);
                resultList.add(temp);
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Activity> getSuitableActivities(Day day) {
        List<Activity> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ACTIVITIES_BETWEEN_TIME)) {
            ps.setInt(1,day.getStartOfDay().getHour());
            ps.setInt(2,day.getEndOfDay().getHour());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Activity temp = buildActivity(rs);
                result.add(temp);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Activity buildActivity(ResultSet rs) throws SQLException {
        Activity temp;
        int identifier = rs.getInt("Priority");
        ActivitiesFactory factory = new ActivitiesFactory();
        switch (identifier) {
            case 1 : temp = factory.createHighImportantActivity();
                    break;
            case 2 : temp = factory.createMiddleImportantActivity();
                    break;
            case 3 : temp = factory.createLowImportantActivity();
                    break;
            default: throw new RuntimeException("Can`t find suitable data!!!");
        }
        temp.setName(rs.getString("name"));
        temp.setPriority(rs.getInt("Priority"));
        temp.setDuration(LocalTime.of(rs.getInt("Duration"),0));
        temp.setPeriodicity(LocalTime.of(rs.getInt("Periodicity"),0));
        return temp;
    }
}
