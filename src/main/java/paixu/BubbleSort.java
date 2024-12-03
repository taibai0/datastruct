package paixu;

/**
 * 冒泡排序，时间复杂度为n^2,经过效率优化后，平均时间复杂度不变，但当输入数组完全有序时，可达到最佳时间复杂度n
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //效率优化前
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //效率优化后
    public  static  void bubbleSort2Pro(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break; //此轮“冒泡”未交换任何元素，直接跳出
            }
        }
    }
}


