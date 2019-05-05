package ua.alex.task.dao;

import java.sql.Statement;


public abstract class AbstractDAO {
    protected WrapperConnector connector;

    public void close() {
        connector.closeConnection();
    }

    public void closeStatement(Statement statement) {
        connector.closeStatemeent(statement);
    }

}
