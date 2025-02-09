package com.homeworks.dao;

import com.homeworks.domain.Ad;
import com.homeworks.domain.Email;

import java.util.Set;

/**
 * The {@code EmailDAO} interface provides methods for accessing and managing
 * email-related data in the database.
 * <p>
 * It defines an operation for retrieving a set of emails that are suitable
 * based on the criteria in the provided {@link Ad} object.
 * </p>
 * <p><b>Note:</b> This interface assumes the use of a singleton {@code EntityManagerFactory}
 * to manage the entity manager lifecycle.</p>
 *
 * @see Ad
 */
public interface EmailDAO {

    /**
     * Factory for creating {@code EntityManager} instances used to interact
     * with the persistence context.
     */
/*
    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);
*/

    /**
     * Finds all suitable email records based on the criteria defined by the provided
     * {@link Ad} instance.
     *
     * @param ad the {@code Ad} object containing criteria for filtering emails.
     *           Must not be {@code null}.
     * @return a {@code Set} of {@code Email} objects that match the given criteria.
     * @throws IllegalArgumentException if {@code ad} is {@code null}.
     */
    Set<Email> findAllSuitableEmails(Ad ad);
}
