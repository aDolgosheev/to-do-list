package com.dolgosheev.to_do_list.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @GetMapping
    public String index() {
        return "index";
    }


}
