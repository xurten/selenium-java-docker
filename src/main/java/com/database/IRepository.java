package com.database;

public interface IRepository<T> {
    void prepareDatabase();
    void Add(T entity);
}
