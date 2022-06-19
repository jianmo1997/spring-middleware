package org.jianmo.springmiddleware.thread.lock;

import java.util.concurrent.Semaphore;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

public class SemaphoreDemo {

  // 创建一个Semaphore实例
  private static Semaphore semaphore = new Semaphore(0);

  public static void main(String[] args) {

    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread() + "A over");
        semaphore.release();
      }
    });


    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread() + "B over");
        semaphore.release();
      }
    });

    try {
      // 如果此处不使用 semaphore.acquire(2);
      // 那么调用时非正常复用，主线程可能在A执行完后B未执行完前就返回！！！！！！
      semaphore.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("前两个线程执行完毕");

    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread() + "C over");
        semaphore.release();
      }
    });


    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread() + "D over");
        semaphore.release();
      }
    });

    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("all child thread over");

  }

}
