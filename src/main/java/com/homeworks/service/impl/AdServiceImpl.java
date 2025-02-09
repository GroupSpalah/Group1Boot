package com.homeworks.service.impl;

import com.homeworks.dao.AdDAO;
import com.homeworks.dao.EmailDAO;
import com.homeworks.dao.impl.AdDaoImpl;
import com.homeworks.dao.impl.EmailDaoImpl;
import com.homeworks.domain.Ad;
import com.homeworks.domain.Email;
import com.homeworks.service.AdService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * The AdServiceImpl class is responsible for managing ads and handling related business logic.
 * Provides methods for CRUD operations on ads, as well as additional functions for ad management.
 * This class interacts with the DAO layer to perform these operations.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service/*("AdService")*/
//@AllArgsConstructor
public class AdServiceImpl implements AdService {

    EmailDAO EMAIL_DAO = new EmailDaoImpl();
    AdDAO AD_DAO = new AdDaoImpl();

    /**
     * Creates a new ad and retrieves suitable emails for notification based on the ad details.
     *
     * @param ad the Ad object to create
     */
    @Override
    public void create(Ad ad) {
        AD_DAO.create(ad);
        Set<Email> allSuitableEmails = EMAIL_DAO.findAllSuitableEmails(ad);
        System.out.println(allSuitableEmails);
    }

    @Override
    public void update(Ad ad) {
        AD_DAO.update(ad);
    }

    @Override
    public Ad getById(int id) {
        return AD_DAO.getById(Ad.class, id);
    }

    @Override
    public void delete(Ad ad) {
        AD_DAO.delete(ad);
    }

    @Override
    public List<Ad> getAdsByHeadings(List<Integer> headingIds) {
        return AD_DAO.getAdsByHeadings(headingIds);
    }

    @Override
    public List<Ad> getAdsByPublicationDate(LocalDate publicationDate) {
        return AD_DAO.getAdsByPublicationDate(publicationDate);
    }

    @Override
    public List<Ad> getAdsByAuthor(int authorId) {
        return AD_DAO.getAdsByAuthor(authorId);
    }

    @Override
    public List<Ad> getAdsByKeyword(String keyWord) {
        return AD_DAO.getAdsByKeyword(keyWord);
    }

    public void deleteInactiveAds() {
        AD_DAO.deleteInactiveAds();
    }
}
