package org.jianmo.springmiddleware.thread;


/**
 * @author jianmo1997
 * @since 22/03/29
 *
 * 《Java并发编程之美》
 *
 *  ThreadLocal实例
 *
 */
public class ThreadLocalDemo {


  static void print(String string){

    System.out.println(string + "localVariable");


  }

  static ThreadLocal<String> localVariable = new ThreadLocal<>();

  public static void main(String[] args) {


  }

}
