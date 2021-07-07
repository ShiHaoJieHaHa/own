package sort;

public class SelectSort {
    public static void main(String[] args) {

    }

    public static void sort(int arr[]) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            int minIndex = i;
            for (int j = 1; j < arr.length; j++) {
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
