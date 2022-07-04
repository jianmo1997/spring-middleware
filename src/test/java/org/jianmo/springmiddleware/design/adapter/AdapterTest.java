package org.jianmo.springmiddleware.design.adapter;

/**
 * 适配器模式测试类
 */
public class AdapterTest {

  public static void main(String[] args) {
    Phone phone = new Phone();

    phone.charging(new VoltageAdapter(new Volatage220V()));
  }

}
