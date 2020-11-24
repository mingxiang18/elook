package cn.elook.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.elook.product.dao")
@SpringBootApplication
public class ElookProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElookProductApplication.class, args);
    }
}
