package cn.elook.test.customer.controller;

import cn.elook.common.bean.TestBean;
import cn.elook.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestCusController {

    public static final String TEST_URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customer/test/{id}")
    public CommonResult<TestBean> getTestById(@PathVariable("id") Long id){
        return restTemplate.getForObject(TEST_URL+"/test/"+id,CommonResult.class);
    }

    @GetMapping("/customer/test/add")
    public CommonResult<TestBean> addTest(TestBean testBean){
        return restTemplate.getForObject(TEST_URL+"/test/add",CommonResult.class);
    }
}
