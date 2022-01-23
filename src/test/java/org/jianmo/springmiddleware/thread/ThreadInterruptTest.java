package org.jianmo.springmiddleware.thread;

/**
 * 线程中断测试类
 *
 *
 */
public class ThreadInterruptTest {

  public static void main(String[] args) {
    Thread thread = new Thread(() ->{

//      while (Thread.interrupted()) {
        System.out.println(System.currentTimeMillis());
//        try {
//          System.out.println("开始睡眠");
//          Thread.sleep(5000);
//          System.out.println("结束睡眠");
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis());
//      }

    });

    thread.start();
    thread.interrupt();

  }


}
