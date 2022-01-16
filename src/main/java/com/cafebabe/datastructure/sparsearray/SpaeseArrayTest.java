package com.cafebabe.datastructure.sparsearray;

import com.cafebabe.datastructure.arrayutils.ArrayPrinter;

public class SpaeseArrayTest {
    public static void main(String[] args) {
        //创建8X8的棋盘
        int[][] originalArray = new int[8][8];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        originalArray[3][4] = 2;
        //打印原始数组
        ArrayPrinter.printArray(originalArray);

        int[][] sparseArray = SparseArray.generateSparseArray(originalArray);

        //打印稀疏数组
        ArrayPrinter.printArray(sparseArray);


        int[][] currentArray = SparseArray.generateArrBySparse(sparseArray);

        //打印从稀疏数组反序列化回来的数组
        ArrayPrinter.printArray(currentArray);

    }
}
