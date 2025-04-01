package org.zida.oss;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ZidaOSSProperties.class)
@Configuration
public class ZidaAutoConfiguration {

  @Bean
  public ZidaOSSOperator zidaOSSOperator(ZidaOSSProperties zidaOSSProperties) {
    return new ZidaOSSOperator(zidaOSSProperties);
  }

}
