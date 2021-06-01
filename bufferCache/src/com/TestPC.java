package com;

public class TestPC {
    public static void main(String[] args) {
        SynContainter containter = new SynContainter();
        new Production(containter).start();
        new Consumer(containter).start();
    }
}

//生产者
class Production extends Thread {
    SynContainter containter;

    public Production(SynContainter containter) {
        this.containter = containter;
    }
    //生产
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            containter.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费
  class Consumer extends Thread {
    SynContainter containter;

    public Consumer(SynContainter containter) {
        this.containter = containter;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了"+containter.pop()+"只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓存区
class SynContainter {
  Chicken[] chickens=new Chicken[10];
  int count=10;
  //生产者放入产品
  public synchronized  void push(Chicken chicken){
      if (count==chickens.length){
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      chickens[count]=chicken;
      count++;
      //通知消费
      this.notifyAll();
  }
//消费者消费产品
    public synchronized Chicken pop(){
      //判断能否消费
      if (count==0){
          //等待生产者生产
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      count--;
      Chicken  chicken=chickens[count];
      //通知生产者生产
        this.notifyAll();
        return chicken;
    }




}

