package org.jianmo.springmiddleware.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    map.put("test1", "test1");
    map.put("test2", "test2");
    map.put("test3", "test2");
    map.put("test4", "test2");
    map.put("test5", "test2");
    map.put("test6", "test2");
    map.put("test7", "test2");
    map.put("test8", "test2");
    map.put("test9", "test2");
    map.put("test10", "test2");
    map.put("test11", "test2");
    map.put("test12", "test2");
    map.put("test13", "test2");
  }
}
