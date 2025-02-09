package com.homeworks.dao.impl;

import com.homeworks.dao.MatchingAdDAO;
import com.homeworks.domain.MatchingAd;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.homeworks.util.ConstantsUtil.*;

@Repository("matchingAdDaoImpl")
@Transactional
public class MatchingAdDaoImpl extends CrudDaoImpl<MatchingAd> implements MatchingAdDAO { //SavedSearch

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(MatchingAd mAd) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd existingAd = em.find(MatchingAd.class, mAd.getId());

        em.remove(existingAd);

        transaction.commit();
    }

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified author.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with author-specific values.
     *
     * @param authorId the ID of the author whose matching ads should be deleted
     */
    @Override
    public void deleteAllMAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_MADS_BY_AUTHOR, FK_MAD_AUTHOR, authorId);
    }

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified heading.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with heading-specific values.
     *
     * @param headingId the ID of the heading whose matching ads should be deleted
     */
    @Override
    public void deleteAllMAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_MADS_BY_HEADING, FK_MAD_HEADING, headingId);
    }
}
