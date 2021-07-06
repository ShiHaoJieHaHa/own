package sort;

public class BubbleSort {
    public static void main(String[] args) {

    }

    public static   void  sort(int[] a ){
        int  temp=0;
        for (int i=1;i<a.length-1;i++){
            for (int j=1;j<a.length-1;j++){
                if (a[j+1]>a[j]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }


    }


}
