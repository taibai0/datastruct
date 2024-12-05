package paixu;

/**
 * 堆排序演示
 * 算法特性：
 * 时间复杂度为 O(nlogn)、非自适应排序：建堆操作使用O(n)时间。
 * 从堆中提取最大元素的时间复杂度为 O(logn)共循环n-1轮
 * 空间复杂度为O(1)、原地排序：几个指针变量使用空间O(1)。元素交换和堆化操作都是在原数组上进行的。
 * 非稳定排序：在交换堆顶元素和堆底元素时，相等元素的相对位置可能发生变化
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr={5,1,7,3,1,6,9,4};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    /*堆排序*/
    public static void heapSort(int[] arr) {
       //建堆操作：堆化除叶节点外的其他所有节点
        for(int i=arr.length/2-1;i>=0;i--){
            siftDown(arr,arr.length,i);
        }
        //从堆中提取最大元素，循环n-1轮
        for(int i=arr.length-1;i>=0;i--){
            //交换根节点与右叶节点（交换首元素与尾元素）
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //以根节点为起点，从顶至底进行堆化
            siftDown(arr,i,0);
        }
    }


    /*堆的长度为n，从节点i开始，从顶至底堆化*/
    public static void siftDown(int[] arr,int n,int i){
        while(true){
            //判断节点i，l，r中值最大的节点，记为max
            int l=2*i+1;
            int r=2*i+2;
            int max=i;
            if(l<n&&arr[l]>arr[max]){
                max=l;
            }
            if(r<n&&arr[r]>arr[max]){
                max=r;
            }
            if(max==i){
                break;
            }
            //交换两节点
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            //循环向下进行堆化
            i=max;
        }
    }

}
