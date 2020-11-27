package cn.elook.product.dao;

import cn.elook.common.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    //获取首页商品信息
    List<Product> getMall();
    //通过id获取商品
    Product getProductById(Long pid);
    //搜索商品，筛选商品
    List<Product> getProductByCondition(@Param("productKey") String productKey, @Param("pcid") Long pcid,
                                        @Param("index") Integer index, @Param("pageSize") Integer pageSize);
    //获取商品总数
    Long getProductCount();
    //添加商品
    int addProduct(Product product);
    //下架商品
    int rackProduct(Long pid);
    //下架商品
    int updateProduct(Product product);

    //搜索，筛选商品详情
    List<ProductDetails> getProductDetailsByCondition(@Param("productKey") String productKey, @Param("pcid") Long pcid,
                                               @Param("index") Integer index, @Param("pageSize") Integer pageSize);
    //获取所有商品详情
    List<ProductDetails> getProductDetails(@Param("index") Integer index, @Param("pageSize") Integer pageSize);

    //添加商品图片
    int addProductPhoto(ProductPhoto productPhoto);
    //获取商品所有图片
    List<ProductPhoto> getProductPhotoByPid(Long pid);
    //获取商品一张图片
    ProductPhoto getOneProductPhotoByPid(Long pid);

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
