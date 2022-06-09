package org.jianmo.springmiddleware.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

  public static void main(String[] args) throws InterruptedException{


    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("child thread begin park !!");

        while (!Thread.currentThread().isInterrupted()){

          LockSupport.park();
        }

        System.out.println("child thread unpark!!");
      }
    });

    thread.start();

    Thread.sleep(1000);

    System.out.println("main thread begin unpark");

    ReentrantLock reentrantLock = new ReentrantLock();
    reentrantLock.lock();
    LockSupport.unpark(thread);



  }

}
