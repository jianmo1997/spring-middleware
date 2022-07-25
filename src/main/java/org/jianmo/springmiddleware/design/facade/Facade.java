package org.jianmo.springmiddleware.design.facade;

public class Facade {

  SystemA systemA;

  SystemB systemB;

  SystemC systemC;

  public Facade(){
    systemA = new SystemA();
    systemB = new SystemB();
    systemC = new SystemC();
  }

  public void handle(){

    System.out.println("Facade handle");

    systemA.handle();
    systemB.handle();
    systemC.handle();
  }

  public void dance(){

    System.out.println("Facade dance");

    systemA.dance();
    systemB.dance();
    systemC.dance();
  }

}
