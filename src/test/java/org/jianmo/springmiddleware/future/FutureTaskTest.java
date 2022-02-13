package org.jianmo.springmiddleware.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import org.jianmo.springmiddleware.thread.ThreadPoolExecutorTest;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

/**
 *
 * FutureTask DEMO简单实现类
 * @author jianmo1997
 * @since 22/02/08
 */
public class FutureTaskTest {

  public static void main(String[] args) {

    Task task = new FutureTaskTest.Task();


    FutureTaskTest.listFutureTask(task);
  }


  static class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
      Thread.sleep(2000);
      return Thread.currentThread().getName() + ":" + Thread.currentThread().getStackTrace()[1]
          .getClassName();
    }
  }

  public static void listFutureTask(Task task){

    List<FutureTask> futureTaskList = new ArrayList<>();

    long startTime = System.currentTimeMillis();
    System.out.println("listFutureTask startTime" + startTime);
    for (int i = 0 ; i <= 20 ; i ++) {
      System.out.println("i:" + i);
      /**
       * 不同于Future实例
       * 此处使用FutureTask实例来创建
       * 其他实现与Future实例逻辑一致
       */
      FutureTask futureTask = new FutureTask(()-> task.call());
      futureTaskList.add(futureTask);
      ThreadPoolExecutorDemo.threadPoolExecutor.execute(futureTask);
    }

    System.out.println("listFutureTask endTime" + (System.currentTimeMillis() - startTime));

    for (FutureTask futureTask : futureTaskList){
      try {
        System.out.println(futureTask.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }


    }
    System.out.println("准备结束listFutureTask" + (System.currentTimeMillis() - startTime));

    ThreadPoolExecutorDemo.threadPoolExecutor.shutdown();
  }

}
