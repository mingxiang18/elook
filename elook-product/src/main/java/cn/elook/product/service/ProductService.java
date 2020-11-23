package cn.elook.product.service;

import cn.elook.common.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    //通过id获取商品
    Product getProductById(Long pid);
    //搜索商品，筛选商品
    List<Product> getProductByCondition(String productKey, Long pcid);
    //添加商品
    int addProduct(Product product);
    //下架商品
    int rackProduct(Long pid);
}
