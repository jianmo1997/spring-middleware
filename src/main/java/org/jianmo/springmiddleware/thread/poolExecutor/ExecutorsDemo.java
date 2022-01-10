package org.jianmo.springmiddleware.thread.poolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池的四种方式
 * @author jianmo
 */
public class ExecutorsDemo {

  /**
   * 创建一个高度可伸缩的线程池
   * @return
   */
  public static ExecutorService newCachedThreadPool() {
    return Executors.newCachedThreadPool();
  }


  /**
   * 创建一个可重用固定的线程数的线程池
   * 以共享的无界队列方式来运行这些线程
   * @return
   */
  public static ExecutorService newFixedThreadPool(){
    return Executors.newFixedThreadPool(10);
  }


  /**
   * 创建一个线程池，安排给定延迟后运行或者定期执行
   * @return
   */
  public static ExecutorService newScheduledThreadPool(){
    return Executors.newScheduledThreadPool(10);
  }


  /**
   * 创建一个单线程的线程池，相当于单线程串行执行所有任务
   * @return
   */
  public static ExecutorService newSingleThreadExecutor(){
    return Executors.newSingleThreadExecutor();
  }
}
