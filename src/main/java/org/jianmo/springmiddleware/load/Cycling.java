package org.jianmo.springmiddleware.load;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tanluzhe
 * 负载均衡之轮询策略
 */
public class Cycling {

  private static AtomicInteger index = new AtomicInteger(0);

  public static void main(String[] args) {

    // 获取ipList列表，此列表可以从Mysql、redis或者其他地方获取
    List<String> ipList =  new ArrayList<>();
    ipList.add("127.0.0.1");
    ipList.add("127.0.0.10");
    ipList.add("127.0.0.5");
    ipList.add("127.0.0.12");

    // 排序
    ipList.sort(String::compareTo);

    // 核心实现
    // 判断当前index的长度是否超过数组长度，大于等于时重新初始化
    if (index.get() >= ipList.size()){
      index = new AtomicInteger(0);
    }

    // 获取ip，原子性操作
    String ip = ipList.get(index.getAndIncrement());
    System.out.println(ip);

  }

}
