package com.homeworks.dao;


import com.homeworks.domain.MatchingAd;

/**
 * DAO interface for managing {@link MatchingAd} entities.
 * Extends the {@link CrudDAO} interface to provide basic CRUD operations and
 * additional methods specific to {@link MatchingAd} management.
 */
public interface MatchingAdDAO extends CrudDAO<MatchingAd> {

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified author.
     *
     * @param authorId the ID of the author whose matching ads should be deleted
     */
    void deleteAllMAdByAuthorId(int authorId);

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified heading.
     *
     * @param headingId the ID of the heading whose matching ads should be deleted
     */
    void deleteAllMAdByHeadingId(int headingId);
}
