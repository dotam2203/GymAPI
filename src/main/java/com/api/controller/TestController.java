package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@RestController
public class TestController {
    @GetMapping("")
    public String index(){
        return "Run API Success!";
    }
}
