package org.jianmo.springmiddleware.design.factory.workshop.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.jianmo.springmiddleware.design.factory.workshop.ICacheAdapter;

public class EGMCacheAdapter implements ICacheAdapter {

  HashMap<String , String> hashMap = new HashMap<>();

  @Override
  public String get(String key) {
    return hashMap.get(key);
  }

  @Override
  public void set(String key, String value) {
    System.out.println("key" + key + ", value" + value);
    hashMap.put(key , value);
  }

  @Override
  public void set(String key, String value, long timeout, TimeUnit timeUnit) {

    hashMap.putIfAbsent(key , value);
  }

  @Override
  public void del(String key) {

    hashMap.remove(key);
  }
}
