package org.dazi.tliasjava21;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


// 为 Filter 服务
@ServletComponentScan
@MapperScan("org.dazi.tliasjava21.mapper")
@SpringBootApplication
public class Tliasjava21Application {

  public static void main(String[] args) {
    SpringApplication.run(Tliasjava21Application.class, args);
  }

}
