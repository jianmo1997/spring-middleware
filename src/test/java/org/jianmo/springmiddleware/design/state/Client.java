package org.jianmo.springmiddleware.design.state;

/**
 * 状态模式测试类
 */
public class Client {

  public static void main(String[] args) {
    //开门状态
    System.out.println("开门状态-->");
    Context context1 = new Context();
    context1.setLiftState(new OpeningState());
    context1.open();
    context1.close();
    context1.run();
    context1.stop();

    System.out.println("=========================");
    //关门状态
    System.out.println("关门状态-->");
    Context context2 = new Context();
    context2.setLiftState(new ClosingState());
    context2.open();
    context2.close();
    context2.run();
    context2.stop();

    System.out.println("=========================");
    //运行状态
    System.out.println("运行状态-->");
    Context context3 = new Context();
    context3.setLiftState(new RunningState());
    context3.open();
    context3.close();
    context3.run();
    context3.stop();


    System.out.println("=========================");
    //停止状态
    System.out.println("停止状态-->");
    Context context4 = new Context();
    context4.setLiftState(new StoppingState());
    context4.open();
    context4.close();
    context4.run();
    context4.stop();


  }

}
