package org.jianmo.springmiddleware.design.proxy;

/**
 * 业务实现类
 */
public class RealSubject implements ISubject{

  @Override
  public void doAction() {
    System.out.println("RealSubject doAction");
  }
}
