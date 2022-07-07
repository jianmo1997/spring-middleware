package org.jianmo.springmiddleware.design.bridge;

public abstract class Merchant {

  protected Pay pay;

  public Merchant(Pay pay){

    this.pay = pay;
  }

  public abstract void make(String money);
}
