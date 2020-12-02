package cn.elook.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class ElookUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElookUserApplication.class,args);
    }

//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                //  .allowCredentials(true)
//                .allowedHeaders("*")
//                .allowedOrigins("*")
//                .allowedMethods("*");
//    }
}
