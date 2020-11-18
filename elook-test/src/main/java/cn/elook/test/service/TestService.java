package cn.elook.test.service;

import cn.elook.common.bean.TestBean;
import cn.elook.common.utils.CommonResult;

public interface TestService {
    public CommonResult getTestById(Long id);
    public CommonResult insertTest(TestBean testBean);
}
