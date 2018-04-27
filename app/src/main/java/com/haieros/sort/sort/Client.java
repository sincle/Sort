package com.haieros.sort.sort;

/**
 * Created by Kang on 2018/4/24.
 */

public class Client {

    public static void main(String[] agrs) {
        int[] data = new int[15000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 15002000);
        }
        //int[] data = {4,7,3,6,8,2};
        //String arrString = Arrays.toString(data);
        //System.out.println("源数据:" + arrString.toString());
        //Sort.bubbleSort(data);
        //Sort.selectionSort(data);
        //Sort.insertSort(data);
        //Sort.shellSort(data);
       // Sort.mergeSort(data);
        Sort.quickSort(data);
    }
}
