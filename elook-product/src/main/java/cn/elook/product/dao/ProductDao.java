package cn.elook.product.dao;

import cn.elook.common.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductDao {
    //获取首页商品信息
    List<Product> getMall();
    //通过id获取商品
    Product getProductById(Long pid);
    //搜索商品，筛选商品
    List<Product> getProductByCondition(@Param("productKey") String productKey, @Param("pcid") Long pcid,
                                        @Param("index") Integer index, @Param("pageSize") Integer pageSize);
    //获取所有商品详情
    List<ProductDetails> getProductDetails(@Param("index") Integer index, @Param("pageSize") Integer pageSize);
    //添加商品
    int addProduct(Product product);
    //下架商品
    int rackProduct(Long pid);

    //添加商品图片
    int addProductPhoto(ProductPhoto productPhoto);
    //获取商品图片
    List<ProductPhoto> getProductPhotoByPid(Long pid);

    //添加商品讨论
    int addProductDiscuss(ProductDiscuss productDiscuss);
    //删除商品讨论
    int deleteProductDiscuss(Long pdid);
    //获取商品下所有商品讨论
    List<ProductDiscuss> getProductDiscussByPid(Long pid);

    //通过父分类id获取商品子分类
    List<ProductCategory> getProductCategoryByParentId(Long parentId);
    //通过主键获取商品分类
    ProductCategory getProductCategoryById(Long pcid);
}
