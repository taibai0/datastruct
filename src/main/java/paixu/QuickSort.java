package paixu;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

   public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
   }

    /**
     * 哨兵划分
     * @param arr
     * @param left
     * @param right
     * @return
     */
   public static int partition(int[] arr,int left,int right){
        int i=left,j=right;
        while(i<j){
            while(i<j&&arr[j]>=arr[left]) //找到右边第一个小于基准数的数
                j--;
            while(i<j&&arr[i]<=arr[left])//找到左边第一个大于基准数的数
                i++;
            swap(arr,i,j); //将大的换到右边，将小的换到左边
        }
        swap(arr,left,i);
        return i; //返回基准数的索引
   }

   public static void quickSort(int[] arr,int left,int right){
        if(left>=right)
            return;
        int pivot=partition(arr,left,right);
        quickSort(arr,left,pivot-1); //递归将基准数左边的数组排序
        quickSort(arr,pivot+1,right); //递归将基准数右边的数组排序
   }

    /**
     * 基准数优化
     * 快速排序在某些输入下的时间效率可能降低。举一个极端例子，假设输入数组是完全倒序的，由于我们选择最左端元素作为基准数，那么在哨兵划分完成后，基准数被交换至数组最右端，导致左子数组长度为
     * n-1右子数组长度为 0
     * 如此递归下去，每轮哨兵划分后都有一个子数组的长度为
     *  0分治策略失效，快速排序退化为“冒泡排序”的近似形式。
     * 为了尽量避免这种情况发生，我们可以优化哨兵划分中的基准数的选取策略。例如，我们可以随机选取一个元素作为基准数。然而，如果运气不佳，每次都选到不理想的基准数，效率仍然不尽如人意。
     * 需要注意的是，编程语言通常生成的是“伪随机数”。如果我们针对伪随机数序列构建一个特定的测试样例，那么快速排序的效率仍然可能劣化。
     * 为了进一步改进，我们可以在数组中选取三个候选元素（通常为数组的首、尾、中点元素），并将这三个候选元素的中位数作为基准数。这样一来，基准数“既不太小也不太大”的概率将大幅提升。当然，我们还可以选取更多候选元素，以进一步提高算法的稳健性。采用这种方法后，时间复杂度劣化至
     *  n^2的概率大大降低。
     */

    //选取三个候选元素的中位数
    public static int medianTree(int[] arr,int left,int mid,int right){
        int l=arr[left],r=arr[right],m=arr[mid];
        if((l<=m&&m<=r)||(r<=m&&m<=l))
            return mid;
        if((m<=l&&l<=r)||(m>=l&&l>=r))
            return left;
        return right;
    }

    //哨兵划分（三数取中值）
    public static int partition2(int[] arr,int left,int right){
        int med=medianTree(arr,left,(left+right)/2,right);
        //将中位数交换至数组最左端
        swap(arr,med,left);
        int i=left,j=right;
        while(i<j){
            while(i<j&&arr[j]>=arr[left])
                j--;
            while(i<j&&arr[i]<=arr[left])
                i++;
            swap(arr,i,j);
        }
        swap(arr,left,i);
        return i;
    }

    /**
     * 尾递归优化
     * 在某些输入下，快速排序可能占用空间较多。以完全有序的输入数组为例，设递归中的子数组长度为
     *  m每轮哨兵划分操作都将产生长度为0的左子数组和长度为m-1的右子数组，
     *  这意味着每一层递归调用减少的问题规模非常小（只减少一个元素），递归树的高度会达到
     *  n-1此时需要占用O(n)大小的栈帧空间。
     * 为了防止栈帧空间的累积，我们可以在每轮哨兵排序完成后，比较两个子数组的长度，仅对较短的子数组进行递归。由于较短子数组的长度不会超过
     *  n/2因此这种方法能确保递归深度不超过logn从而将最差空间复杂度优化至
     *  O(logn)代码如下所示：
     */
    public static void quickSort2(int[] arr,int left,int right){
        //子树长度为一时终止
        while(left<right){
            //哨兵划分操作
            int pivot=partition2(arr,left,right);
            //对两个子树中较短的那个执行快速排序
            if(pivot-left<right-pivot){
                quickSort2(arr,left,pivot-1);
                left=pivot+1;
            }else {
                quickSort2(arr,pivot+1,right);
                right=pivot-1;
            }
        }
    }
}
