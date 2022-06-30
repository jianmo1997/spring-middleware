package org.jianmo.springmiddleware.design.builder.ceilling;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;

/**
 * 吊顶材料
 *
 * 二级顶
 */
public class LevelTwoCeiling implements Matter {

  @Override
  public String scene() {
    return "吊顶";
  }

  @Override
  public String brand() {
    return "装修公司自带";
  }

  @Override
  public String model() {
    return "二级顶";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(850);
  }

  @Override
  public String desc() {
    return "两个层次的吊顶，二级吊顶高度一般往下吊20cm，如果层高很高，则可以增加每级的厚度";
  }
}
