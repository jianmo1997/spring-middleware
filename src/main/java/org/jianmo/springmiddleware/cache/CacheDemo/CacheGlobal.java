package org.jianmo.springmiddleware.cache.CacheDemo;

import java.util.concurrent.ConcurrentHashMap;

public class CacheGlobal {

  public static ConcurrentHashMap<String, MyCache> concurrentHashMap = new ConcurrentHashMap<>();

}
