package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "/run", method = RequestMethod.GET)
    public void getAction() {
        System.out.println("Hello");
    }

    @GetMapping("/new/{id}/{name}")
    @ResponseBody
    public String getActionNew(@PathVariable("id") int id,
                             @PathVariable("name") String name) {
        return "Hello " + name + " - " + id;
    }
}
