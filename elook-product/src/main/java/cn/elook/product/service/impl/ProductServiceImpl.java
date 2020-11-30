package cn.elook.product.service.impl;

import cn.elook.common.entity.*;
import cn.elook.common.utils.CommonResult;
import cn.elook.product.dao.ProductDao;
import cn.elook.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public CommonResult getMall() {
        List<Product> productList = productDao.getMall();
        List<ProductMall> productMall = new ArrayList<>();
        for (int i = 0; i < productList.size();i++){
            ProductMall product = new ProductMall();
            product.setProduct(productList.get(i));
            product.setProductPhoto(productDao.getOneProductPhotoByPid(productList.get(i).getPid()));
            productMall.add(product);
        }
        if(productList != null){
            return new CommonResult(200,"商城数据加载成功",productMall);
        }else {
            return new CommonResult(444,"无商城数据");
        }
    }

    @Override
    public CommonResult getProductById(Long pid) {
        Product product = productDao.getProductById(pid);
        if(product != null){
            return new CommonResult(200,"查询成功",product);
        }else {
            return new CommonResult(444,"商品不存在");
        }
    }

    @Override
    public CommonResult getProductByCondition(String productKey, Long pcid, Integer index, Integer pageSize) {
        List<Product> productList = productDao.getProductByCondition(productKey, pcid, index, pageSize);
        if(productList != null){
            return new CommonResult(200,"查询成功",productList);
        }else {
            return new CommonResult(444,"无相应商品");
        }
    }

    @Override
    public CommonResult getProductCount(String productKey, Long pcid) {
        Long result = productDao.getProductCount(productKey,pcid);
        if(result > 0){
            return new CommonResult(200,"获取商品总数成功",result);
        }else {
            return new CommonResult(444,"无商品");
        }
    }

    @Override
    public CommonResult getProductDetails(Integer index, Integer pageSize) {
        List<ProductDetails> productDetails = productDao.getProductDetails(index, pageSize);
        if(productDetails != null){
            return new CommonResult(200,"查询成功",productDetails);
        }else {
            return new CommonResult(444,"无相应商品");
        }
    }

    @Override
    public CommonResult addProduct(Product product, ProductPhoto productPhoto) {
        product.setIfSold(0);
        product.setProductCreateTime(new Date());
        int result = productDao.addProduct(product);
        if(result <= 0){
            return new CommonResult(444,"添加商品失败",result);
        }
        if(productPhoto != null && productPhoto.getProductSrc() != null){
            productPhoto.setPid(product.getPid());
            int result2 = productDao.addProductPhoto(productPhoto);
            if (result2 <= 0){
                return new CommonResult(444,"添加商品图片失败",result2);
            }
        }

        return new CommonResult(200,"添加商品成功",result);
    }

    @Override
    public CommonResult rackProduct(Long pid) {
        int result = productDao.rackProduct(pid);
        if(result > 0){
            return new CommonResult(200,"下架成功",result);
        }else {
            return new CommonResult(444,"下架商品失败");
        }
    }

    @Override
    public CommonResult updateProduct(Product product) {
        int result = productDao.updateProduct(product);
        if(result > 0){
            return new CommonResult(200,"修改成功",result);
        }else {
            return new CommonResult(444,"修改商品失败");
        }
    }

    @Override
    public CommonResult getProductDetailsByCondition(String productKey, Long pcid, Integer index, Integer pageSize) {
        List<ProductDetails> productDetails = productDao.getProductDetailsByCondition(productKey, pcid, index, pageSize);
        if(productDetails != null){
            return new CommonResult(200,"查询成功",productDetails);
        }else {
            return new CommonResult(444,"无相应商品");
        }
    }

    @Override
    public CommonResult addProductPhoto(ProductPhoto productPhoto) {
        int result = productDao.addProductPhoto(productPhoto);
        if(result > 0){
            return new CommonResult(200,"添加商品图片成功",result);
        }else {
            return new CommonResult(444,"添加商品图片失败");
        }
    }

    @Override
    public CommonResult getProductPhotoByPid(Long pid) {
        List<ProductPhoto> productPhotoList = productDao.getProductPhotoByPid(pid);
        if(productPhotoList != null){
            return new CommonResult(200,"获取商品图片成功",productPhotoList);
        }else {
            return new CommonResult(444,"无对应商品图片");
        }
    }

    @Override
    public CommonResult getOneProductPhotoByPid(Long pid) {
        ProductPhoto productPhotot = productDao.getOneProductPhotoByPid(pid);
        if(productPhotot != null){
            return new CommonResult(200,"获取商品图片成功",productPhotot);
        }else {
            return new CommonResult(444,"无对应商品图片");
        }
    }

    @Override
    public CommonResult addProductDiscuss(ProductDiscuss productDiscuss) {
        productDiscuss.setPdCreateTime(new Date());
        int result = productDao.addProductDiscuss(productDiscuss);
        if(result > 0){
            return new CommonResult(200,"商品留言成功",result);
        }else {
            return new CommonResult(444,"商品留言失败");
        }
    }

    @Override
    public CommonResult deleteProductDiscuss(Long pdid) {
        int result = productDao.deleteProductDiscuss(pdid);
        if(result > 0){
            return new CommonResult(200,"商品留言删除成功",result);
        }else {
            return new CommonResult(444,"商品留言删除失败");
        }
    }

    @Override
    public CommonResult getProductDiscussByPid(Long pid) {
        List<ProductDiscuss> productDiscussList = productDao.getProductDiscussByPid(pid);
        if(productDiscussList != null){
            return new CommonResult(200,"获取商品留言成功",productDiscussList);
        }else {
            return new CommonResult(444,"无对应留言成功");
        }
    }

    @Override
    public CommonResult getProductCategoryByParentId(Long parentId) {
        List<ProductCategory> productCategoryList = productDao.getProductCategoryByParentId(parentId);
        if (productCategoryList != null && productCategoryList.size() > 0){
            return new CommonResult(200,"获取分类标签成功",productCategoryList);
        }else {
            return new CommonResult(444,"无对应分类标签");
        }
    }

    @Override
    public CommonResult getProductCategoryById(Long pcid) {
        ProductCategory productCategoryList = productDao.getProductCategoryById(pcid);
        if (productCategoryList != null){
            return new CommonResult(200,"获取商品标签成功",productCategoryList);
        }else {
            return new CommonResult(444,"无对应商品标签");
        }
    }
}
