package com.haieros.sort.sort;

import java.util.Arrays;

/**
 * Created by Kang on 2018/4/24.
 */

public class Sort {

    public static void bubbleSort(int[] data){
        long start = System.currentTimeMillis();
        //开始
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if(data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("冒泡排序: 时间:"+(end-start)+"ms,result: "+arrString);
    }
}
