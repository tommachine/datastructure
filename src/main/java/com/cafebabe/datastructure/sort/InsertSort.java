package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] data = RandomArrayGenerator.generate(30);
        System.out.println(Arrays.toString(data));
        for (int i = 1; i < data.length; i++) {

            int index = i;
            int tempValue = data[index];
            while (index > 0 && data [index -1] > tempValue){
                data[index] = data[index -1];
                --index;
            };
            data[index] = tempValue;
        }
        
        System.out.println(Arrays.toString(data));
    }
}
