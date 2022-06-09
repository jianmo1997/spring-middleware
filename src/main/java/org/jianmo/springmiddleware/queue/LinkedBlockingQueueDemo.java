package org.jianmo.springmiddleware.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.jianmo.springmiddleware.thread.poolExecutor.ThreadPoolExecutorDemo;

/**
 * @author jianmo1997
 * @since 22/05/22
 * 使用LinkedBlockingQueue实现
 * 生成/消费模式
 */
public class LinkedBlockingQueueDemo {

  /**
   * 待处理任务队列
   */
  public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

  /**
   * 消费者线程个数
   */
  private static int threadCount = 5;

  /**
   * CAS记录并发情况下的任务数
   */
  private static AtomicInteger stopProduer= new AtomicInteger(0);

  public static void main(String[] args) {
    ThreadPoolExecutorDemo.getThreadPoolExecutor().submit(new Producer());

    for (int i = 1 ; i <= threadCount ; i++){
      ThreadPoolExecutorDemo.threadPoolExecutor.submit(new Consumer());
    }

  }




  static class Producer implements Runnable {

    @Override
    public void run() {
      while (true){

        try {
          // 只生产15个
          if (stopProduer.intValue() < 15){
            long l = System.currentTimeMillis();
            System.out.println("塞入入参" + l);
            queue.put("队列元素：" + l);
            Thread.sleep(100);
            // 自增
            stopProduer.getAndIncrement();
          }
        }catch (Exception e){
          System.out.println("生产异常" + e.getMessage());
        }
      }
    }
  }


  static class Consumer implements Runnable{


    @Override
    public void run() {

      while (true){

        try {

          if (!queue.isEmpty()){
            String poll = queue.poll();
            if (poll != null && !poll.isEmpty()){
              System.out.println("消费线程"+ Thread.currentThread().getName() + "，消费"+ poll);
            }
          } else {
            // 消费完成等待生产者继续插入
            Thread.sleep(100);
          }
        }catch (Exception e){

          System.out.println("消费异常" +e.getMessage());
        }
      }
    }
  }
}
