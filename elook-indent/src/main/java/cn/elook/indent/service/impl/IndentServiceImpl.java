package cn.elook.indent.service.impl;

import cn.elook.common.entity.Indent;
import cn.elook.common.entity.IndentDetails;
import cn.elook.common.utils.CommonResult;
import cn.elook.indent.dao.IndentDao;
import cn.elook.indent.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indentService")
public class IndentServiceImpl implements IndentService {

    @Autowired
    private IndentDao indentDao;

    @Override
    public CommonResult findAll(Integer index, Integer pageSize, String sort) {
        List<Indent> indentList =  indentDao.findAll(index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单数据加载成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findById(String oId,Integer index,Integer pageSize,String sort) {
        List<Indent> indentList =  indentDao.findById(oId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单数据加载成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findByBuyerId(Long buyerId,Integer index, Integer pageSize, String sort) {
        List<Indent> indentList = indentDao.findByBuyerId(buyerId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单查询成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findByVendorId(Long vendorId,Integer index, Integer pageSize, String sort) {
        List<Indent> indentList = indentDao.findByVendorId(vendorId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单查询成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult saveIndent(Indent indent) {
        int result = indentDao.saveIndent(indent);
        if(result <= 0){
            return new CommonResult(444,"添加订单失败",result);
        }
        return new CommonResult(200,"添加订单成功",result);
    }

    @Override
    public CommonResult deleteIndentById(String oId) {
        int result = indentDao.deleteIndentById(oId);
        if(result > 0){
            return new CommonResult(200,"订单删除成功",result);
        }else {
            return new CommonResult(444,"订单删除失败");
        }
    }

    @Override
    public CommonResult updateIndent(Indent indent) {
        int result = indentDao.updateIndent(indent);
        if(result > 0){
            return new CommonResult(200,"订单修改成功",result);
        }else {
            return new CommonResult(444,"订单修改失败");
        }
    }

    @Override
    public CommonResult findAllDetails(Integer index, Integer pageSize, String sort) {
        List<IndentDetails> indentList =  indentDao.findAllDetails(index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单数据加载成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findByIdDetails(String oId, Integer index, Integer pageSize, String sort) {
        List<IndentDetails> indentList =  indentDao.findByIdDetails(oId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单数据加载成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findByBuyerIdDetails(Long buyerId, Integer index, Integer pageSize, String sort) {
        List<IndentDetails> indentList = indentDao.findByBuyerIdDetails(buyerId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单查询成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult findByVendorIdDetails(Long vendorId, Integer index, Integer pageSize, String sort) {
        List<IndentDetails> indentList = indentDao.findByVendorIdDetails(vendorId,index,pageSize,sort);
        if(indentList != null){
            return new CommonResult(200,"订单查询成功",indentList);
        }else {
            return new CommonResult(444,"无订单数据");
        }
    }

    @Override
    public CommonResult IndentCount() {
        Integer result = indentDao.IndentCount();
        if(result > 0){
            return new CommonResult(200,"查询总数成功",result);
        }else {
            return new CommonResult(444,"查询总数失败");
        }
    }
}
