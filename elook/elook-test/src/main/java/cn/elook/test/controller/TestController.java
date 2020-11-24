package cn.elook.test.controller;

import cn.elook.common.bean.TestBean;
import cn.elook.common.utils.CommonResult;
import cn.elook.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    private TestBean testBean;

    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/test/{id}")
    public CommonResult getTestById(@PathVariable("id") Long id){
        return testService.getTestById(id);
    }

    @PostMapping("/test/add")
    public CommonResult insertTest(TestBean testBean){
        return testService.insertTest(testBean);
    }
}
