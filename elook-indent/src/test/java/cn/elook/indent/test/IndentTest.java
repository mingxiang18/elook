package cn.elook.indent.test;


import cn.elook.common.entity.Indent;
import cn.elook.common.utils.CommonResult;
import cn.elook.indent.ElookIndentApplication;
import cn.elook.indent.service.IndentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElookIndentApplication.class})
public class IndentTest {

    @Autowired
    private IndentService indentService;


    @Test
    public void findAllTest(){
        CommonResult commonResult = indentService.findAll(0,2,"Asc");
    }

    @Test
    public void saveIndent(){
        Indent indent = new Indent();
        indent.setoId("IT20112466602bb01");
        indent.setVendorId(1L);
        indent.setBuyerId(2L);
        indent.setAddress("广东省湛江市广东海洋大学海思B555");
        indent.setIndentPrice(888.0f);
        indent.setIndentCreateTime(new Date());
        indent.setIndentState(1);
        indent.setpId(2l);
        indentService.saveIndent(indent);
        System.out.println(new Date());
    }

    @Test
    public void findByIdTest(){
        System.out.println(indentService.findById("%IT201124%",0,2,"Asc"));
    }

    @Test
    public void deleteByIdTest(){
        indentService.deleteIndentById("IT201124bbt02w01");
        System.out.println("success");
    }

    @Test
    public void updateIndent(){
        Indent indent = new Indent();
        indent.setoId("IT20112466602i01");
        indent.setVendorId(1l);
        indent.setBuyerId(2l);
        indent.setAddress("广东省湛江市广东海洋大学海思BBB517");
        indent.setIndentPrice(999.0f);
        indent.setIndentCreateTime(new Date());
        indent.setIndentState(3);
        indent.setpId(3l);
        indentService.updateIndent(indent);
        System.out.println(indent);
    }





}
