package org.jianmo.springmiddleware.design.bridge;

public class MerchantTest {

  public static void main(String[] args) {

    // 京东商城采用支付宝方式付款
    JdMerchant jdMerchant = new JdMerchant(new ZhiFuBaoPay());
    jdMerchant.make("100");

    System.out.println("--------------------");

    // 拼夕夕采用微信方式付款
    PddMerchant pddMerchant = new PddMerchant(new VxPay());
    pddMerchant.make("66");
  }

}
