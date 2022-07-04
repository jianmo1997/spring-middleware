package org.jianmo.springmiddleware.design.adapter;

/**
 * 需要适配的实例
 */
public class Phone {


  public void charging(IVoltage5V v){

    if (v.output5V() == 5){
      System.out.println("电压5V，符合充电标准，开始充电");
    } else {
      System.out.println("电压不符合标准，无法充电");
    }


  }

}
