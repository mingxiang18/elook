package cn.elook.indent.dao;


import cn.elook.common.entity.Indent;
import cn.elook.product.dao.ProductDao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface IndentDao {

    //查询所有订单,分页/按降序或升序查询
    @Select("select * from indent ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @Results(id="indentMap",value={
            @Result(id=true,column = "oid",property = "oId"),
            @Result(column = "vendor_id",property = "vendorId"),
            @Result(column = "buyer_id",property = "buyerId"),
            @Result(column = "address",property = "address"),
            @Result(column = "indent_price",property = "indentPrice"),
            @Result(column = "indent_create_time",property = "indentCreateTime"),
            @Result(column = "indent_state",property = "indentState"),
            @Result(column = "pid",property = "pId"),
    })
    public List<Indent> findAll(Integer index,Integer pageSize,String sort);



    //根据ID查询订单
    @Select("select * from indent where oid LIKE #{oId} ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentMap")
    public List<Indent> findById(String oId,Integer index,Integer pageSize,String sort);


    //根据买家ID查询，分页/按降序或升序查询
    @Select("select * from indent where buyer_id=#{buyerId} ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentMap")
    public List<Indent> findByBuyerId(Long buyerId,Integer index,Integer pageSize,String sort);

    //根据卖家ID查询，分页/按降序或升序查询
    @Select("select * from indent where vendor_id=#{vendorId} ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentMap")
    public List<Indent> findByVendorId(Long vendorId,Integer index,Integer pageSize,String sort);


    //新增订单
    @Insert("insert into indent (oid,vendor_id,buyer_id,address,indent_price,indent_create_time,indent_state,pid) values(#{oId},#{vendorId},#{buyerId},#{address},#{indentPrice},#{indentCreateTime},#{indentState},#{pId})")
    public int saveIndent(Indent indent);


    //删除订单
    @Delete("delete from indent where oid=#{oId}")
    public int deleteIndentById(String oId);


    //根据ID修改订单
    @Update("update indent set vendor_id=#{vendorId},buyer_id=#{buyerId},address=#{address},indent_price=#{indentPrice},indent_create_time=#{indentCreateTime},indent_state=#{indentState},pid=#{pId} where oid=#{oId}")
    public int updateIndent(Indent indent);

}
