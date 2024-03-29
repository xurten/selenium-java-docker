package com.database;

import com.model.Log;
import java.sql.*;

public class SqlRepository implements IRepository<Log> {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";
    static final String DB_URL_WITH_DB ="jdbc:mysql://localhost/logs";
    static final String USER = "root";
    static final String PASS = "root";
    static final String INSERT_INTO_LOGS = "insert into logs(message, testName, currentDate) values ('%s', '%s', '%s');";
    static final String CREATE_TABLE = "CREATE TABLE logs (id int NOT NULL AUTO_INCREMENT, message VARCHAR(200), testName VARCHAR(50), currentDate datetime, PRIMARY KEY(id));";

    @Override
    public void prepareDatabase() {
        executeUpdateWithoutDb("CREATE DATABASE logs;");
        executeUpdate(CREATE_TABLE, DB_URL_WITH_DB);
    }

    @Override
    public void add(Log entity) {
        executeUpdateWithDb(String.format(INSERT_INTO_LOGS, entity.getMessage(), entity.getSuccess(), entity.getCurrentDate()));
    }

    public void executeUpdateWithoutDb(String query) {
        executeUpdate(query, DB_URL);
    }

    public void executeUpdate(String query, String url) {
        try(Connection connection = DriverManager.getConnection(url, USER, PASS);Statement statement = connection.createStatement()){
            Class.forName(JDBC_DRIVER);
            int affectedRows = statement.executeUpdate(query);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void executeUpdateWithDb(String query) {
        executeUpdate(query, DB_URL_WITH_DB);
    }
}
