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

    public CommonResult IndentCount();
}
