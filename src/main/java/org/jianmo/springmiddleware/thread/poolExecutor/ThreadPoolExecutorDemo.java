package org.jianmo.springmiddleware.thread.poolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author
 *
 * @since 2021/11/30
 */
public class ThreadPoolExecutorDemo {

  public static final ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS,
          new LinkedBlockingQueue<Runnable>());

}
