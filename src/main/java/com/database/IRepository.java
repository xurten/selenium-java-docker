package com.database;

import java.util.List;

public interface IRepository<T> {
    void prepareDatabase();
    List List = null;
    void Add(T entity);
    void Delete(T entity);
    void Update(T entity);
    T FindById(int Id);
}
