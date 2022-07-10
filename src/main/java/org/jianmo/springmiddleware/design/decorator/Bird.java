package org.jianmo.springmiddleware.design.decorator;

public class Bird extends Change{

  public Bird(TheGreatestSage theGreatestSage) {
    super(theGreatestSage);
  }

  @Override
  public void move() {

    super.move();

    System.out.println("change bird move");
  }
}
