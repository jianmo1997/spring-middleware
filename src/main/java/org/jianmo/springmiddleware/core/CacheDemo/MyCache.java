package org.jianmo.springmiddleware.core.CacheDemo;

import lombok.Data;

@Data
public class MyCache implements Comparable<MyCache>{

  private Object key;

  private volatile Object value;

  private long lastTime;

  private long writeTime;

  private long expireTime;

  private Integer hitCount;

  @Override
  public int compareTo(MyCache o) {
    return 0;
  }
}
