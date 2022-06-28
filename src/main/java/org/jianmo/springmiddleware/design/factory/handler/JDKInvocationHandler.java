package org.jianmo.springmiddleware.design.factory.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.jianmo.springmiddleware.design.factory.util.ClassLoaderUtils;
import org.jianmo.springmiddleware.design.factory.workshop.ICacheAdapter;

/**
 * 反射调用方法
 */
public class JDKInvocationHandler implements InvocationHandler {

  private ICacheAdapter iCacheAdapter;

  public JDKInvocationHandler(ICacheAdapter iCacheAdapter){
    this.iCacheAdapter = iCacheAdapter;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return ICacheAdapter.class.getMethod(method.getName() , ClassLoaderUtils.getClazzByArgs(args)).invoke(iCacheAdapter , args);
  }
}
