package org.jianmo.springmiddleware.design.proxy;

/**
 * 业务实现类2
 */
public class RealSubject2 implements ISubject{

  @Override
  public void doAction() {
    System.out.println("RealSubject2 doAction");
  }
}
