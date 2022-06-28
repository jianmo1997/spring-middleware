package org.jianmo.springmiddleware.design.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.jianmo.springmiddleware.design.factory.handler.JDKInvocationHandler;
import org.jianmo.springmiddleware.design.factory.workshop.ICacheAdapter;


/**
 * 代理抽象工厂
 *
 * Class cacheClass：在模拟的场景下，不同的系统使用Redis服务类名可能有所不同，通过这样的方式便于实例化后的注入操作
 *
 * Class<? extends ICacheAdapter> cacheAdapter: 这个参数用于决定实例化那套集群
 */
public class JDKProxyFactory {

  public static <T> T getProxy(Class cacheClass, Class<? extends ICacheAdapter> cacheAdapter) throws Exception{
    InvocationHandler handler = new JDKInvocationHandler(cacheAdapter.newInstance());

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    return (T) Proxy.newProxyInstance(classLoader, new Class[]{cacheClass}, handler);
  }
}
