package org.jianmo.springmiddleware.design.builder.floor;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;

/**
 * 地板材料
 *
 * 圣象
 */
public class ShengXiangFloor implements Matter {

  @Override
  public String scene() {
    return "地板";
  }

  @Override
  public String brand() {
    return "圣象";
  }

  @Override
  public String model() {
    return "一级";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(318);
  }

  @Override
  public String desc() {
    return "圣象集团";
  }
}
