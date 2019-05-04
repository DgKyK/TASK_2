package ua.alex.task.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class WrapperConnector {
    private Connection connection;

    public WrapperConnector() {
        try {
            ResourceBundle rs = ResourceBundle.getBundle("info");
            String url = rs.getString("url");
            String user = rs.getString("user");
            String password = rs.getString("password");
            Properties properties = new Properties();
            properties.put("user", user);
            properties.put("password", password);
            connection = DriverManager.getConnection(url, properties);
        } catch (MissingResourceException e) {
            System.err.println("Properties file is missing!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw  new SQLException("Connection or statement is NULL");
    }

    public void closeStatemeent(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Exception when closing statement!");
            }
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                System.err.println("Exception when closing connection!");
            }
        }
    }
}
