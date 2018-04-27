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
     * <p>
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     *
     * @param data
     */
    public static void bubbleSort(int[] data) {
        long start = System.currentTimeMillis();
        int temp;
        //开始
        //最后一次不需要比较
        for (int i = 0; i < data.length - 1; i++) {
            //
            for (int j = 0; j < data.length - i - 1; j++) {
                //比较2个元素
                if (data[j] > data[j + 1]) {
                    //交换
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("冒泡排序: 时间:" + (end - start) + "ms");
        System.out.println("reuslt:" + arrString);
    }

    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元
     * 素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列
     * 的末尾。以此类推，直到所有元素均排序完毕.
     *
     * @param data
     */
    public static void selectionSort(int[] data) {
        long start = System.currentTimeMillis();
        int temp, minIndex;
        //开始
        //假设data[i] 最小,然后寻找最小值替换它 剩下最后一个不需要比较
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i; //假设是最小值
            for (int j = i + 1; j < data.length - 1; j++) {
                if (data[j] < data[minIndex]) { // 寻找最小值
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
        System.out.println("选择排序: 时间:" + (end - start) + "ms");
        System.out.println("reuslt:" + arrString);
    }

    /**
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
     * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * @param data
     */
    public static void insertSort(int[] data) {
        long start = System.currentTimeMillis();
        // 目标元素
        int target;
        //目标元素前面的元素
        int preIndex;
        //开始
        //假设第一个元素是最小值 从 i = 1 处开始
        for (int i = 1; i < data.length; i++) {
            //保存目标元素
            target = data[i];
            //记录目标元素index
            preIndex = i;
            //如果满足 目标元素 < 其前一个元素  则覆盖之
            //i 之前的元素 已经排序完成 故 只需要data[preIndex - 1] > target
            while (preIndex > 0 && data[preIndex - 1] > target) {
                //使用前一个元素覆盖当前元素
                data[preIndex] = data[preIndex - 1];
                // 自减 指向preIndex 前一个元素
                preIndex--;
            }
            //使用目标元素覆盖之
            data[preIndex] = target;
        }
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("插入排序: 时间:" + (end - start) + "ms");
        System.out.println("reuslt:" + arrString);
    }

    /**
     * 第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较
     * 远的元素。希尔排序又叫缩小增量排序。
     *
     * @param data
     */
    public static void shellSort(int[] data) {
        long start = System.currentTimeMillis();
        //开始
        int len = data.length;
        // 间隔
        int h = 1;
        //前元素索引
        int preIndex;
        //目标元素
        int target;
        //步长选取
        while (h <= len / 3) {
            h = h * 3 + 1;
        }
        //步长判断
        while (h > 0) {
            //步长间隔内,index 变化
            for (int i = 0; i < h; i++) {
                //以 h 为间隔的所有元素集合 插入排序
                for (int j = h + i; j < len; j = j + h) {
                    //前一个元素
                    preIndex = j - h;
                    //目标元素
                    target = data[j];
                    //之前的元素 大于目标元素 用目标元素 覆盖之
                    while (preIndex >= 0 && target < data[preIndex]) {
                        //覆盖之
                        data[preIndex + h] = data[preIndex];
                        //取preIndex 前一个元素
                        preIndex = preIndex - h;
                    }
                    data[preIndex + h] = target;
                }
            }
            //步长变化
            h = (h - 1) / 3;
        }
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("希尔排序: 时间:" + (end - start) + "ms");
        System.out.println("reuslt:" + arrString);
    }

    /**
     * 归并排序 (merge sort) 是一类与插入排序、交换排序、选择排序不同的另一种排序方法。归并的含义是将两个
     * 或两个以上的有序表合并成一个新的有序表。归并排序有多路归并排序、两路归并排序 , 可用于内排序，也可
     * 以用于外排序。
     *
     * @param data
     */
    public static void mergeSort(int[] data) {
        long start = System.currentTimeMillis();
        //开始
        merge(data,0,data.length-1);
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(data);
        System.out.println("归并排序: 时间:" + (end - start) + "ms");
        //System.out.println("reuslt:" + arrString);
    }
    private static void merge(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            merge(a, low, mid);
            // 右边
            merge(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
           // System.out.println(Arrays.toString(a));
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    /**
     *
     * @param a
     * @param low
     * @param hight
     */
    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }

    /**
     * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * @param a
     */
    public static void quickSort(int a[]) {

        long start = System.currentTimeMillis();
        //开始

        sort(a, 0, a.length - 1);
        //结束
        long end = System.currentTimeMillis();
        String arrString = Arrays.toString(a);
        System.out.println("快速排序: 时间:" + (end - start) + "ms");
        //System.out.println("reuslt:" + arrString);
    }
}
