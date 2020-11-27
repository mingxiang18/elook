package cn.elook.indent.controller;


import cn.elook.common.entity.Indent;
import cn.elook.common.utils.CommonResult;
import cn.elook.indent.service.IndentService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/indent")
public class IndentController {

    @Autowired
    private IndentService indentService;


    //获取订单基本信息,可分页和按订单时间排序
    @GetMapping("/list")
    public CommonResult getIndentList(Integer index,Integer pageSize,String sort){
        return indentService.findAll(index,pageSize,sort);
    }

    //获取订单详细信息,包括买家卖家的用户名和商品名称，可分页和按订单时间排序
    @GetMapping("/listDetails")
    public CommonResult getIndentListDetails(Integer index,Integer pageSize,String sort){
        return indentService.findAllDetails(index,pageSize,sort);
    }

    //根据订单ID模糊查询获取订单基本信息，可分页和按订单时间排序
    @GetMapping("/get")
    public CommonResult getIndent(String oId,Integer index,Integer pageSize,String sort){
        return indentService.findById(oId,index,pageSize,sort);
    }

    //根据订单ID模糊查询获取订单详细信息，包括买家卖家的用户名和商品名称，可分页和按订单时间排序
    @GetMapping("/getDetails")
    public CommonResult getIndentDetails(String oId,Integer index,Integer pageSize,String sort){
        return indentService.findByIdDetails(oId,index,pageSize,sort);
    }

    //根据买家ID查询获取订单基本信息，可分页和按订单时间排序
    @GetMapping("/getBuyer")
    public CommonResult getIndentByBuyer(Long buyerId,Integer index,Integer pageSize,String sort){
        return indentService.findByBuyerId(buyerId,index,pageSize,sort);
    }

    //根据买家ID查询获取订单详细信息，包括买家卖家的用户名和商品名称，可分页和按订单时间排序
    @GetMapping("/getBuyerDetails")
    public CommonResult getIndentDetailByBuyer(Long buyerId,Integer index,Integer pageSize,String sort){
        return indentService.findByBuyerIdDetails(buyerId,index,pageSize,sort);
    }

    //根据卖家ID查询获取订单基本信息，可分页和按订单时间排序
    @GetMapping("/getVendor")
    public CommonResult getIndentByVendor(Long vendorId,Integer index,Integer pageSize,String sort){
        return indentService.findByVendorId(vendorId,index,pageSize,sort);
    }

    //根据卖家ID查询获取订单详细信息，包括买家卖家的用户名和商品名称，可分页和按订单时间排序
    @GetMapping("/getVendorDetails")
    public CommonResult getIndentDetailByVendor(Long vendorId,Integer index,Integer pageSize,String sort){
        return indentService.findByVendorIdDetails(vendorId,index,pageSize,sort);
    }

    //添加订单
    @PostMapping("/add")
    public CommonResult addIndent(Indent indent){
        Date date = new Date();
        indent.setIndentCreateTime(date);
        String year=String.format("%tY", date);
        String mon=String .format("%tm", date);
        String day=String .format("%td", date);
        String rand1 = RandomStringUtils.randomAlphanumeric(3);
        String rand2 = RandomStringUtils.randomAlphanumeric(3);
        String idString = indent.getpId()+rand1+year+mon+day+rand2+indent.getBuyerId();
        indent.setoId(idString);
        return indentService.saveIndent(indent);
    }

    //根据订单号删除订单
    @PostMapping("/delete")
    public CommonResult deleteIndent(String oId){
        return indentService.deleteIndentById(oId);
    }

    //修改订单
    @PostMapping("/update")
    public CommonResult updateIndent(Indent indent){
        return indentService.updateIndent(indent);
    }


    //分页计算页数
    @GetMapping("/count")
    public CommonResult countIndent(){
        return indentService.indentCount();
    }


    //计算订单总数
    @GetMapping("countAll")
    public CommonResult countAllIndent(){
        return indentService.indentCountAll();
    }

    //分页计算买家个人订单页数
    @GetMapping("/countBuyer")
    public CommonResult countBuyerIndent(Long buyerId){
        return indentService.countBuyerIndent(buyerId);
    }


    //计算买家订单总数
    @GetMapping("countBuyerAll")
    public CommonResult countBuyerAllIndent(Long buyerId){
        return indentService.countBuyerAllIndent(buyerId);
    }

    //分页计算买家个人订单页数
    @GetMapping("/countVendor")
    public CommonResult countVendorIndent(Long vendorId){
        return indentService.countVendorIndent(vendorId);
    }


    //计算买家订单总数
    @GetMapping("countVendorAll")
    public CommonResult countVendorAllIndent(Long vendorId){
        return indentService.countVendorAllIndent(vendorId);
    }


}
