package org.jianmo.springmiddleware.queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

  static class DelayedEle implements Delayed{

    private final long delayTime ; //延迟时间

    private final long exprie; //到期时间

    private String taskName; // 任务名称

    public DelayedEle(long delayTime , String taskName){
      this.delayTime = delayTime;
      this.taskName = taskName;
      exprie = System.currentTimeMillis() + delayTime;

    }

    /**
     * 剩余时间=到期时间-当前时间
     * @param unit
     * @return
     */

    @Override
    public long getDelay(TimeUnit unit) {
      return unit.convert(this.exprie - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
    }

    /**
     * 优先级队列里面的优先级规则
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
      return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
      final StringBuilder builder = new StringBuilder("DelayedEle{");
      builder.append("delay=").append(delayTime);
      builder.append(",exprie=").append(exprie);
      builder.append(",taskName=").append(taskName);
      builder.append("}");
      return builder.toString();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    // 创建队列
    DelayQueue<DelayedEle> delayedEles = new DelayQueue<DelayedEle>();

    // 创建延迟队列
    Random random = new Random();
    for (int i = 0 ; i< 10 ; i++){
      DelayedEle delayedEle = new DelayedEle(random.nextInt(100) , "task:" + i);
      delayedEles.put(delayedEle);
    }

    // 依次取出任务并打印
    DelayedEle ele = null;

    // 循环，如果想避免虚假唤醒，则不能把全部元素都打印出来
    for (;;){
      while ((ele = delayedEles.take()) != null){
        System.out.println(ele.toString());
      }
    }
  }
}
