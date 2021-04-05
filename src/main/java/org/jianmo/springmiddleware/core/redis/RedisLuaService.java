package org.jianmo.springmiddleware.core.redis;

import java.util.Collections;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.commands.ScriptingCommands;
import redis.clients.jedis.params.SetParams;

/**
 * @author jianmo
 * @since 21/04/05
 * 使用lua脚本实现
 *
 * 优点:使用Lua脚本的方式，尽量保证了原子性
 */
@Slf4j
@Component
public class RedisLuaService {


  @Autowired
  private StringRedisTemplate redisTemplate;

  @Resource
  private Jedis jedis;


  private static final String LUA_SCRIPTS = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then" +
          "redis.call('expire',KEYS[1],ARGV[2]) return 1 else return 0 end";

  private static final String LUA_SCRIPTS_REDIS = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


  /**
   * 基于redis客户端实现的获取锁
   * @param key
   * @param request
   * @param timeout
   * @return
   */
  public Boolean tryLockByJedis(String key , String request, int timeout){
    SetParams setParams = new SetParams();
    setParams.ex(timeout);
    setParams.nx();
    String set = jedis.set(key , request , setParams);
    return "OK".equals(set);
  }


  /**
   * 基于redis客户端释放锁
   * @param key
   * @param request
   * @return
   */

  public Boolean releaseLockByJedis(String key , String request){
    return jedis.eval(LUA_SCRIPTS_REDIS , Collections.singletonList(key), Collections.singletonList(request)).equals(1L);
  }


  /**
   * 基于redisTemplate实现的获取锁操作
   * 该加锁方式仅针对单实例redis
   * 对于集群redis无法复用
   * @param key
   * @param request
   * @param timeout
   * @return
   */
  public Boolean tryLockByRedisTemplate(String key , String request, int timeout){
    return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
      JedisCommands jedis = (JedisCommands) redisConnection.getNativeConnection();
      SetParams setParams = new SetParams();
      setParams.ex(timeout);
      setParams.nx();
      String set = jedis.set(key, request , setParams);
      return "OK".equals(set);
    });
  }


  /**
   * 基于redisTemplate实现的释放锁
   * @param key
   * @param request
   * @return
   */
  public Boolean releaseLockByRedisTemplate(String key , String request){
    return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
      ScriptingCommands jedis = (ScriptingCommands) redisConnection.getNativeConnection();
      return jedis.eval(LUA_SCRIPTS_REDIS , Collections.singletonList(key) , Collections.singletonList(request)).equals(1L);
    });
  }


}
