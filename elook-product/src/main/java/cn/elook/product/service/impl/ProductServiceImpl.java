package cn.elook.product.service.impl;

import cn.elook.common.entity.Product;
import cn.elook.product.dao.ProductDao;
import cn.elook.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Long pid) {
        return productDao.getProductById(pid);
    }

    @Override
    public List<Product> getProductByCondition(String productKey, Long pcid) {
        return productDao.getProductByCondition(productKey, pcid);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int rackProduct(Long pid) {
        return productDao.rackProduct(pid);
    }
}
