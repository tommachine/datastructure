package com.cafebabe.datastructure.bin;

public class BinarySerach {

    private int[] data;

    private int minIndex = 0;

    private int maxIndex;

    public BinarySerach(int[] data) {
        this.maxIndex = data.length - 1;
        this.data = data;

    }


    private int binarySerach(int value) {
        int minIndex = 0;
        int maxIndex = data.length - 1;
        int index;
        while (true) {
            index = (minIndex + maxIndex) / 2;
            if (value == data[index]) {
                return index;
            } else if (minIndex > maxIndex) {
                return -1;
            } else {
                if (value > data[index]) {
                    minIndex = index + 1;
                } else {
                    maxIndex = index - 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySerach binarySerach = new BinarySerach(data);
        int index = binarySerach.binarySerach(0);
        System.out.println(index);
    }
}
