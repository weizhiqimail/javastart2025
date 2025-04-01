package org.dazi.tliasjava21;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
class Tliasjava21ApplicationTests {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void contextLoads() {
    // 获取 bean 的名称
    Object controller = applicationContext.getBean("authController");
    String beanName = controller.getClass().getName();

    log.info("获取 bean 的名称 beanName = " + beanName);
  }

}
