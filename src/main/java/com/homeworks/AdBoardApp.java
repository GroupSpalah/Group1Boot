package com.homeworks;


import com.homeworks.dao.EmailDAO;
import com.homeworks.dao.impl.*;
import com.homeworks.domain.*;
import com.homeworks.service.AdService;
import com.homeworks.service.CrudService;
import com.homeworks.service.impl.AdServiceImpl;
import com.homeworks.service.impl.AuthorServiceImpl;
import com.homeworks.service.impl.HeadingServiceImpl;
import com.homeworks.service.impl.MatchingAdServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class AdBoardApp {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        CrudService<Heading> headingCrudService = new HeadingServiceImpl(new HeadingDaoImpl(new AdDaoImpl(), new MatchingAdDaoImpl()));
        CrudService<Author> authorCrudService = new AuthorServiceImpl(new AuthorDaoImpl(new AdDaoImpl(), new MatchingAdDaoImpl()));
        AdService adService = new AdServiceImpl();
        CrudService<MatchingAd> mAdService = new MatchingAdServiceImpl(new MatchingAdDaoImpl());


        Email johnEmail = Email
                .builder()
                //.id(1202)
                .email("john_travolta@gmail.com")
                .build();

        Email jackEmail = Email
                .builder()
                //.id(1202)
                .email("jack_nicholson@gmail.com")
                .build();

        Address johnAddress = Address
                .builder()
                //.id(602)
                .district("Columbia")
                .city("Washington")
                .street("20 avenue")
                .build();

        Address jackAddress = Address
                .builder()
                //.id(602)
                .district("Columbia")
                .city("Washington")
                .street("80 avenue")
                .build();

        Phone johnPhone = Phone
                .builder()
                //.id(402)
                .phoneNumber("0987654321")
                .build();
        Phone johnPhone2 = Phone
                .builder()
                //.id(403)
                .phoneNumber("0937654321")
                .build();
        Phone johnPhone3 = Phone
                .builder()
                //.id(404)
                .phoneNumber("0957654321")
                .build();

        Phone jackPhone = Phone
                .builder()
                //.id(402)
                .phoneNumber("0981234567")
                .build();
        Phone jackPhone2 = Phone
                .builder()
                //.id(403)
                .phoneNumber("0931234567")
                .build();
        Phone jackPhone3 = Phone
                .builder()
                //.id(404)
                .phoneNumber("0951234567")
                .build();

        Set<Phone> johnPhones = new HashSet<>();

        johnPhones.add(johnPhone);
        johnPhones.add(johnPhone2);
        johnPhones.add(johnPhone3);

        Set<Phone> jackPhones = new HashSet<>();

        jackPhones.add(jackPhone);
        jackPhones.add(jackPhone2);
        jackPhones.add(jackPhone3);

        Author john = Author
                .builder()
                .id(1)
                .firstName("John")
                .lastName("Travolta")
                .address(johnAddress)
                .email(johnEmail)
                .phones(johnPhones)
                .build();

        johnAddress.setAuthor(john);

        johnPhone.setAuthor(john);
        johnPhone2.setAuthor(john);
        johnPhone3.setAuthor(john);


        Author jack = Author
                .builder()
                .id(2)
                .firstName("Jack")
                .lastName("Nicholson")
                .address(jackAddress)
                .email(jackEmail)
                .phones(jackPhones)
                .build();

        jackAddress.setAuthor(jack);

        jackPhone.setAuthor(jack);
        jackPhone2.setAuthor(jack);
        jackPhone3.setAuthor(jack);


        Heading phonesHeading = Heading
                .builder()
                //.id(1)
                .name("Phones")
                .build();

        Ad ad = Ad
                .builder()
                //.id(1)
                .heading(phonesHeading)
                .name("Sale Xiaomi 15")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(2000))
                .content("Selling Xiaomi 15")
                .author(john)
                //.isActive(false)
                .isActive(true)
                .build();

        Ad ad2 = Ad
                .builder()
                //.id(8)
                .heading(phonesHeading)
                .name("Sale IPhone 13")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(800))
                .content("Selling iPhone 13, NEW")
                .author(john)
                .isActive(false)//++
                //.isActive(true)//++
                .build();
        headingCrudService.create(phonesHeading);//++
        headingCrudService.delete(phonesHeading);//(with Ad & mAd)++
        System.out.println(headingCrudService.getById(52).toString());//++

        authorCrudService.create(john);//++
        authorCrudService.create(jack);//++ (ок после взаимоисключения полей автора и адреса)
        authorCrudService.update(john);//++

        /*проверить удаление с (mAd)*/
        authorCrudService.delete(john);//(with Ad & mAd)++

        adService.create(ad);//++
        adService.create(ad2);//++
        adService.update(ad);//++
        adService.deleteInactiveAds();//++
        System.out.println(adService.getById(1));//++
        adService.delete(ad);//++
        System.out.println(adService.getAdsByHeadings(Collections.singletonList(1)));//++
        System.out.println(adService.getAdsByHeadings(Arrays.asList(2, 52)));//++??
        System.out.println(adService.getAdsByPublicationDate(LocalDate.of(2024, 10, 27)));//++
        System.out.println(adService.getAdsByAuthor(1));//++
        System.out.println(adService.getAdsByKeyword("new"));//++
        System.out.println(john.getEmail());//??
        System.out.println(john.getPhones());

        MatchingAd matchingAdJohn1 = MatchingAd
                .builder()
                .author(john)
                //.heading(phonesHeading)
                .subject("IPhone")
                //.priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1000))
                .build();

        MatchingAd matchingAdJack1 = MatchingAd
                .builder()
                .author(jack)
                .heading(phonesHeading)
                .subject("Xiaomi")
                .priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1000))
                .build();

        mAdService.create(matchingAdJohn1);
        mAdService.create(matchingAdJack1);


        MatchingAd matchingAdJohn2 = MatchingAd.builder()
                //.id(3)
                .author(john)
                .heading(phonesHeading)
                .subject("IPhone")
                .priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1600))
                .build();
        mAdService.create(matchingAdJohn2);//++

        EmailDAO EMAIL_DAO = new EmailDaoImpl();


        Set<Email> emails = EMAIL_DAO.findAllSuitableEmails(ad2);//++
        System.out.println(emails);

        mAdService.create(matchingAdJohn2);//работает с полным или частичным совпадением.
        //выводит результат по любому кол-ву установленных фильтров.

        mAdService.delete(matchingAdJohn2);
        System.out.println(mAdService.getById(1));//++
        mAdService.update(matchingAdJohn2);//++
        System.out.println(mAdService.getById(4));//++
    }
}
