package org.jianmo.springmiddleware.thread.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

  private static volatile CountDownLatch countDownLatch = new CountDownLatch(3);

  public static void main(String[] args) throws InterruptedException {

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          countDownLatch.countDown();
        }
      }
    });


    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          countDownLatch.countDown();
        }
      }
    });


    thread1.start();
    thread2.start();

    System.out.println("wait all child thread over");

    countDownLatch.await();

    System.out.println("all child thread over");
  }

}
