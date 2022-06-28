package org.jianmo.springmiddleware.thread.poolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 *
 * @since 2021/11/30
 *
 * 线程池工作原理
 *
 * 当调用execute()或者submit()时，线程池会左下判断
 * 1. 如果正在运行的线程量小于corePoolSize，那么马上创建线程运行这个任务
 * 2. 如果正在运行的线程量大于corePoolSize，那么将这个任务放入队列
 * 3. 如果这时候队列满了，而且正在运行的线程数量小于maximumPoolSize，那么还是要创建非核心线程立即运行这个任务
 * 4. 如果队列满了，maximumPoolSize也到达上限，那么线程池默认会抛出RejectExecutionException(AbortPolicy策略抛出)
 */
@Slf4j
public class ThreadPoolExecutorDemo {

  public static final ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS,
          new LinkedBlockingQueue<Runnable>(1000) , new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
          log.error("拒绝执行任务,{}" , r.toString());
        }
      });

  public static ThreadPoolExecutor getThreadPoolExecutor(){
    return new ThreadPoolExecutor(3 , 10 , 60 , TimeUnit.SECONDS ,
        new LinkedBlockingQueue<Runnable>(10) , new AbortPolicy());
  }

}
