package com;

public class TestPC {
    public static void main(String[] args) {
        SynContainter containter = new SynContainter();
        new Production(containter).start();
        new Consumer(containter).start();
    }
}

//������
class Production extends Thread {
    SynContainter containter;

    public Production(SynContainter containter) {
        this.containter = containter;
    }
    //����
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            containter.push(new Chicken(i));
            System.out.println("������"+i+"ֻ��");
        }
    }
}
//����
  class Consumer extends Thread {
    SynContainter containter;

    public Consumer(SynContainter containter) {
        this.containter = containter;
    }

    //����
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("������"+containter.pop()+"ֻ��");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//������
class SynContainter {
  Chicken[] chickens=new Chicken[10];
  int count=10;
  //�����߷����Ʒ
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
      //֪ͨ����
      this.notifyAll();
  }
//���������Ѳ�Ʒ
    public synchronized Chicken pop(){
      //�ж��ܷ�����
      if (count==0){
          //�ȴ�����������
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      count--;
      Chicken  chicken=chickens[count];
      //֪ͨ����������
        this.notifyAll();
        return chicken;
    }




}

