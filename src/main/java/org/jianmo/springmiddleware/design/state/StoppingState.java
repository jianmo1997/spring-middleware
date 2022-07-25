package org.jianmo.springmiddleware.design.state;

/**
 * 停止状态
 */
public class StoppingState extends LiftState{

  @Override
  public void open() {
    //状态修改
    super.context.setLiftState(Context.OPENNING_STATE);
    //动作委托给CloseState来执行 也就是委托给了ClosingState子类执行动作
    super.context.getLiftState().open();
  }

  @Override
  public void close() {
    //状态修改
    super.context.setLiftState(Context.CLOSEING_STATE);
    //动作委托给CloseState来执行 也就是委托给了ClosingState子类执行动作
    super.context.getLiftState().close();
  }

  @Override
  public void run() {
    //状态修改
    super.context.setLiftState(Context.RUNNING_STATE);
    //动作委托给CloseState来执行 也就是委托给了ClosingState子类执行动作
    super.context.getLiftState().run();
  }

  @Override
  public void stop() {
    System.out.println("电梯停止了...");
  }


}
