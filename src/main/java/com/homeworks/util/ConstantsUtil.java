package com.homeworks.util;

public class ConstantsUtil {

    public static final String PRICE = "price";
    public static final String WORD = "word";
    public static final String CONTENT = "content";
    public static final String HEADING_ID2 = "headingId";
    public static final String HEADING_IDS = "heading_ids";
    public static final String FK_AD_AUTHOR = "FK_Ad_Author";
    public static final String FK_MAD_AUTHOR = "FK_Mad_Author";
    public static final String FK_AD_HEADING = "FK_Ad_Heading";
    public static final String FK_MAD_HEADING = "FK_Mad_Heading";
    public static final String PUBLICATION_DATE = "publication_date";
    public static final String UNIT_NAME = "test-dmytro";

    public static final String DELETE_ADS_BY_AUTHOR = "DELETE FROM Ad a " +
            "WHERE a.author.id = :FK_Ad_Author";//через точку можно углубляться в сущность

    public static final String DELETE_MADS_BY_AUTHOR = "DELETE FROM Matching_ad ma " +
            "WHERE ma.author.id = :FK_Mad_Author";

    public static final String DELETE_ADS_BY_HEADING = "DELETE FROM Ad a " +
            "WHERE a.heading.id = :FK_Ad_Heading";

    public static final String DELETE_INACTIVE_ADS = "DELETE FROM Ad a " +
            "WHERE a.isActive = false";

    public static final String DELETE_MADS_BY_HEADING = "DELETE FROM Matching_ad ma " +
            "WHERE ma.heading.id = :FK_Mad_Heading";

    public static final String SELECT_ADS_BY_PUBLICATION_DATE = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.publicationDate = :publication_date";

    public static final String SELECT_ADS_BY_HEADINGS = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE h.id IN :heading_ids";

    public static final String SELECT_ADS_BY_AUTHOR_ID = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.author.id IN :FK_Ad_Author";

    public static final String SELECT_ADS_BY_BY_KEYWORD = "FROM Ad a " +
            "JOIN FETCH a.heading h " +
            "JOIN FETCH a.author au " +
            "JOIN FETCH au.phones " +
            "WHERE a.content " +
            "LIKE CONCAT('%', :word, '%')";

    public static final String SELECT_MADS_BY_PARAMS =
            "SELECT ma.author.email FROM Matching_ad ma " +
                    "WHERE (ma.heading IS NULL OR ma.heading.id = :headingId) " +
                    "AND (ma.priceFrom IS NULL OR ma.priceFrom <= :price)" +
                    "AND (ma.priceTo IS NULL OR ma.priceTo >= :price)" +
                    "AND (ma.subject IS NULL OR :content LIKE CONCAT('%', ma.subject, '%'))";
}
