package com.database;

public interface IRepository {
    void prepereDatabase();
    void executeUpdateWithoutDb(String query);
    void executeUpdate(String query, String url);
    void executeUpdateWithDb(String query);
}
