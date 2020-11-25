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
    @GetMapping("/mall")
    public CommonResult getMall(){
        return productService.getMall();
    }

    //通过id获取商品
    @GetMapping("/product/{pid}")
    public CommonResult getProductById(@PathVariable("pid") Long pid){
        return productService.getProductById(pid);
    }

    //搜索商品，productKey是关键字模糊查询，pcid是按分类查询
    @GetMapping("/product/search")
    public CommonResult getProductByCondition(String productKey, Long pcid){
        return productService.getProductByCondition(productKey,pcid);
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
    @GetMapping("/product/discuss/{pid}")
    public CommonResult getProductDiscussByPid(@PathVariable("pid") Long pid){
        return productService.getProductDiscussByPid(pid);
    }

    //通过父分类id获取所有商品子分类
    @GetMapping("/product/category/parentId/{parentId}")
    public CommonResult getProductCategoryByParentId(@PathVariable("parentId") Long parentId){
        return productService.getProductCategoryByParentId(parentId);
    }

    //通过主键获取商品分类
    @GetMapping("/product/category/{pcid}")
    public CommonResult getProductCategoryById(@PathVariable("pcid") Long pcid){
        return productService.getProductCategoryById(pcid);
    }
}
