package org.jianmo.springmiddleware.design.builder.coat;

import java.math.BigDecimal;
import org.jianmo.springmiddleware.design.builder.Matter;

/**
 * 涂料材料
 *
 * 多乐士
 *
 */
public class DuluxCoat implements Matter {


  @Override
  public String scene() {
    return "涂料";
  }

  @Override
  public String brand() {
    return "多乐士";
  }

  @Override
  public String model() {
    return "第二代";
  }

  @Override
  public BigDecimal price() {
    return new BigDecimal(719);
  }

  @Override
  public String desc() {
    return "多乐士涂料";
  }
}
