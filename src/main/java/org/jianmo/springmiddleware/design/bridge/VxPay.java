package org.jianmo.springmiddleware.design.bridge;

public class VxPay implements Pay{

  @Override
  public void payMoney(String money) {
    System.out.println("微信支付"+money);
  }
}
