package com.homeworks.dao.impl;

import com.homeworks.dao.AdDAO;
import com.homeworks.domain.Ad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.homeworks.util.ConstantsUtil.*;

//@NoArgsConstructor//??
@Repository
@Transactional
public class AdDaoImpl extends CrudDaoImpl<Ad> implements AdDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(Ad ad) {
        int id = ad.getId();
        Ad existingAd = em.find(Ad.class, id);

        em.remove(existingAd);
    }

    /**
     * Deletes all {@link Ad} entities associated with the specified heading.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with author-specific values.
     *
     * @param authorId the ID of the author whose matching ads should be deleted
     */
    @Override
    public void deleteAllAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_ADS_BY_AUTHOR, FK_AD_AUTHOR, authorId);
    }

    /**
     * Deletes all {@link Ad} entities associated with the specified heading.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with heading-specific values.
     *
     * @param headingId the ID of the heading whose matching ads should be deleted
     */
    @Override
    public void deleteAllAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_ADS_BY_HEADING, FK_AD_HEADING, headingId);
    }

    @Override
    public void deleteInactiveAds() {
        Query query = em.createQuery(DELETE_INACTIVE_ADS);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
    }

    /**
     * Retrieves a list of ads associated with the specified heading IDs.
     * Utilizes a parameterized query approach with `getAdsByParam`.
     *
     * @param headingIds a list of heading IDs to filter ads
     * @return a list of {@link Ad} entities associated with the specified headings
     */
    @Override
    public List<Ad> getAdsByHeadings(List<Integer> headingIds) {
        return getAdsByParam(SELECT_ADS_BY_HEADINGS, HEADING_IDS, headingIds);
    }

    /**
     * Retrieves a list of ads published on the specified date.
     * Uses `getAdsByParam` for a parameterized query based on publication date.
     *
     * @param publicationDate the publication date to filter ads
     * @return a list of {@link Ad} entities published on the specified date
     */
    @Override
    public List<Ad> getAdsByPublicationDate(LocalDate publicationDate) {
        return getAdsByParam(SELECT_ADS_BY_PUBLICATION_DATE, PUBLICATION_DATE, publicationDate);
    }

    /**
     * Retrieves a list of ads associated with the specified author ID.
     * Uses `getAdsByParam` for author-specific filtering.
     *
     * @param authorId the ID of the author to filter ads
     * @return a list of {@link Ad} entities associated with the specified author
     */
    @Override
    public List<Ad> getAdsByAuthor(int authorId) {
        return getAdsByParam(SELECT_ADS_BY_AUTHOR_ID, FK_AD_AUTHOR, authorId);
    }

    /**
     * Retrieves a list of ads that contain the specified keyword.
     * Uses `getAdsByParam` to perform keyword-based filtering.
     *
     * @param keyWord the keyword to search within ads' content
     * @return a list of {@link Ad} entities containing the specified keyword
     */
    @Override
    public List<Ad> getAdsByKeyword(String keyWord) {
        return getAdsByParam(SELECT_ADS_BY_BY_KEYWORD, WORD, keyWord);
    }

    /**
     * Executes a parameterized query based on the given request and parameter.
     * This method is used internally to handle various filtering queries for ads.
     *
     * @param request    the JPQL query string to execute
     * @param columnName the parameter name used in the query
     * @param obj        the parameter value to filter the query
     * @return a list of {@link Ad} entities that match the specified filter
     */
    private List<Ad> getAdsByParam(String request, String columnName, Object obj) {
        TypedQuery<Ad> query = em.createQuery(request, Ad.class);
        query.setParameter(columnName, obj);

        return query.getResultList();
    }
}
