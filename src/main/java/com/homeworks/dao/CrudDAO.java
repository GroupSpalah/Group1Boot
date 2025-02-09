package com.homeworks.dao;

/**
 * Interface {@code CrudDAO} is a general interface for CRUD operations (create, read, update, delete)
 * in the database for any entity type.
 * Uses ``DAO'' (Data Access Object) design pattern.
 * <p>
 * <b>Note.</b> This interface requires one {@code EntityManagerFactory} element
 * to manage the object manager lifecycle.
 *
 * @param <T> the entity type for which the DAO is implemented.
 */

public interface CrudDAO<T> {


    /**
     * Stores the new object in the database.
     *
     * @param obj an object of type {@code T} that is stored in the database.
     */

    void create(T obj);

    /**
     * Updates an existing object in the database.
     *
     * @param obj an object of type {@code T} that is updated in the database.
     */

    void update(T obj);

    /**
     * Returns the object by its identifier.
     *
     * @param tClass the class of the object to retrieve.
     * @param id     object identifier.
     * @return an object of type {@code T} corresponding to the given identifier.
     */

    T getById(Class<T> tClass, int id);

    /**
     * Deletes all objects matching the specified conditions.
     *
     * @param request    the text of the request to delete objects.
     * @param columnName the name of the query parameter corresponding to the identifier.
     * @param id         the value of the identifier to search for objects to delete.
     */
    void deleteAllAdByParam(String request, String columnName, int id);

    /**
     * Deletes a specific object from the database.
     *
     * @param obj an object of type {@code T} to be deleted from the database.
     * @throws IllegalArgumentException if {@code obj} is {@code null}.
     */
    void delete(T obj);

}
