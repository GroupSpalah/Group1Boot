package com.homeworks.service;

import com.homeworks.domain.Ad;

import java.time.LocalDate;
import java.util.List;

/**
 * Service interface for managing advertisements and implementing business logic related to advertisements.
 * <p>
 * This interface provides methods for managing and processing advertisements, such as:
 * <p>
 * - Deleting advertisements based on author or heading.
 * <p>
 * - Retrieving advertisements by specific criteria like publication date or keywords.
 * <p>
 * These methods utilize the DAO layer to access and modify the underlying data, but they
 * allow the introduction of additional business logic and validation before interacting with the database.
 */
public interface AdService extends CrudService<Ad> {

    void deleteInactiveAds();

    List<Ad> getAdsByHeadings(List<Integer> headingIds);

    List<Ad> getAdsByPublicationDate(LocalDate publicationDate);

    List<Ad> getAdsByAuthor(int authorId);

    List<Ad> getAdsByKeyword(String keyWord);
}
