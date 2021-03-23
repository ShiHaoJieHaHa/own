package two;

public class Singleton1 {
	 private  static  final Singleton1 instance=new Singleton1();
	 private Singleton1(){	 
	 }
     public  static Singleton1  getSingleton1(){
		return instance;
    	 
     }
}
