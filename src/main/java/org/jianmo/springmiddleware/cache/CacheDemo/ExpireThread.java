package org.jianmo.springmiddleware.cache.CacheDemo;

import java.util.concurrent.TimeUnit;

public class ExpireThread implements Runnable{

  @Override
  public void run() {
    while (true){
      try {
        TimeUnit.SECONDS.sleep(10);
        expireCache();
      }catch (Exception e){
        e.printStackTrace();
      }
    }
  }

  private void expireCache(){
    CacheGlobal.concurrentHashMap.forEach((key, value) -> {
      MyCache myCache = value;
      long timeTime = System.currentTimeMillis() - myCache.getWriteTime();
      if (myCache.getExpireTime() <= timeTime){
        CacheGlobal.concurrentHashMap.remove(key);
      }
    });
  }
}
