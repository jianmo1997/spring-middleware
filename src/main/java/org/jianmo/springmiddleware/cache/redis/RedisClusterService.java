package org.jianmo.springmiddleware.cache.redis;


import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.jianmo.springmiddleware.cache.redis.config.RedisClusterConfig;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianmo1997
 *
 */
@Service
@Slf4j
public class RedisClusterService {


  @Autowired
  private RedisClusterConfig redisClusterConfig;

  private static final String LOCK_KEY = "lock_key";

  /**
   * 获取哨兵模式的分布式锁
   * 获取集群模式分布式锁同理
   * 只需要将:
   *      RedissonClient redissonClient = redisClusterConfig.redissonSentinel();
   *      修改成
   *      RedissonClient redissonClient = redisClusterConfig.redissonClient();
   * @return
   */
  public void getSentinelLock(){
    RedissonClient redissonClient = redisClusterConfig.redissonSentinel();
    RLock lock = redissonClient.getLock(LOCK_KEY);

    boolean isLock;
    try {
      // 返回true为获取锁成功。false为获取失败
      isLock = lock.tryLock();

      // 500ms拿不到锁, 就认为获取锁失败。10000ms即10s是锁失效时间。
      isLock = lock.tryLock(500, 10000, TimeUnit.MILLISECONDS);

      // 如果获取锁成功,处理业务逻辑
      if (isLock){
        log.info("获取锁成功");
      }
    }catch (Exception e){
      throw new RuntimeException("获取锁异常");
    } finally {
      // 无论如何，都要释放锁
      lock.unlock();
    }
  }
}
