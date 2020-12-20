package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping(value = "/postMethod")
    // @RequestMapping(method = RequestMethod.POST, path="/postMethod")
    public String postMethod(@RequestBody SearchParam searchParam){

        return "OK";
    }
}
