package org.jianmo.springmiddleware.design.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DecorationPackageMenu implements IMenu{


  private List<Matter> list = new ArrayList<>(); // 装修清单

  private BigDecimal price = BigDecimal.ZERO; // 装修价格

  private BigDecimal area; // 面积

  private String grade;  // 装修登记：豪华欧式、轻奢田园和现代简约

  private DecorationPackageMenu(){

  }

  public DecorationPackageMenu(Double area, String grade){
    this.area = new BigDecimal(area);
    this.grade = grade;
  }

  @Override
  public IMenu appendCeiling(Matter matter) {
    list.add(matter);
    price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendCoat(Matter matter) {
    list.add(matter);
    price = price.add(area.multiply(new BigDecimal("1.2")).multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendFloor(Matter matter) {
    list.add(matter);
    price = price.add(area.multiply(matter.price()));
    return this;
  }

  @Override
  public IMenu appendTile(Matter matter) {
    list.add(matter);
    price = price.add(area.multiply(matter.price()));
    return this;
  }

  @Override
  public String getDetail() {
    StringBuilder detail = new StringBuilder("\r\n-------\r\n" +
        "装修清单：" + "\r\n" +
        "装修登记：" + grade + "\r\n" +
        "装修价格：" + price.setScale(2 , BigDecimal.ROUND_HALF_UP) + "元\r\n");
    for (Matter matter : list){
      detail.append(matter.scene()).append(":").
          append(matter.brand()).
          append("、").
          append(matter.model()).
          append("、").
          append(matter.price());
    }
    return detail.toString();
  }
}
