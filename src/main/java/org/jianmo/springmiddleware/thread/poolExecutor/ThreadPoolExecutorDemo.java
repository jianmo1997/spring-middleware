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
