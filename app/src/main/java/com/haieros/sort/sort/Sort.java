package com.haieros.sort.sort;

import java.util.Arrays;

/**
 * Created by Kang on 2018/4/24.
 */

public class Sort {

    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把
     * 它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的
     * 名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
     *
     1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     3.针对所有的元素重复以上的步骤，除了最后一个；
     4.重复步骤1~3，直到排序完成。
     * @param data
     */
    public static void bubbleSort(int[] data){
        long start = System.currentTimeMillis();
        //开始
        //最后一次不需要比较
        for (int i = 0; i < data.length-1; i++) {
            //
            for (int j = 0; j < data.length-i-1; j++) {
                //比较2个元素
                if(data[j] > data[j+1]) {
                    //交换
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

    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元
     * 素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列
     * 的末尾。以此类推，直到所有元素均排序完毕.
     * @param data
     */
    public static void selectionSort(int[] data){
        long start = System.currentTimeMillis();
        int temp, minIndex;
        //开始
        //假设data[0] 最小,然后寻找最小值替换它 剩下最后一个不需要比较
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i; //假设是最小值
            for (int j = i+1; j < data.length - 1; j++) {
                if(data[j] < data[minIndex]) { // 寻找最小值
                    minIndex = j; //保存最小值的 index
                }
            }
            //交换最小值
            temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("选择排序: 时间:"+(end-start)+"ms,result: "+arrString);
    }
}
