package org.jianmo.springmiddleware.cache.CacheDemo;

public class MyCacheTest {

  public static void main(String[] args) {
    CacheUtils cacheUtils = new CacheUtils();
    cacheUtils.put("key" , "jiamo" , 10);
    String val = (String) cacheUtils.get("key");
    System.out.println(val);

    String noval = (String) cacheUtils.get("noval");
    System.out.println(noval);
  }
}
