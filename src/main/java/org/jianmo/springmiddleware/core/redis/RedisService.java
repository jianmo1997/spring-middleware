package org.jianmo.springmiddleware.core.redis;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * @author jianmo
 * @since 21/04/05
 * 基础且有缺陷的redis分布式锁
 */
@Slf4j
@Component
public class RedisService {

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Resource
  private Jedis jedis;


  /**
   * 使用jedis的setnx+expire实现分布式锁(错误做法)存在死锁情况，强烈不建议这样做
   * setnx和expire是分开两个步骤，不具备原子性，如果执行第一条指令之后应用异常或者重启，锁将无法过期
   * @param key
   * @param request
   * @param timeout
   * @return
   */
  public Boolean tryLockByJedis(String key , String request, int timeout) {

    Long setnx = jedis.setnx(key, request);

    if (setnx == 1L){
      return jedis.expire(key , timeout) == 1L;
    } else {
      return false;
    }
  }


//  public Boolean tryLockByRedisTemplate(String key , String request, int timeout){
//    return redisTemplate.execute()
//  }

}
