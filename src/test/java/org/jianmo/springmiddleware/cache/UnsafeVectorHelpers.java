package org.jianmo.springmiddleware.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class UnsafeVectorHelpers {

  public static void main(String[] args) {

    // 初始化Vector
    Vector<String> vector = new Vector();
    vector.add("hello");
    vector.add("Java3y");
    vector.add("买Linux可到我下面的链接，享受最低价");
    vector.add("给3y加鸡腿");

    new Thread(() -> getLast(vector)).start();
    new Thread(() -> deleteLast(vector)).start();
    new Thread(() -> getLast(vector)).start();
    new Thread(() -> deleteLast(vector)).start();

    List<String> list = Collections.synchronizedList(new ArrayList<>());


  }

  // 得到Vector最后一个元素
  public static Object getLast(Vector list) {
    int lastIndex = list.size() - 1;
    return list.get(lastIndex);
  }

  // 删除Vector最后一个元素
  public static void deleteLast(Vector list) {
    int lastIndex = list.size() - 1;
    list.remove(lastIndex);
  }
}
