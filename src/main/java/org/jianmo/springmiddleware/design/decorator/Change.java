package org.jianmo.springmiddleware.design.decorator;

/**
 *
 * 七十二变
 */
public class Change implements TheGreatestSage{

  private TheGreatestSage theGreatestSage;

  public Change(TheGreatestSage theGreatestSage){
    this.theGreatestSage = theGreatestSage;
  }

  @Override
  public void move() {

    this.theGreatestSage.move();
  }
}
