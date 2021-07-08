package sort;

public class OwnSort {
    public  static  void  sort(int [] a){
        int temp=0;
        for(int i=1;i< a.length-1;i++){
            for (int j=1;j< a.length-1;j++){
                if (a[j+1]<a[j]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public  static  void  sort2(int arr[]){
        int temp=0;
        int flag=0;
        for (int i=1;i<arr.length-1;i++){
            for (int j=1;j<arr.length-1;j++){
                if (arr[j+1]<arr[j]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=1;
                }
            }
            if (flag==0){
                break;
            }
        }

    }




}
