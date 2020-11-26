package cn.elook.product;

import cn.elook.common.entity.Product;
import cn.elook.common.entity.ProductCategory;
import cn.elook.common.entity.ProductDiscuss;
import cn.elook.common.entity.ProductPhoto;
import cn.elook.common.utils.CommonResult;
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
        CommonResult productList = productService.getMall();
        System.out.println();
    }

    @Test
    public void test1() {
        CommonResult product = productService.getProductById(1l);
        System.out.println();
    }

    @Test
    public void test2() {
        CommonResult productList = productService.getProductByCondition(null,null,0,10);
        System.out.println(productList.getData());
    }

    @Test
    public void test3() {
        Product product = new Product();
        product.setProductName("ads");
        product.setProductPrice(100f);
        product.setPcid(1l);
        product.setIfSold(0);
        product.setUid(1l);
        product.setProductCreateTime(new Date());

        CommonResult result = productService.addProduct(product,null);
        System.out.println(result.getData());
    }

    @Test
    public void test4() {

        CommonResult result = productService.rackProduct(3l);
        System.out.println(result);
    }

    @Test
    public void test5() {
        ProductDiscuss productDiscuss = new ProductDiscuss();
        productDiscuss.setPid(1l);
        productDiscuss.setPdDiscuss("你好");
        productDiscuss.setPdCreateTime(new Date());
        productDiscuss.setUid(1l);

        CommonResult result = productService.addProductDiscuss(productDiscuss);
        System.out.println(result);
    }

    @Test
    public void test6() {
        CommonResult result = productService.deleteProductDiscuss(1l);
        System.out.println(result);
    }

    @Test
    public void test7() {
        CommonResult discuss = productService.getProductDiscussByPid(1l);
        System.out.println(discuss.getData());
    }

    @Test
    public void test8() {
        CommonResult categoryList = productService.getProductCategoryById(1l);
        System.out.println();
    }

    @Test
    public void test9() {
        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setPid(1l);
        productPhoto.setProductSrc("http://8.129.53.24:8888/group1/M00/00/00/rBMbxV-7LZuAPk8DAAqNY_2fplY382.jpg");
        CommonResult result = productService.addProductPhoto(productPhoto);
        System.out.println(result);
    }

    @Test
    public void test10() {
        CommonResult photoList = productService.getProductPhotoByPid(1l);
        System.out.println();
    }

    @Test
    public void test11() {
        CommonResult productDetails = productService.getProductDetails(0, 10);
        System.out.println(productDetails.getData());
    }

    @Test
    public void test12() {
        CommonResult categoryList = productService.getProductCategoryByParentId(1l);
        System.out.println();
    }

    @Test
    public void test13() {
        CommonResult productDetails  = productService.getProductDetailsByCondition(null,null,0,10);
        System.out.println(productDetails.getData());
    }

    @Test
    public void test14() {
        CommonResult productCount  = productService.getProductCount();
        System.out.println(productCount.getData());
    }
}
