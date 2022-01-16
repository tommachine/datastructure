package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class QuickSort {


    private static void quickSort(int[] data, int left, int right) {
        int l, r, pivot;
        l = left;
        r = right;
        pivot = data[(left + right) / 2];
        //从左边依次向右找到比中指大的索引，从右边依次找到比种植小的索引，然后两个索引交换。
        while (l < r) {
            while (data[l] < pivot) {
                l++;
            }
            while (data[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(data, l, r);

            //此时data[l] 为swap 之前 data[r]的值，说明data[r]此时等于 pivot 了，此时要接着向左移动
            if (data[l] == pivot) {
                r--;
            }
            ////此时data[r] 为swap 之前 data[l]的值，说明data[l]此时等于 pivot 了，此时要接着向右移动
            if (data[r] == pivot) {
                l++;
            }
            System.out.println(Arrays.toString(data));
        }
        //while 循环结束后，此时应该，再将l右移一个索引,再将r 左移一个索引
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(data, left, r);
        }
        if (right > l) {
            quickSort(data, l, right);
        }

    }

    private static void swap(int[] data, int lIndex, int rIndex) {
        int temp = data[lIndex];
        data[lIndex] = data[rIndex];
        data[rIndex] = temp;
    }

    ;

    public static void main(String[] args) {
        //int[] data = RandomArrayGenerator.generate(21);


        int[] data = {1,2,3,5,6,5,6,5,7,8,9};
        System.out.println(Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}