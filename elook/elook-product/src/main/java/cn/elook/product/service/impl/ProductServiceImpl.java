package cn.elook.product.service.impl;

import cn.elook.common.entity.Product;
import cn.elook.common.entity.ProductCategory;
import cn.elook.common.entity.ProductDiscuss;
import cn.elook.common.entity.ProductPhoto;
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
    public List<Product> getMall() {
        return productDao.getMall();
    }

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

    @Override
    public int addProductPhoto(ProductPhoto productPhoto) {
        return productDao.addProductPhoto(productPhoto);
    }

    @Override
    public List<ProductPhoto> getProductPhotoByPid(Long pid) {
        return productDao.getProductPhotoByPid(pid);
    }

    @Override
    public int addProductDiscuss(ProductDiscuss productDiscuss) {
        return productDao.addProductDiscuss(productDiscuss);
    }

    @Override
    public int deleteProductDiscuss(Long pdid) {
        return productDao.deleteProductDiscuss(pdid);
    }

    @Override
    public List<ProductDiscuss> getProductDiscussByPid(Long pid) {
        return productDao.getProductDiscussByPid(pid);
    }

    @Override
    public List<ProductCategory> getProductCategoryById(Long pcid) {
        return productDao.getProductCategoryById(pcid);
    }
}
