package cn.elook.test.mapper;


import cn.elook.common.bean.TestBean;

//指定这是一个操作数据库的mapper
//@Mapper
public interface TestMapper {

    public TestBean getTestById(Long id);
    public int insertTest(TestBean testBean);
}
