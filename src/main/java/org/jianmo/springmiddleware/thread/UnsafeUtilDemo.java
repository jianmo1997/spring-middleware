package org.jianmo.springmiddleware.thread;


import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author jianmo1997
 * @since 22/04/07
 */
public class UnsafeUtilDemo {


  // 获取一个unsafe实例
  static final Unsafe unsafe;

  // 记录变量state在类TestUnSafe中的偏移量
  static final long stateOffset;


  private volatile long state = 0;

  static {

    try {

      // 通过反射获取Unsafe的成员变量theUnsafe
      Field field = Unsafe.class.getDeclaredField("theUnsafe");

      // 设置为可存取
      field.setAccessible(true);

      // 获取改变量的值
      unsafe = (Unsafe) field.get(null);

      // 获取state在TestUnSafe中偏移量
      stateOffset = unsafe.objectFieldOffset(UnsafeUtilDemo.class.getDeclaredField("state"));

    } catch (NoSuchFieldException | IllegalAccessException e) {
      System.out.println(e.getMessage());
      throw new Error(e);
    }
  }

  public static void main(String[] args) {


    UnsafeUtilDemo unsafeUtilDemo = new UnsafeUtilDemo();

    boolean b = unsafe.compareAndSwapInt(unsafeUtilDemo, stateOffset, 0, 1);
    System.out.println(b);

  }

}
