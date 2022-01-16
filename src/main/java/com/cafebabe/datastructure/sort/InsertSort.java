package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] data = RandomArrayGenerator.generate(30);
        System.out.println(Arrays.toString(data));
        for (int i = 0; i < data.length; i++) {

            int index = i;
            int tempValue = data[index];
            while (i > 0 && data [i -1] > tempValue){
                data[i] = data[i -1];
                --i;
            };
            data[i] = tempValue;
        }
        
        System.out.println(Arrays.toString(data));
    }
}
