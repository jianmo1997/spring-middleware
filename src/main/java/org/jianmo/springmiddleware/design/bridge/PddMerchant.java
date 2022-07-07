package org.jianmo.springmiddleware.design.bridge;

public class PddMerchant extends Merchant{

  public PddMerchant(Pay pay) {
    super(pay);
  }

  @Override
  public void make(String money) {

    System.out.println("拼夕夕商城");
    pay.payMoney(money);
  }
}
