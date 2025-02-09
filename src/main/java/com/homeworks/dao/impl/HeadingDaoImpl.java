package com.homeworks.dao.impl;


import com.homeworks.dao.AdDAO;
import com.homeworks.dao.MatchingAdDAO;
import com.homeworks.domain.Heading;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Repository("headingDaoImpl")
@Transactional
public class HeadingDaoImpl extends CrudDaoImpl<Heading> /*implements CrudDAO<Heading>*/ {

    final AdDAO AD_DAO;

    final MatchingAdDAO MATCHING_AD_DAO;

    public HeadingDaoImpl(AdDAO AD_DAO, MatchingAdDAO MATCHING_AD_DAO) {
        this.AD_DAO = AD_DAO;
        this.MATCHING_AD_DAO = MATCHING_AD_DAO;
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(Heading heading) {

        Heading existingHeading = em.find(Heading.class, heading.getId());

        AD_DAO.deleteAllAdByHeadingId(existingHeading.getId());
        MATCHING_AD_DAO.deleteAllMAdByHeadingId(existingHeading.getId());

        em.remove(existingHeading);


    } // переделать на 1 запрос к базе вместо 2 find remove
}
