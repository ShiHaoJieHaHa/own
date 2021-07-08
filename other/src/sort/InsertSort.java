package sort;

public class InsertSort {
     public static  void  sort(int [] arr){
         int i,j;
       for (i=1;i<arr.length;i++){
           int temp=arr[i];
           for (j=i;j>0&&temp<arr[i-1];j--){
            arr[j]=arr[j-1];
           }
           arr[j]=temp;
       }
     }
}
