package com.database;

public interface IRepository<T> {
    void prepareDatabase();
    void add(T entity);
}
