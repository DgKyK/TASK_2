package ua.alex.task.model.dao.Impl;

import ua.alex.task.model.dao.ActivitiesDao;
import ua.alex.task.model.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCDaoFactory extends DaoFactory {


    @Override
    public ActivitiesDao createActivityDao() {
        return new JDBCActivitiesDao(getConnection());
    }

    private Connection getConnection() {
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        try {
            return DriverManager.getConnection(
                    rb.getString("url"),
                    rb.getString("user"),
                    rb.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
