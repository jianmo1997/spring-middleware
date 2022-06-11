package org.jianmo.springmiddleware.thread.lock;

import java.util.concurrent.CyclicBarrier;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

public class CyclicBarrierDemo {

  // 创建一个CyclicBarrier实例
  private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
    @Override
    public void run() {
      System.out.println(Thread.currentThread() + "task merge result");
    }
  });

  public static void main(String[] args) {

    //
    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        try {
          // 保证所有线程的阶段1执行完成后，才能执行阶段2
          System.out.println(Thread.currentThread() +  "task-1");
          int await = cyclicBarrier.await();
          System.out.println("Thread1 task-1 await" + await);

          System.out.println(Thread.currentThread() +  "task-2");
          cyclicBarrier.await();

          System.out.println(Thread.currentThread() +  "task-3");

        }catch (Exception e){
          e.printStackTrace();
        }
      }
    });



    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println(Thread.currentThread() +  "task-1");
          int await = cyclicBarrier.await();
          System.out.println("Thread2 task-1 await" + await);

          System.out.println(Thread.currentThread() +  "task-2");
          cyclicBarrier.await();

          System.out.println(Thread.currentThread() +  "task-3");

        }catch (Exception e){
          e.printStackTrace();
        }
      }
    });


    ThreadPoolExecutorDemo.getThreadPoolExecutor().shutdown();
  }

}
