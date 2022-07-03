package org.jianmo.springmiddleware.design.prototype;

public class Sheep implements Cloneable{


  private String name;

  private int age;

  private String color;

  public Sheep friend;


  public Sheep(String name , int age , String color){

    this.name = name;
    this.age = age;
    this.color = color;
  }

  public String getName() {
    return name;
  }


  public int getAge() {
    return age;
  }

  public String getColor() {
    return color;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Sheep{" + "name:" + name + ", age:" + age + ", color" + color;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Sheep sheep = null;
    sheep = (Sheep) super.clone();
    return sheep;
  }
}
