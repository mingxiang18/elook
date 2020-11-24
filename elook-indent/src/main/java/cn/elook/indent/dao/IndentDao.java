package cn.elook.indent.dao;


import cn.elook.common.entity.Indent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IndentDao {

    @Select("select * from indent")
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
    public List<Indent> findAll();

    @Select("select * from indent where oid=#{oId}")
    @ResultMap("indentMap")
    public Indent findById(Integer oId);

    @Insert("insert into indent (oid,vendor_id,buyer_id,address,indent_price,indent_create_time,indent_state,pid) values(#{oId},#{vendorId},#{buyerId},#{address},#{indentPrice},#{indentCreateTime},#{indentState},#{pId})")
    public void saveIndent(Indent indent);

    @Delete("delete from indent where oid=#{oId}")
    public void deleteIndentById(Integer oId);

}
