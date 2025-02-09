package com.homeworks.service.impl;

import com.homeworks.dao.CrudDAO;
import com.homeworks.domain.Author;
import com.homeworks.service.CrudService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * The AuthorServiceImpl class is responsible for managing authors and handling related business logic.
 * Provides methods for CRUD operations on authors.
 * This class interacts with the DAO layer to perform these operations.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements CrudService<Author> {

    CrudDAO<Author> AUTHOR_DAO;

    @Override
    public void create(Author author) {
        AUTHOR_DAO.create(author);
    }

    @Override
    public void update(Author author) {
        AUTHOR_DAO.update(author);
    }

    @Override
    public Author getById(int id) {
        return AUTHOR_DAO.getById(Author.class, id);
    }

    @Override
    public void delete(Author author) {
        AUTHOR_DAO.delete(author);
    }
}
