package cn.elook.indent.test;


import cn.elook.common.entity.Indent;
import cn.elook.common.entity.IndentDetails;
import cn.elook.common.utils.CommonResult;
import cn.elook.indent.ElookIndentApplication;
import cn.elook.indent.service.IndentService;
import org.apache.commons.lang.RandomStringUtils;
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
        indent.setVendorId(2L);
        indent.setBuyerId(1L);
        indent.setAddress("广东省湛江市广东海洋大学海思eggg");
        indent.setIndentPrice(86.0f);
        Date date = new Date();
        indent.setIndentCreateTime(date);
        String year=String.format("%tY", date);
        String mon=String .format("%tm", date);
        String day=String .format("%td", date);
        String rand1 = RandomStringUtils.randomAlphanumeric(3);
        String rand2 = RandomStringUtils.randomAlphanumeric(3);
        indent.setIndentState(1);
        indent.setpId(14l);
        String idString = indent.getpId()+rand1+year+mon+day+rand2+indent.getBuyerId();
        indent.setoId(idString);
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
        indent.setAddress("广东省湛江市广东海洋大学海思ABC517");
        indent.setIndentPrice(999.0f);
        indent.setIndentCreateTime(new Date());
        indent.setIndentState(3);
        indent.setpId(3l);
        CommonResult commonResult = indentService.updateIndent(indent);
        System.out.println(commonResult.getCode()+commonResult.getMessage()+commonResult.getData());
        System.out.println(commonResult.getMessage());
        System.out.println(commonResult.getData());
    }

    @Test
    public void findAllDetails(){
        CommonResult commonResult = indentService.findAllDetails(0,2,"Asc");
        System.out.println(commonResult.getData());
    }

    @Test
    public void findByIdDetailsTest(){
        CommonResult commonResult = indentService.findByIdDetails("%IT20112466%",0,2,"Asc");
        System.out.println(commonResult.getData());
    }

    @Test
    public void IndentCount(){
        IndentDetails indent = new IndentDetails();
        indent.setoId("裤子");
//       indent.setVendorId(1l);
//        indent.setBuyerId(2l);
//        indent.setIndentState(2);
//        indent.setpId(3l);
//        indent.setIndentState(0);
        indent.setProductName("裤子");
        indent.setBuyerName("裤子");
        indent.setVendorName("裤子");
        CommonResult commonResult = indentService.indentCount(indent,10,"desc");
        System.out.println(commonResult.getData());
    }

    @Test
    public void BuyerIndentCount(){
        CommonResult commonResult = indentService.countBuyerIndent(1l,10);
        System.out.println(commonResult.getData());
    }

    @Test
    public void IndentIDFormat(){
        Date dt=new Date();
        String year=String.format("%tY", dt);
        String mon=String .format("%tm", dt);
        String day=String .format("%td", dt);
        String rand1= RandomStringUtils.randomAlphanumeric(3);
        System.out.println(year+mon+day+rand1);

    }

    @Test
    public void getByAny(){
        IndentDetails indent = new IndentDetails();
        indent.setoId("裤子");
//       indent.setVendorId(1l);
//        indent.setBuyerId(2l);
//        indent.setIndentState(2);
//        indent.setpId(3l);
//        indent.setIndentState(0);
        indent.setProductName("裤子");
        indent.setBuyerName("裤子");
        indent.setVendorName("裤子");
        CommonResult commonResult = indentService.getIndentDetailByAny(indent,0,10,"desc");
//        System.out.println(commonResult.getData());
        List<IndentDetails> indentDetailsList = (List<IndentDetails>)commonResult.getData();
        for(IndentDetails ind : indentDetailsList){
            System.out.println(ind);
        }
    }




}
