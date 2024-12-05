package paixu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 演示桶排序
 */
public class BucketSort {
    public static void main(String[] args) {

    }
    public static void bucketSort(float[] arr){
        //初始化k=n/2个桶，预期向每个桶分配2个元素
        int k=arr.length/2;
        List<List<Float>> buckets=new ArrayList<>();
        for(int i=0;i<k;i++){
            buckets.add(new ArrayList<>());
        }
        //1.将数组元素分配到各个桶中
        for(float x:arr){
            //输入数据范围为[0,1),使用num*k映射到索引范围[0,k-1]
            int i=(int)(x*k);
            buckets.get(i).add(x);
        }
        //2.对各个桶执行排序
        for(List<Float> bucket:buckets){
            Collections.sort(bucket);
        }
        //遍历桶合并结果
        int i=0;
        for(List<Float> bucket:buckets){
            for(float num:bucket){
                arr[i++]=num;
            }
        }
    }
}
