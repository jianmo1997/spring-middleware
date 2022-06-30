package org.jianmo.springmiddleware.design.builder.tile;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;


/**
 * 地砖材料
 *
 * 马可波罗
 *
 */
public class MarcoPoloTile implements Matter {


  @Override
  public String scene() {
    return "地砖";
  }

  @Override
  public String brand() {
    return "马克波罗";
  }

  @Override
  public String model() {
    return "默认";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(140);
  }

  @Override
  public String desc() {
    return "马克波罗集团";
  }
}
