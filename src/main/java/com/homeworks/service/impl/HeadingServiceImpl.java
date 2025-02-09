package com.homeworks.service.impl;


import com.homeworks.dao.CrudDAO;
import com.homeworks.domain.Heading;
import com.homeworks.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * The HeadingServiceImpl class is responsible for managing headings and handling related business logic.
 * Provides methods for CRUD operations on headings.
 * This class interacts with the DAO layer to perform these operations.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
public class HeadingServiceImpl implements CrudService<Heading> {

    CrudDAO<Heading> HEADING_DAO;

    @Override
    public void create(Heading heading) {
        HEADING_DAO.create(heading);
    }

    @Override
    public void update(Heading heading) {
        HEADING_DAO.update(heading);
    }

    @Override
    public Heading getById(int id) {
        return HEADING_DAO.getById(Heading.class, id);
    }

    @Override
    public void delete(Heading heading) {
        HEADING_DAO.delete(heading);
    }
}
