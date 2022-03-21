package org.jianmo.springmiddleware.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

/**
 * @author jianmo1997
 *
 * CompletableFuture 测试实例
 *
 * 一个非常简单的ComplatableFuture实例
 *
 * 主要实现的功能为：
 *  给定自定义的线程池，并进行异步化处理
 *  捕获异步处理任务时的异常
 *  将结果放到list中
 *
 */
public class CompletableFutureTest {


  public static void main(String[] args) {

    CompletableFutureTest completableFutureTest = new CompletableFutureTest();

    List<CompletableFuture<String>> futureList = new ArrayList<>();

    long beginTime = System.currentTimeMillis();

    System.out.println("开始时间:" + beginTime);
    for (int i = 0 ; i <= 20 ; i++){
      String task = "task=" + i;
      CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        return completableFutureTest.testPool(task);
      }, ThreadPoolExecutorDemo.threadPoolExecutor)
        .exceptionally(throwable -> {
             throw new RuntimeException("运行异常");
        });
      futureList.add(future);
    }

    long futureTime = System.currentTimeMillis() - beginTime;
    System.out.println("运行耗时:"+ futureTime);

    //
    futureList.stream().forEach(voidCompletableFuture -> {
      System.out.println("返回结果:" + voidCompletableFuture);
    });

    long last = System.currentTimeMillis() - beginTime;
    System.out.println("总耗时:"+ last);
    ThreadPoolExecutorDemo.threadPoolExecutor.shutdown();

  }


  public String testPool(String task){
    String name = task + "使用的线程池，线程名称" + Thread.currentThread().getName();

    System.out.println(name);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return name;
  }

}
