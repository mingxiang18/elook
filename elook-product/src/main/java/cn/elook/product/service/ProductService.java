package cn.elook.product.service;

import cn.elook.common.entity.Product;
import cn.elook.common.entity.ProductCategory;
import cn.elook.common.entity.ProductDiscuss;
import cn.elook.common.entity.ProductPhoto;
import cn.elook.common.utils.CommonResult;

import java.util.List;

public interface ProductService {
    //获取首页商品信息
    CommonResult getMall();

    //通过id获取商品
    CommonResult getProductById(Long pid);
    //搜索商品，筛选商品
    CommonResult getProductByCondition(String productKey, Long pcid);
    //添加商品
    CommonResult addProduct(Product product, ProductPhoto productPhoto);
    //下架商品
    CommonResult rackProduct(Long pid);

    //添加商品图片
    CommonResult addProductPhoto(ProductPhoto productPhoto);
    //获取商品图片
    CommonResult getProductPhotoByPid(Long pid);

    //添加商品讨论
    CommonResult addProductDiscuss(ProductDiscuss productDiscuss);
    //删除商品讨论
    CommonResult deleteProductDiscuss(Long pdid);
    //获取商品下所有商品讨论
    CommonResult getProductDiscussByPid(Long pid);

    //获取商品分类
    CommonResult getProductCategoryByParentId(Long parentId);
    //通过主键获取商品分类
    CommonResult getProductCategoryById(Long pcid);
}
