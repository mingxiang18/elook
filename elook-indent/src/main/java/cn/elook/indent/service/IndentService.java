package cn.elook.indent.service;

import cn.elook.common.entity.Indent;
import cn.elook.common.entity.IndentDetails;
import cn.elook.common.utils.CommonResult;

import java.util.List;

public interface IndentService {

    public CommonResult findAll(Integer index, Integer pageSize, String sort);

    public CommonResult findById(String oId,Integer index,Integer pageSize,String sort);

    public CommonResult findByBuyerId(Long buyerId,Integer index,Integer pageSize,String sort);

    public CommonResult findByVendorId(Long vendorId,Integer index,Integer pageSize,String sort);

    public CommonResult saveIndent(Indent indent);

    public CommonResult deleteIndentById(String oId);

    public CommonResult updateIndent(Indent indent);

    public CommonResult findAllDetails(Integer index,Integer pageSize,String sort);

    public CommonResult findByIdDetails(String oId,Integer index,Integer pageSize,String sort);

    public CommonResult findByBuyerIdDetails(Long buyerId, Integer index, Integer pageSize, String sort);

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
