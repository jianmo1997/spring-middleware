package org.jianmo.springmiddleware.core.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jianmo1997
 * @since 4/16
 */

@Configuration
public class RedisClusterConfig {


  /**
   * 集群模式
   * @return
   */
  @Bean
  public RedissonClient redissonClient(){
    Config config = new Config();
    config.useClusterServers()
        .setScanInterval(2000) // 集群状态扫描间隔时间，时间为毫秒
        // 可以用redis://来启动SSL连接
        .addNodeAddress("redis://127.0.0.1:7000" , "redis://127.0.0.1:7001" , "redis://127.0.0.1:7002");
//        .setPassword("password");
    return Redisson.create(config);
  }


  /**
   * 哨兵模式
   * @return
   */
  @Bean
  public RedissonClient redissonSentinel(){
    Config config = new Config();
    config.useSentinelServers()
        .setScanInterval(2000)
        .addSentinelAddress("redis://127.0.0.1:7000" , "redis://127.0.0.1:7001" , "redis://127.0.0.1:7002")
        .setMasterName("myMaster");
    return Redisson.create(config);
  }

}
