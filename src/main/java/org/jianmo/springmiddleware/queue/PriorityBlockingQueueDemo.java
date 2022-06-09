package org.jianmo.springmiddleware.queue;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author jianmo1997
 * @since 22/05/22
 *
 */
public class PriorityBlockingQueueDemo {

  static class Task implements Comparable<Task>{

    private int priortity = 0;

    private String taskName;


    public int getPriority() {

      return priortity;
    }


    public void setPriortity(int priortity){
      this.priortity = priortity;
    }


    public String getTaskName(){
      return taskName;
    }

    public void setTaskName(String taskName){
      this.taskName = taskName;
    }

    @Override
    public int compareTo(Task o) {
      if (this.priortity > o.getPriority()){
        return 1;
      }else {
        return -1;
      }
    }

    public void doSomeThing(){
      System.out.println(taskName + ":" + priortity);
    }
  }


  public static void main(String[] args) {
    PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<Task>();

    // 添加任务
    Random random = new Random();
    for (int i = 0 ; i< 100 ; i++){
      Task  task = new Task();
      task.setPriortity(random.nextInt(100));
      task.setTaskName("taskName" + i);
      priorityBlockingQueue.put(task);
    }

    // 取出任务
    while (!priorityBlockingQueue.isEmpty()){
      Task poll = priorityBlockingQueue.poll();
      if (null != poll){
        poll.doSomeThing();
      }

    }
  }

}
