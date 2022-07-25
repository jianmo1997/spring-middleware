package org.jianmo.springmiddleware.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 动态代理类
 */
public class SubjectJdkProxyHandler implements InvocationHandler {

  private ISubject iSubject;

  public SubjectJdkProxyHandler(ISubject iSubject){
    this.iSubject = iSubject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("doWhatever start");
    Object invoke = method.invoke(iSubject, args); // 执行目标对象方法
    System.out.println("diWhatever end");
    return invoke;
  }


}
