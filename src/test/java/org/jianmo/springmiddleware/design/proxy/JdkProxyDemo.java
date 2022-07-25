package org.jianmo.springmiddleware.design.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 *
 * JDK动态代理
 */
public class JdkProxyDemo {

  public static void main(String[] args) {

    ISubject iSubject = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{
        ISubject.class
    }, new SubjectJdkProxyHandler(new RealSubject()));
    iSubject.doAction();

    System.out.println("--------------");

    ISubject iSubject2 = (ISubject) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{
        ISubject.class
    }, new SubjectJdkProxyHandler(new RealSubject2()));
    iSubject2.doAction();
  }

}
