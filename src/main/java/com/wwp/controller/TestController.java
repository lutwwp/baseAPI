package com.wwp.controller;

import com.wwp.pojo.Test;
import com.wwp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * RestController相当于@ResponseBody ＋ @Controller合在一起的作用
     * @return
     */
    @RequestMapping("/")
    public Test test(){
        return testService.findById("001");
    }

}
