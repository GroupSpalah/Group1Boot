package com.homeworks.dao.impl;

import com.homeworks.dao.EmailDAO;
import com.homeworks.domain.Ad;
import com.homeworks.domain.Email;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.homeworks.util.ConstantsUtil.*;

@Repository
public class EmailDaoImpl implements EmailDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Set<Email> findAllSuitableEmails(Ad ad) {

/*        EntityTransaction transaction = em.getTransaction();
        transaction.begin()*/;

        TypedQuery<Email> query = em.createQuery(SELECT_MADS_BY_PARAMS, Email.class);
                                //mAd = Ad
        query.setParameter(HEADING_ID2, ad.getHeading().getId());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(CONTENT, ad.getContent());

        //transaction.commit();
        return new HashSet<>(query.getResultList());
    }
}
