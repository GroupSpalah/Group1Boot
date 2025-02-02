package com.controller;

import com.domain.Man;
import com.service.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("man")
public class ManController {

    final
    CrudService<Man> service;

    public ManController(CrudService<Man> service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void save(Man man) {
        service.save(man);
    }

    @PutMapping("/update")
    public void update(Man man) {
        service.update(man);
    }

    @GetMapping("/find/{id}")
    public Man getById(@PathVariable("id") int id) {
       return service.findById(id);
    }

    @GetMapping("/find/all/{page}/{size}")
    public List<Man> findAllPagination(@PathVariable("page") int page, @PathVariable("size")int size) {
        return service.usePagination(page, size);
    }

    @GetMapping("/find/{name}/{age}")
    public Man findByNameAndAge(@PathVariable("age") int age, @PathVariable("name")String name) {
       return service.findByAgeAndName(age, name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
       service.deleteById(id);
    }

}

/**
 * /mvc/*
 * /mvc/save/*
 * /mvc/save/find
 */
