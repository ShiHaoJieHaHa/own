package frist;

public class Singleton1 {
	//单例(饿汉式)
	private static final Singleton1 instance = new Singleton1();
     private Singleton1(){  	 
     }
     public  static  Singleton1 getSingleton1(){
		return instance;
    	 
     }
}
