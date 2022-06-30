package org.jianmo.springmiddleware.design.builder.tile;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;


/**
 * 地砖材料
 *
 * 东鹏
 */
public class DongPengTile implements Matter {


  @Override
  public String scene() {
    return "地砖";
  }

  @Override
  public String brand() {
    return "东鹏地砖";
  }

  @Override
  public String model() {
    return "10001";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(102);
  }

  @Override
  public String desc() {
    return "东鹏地砖集团";
  }
}
