package cn.elook.test;

import cn.elook.common.bean.TestBean;
import cn.elook.common.utils.CommonResult;
import cn.elook.test.mapper.TestMapper;
import cn.elook.test.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElookTestApplication.class})
public class ElookTestApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	public void contextLoads() {
		CommonResult commonResult = testService.getTestById(1l);
		System.out.println(commonResult.getMessage());
	}

	@Test
	public void create() {
		TestBean testBean = new TestBean();
		testBean.setTname("dads");
		testBean.setContent("adadada");
		CommonResult commonResult = testService.insertTest(testBean);
		System.out.println(commonResult.getMessage());
	}

}
