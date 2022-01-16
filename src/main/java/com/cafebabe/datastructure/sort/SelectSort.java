package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] data = RandomArrayGenerator.generate(30);
        System.out.println(Arrays.toString(data));
        for (int i = 0; i < data.length; i++) {
            int minValue = data[i];
            int minIndex = i;
            int temp;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < minValue) {
                    minValue = data[j];
                    minIndex = j;
                }
            }
            temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
        System.out.println(Arrays.toString(data));
    }
}
