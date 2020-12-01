package cn.elook.indent.dao;


import cn.elook.common.entity.Indent;
import cn.elook.common.entity.IndentDetails;
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
            @Result(column = "pid",property = "pId")
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

    //查询所有订单,分页/按降序或升序查询,详细信息
    @Select("select indent.*,u1.username buyer_name,u2.username vendor_name,product.product_name " +
            "from indent " +
            "join user u1 on u1.uid = indent.buyer_id " +
            "join user u2 on u2.uid = indent.vendor_id " +
            "join product on product.pid = indent.pid " +
            "ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @Results(id="indentDetailsMap",value={
            @Result(id=true,column = "oid",property = "oId"),
            @Result(column = "vendor_id",property = "vendorId"),
            @Result(column = "buyer_id",property = "buyerId"),
            @Result(column = "address",property = "address"),
            @Result(column = "indent_price",property = "indentPrice"),
            @Result(column = "indent_create_time",property = "indentCreateTime"),
            @Result(column = "indent_state",property = "indentState"),
            @Result(column = "pid",property = "pId"),
            @Result(column = "buyer_name",property = "buyerName"),
            @Result(column = "vendor_name",property = "vendorName"),
            @Result(column = "product_name",property = "productName"),
            @Result(column = "product_des",property = "productDes")
    })
    public List<IndentDetails> findAllDetails(Integer index,Integer pageSize,String sort);


    //根据订单ID查询所有订单,分页/按降序或升序查询,详细信息
    @Select("select indent.*,u1.username buyer_name,u2.username vendor_name,product.product_name,product.product_des " +
            "from indent " +
            "join user u1 on u1.uid = indent.buyer_id " +
            "join user u2 on u2.uid = indent.vendor_id " +
            "join product on product.pid = indent.pid " +
            "where oid LIKE #{oId} " +
            "ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentDetailsMap")
    public List<IndentDetails> findByIdDetails(String oId,Integer index,Integer pageSize,String sort);


    //根据买家ID查询所有订单,分页/按降序或升序查询,详细信息
    @Select("select indent.*,u1.username buyer_name,u2.username vendor_name,product.product_name,product.product_des " +
            "from indent " +
            "join user u1 on u1.uid = indent.buyer_id " +
            "join user u2 on u2.uid = indent.vendor_id " +
            "join product on product.pid = indent.pid " +
            "where buyer_id=#{buyerId} " +
            "ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentDetailsMap")
    public List<IndentDetails> findByBuyerIdDetails(Long buyerId,Integer index,Integer pageSize,String sort);


    //根据卖家ID查询所有订单,分页/按降序或升序查询,详细信息
    @Select("select indent.*,u1.username buyer_name,u2.username vendor_name,product.product_name,product.product_des " +
            "from indent " +
            "join user u1 on u1.uid = indent.buyer_id " +
            "join user u2 on u2.uid = indent.vendor_id " +
            "join product on product.pid = indent.pid " +
            "where vendor_id=#{vendorId} " +
            "ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}")
    @ResultMap("indentDetailsMap")
    public List<IndentDetails> findByVendorIdDetails(Long vendorId,Integer index,Integer pageSize,String sort);


    //模糊查询统计订单数量
    @Select("<script>"
            + "select COUNT(*) count from indent "
            + "join user u1 on u1.uid = indent.buyer_id "
            + "join user u2 on u2.uid = indent.vendor_id "
            + "join product on product.pid = indent.pid "
            + " <where>"
            + " 	<if test='indentDetails.oId != null or indentDetails.buyerName != null or indentDetails.vendorName != null or indentDetails.productName != null ' > "
            + "	    and ( oid like '%${indentDetails.oId}%' or u1.username like '%${indentDetails.buyerName}%' or u2.username like '%${indentDetails.vendorName}%' or product.product_name like '%${indentDetails.productName}%')"
            + "	</if>"
            + " 	<if test='indentDetails.buyerId != null' > "
            + "	    and buyer_id = #{indentDetails.buyerId}"
            + "	</if>"
            + "     <if test='indentDetails.vendorId != null'>"
            + "     and vendor_id = #{indentDetails.vendorId}"
            + " </if>"
            + "     <if test='indentDetails.indentState != null'>"
            + "     and indent_state = #{indentDetails.indentState}"
            + " </if>"
            + "</where>"
            + "ORDER BY indent_create_time ${sort}"
            + "</script>")
    public Integer indentCount(@Param("indentDetails") IndentDetails indentDetails, @Param("sort") String sort);

    @Select("select COUNT(*) count from indent where buyer_id=#{buyerId}")
    public Integer countBuyerIndent(Long buyerId);

    @Select("select COUNT(*) count from indent where vendor_id=#{vendorId}")
    public Integer countVendorIndent(Long buyerId);



    //究极模糊查询，根据订单ID,买家、卖家ID、用户名，订单状态，分页，按订单时间排序查询，订单状态为  0：已下单未付款，1.已付款未发货，2.已发货，3：已完成
    @Select("<script>"
            + "select indent.*,u1.username buyer_name,u2.username vendor_name,product.product_name,product.product_des from indent "
            + "join user u1 on u1.uid = indent.buyer_id "
            + "join user u2 on u2.uid = indent.vendor_id "
            + "join product on product.pid = indent.pid "
            + " <where>"
            + " 	<if test='indentDetails.oId != null or indentDetails.buyerName != null or indentDetails.vendorName != null or indentDetails.productName != null ' > "
            + "	    and ( oid like '%${indentDetails.oId}%' or u1.username like '%${indentDetails.buyerName}%' or u2.username like '%${indentDetails.vendorName}%' or product.product_name like '%${indentDetails.productName}%')"
            + "	</if>"
            + " 	<if test='indentDetails.buyerId != null' > "
            + "	    and buyer_id = #{indentDetails.buyerId}"
            + "	</if>"
            + "     <if test='indentDetails.vendorId != null'>"
            + "     and vendor_id = #{indentDetails.vendorId}"
            + " </if>"
            + "     <if test='indentDetails.indentState != null'>"
            + "     and indent_state = #{indentDetails.indentState}"
            + " </if>"
            + "</where>"
            + "ORDER BY indent_create_time ${sort} limit #{index},#{pageSize}"
            + "</script>")
    @ResultMap("indentDetailsMap")
    public List<IndentDetails> getIndentDetailByAny(@Param("indentDetails") IndentDetails indentDetails, @Param("index") Integer index,@Param("pageSize") Integer pageSize,@Param("sort") String sort);






}
