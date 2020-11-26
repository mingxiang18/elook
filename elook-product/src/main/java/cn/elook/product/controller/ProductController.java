package cn.elook.product.controller;

import cn.elook.common.entity.Product;
import cn.elook.common.entity.ProductDiscuss;
import cn.elook.common.entity.ProductPhoto;
import cn.elook.common.utils.CommonResult;
import cn.elook.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    //获取首页商品信息
    @GetMapping("/product/mall")
    public CommonResult getMall(){
        return productService.getMall();
    }

    //通过id获取商品
    @GetMapping("/product/get")
    public CommonResult getProductById(Long pid){
        return productService.getProductById(pid);
    }

    //搜索商品，productKey是关键字模糊查询，pcid是按分类查询
    @GetMapping("/product/search")
    public CommonResult getProductByCondition(String productKey, Long pcid, Integer index, Integer pageSize){
        return productService.getProductByCondition(productKey,pcid,index,pageSize);
    }

    //搜索商品获取详情，productKey是关键字模糊查询，pcid是按分类查询
    @GetMapping("/product/details/search")
    public CommonResult getProductDetailsByCondition(String productKey, Long pcid, Integer index, Integer pageSize){
        return productService.getProductDetailsByCondition(productKey,pcid,index,pageSize);
    }

    //获取所有商品详情
    @GetMapping("/product/details")
    public CommonResult getProductDetails(Integer index, Integer pageSize){
        return productService.getProductDetails(index, pageSize);
    }

    //下架商品
    @GetMapping("/product/count")
    public CommonResult getProductCount(){
        return productService.getProductCount();
    }

    //添加商品
    @PostMapping("/product/add")
    public CommonResult addProduct(Product product, ProductPhoto productPhoto){
        return productService.addProduct(product, productPhoto);
    }

    //下架商品
    @PostMapping("/product/rack")
    public CommonResult rackProduct(Long pid){
        return productService.rackProduct(pid);
    }

    //添加商品图片
    @PostMapping("/product/photo/add")
    public CommonResult addProductPhoto(ProductPhoto productPhoto){
        return productService.addProductPhoto(productPhoto);
    }

    //获取商品图片
    @GetMapping("/product/photo")
    public CommonResult getProductPhotoByPid(Long pid){
        return productService.getProductPhotoByPid(pid);
    }

    //添加商品讨论
    @PostMapping("/product/discuss/add")
    public CommonResult addProductDiscuss(ProductDiscuss productDiscuss){
        return productService.addProductDiscuss(productDiscuss);
    }

    //删除商品讨论
    @PostMapping("/product/discuss/delete")
    public CommonResult deleteProductDiscuss(Long pdid){
        return productService.deleteProductDiscuss(pdid);
    }

    //获取商品下所有商品讨论
    @GetMapping("/product/discuss")
    public CommonResult getProductDiscussByPid(Long pid){
        return productService.getProductDiscussByPid(pid);
    }

    //通过父分类id获取所有商品子分类
    @GetMapping("/product/categoryByParent")
    public CommonResult getProductCategoryByParentId(Long parentId){
        return productService.getProductCategoryByParentId(parentId);
    }

    //通过主键获取商品分类
    @GetMapping("/product/category")
    public CommonResult getProductCategoryById(Long pcid){
        return productService.getProductCategoryById(pcid);
    }
}
