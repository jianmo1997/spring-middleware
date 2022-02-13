package org.jianmo.springmiddleware.thread;

import java.util.concurrent.TimeUnit;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

public class ThreadPoolExecutorTest {

  public static void main(String[] args) {

    long currentTimeMillis = System.currentTimeMillis();

    for (int i = 0 ; i <= 20 ; i++){

      ThreadPoolExecutorTest threadPoolExecutorTest = new ThreadPoolExecutorTest();

      try {
        String task = "task=" + i;
        ThreadPoolExecutorDemo.threadPoolExecutor.submit(() -> threadPoolExecutorTest.testPool(task));

//        Thread.sleep(1000);
      }catch (Exception e){
        e.printStackTrace();
      }
    }


    try{

      ThreadPoolExecutorDemo.threadPoolExecutor.shutdown();
      boolean loop = true;

      do {
        loop = !ThreadPoolExecutorDemo.threadPoolExecutor.awaitTermination(2, TimeUnit.SECONDS); // 等待两秒
      }while (loop);

      if (loop != true) {
        System.out.println("所有线程执行完毕");
      }
    }catch (InterruptedException e){

    }finally {
      System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
    }
  }

  public String  testPool(String task){
    String name = task + "使用的线程池，线程名称" + Thread.currentThread().getName();

    System.out.println(name);

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return name;
  }


}
