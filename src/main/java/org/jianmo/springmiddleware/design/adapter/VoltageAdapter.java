package org.jianmo.springmiddleware.design.adapter;

/**
 * 适配器
 */
public class VoltageAdapter implements  IVoltage5V {

  private Volatage220V volatage220V;

  public VoltageAdapter (Volatage220V v){
    this.volatage220V = v;
  }

  @Override
  public int output5V() {
    int dst = 0;
    if (null != volatage220V){
      int src = volatage220V.output220v();
      System.out.println("适配器工作~~");
      dst = src/44;
      System.out.println("适配器工作完成"+ dst);
    }
    return dst;
  }
}
