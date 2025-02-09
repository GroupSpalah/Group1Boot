package com.homeworks.service;

/**
 * The CrudService interface provides basic CRUD (Create, Read, Update, Delete) operations
 * for entities of type T. It is intended to be implemented by service classes that
 * handle business logic related to the entities, delegating data operations to the DAO layer.
 * <p>
 * These methods ensure that entities can be created, updated, retrieved, and deleted in a consistent
 * manner, abstracting the persistence layer from the client or controller.
 * CRUD operations may involve additional logic, such as validation or transformation,
 * before interacting with the database.
 * </p>
 *
 * @param <T> the type of the entity to be handled by the service
 */
public interface CrudService<T> {

    void create(T obj);

    void update(T obj);

    T getById(int id);

    void delete(T obj);
}
