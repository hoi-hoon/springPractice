package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParam")
    public String getParam(@RequestParam String id, @RequestParam(name = "password") String pw){
        System.out.println("id: "+id+", pw: " + pw);
        return id + pw;
    }

    @GetMapping("/getMultiPram")
    public String getMultiParam(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        return "OK";
    }
}
