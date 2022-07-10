package org.jianmo.springmiddleware.design.decorator;

/**
 * 装饰器模式实现方式
 *
 */
public class DecoratorTest {

  public static void main(String[] args) {
    // 类似桥接？？？？
    // 系统将鸟儿的功能附加到猢狲身上
    TheGreatestSage greatestSage = new Monkey();
    TheGreatestSage bird = new Bird(greatestSage);
    bird.move();

    System.out.println("------");
    // 将鱼儿的功能跟附加到猢狲+鸟儿身上
    TheGreatestSage fish = new Fish(new Bird(greatestSage));

    fish.move();
  }

}
