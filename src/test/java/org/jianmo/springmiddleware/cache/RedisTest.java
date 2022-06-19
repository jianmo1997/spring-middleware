package org.jianmo.springmiddleware.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

  @Test
  public void test(){
    System.out.println("hello");
  }


  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
//    map.put("test1", "test1");
//    map.put("test2", "test2");
//    map.put("test3", "test2");
//    map.put("test4", "test2");
//    map.put("test5", "test2");
//    map.put("test6", "test2");
//    map.put("test7", "test2");
//    map.put("test8", "test2");
//    map.put("test9", "test2");
//    map.put("test10", "test2");
//    map.put("test11", "test2");
//    map.put("test12", "test2");
//    map.put("test13", "test2");
//    CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();
//    arrayList.add("1");
//    arrayList.add("2");
//
//
//    arrayList.set(1 , "3");
//    arrayList.get(1);
//
//    arrayList.remove(1);

//    int count[] = {11, 22, 33, 44, 55, 33};
//    HashSet<Integer> hset = new HashSet<Integer>();
//    try{
//      for(int i = 0; i<4; i++){
//        hset.add(count[i]);
//      }
//      hset.add(null);
//      System.out.println(hset);
//
//      TreeSet<Integer> treeset = new TreeSet<Integer>();
//      System.out.println("The sorted list is:");
//      System.out.println(treeset);
//
//      treeset.add(88);
//
//      LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>(hset);
//      linkedHashSet.add(null);
//      System.out.println(linkedHashSet);
//
//    }
//    catch(Exception e){
//      e.printStackTrace();
//    }

//    HashMap<String ,String> map = new HashMap<>();
//    map.put(null , null);
//    System.out.println("添加成功");

    Map<String , String> cumap = new ConcurrentHashMap<>(5);
    cumap.put("test" , "test");

//    String key = "test";
//    int hash = hash(key);
//    System.out.println(hash);
//    int hash2 = hash("testl");
//    System.out.println(hash2);
  }

  static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
}
