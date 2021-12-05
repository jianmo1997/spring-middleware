package org.jianmo.springmiddleware.cache.CacheDemo;


import io.netty.util.internal.StringUtil;

public class CacheUtils {

  public void put(String key, Object value, long expire){
    if (StringUtil.isNullOrEmpty(key)) return;

    if (CacheGlobal.concurrentHashMap.containsKey(key)){
      MyCache cache = CacheGlobal.concurrentHashMap.get(key);
      cache.setHitCount(cache.getHitCount() + 1);
      cache.setWriteTime(System.currentTimeMillis());
      cache.setLastTime(System.currentTimeMillis());
      cache.setExpireTime(expire);
      cache.setValue(value);
    }

    MyCache cache = new MyCache();
    cache.setKey(key);
    cache.setValue(value);
    cache.setWriteTime(System.currentTimeMillis());
    cache.setLastTime(System.currentTimeMillis());
    cache.setHitCount(1);
    cache.setExpireTime(expire);
    CacheGlobal.concurrentHashMap.put(key, cache);
  }

  public Object get(String key){
    if (StringUtil.isNullOrEmpty(key)) return null;
    if (CacheGlobal.concurrentHashMap.isEmpty()) return null;
    if (!CacheGlobal.concurrentHashMap.containsKey(key)) return null;
    MyCache cache = CacheGlobal.concurrentHashMap.get(key);
    if (cache == null)  return null;
    long timoutTime = System.currentTimeMillis() - cache.getWriteTime();
    // 缓存过期
    if (cache.getExpireTime() <= timoutTime) {
      // 清除过期缓存
      CacheGlobal.concurrentHashMap.remove(key);
      return null;
    }

    cache.setHitCount(cache.getHitCount() + 1);
    cache.setLastTime(System.currentTimeMillis());
    return cache.getValue();
  }
}
