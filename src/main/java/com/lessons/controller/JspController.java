package com.lessons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("page")
public class JspController {

    @RequestMapping(value = "/run", method = RequestMethod.GET)
    public ModelAndView getAction(ModelAndView mav) {

        mav.setViewName("hello");

        mav.addObject("message", "Hello, MVC");

        return mav;
    }

}
