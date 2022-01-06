package com.cafebabe.datastructure.ArrayUtils;

import java.util.Random;

public class RandomArrayGenerator {

    public static int[] generate(int index){
        if(index <= 0){
            throw new RuntimeException("array length lt zero!");
        }
        Random random = new Random();
        int [] data = new int[index];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(index);
        }
        return data;
    }
}
