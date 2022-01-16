package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] source = RandomArrayGenerator.generate(30);
        int[] workSpace = new int[30];
        System.out.println(Arrays.toString(source));
        mergeSort(source, workSpace, 0, source.length - 1);
        System.out.println(Arrays.toString(source));
    }


    private static void merge(int[] source, int[] workSpace, int lowPtr, int highPtr, int unpperBound) {
        int j = 0;                      //workSpace index
        int lowerBound = lowPtr;        //
        int mid = highPtr - 1;
        int n = unpperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= unpperBound) {
            if (source[lowPtr] < source[highPtr]) {
                workSpace[j++] = source[lowPtr++];
            } else {
                workSpace[j++] = source[highPtr++];
            }
            while (lowPtr <= mid) {
                workSpace[j++] = source[lowPtr++];
            }
            while (highPtr <= unpperBound) {
                workSpace[j++] = source[highPtr++];
            }
            for (int i = 0; i < n; i++) {
                source[lowerBound + i] = workSpace[i];
            }
        }

    }


    private static void mergeSort(int[] source, int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(source, workSpace, lowerBound, mid);  //sort left half;
            mergeSort(source, workSpace, mid + 1, upperBound); //sort right half
            merge(source, workSpace, lowerBound, mid + 1, upperBound); //merge them

        }

    }
}
