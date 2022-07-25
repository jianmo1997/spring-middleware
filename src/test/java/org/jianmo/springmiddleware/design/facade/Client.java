package org.jianmo.springmiddleware.design.facade;

/**
 * 外观模式(门面模式)
 */
public class Client {

  public static void main(String[] args) {

    Facade facade = new Facade();

    // 对于用户来说，完全不关心底层细节
    facade.handle();

    facade.dance();
  }

}
