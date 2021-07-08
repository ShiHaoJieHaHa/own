package sort;

//sort1 2 冒泡排序    sort 3 4  选择排序
public class OwnSort {
    public static void sort(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - 1; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void sort2(int arr[]) {
        int temp = 0;
        int flag = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1-i; j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }

    }

    public static void sort3(int arr[]) {
        int temp = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


    public static void sort4(int arr[]) {
        int temp = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
