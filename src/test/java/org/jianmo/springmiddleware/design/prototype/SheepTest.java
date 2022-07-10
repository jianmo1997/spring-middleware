package org.jianmo.springmiddleware.design.prototype;

/**
 * 原型模式测试类
 */
public class SheepTest {

  public static void main(String[] args) throws CloneNotSupportedException {
    Sheep sheep = new Sheep("TOM" , 1 , "白色");

    sheep.friend = new Sheep("jack" , 2 , "蓝色");

    Sheep sheep1 = ( Sheep) sheep.clone();
    Sheep sheep2 = ( Sheep) sheep.clone();
    Sheep sheep3 = ( Sheep) sheep.clone();
    Sheep sheep4 = ( Sheep) sheep.clone();

    System.out.println(sheep1);
    System.out.println(sheep2);
    System.out.println(sheep3);
    System.out.println(sheep4);
  }

}
