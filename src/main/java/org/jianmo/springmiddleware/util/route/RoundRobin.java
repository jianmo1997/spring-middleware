package org.jianmo.springmiddleware.util.route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import jodd.util.CollectionUtil;
import org.springframework.util.CollectionUtils;

/**
 * @author jianmo1997
 * @since 22/04/10
 *
 * 使用
 *
 */
public class RoundRobin {

  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  public static void main(String[] args) {

    List<String> ipList = new ArrayList<>();
    ipList.add("127.0.0.1");
    ipList.add("127.0.0.2");
    ipList.add("127.0.0.3");
    ipList.add("127.0.0.4");
    ipList.add("127.0.0.5");

  }

  public String getIp(List<String> list){

    if (CollectionUtils.isEmpty(list)){
      return null;
    }

    if (atomicInteger.get() >= list.size()){
      atomicInteger = new AtomicInteger(0);
    }
    return list.get(atomicInteger.getAndIncrement());
  }

}
