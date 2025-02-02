package com.service;


import java.util.List;

public interface CrudService<T> {

    void save(T t);

    void update(T t);

    void deleteById(int id);

    T findById(int id);

    T findByAgeAndName(int age, String name);

    List<T> usePagination(int page, int size);

}
