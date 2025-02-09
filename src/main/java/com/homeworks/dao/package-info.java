/**
 * A package containing DAO interfaces and their implementations for database access.
 * <p>
 * The main features of the package include providing templates for CRUD operations
 * (create, read, update, delete) for any entities
 * application, storage of the general logic of access to the database and its management.
 * </p>
 *
 * <h2>Main interfaces</h2>
 * <ul>
 * <li>{@link org.com.ad_board.dao.CrudDAO} - the basic interface for all DAO implementations, providing standard
 * methods for performing CRUD operations on entities. Its implementation allows
 * perform basic operations with the database.</li>
 * <li>{@link org.com.ad_board.dao.AdDAO} - provides access to data for the advertising object.</li>
 * <li>{@link org.com.ad_board.dao.EmailDAO} - provides access to data for the email entity.</li>
 * <li>{@link org.com.ad_board.dao.MatchingAdDAO} - provides access to data for a matching ad entity.</li>
 * </ul>
 *
 * <h2>Usage</h2>
 * The package provides a unified approach to working with the database by using
 * a single ``CrudDAO'' interface that implements basic CRUD operations, as well as interfaces that extend it
 * and implement additional operations for individual entities.
 *
 * @see org.com.ad_board.dao.CrudDAO
 * @see org.com.ad_board.dao.AdDAO
 * @see org.com.ad_board.dao.EmailDAO
 * @see org.com.ad_board.dao.MatchingAdDAO
 */
package com.homeworks.dao;