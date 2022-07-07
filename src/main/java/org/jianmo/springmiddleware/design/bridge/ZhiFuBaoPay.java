package org.jianmo.springmiddleware.design.bridge;

public class ZhiFuBaoPay implements Pay{

  @Override
  public void payMoney(String money) {
    System.out.println("支付宝支付"+money);
  }
}
