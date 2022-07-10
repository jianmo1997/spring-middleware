package org.jianmo.springmiddleware.design.design;

import org.jianmo.springmiddleware.design.factory.JDKProxyFactory;
import org.jianmo.springmiddleware.design.factory.workshop.ICacheAdapter;
import org.jianmo.springmiddleware.design.factory.workshop.impl.EGMCacheAdapter;
import org.junit.jupiter.api.Test;

/**
 * 抽象工厂
 */
public class ApiTest {

  @Test
  public void testCacheService() {

    try {
      ICacheAdapter proxy = JDKProxyFactory.getProxy(ICacheAdapter.class, EGMCacheAdapter.class);

      proxy.set("name" , "tanluzhe");

      String name = proxy.get("name");
      System.out.println(name);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
