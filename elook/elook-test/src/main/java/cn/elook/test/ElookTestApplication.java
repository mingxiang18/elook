package cn.elook.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(value = "cn.elook.test.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class ElookTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElookTestApplication.class, args);
	}
}
