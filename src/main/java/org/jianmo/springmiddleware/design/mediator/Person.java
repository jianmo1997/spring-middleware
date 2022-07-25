package org.jianmo.springmiddleware.design.mediator;

/**
 * 用户类
 */
public class Person {

  protected String name;

  protected Mediator mediator;

  Person(String name,Mediator mediator){
    this.name = name;
    this.mediator = mediator;
  }

}
