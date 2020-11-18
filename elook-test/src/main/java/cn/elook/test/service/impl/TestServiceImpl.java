package cn.elook.test.service.impl;

import cn.elook.common.bean.TestBean;
import cn.elook.common.utils.CommonResult;
import cn.elook.test.mapper.TestMapper;
import cn.elook.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    public CommonResult getTestById(Long id){
        TestBean testBean = testMapper.getTestById(id);
        if(testBean != null){
            return new CommonResult(200,"查询成功",testBean);
        }else {
            return new CommonResult(444,"查询没有对应记录，id："+id);
        }
    }

    @Override
    public CommonResult insertTest(TestBean testBean) {
        int result = testMapper.insertTest(testBean);
        if(result > 0){
            return new CommonResult(200,"添加数据成功",result);
        }else {
            return new CommonResult(444,"添加数据失败");
        }
    }
}
