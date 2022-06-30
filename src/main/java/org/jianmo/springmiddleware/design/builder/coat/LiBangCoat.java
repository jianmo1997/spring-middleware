package org.jianmo.springmiddleware.design.builder.coat;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;

/**
 * 涂料材料
 *
 *
 * 立邦
 */
public class LiBangCoat implements Matter {


  @Override
  public String scene() {
    return "涂料";
  }

  @Override
  public String brand() {
    return "立邦";
  }

  @Override
  public String model() {
    return "默认级别";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(650);
  }

  @Override
  public String desc() {
    return "立邦涂料";
  }
}
