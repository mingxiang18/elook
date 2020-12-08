package cn.elook.indent.service;

import cn.elook.common.entity.Indent;
import cn.elook.common.entity.IndentDetails;
import cn.elook.common.utils.CommonResult;

import java.util.List;

public interface IndentService {


    //查询所有订单,分页/按降序或升序查询
    public CommonResult findAll(Integer index, Integer pageSize, String sort);

    //根据ID查询订单
    public CommonResult findById(String oId,Integer index,Integer pageSize,String sort);

    //根据买家ID查询，分页/按降序或升序查询
    public CommonResult findByBuyerId(Long buyerId,Integer index,Integer pageSize,String sort);

    //根据卖家ID查询，分页/按降序或升序查询
    public CommonResult findByVendorId(Long vendorId,Integer index,Integer pageSize,String sort);

    //新增订单
    public CommonResult saveIndent(Indent indent);

    //删除订单
    public CommonResult deleteIndentById(String oId);

    //根据ID修改订单
    public CommonResult updateIndent(Indent indent);

    //查询所有订单,分页/按降序或升序查询,详细信息
    public CommonResult findAllDetails(Integer index,Integer pageSize,String sort);

    //根据订单ID查询所有订单,分页/按降序或升序查询,详细信息
    public CommonResult findByIdDetails(String oId,Integer index,Integer pageSize,String sort);

    //根据买家ID查询所有订单,分页/按降序或升序查询,详细信息
    public CommonResult findByBuyerIdDetails(Long buyerId, Integer index, Integer pageSize, String sort);

    //根据卖家ID查询所有订单,分页/按降序或升序查询,详细信息
    public CommonResult findByVendorIdDetails(Long vendorId,Integer index,Integer pageSize,String sort);

    //模糊查询统计订单页数
    public CommonResult indentCount(IndentDetails indentDetails,Integer pageSize, String sort);
    //模糊查询统计订单总数
    public CommonResult indentCountAll(IndentDetails indentDetails,String sort);

    public CommonResult countBuyerIndent(Long buyerId,Integer pageSize);

    public CommonResult countBuyerAllIndent(Long buyerId);

    public CommonResult countVendorIndent(Long vendorId,Integer pageSize);

    public CommonResult countVendorAllIndent(Long vendorId);


    //万能模糊查询
    public CommonResult getIndentDetailByAny(IndentDetails indentDetails,Integer index,Integer pageSize,String sort);

}
