package org.jianmo.springmiddleware.design.factory.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class ClassLoaderUtils {

  public static  Class<?>[] getClazzByArgs(Object[] args){

    Class<?>[] parameterType = new Class[args.length];
    for (int i=0 ; i< args.length; i++){

      if (args[i] instanceof ArrayList){
        parameterType[i] = List.class;
        continue;
      }

      if (args[i] instanceof LinkedList){
        parameterType[i] = List.class;
        continue;
      }

      if (args[i] instanceof HashMap){
        parameterType[i] = Map.class;
        continue;
      }

      if (args[i] instanceof Long){
        parameterType[i] = long.class;
        continue;
      }


      if (args[i] instanceof Double){
        parameterType[i] = long.class;
        continue;
      }

      if (args[i] instanceof TimeUnit){
        parameterType[i] = TimeUnit.class;
        continue;
      }


      parameterType[i] = args[i].getClass();

    }

    return parameterType;
  }

}
