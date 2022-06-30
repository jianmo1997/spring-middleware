package org.jianmo.springmiddleware.design.builder.floor;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;

/**
 * 地板材料
 *
 *
 * 德尔
 */
public class DerFloor implements Matter {

  @Override
  public String scene() {
    return "地板";
  }

  @Override
  public String brand() {
    return "德尔";
  }

  @Override
  public String model() {
    return "A+";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(119);
  }

  @Override
  public String desc() {
    return "德尔集团";
  }
}
