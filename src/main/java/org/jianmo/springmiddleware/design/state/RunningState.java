package org.jianmo.springmiddleware.design.state;

/**
 * 运行状态
 */
public class RunningState extends LiftState{

  @Override
  public void open() {
    //什么也不做
  }

  @Override
  public void close() {
    //什么也不做
  }

  @Override
  public void run() {
    System.out.println("电梯正在运行...");
  }

  @Override
  public void stop() {
    //停止
    super.context.setLiftState(Context.OPENNING_STATE);
    super.context.stop();
  }

}
