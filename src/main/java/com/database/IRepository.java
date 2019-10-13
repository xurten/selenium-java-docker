package com.database;

public interface IRepository {
    void prepereDatabase();
    void executeUpdate(String query);
    void executeUpdate(String query, String url);
}
