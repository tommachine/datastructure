package com.cafebabe.datastructure.arrayutils;

public class ArrayPrinter {
    public static void printArray(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}
