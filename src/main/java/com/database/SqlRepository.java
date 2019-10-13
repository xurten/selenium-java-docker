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
    public void Add(Log entity) {
        executeUpdateWithDb(String.format(INSERT_INTO_LOGS, entity.getMessage(), entity.getSuccess(), entity.getCurrentDate()));
    }

    @Override
    public void Delete(Log entity) {

    }

    @Override
    public void Update(Log entity) {

    }

    @Override
    public Log FindById(int Id) {
        return null;
    }

    public void executeUpdateWithoutDb(String query) {
        executeUpdate(query, DB_URL);
    }

    public void executeUpdate(String query, String url) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(url, USER, PASS);
            stmt = conn.createStatement();
            int affectedRows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void executeUpdateWithDb(String query) {
        executeUpdate(query, DB_URL_WITH_DB);
    }
}
