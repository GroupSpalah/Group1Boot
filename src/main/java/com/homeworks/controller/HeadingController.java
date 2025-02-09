package com.homeworks.controller;

import com.homeworks.domain.Heading;
import com.homeworks.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("headings-management")
//@AllArgsConstructor
public class HeadingController {

    private final CrudService<Heading> headingService;

    @Autowired
    public HeadingController(CrudService<Heading> HeadingService) {
        this.headingService = HeadingService;
    }

    @PostMapping("/headings")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Heading obj) {
        headingService.create(obj);
    }

    @PutMapping("/headings")
    public void update(@RequestBody Heading obj) {
        headingService.update(obj);

    }

    @GetMapping("/headings/{id}")
    @ResponseBody
    public Heading getHeadingsById(@PathVariable(name = "id") int id) {
        return headingService.getById(id);
    }

    @DeleteMapping("/headings")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Heading obj) {
        headingService.delete(obj);
    }
}
