package com.homeworks.controller;

import com.homeworks.domain.Author;
import com.homeworks.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("authors-management")
//@AllArgsConstructor
public class AuthorController {

    private final CrudService<Author> authorService;

    @Autowired
    public AuthorController(CrudService<Author> authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Author obj) {
        authorService.create(obj);
    }

    @PutMapping("/authors")
    public void update(@RequestBody Author obj) {
        authorService.update(obj);

    }

    @GetMapping("/authors/{id}")
    @ResponseBody
    public Author getAuthorsById(@PathVariable(name = "id") int id) {
        return authorService.getById(id);
    }

    @DeleteMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Author obj) {
        authorService.delete(obj);
    }
}
