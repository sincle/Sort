package com.haieros.sort.sort;

import java.util.Arrays;

/**
 * Created by Kang on 2018/4/24.
 */

public class Client {

    public static void main(String[] agrs) {
        int[] data = new int[8];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 20);
        }
//        int[] data = {5,8,1,9,3,41,21,12,74,2};
        String arrString = Arrays.toString(data);
        System.out.println("源数据:" + arrString.toString());
        //Sort.bubbleSort(data);
        //Sort.selectionSort(data);
        //Sort.insertSort(data);
       // Sort.shellSort(data);
        Sort.mergeSort(data);
    }
}
