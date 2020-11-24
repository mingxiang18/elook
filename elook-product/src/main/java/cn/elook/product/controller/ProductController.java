package cn.elook.product.controller;

import cn.elook.common.entity.Product;
import cn.elook.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/mall")
    public List<Product> getMall(){
        return productService.getMall();
    }

    @GetMapping("/product/{pid}")
    public Product getProductById(@PathVariable("pid") Long pid){
        return productService.getProductById(pid);
    }

    @GetMapping("/product/search")
    List<Product> getProductByCondition(String productKey, Long pcid){
        return productService.getProductByCondition(productKey,pcid);
    }
}
