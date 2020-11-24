package cn.elook.product;

import cn.elook.common.entity.Product;
import cn.elook.common.entity.ProductCategory;
import cn.elook.common.entity.ProductDiscuss;
import cn.elook.common.entity.ProductPhoto;
import cn.elook.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElookProductApplication.class})
public class ElookProductTest {

    @Autowired
    private ProductService productService;

    @Test
    public void test0() {
        List<Product> productList = productService.getMall();
        System.out.println(productList.size()+"  "+productList.get(0).getProductName());
    }

    @Test
    public void test1() {
        Product product = productService.getProductById(1l);
        System.out.println(product.getProductName());
    }

    @Test
    public void test2() {
        List<Product> productList = productService.getProductByCondition(null,1l);
        System.out.println(productList.size()+"  "+productList.get(0).getProductName());
    }

    @Test
    public void test3() {
        Product product = new Product();
        product.setProductName("ads");
        product.setProductPrice(100f);
        product.setPcid(1l);
        product.setIfSold(0);
        product.setUid(1l);

        int result = productService.addProduct(product);
        System.out.println(result);
    }

    @Test
    public void test4() {

        int result = productService.rackProduct(3l);
        System.out.println(result);
    }

    @Test
    public void test5() {
        ProductDiscuss productDiscuss = new ProductDiscuss();
        productDiscuss.setPid(1l);
        productDiscuss.setPdDiscuss("你好");
        productDiscuss.setPdCreateTime(new Date());
        productDiscuss.setUid(1l);

        int result = productService.addProductDiscuss(productDiscuss);
        System.out.println(result);
    }

    @Test
    public void test6() {
        int result = productService.deleteProductDiscuss(1l);
        System.out.println(result);
    }

    @Test
    public void test7() {
        List<ProductDiscuss> discuss = productService.getProductDiscussByPid(1l);
        System.out.println(discuss.size()+"   "+discuss.get(0).getPdDiscuss());
    }

    @Test
    public void test8() {
        List<ProductCategory> categoryList = productService.getProductCategoryById(1l);
        System.out.println(categoryList.size()+"   "+categoryList.get(0).getCategoryName());
    }

    @Test
    public void test9() {
        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setPid(1l);
        productPhoto.setProductSrc("http://8.129.53.24:8888/group1/M00/00/00/rBMbxV-7LZuAPk8DAAqNY_2fplY382.jpg");
        int result = productService.addProductPhoto(productPhoto);
        System.out.println(result);
    }

    @Test
    public void test10() {
        List<ProductPhoto> photoList = productService.getProductPhotoByPid(1l);
        System.out.println(photoList.size()+"   "+photoList.get(0).getProductSrc());
    }
}
