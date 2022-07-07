package org.jianmo.springmiddleware.design.bridge;

public class JdMerchant extends Merchant{

  public JdMerchant(Pay pay){
    super(pay);
  }

  @Override
  public void make(String money) {
    System.out.println("JD商城");
    pay.payMoney(money);
  }
}
