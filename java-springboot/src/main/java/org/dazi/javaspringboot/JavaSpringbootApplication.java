package org.dazi.javaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

/**
 * 启动类/引导类
 */
@SpringBootApplication
@MapperScan("org.dazi.javaspringboot.mapper")
public class JavaSpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaSpringbootApplication.class, args);
  }

}
