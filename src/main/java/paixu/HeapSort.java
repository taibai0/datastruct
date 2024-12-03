package paixu;

/**
 * 堆排序演示
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr={5,1,7,3,1,6,9,4};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr) {
        int n=arr.length;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            adjustHeap(arr,i,0);
        }
    }

    public static void adjustHeap(int[] arr,int heapSize,int index){
        int largest=index;
        int left=index*2+1;
        int right=index*2+2;

        if(left<heapSize&&arr[left]>arr[largest]){
            largest=left;
        }

        if(right<heapSize&&arr[right]>arr[largest]){
            largest=right;
        }

        if(largest!=index){
            int temp=arr[index];
            arr[index]=arr[largest];
            arr[largest]=temp;
            adjustHeap(arr,heapSize,largest);
        }
    }

}
