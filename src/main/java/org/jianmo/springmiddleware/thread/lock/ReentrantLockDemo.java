package org.jianmo.springmiddleware.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {

  private ArrayList<String> arrayList = new ArrayList<>();

  private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

  private final Lock readLock = reentrantReadWriteLock.readLock();

  private final Lock writeLock = reentrantReadWriteLock.writeLock();

  public void add(String e){

    writeLock.lock();
    try{
      arrayList.add(e);
    }catch (Exception e1){

    }finally {
      writeLock.unlock();
    }

  }


  public String get(int index){

    readLock.lock();
    try {
      return arrayList.get(index);
    }finally {
      readLock.unlock();
    }
  }

}
