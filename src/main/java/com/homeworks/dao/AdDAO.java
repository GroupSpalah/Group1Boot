package com.homeworks.dao;

import com.homeworks.domain.Ad;

import java.time.LocalDate;
import java.util.List;

/**
 * The {@code AdDAO} interface provides data access operations specifically
 * for the {@link Ad} entity, extending the basic CRUD operations from
 * {@link CrudDAO}.
 * <p>
 * This interface allows for managing ads by various parameters, such as
 * author ID, heading ID, publication date, and keywords.
 * </p>
 *
 * @see CrudDAO
 * @see Ad
 */
public interface AdDAO extends CrudDAO<Ad> {

    /**
     * Deletes all ads associated with a given author's ID.
     *
     * @param authorId the ID of the author whose ads are to be deleted.
     */
    void deleteAllAdByAuthorId(int authorId);

    /**
     * Deletes all ads associated with a specific heading ID.
     *
     * @param headingId the ID of the heading whose ads are to be deleted.
     */
    void deleteAllAdByHeadingId(int headingId);

    /**
     * Deletes all inactive ads from the database.
     */
    void deleteInactiveAds();

    /**
     * Retrieves a list of ads associated with the given list of heading IDs.
     *
     * @param headingIds a list of heading IDs for which ads are to be retrieved.
     * @return a list of {@link Ad} objects matching the specified heading IDs.
     */
    List<Ad> getAdsByHeadings(List<Integer> headingIds);

    /**
     * Retrieves a list of ads that were published on a specific date.
     *
     * @param publicationDate the date of publication to filter ads by.
     * @return a list of {@link Ad} objects published on the specified date.
     */
    List<Ad> getAdsByPublicationDate(LocalDate publicationDate);

    /**
     * Retrieves a list of ads associated with a specific author's ID.
     *
     * @param authorId the ID of the author whose ads are to be retrieved.
     * @return a list of {@link Ad} objects associated with the specified author.
     */
    List<Ad> getAdsByAuthor(int authorId);

    /**
     * Searches for ads that contain the specified keyword in their content.
     *
     * @param keyWord the keyword to search for within the ad content.
     * @return a list of {@link Ad} objects that match the given keyword.
     */
    List<Ad> getAdsByKeyword(String keyWord);
}