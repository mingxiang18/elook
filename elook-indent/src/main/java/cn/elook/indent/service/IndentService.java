package cn.elook.indent.service;

import cn.elook.common.entity.Indent;
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
}
