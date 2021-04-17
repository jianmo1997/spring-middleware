package org.jianmo.springmiddleware.core.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author jianmo1997
 */

@Configuration
public class JedisConfig {

  /**
   * todo 此处需要加载相关的redis配置
   * @return
   */
  @Bean
  public Jedis jedis(){
    return new Jedis();
  }
}
