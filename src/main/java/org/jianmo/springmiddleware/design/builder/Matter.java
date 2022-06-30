package org.jianmo.springmiddleware.design.builder;

import java.math.BigDecimal;

public interface Matter {

  /**
   * 场景；地板、地砖、涂料、吊顶
   * @return
   */
  String scene();

  // 品牌
  String brand();

  // 型号
  String model();

  // 价格
  BigDecimal price();

  // 描述
  String desc();

}
