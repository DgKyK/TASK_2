package ua.alex.task.DAO;

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
