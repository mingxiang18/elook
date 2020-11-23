package cn.elook.product;

import cn.elook.common.entity.Product;
import cn.elook.product.dao.ProductDao;
import cn.elook.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElookProductApplication.class})
public class ElookProductTest {

    @Autowired
    private ProductService productService;

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

        int result = productService.rackProduct(4l);
        System.out.println(result);
    }
}
