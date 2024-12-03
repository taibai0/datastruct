package paixu;

/**
 * 时间复杂度为n^2
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={54,8,6,1,9,3,4,9,4,7};
        selectionSort(arr);
        for(Integer i:arr){
            System.out.print(i+" ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int k=i;
            for(int j=i+1;j<n;j++){
                //内循环找到未排序区间内的最小元素
                if(arr[k]>arr[j]){
                    k=j;
                }
            }
            //将该最小元素与未排序区间的首个元素交换
            int temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
        }
    }
}
