package three;

public class Other {
    public static void main(String[] args) {
     Other other=new Other();
        System.out.println(other.factorial(6));
    }


    public  int  factorial(int n){
        if (n==1 || n==0){
            return n;
        }else{
            return  n*factorial(n-1);
        }
    }

}
