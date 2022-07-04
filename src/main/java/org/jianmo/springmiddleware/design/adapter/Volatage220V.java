package org.jianmo.springmiddleware.design.adapter;


/**
 * 交流电220V
 */
public class Volatage220V {

  public final int output = 220;

  public int output220v() {
    System.out.println("输出电压 " + output);
    return output;
  }

}
