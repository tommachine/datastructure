package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = RandomArrayGenerator.generate(20);
        System.out.println(Arrays.toString(data));
        int temp = -1;
        for (int i = data.length - 1; i > 1; i--) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

}
