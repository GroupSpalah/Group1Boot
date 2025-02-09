package com.homeworks.dao.impl;

import com.homeworks.dao.CrudDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public abstract class CrudDaoImpl<T> implements CrudDAO<T> {
    /**
     * Factory for instantiating {@code EntityManager} used for management
     * database operations. Uses the configuration name `UNIT_NAME`
     *///refactor

    @PersistenceContext
    private EntityManager em;

    /**
     * Stores the new object in the database.
     *
     * @param obj an object of type {@code T} that is stored in the database.
     */
    @Transactional
    public void create(T obj) {

/*        EntityTransaction transaction = em.getTransaction();
        transaction.begin();*/

        em.persist(obj);

        //transaction.commit();
    }

    /**
     * Updates an existing object in the database.
     *
     * @param obj an object of type {@code T} that is updated in the database.
     */
    @Transactional
    public void update(T obj) {
/*        EntityTransaction transaction = em.getTransaction();
        transaction.begin();*/

        em.merge(obj);

        //transaction.commit();
    }

    /**
     * Returns the object by its identifier.
     *
     * @param tClass the class of the object to retrieve.
     * @param id     object identifier.
     * @return an object of type {@code T} corresponding to the given identifier.
     */
/*    @Transactional
    public T getById(Class<T> tClass, int id) {
        em.getTransaction();

        T entity = em.find(tClass, id);//?

        String simpleName = tClass.getSimpleName();

        TypedQuery<T> query = em.createQuery("FROM " + simpleName + " WHERE id = :id", tClass);
        query.setParameter("id", id);

        entity = query.getSingleResult();

        return entity;
    }*/

    @Transactional/*(readOnly = true)*/ //не подтягивает??
    public T getById(Class<T> tClass, int id) {
        return em.find(tClass, id);
    }

    /**
     * Deletes all objects matching the specified conditions.
     *
     * @param request    the text of the request to delete objects.
     * @param columnName the name of the query parameter corresponding to the identifier.
     * @param id         the value of the identifier to search for objects to delete.
     */
/*    @Transactional
    public void deleteAllAdByParam(String request, String columnName, int id) {
        em.getTransaction();

        Query query = em.createQuery(request);
        query.setParameter(columnName, id);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
    }*/

    @Transactional
    public void deleteAllAdByParam(String request, String columnName, int id) {
        Query query = em.createQuery(request);//???
        query.setParameter(columnName, id);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
    }

}
