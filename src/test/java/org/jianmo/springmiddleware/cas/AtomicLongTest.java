package org.jianmo.springmiddleware.cas;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author jiamo1997
 */
public class AtomicLongTest {

  private static final AtomicLong atmoicLong = new AtomicLong();

  private static final LongAdder adder = new LongAdder();

  public static void main(String[] args) {

    atmoicLong.set(1);
    atmoicLong.set(10);

    atmoicLong.getAndIncrement();

    System.out.println("--------");

//    atmoicLong.getAndSet(2);
    System.out.println(atmoicLong.get());
  }
}
