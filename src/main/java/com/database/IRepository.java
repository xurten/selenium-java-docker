package com.database;

public interface IRepository {
    void prepereDatabase();
    void executeQuery(String query);
}
