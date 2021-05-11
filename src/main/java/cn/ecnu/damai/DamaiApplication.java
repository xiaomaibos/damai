package cn.ecnu.damai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ecnu.damai.mapper")
public class DamaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DamaiApplication.class, args);
    }

}
