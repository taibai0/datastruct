package paixu;

/**
 *虽然冒泡排序、选择排序和插入排序的时间复杂度都为
 *  n^2但在实际情况中，插入排序的使用频率显著高于冒泡排序和选择排序，主要有以下原因。
 *
 * 冒泡排序基于元素交换实现，需要借助一个临时变量，共涉及 3 个单元操作；插入排序基于元素赋值实现，仅需 1 个单元操作。因此，冒泡排序的计算开销通常比插入排序更高。
 * 选择排序在任何情况下的时间复杂度都为 n^2
 * 如果给定一组部分有序的数据，插入排序通常比选择排序效率更高。
 * 选择排序不稳定，无法应用于多级排序。
 */
public class InsertionSort {
    public static void main(String[] args) {

    }

    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j>=0 &&arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
