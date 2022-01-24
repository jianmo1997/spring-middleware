package org.jianmo.springmiddleware.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

/**
 * @author jianmo1997
 * callable测试类
 */
public class CallableTest {

  static AtomicInteger index = new AtomicInteger(0);

  public static void main(String[] args) {

    Callable<String> callable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(2000);
        return Thread.currentThread().getName()  + ":" + Thread.currentThread().getStackTrace()[1].getClassName();
      }
    };

    // 正确的写法
    CallableTest.listFutureStringDemo(callable);

    System.out.println("---------------");

    // 错误的写法
    CallableTest.listStringDemo(callable);


    System.out.println("---------------");

//    // 另一种实现方式
//    CallableTest.invokeAllTest(callable);

  }

  /**
   * 正确的写法
   * @param callable
   */
  public static void listFutureStringDemo(Callable callable){
    List<Future<String>> list = new ArrayList<>();
    long startTime = System.currentTimeMillis();

    System.out.println("listFutureStringDemo startTime" + startTime);


    for (int i = 0 ; i <= 20 ; i ++){
      System.out.println(i);
      Future<String> submit = ThreadPoolExecutorDemo.threadPoolExecutor.submit(callable);
      list.add(submit);
    }

    System.out.println("future endTime" + (System.currentTimeMillis() - startTime));

    list.stream().forEach(stringFuture -> {
      try {
        System.out.println(stringFuture.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    });
    System.out.println("准备结束listFutureStringDemo");

    ThreadPoolExecutorDemo.threadPoolExecutor.shutdown();
  }


  /**
   * 错误的写法，这种方式其实就是串行了
   * @param callable
   */
  public static void listStringDemo(Callable callable) {

    List<String> list = new ArrayList<>();
    long startTime = System.currentTimeMillis();

    System.out.println("listStringDemo startTime" + startTime);

    for (int i = 0 ; i <= 20 ; i ++){
      System.out.println(i);
      Future<String> submit = ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(callable);
      try {
        /**
         * 错误的示例，每个线程调用之后如未获取结果，会阻塞流程
         */
        list.add(submit.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

    System.out.println("listStringDemo endTime" + (System.currentTimeMillis() - startTime));
    list.stream().forEach(stringFuture -> {
      System.out.println(stringFuture);
    });
    System.out.println("准备结束listStringDemo");
    ThreadPoolExecutorDemo.getThreadPoolExecutor().shutdownNow();
  }


  /**
   * invokeAll调用线程List，可以看到也达到了我们想要的效果
   * 但没用Future的get方法，所以invokeAll不用Future的get方法也会阻塞主线程
   * @param callable
   */
  public static void invokeAllTest(Callable callable){

    List<Callable<String>> list = new ArrayList<>();
    long startTime = System.currentTimeMillis();

    System.out.println("invokeAllTest startTime" + startTime);
    // 定义20个Callable,放入list中
    for (int i = 0 ; i <= 20 ; i ++) {
      list.add(callable);
    }

    // 通过invokeAll唤醒所有线程。没有get方也会阻塞流程的哦
    try {
      ThreadPoolExecutorDemo.threadPoolExecutor.invokeAll(list);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("invokeAllTest endTime" + (System.currentTimeMillis() - startTime));

    System.out.println("准备结束invokeAllTest");
    ThreadPoolExecutorDemo.threadPoolExecutor.shutdownNow();

  }

}
