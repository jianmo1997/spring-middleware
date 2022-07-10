package org.jianmo.springmiddleware.design.builder;

import org.junit.jupiter.api.Test;

/**
 * 建造者模式测试类
 */
public class BuilderTest {

  @Test
  public void test(){

    Builder builder = new Builder();

    // 豪华欧式
    System.out.println(builder.levelOne(132.52D).getDetail());

    // 轻奢田园
    System.out.println(builder.levelTwo(98.12D).getDetail());

    // 现代简约
    System.out.println(builder.levelThree(83.12D).getDetail());
  }

}
