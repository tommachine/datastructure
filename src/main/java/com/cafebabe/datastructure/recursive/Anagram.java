package com.cafebabe.datastructure.recursive;

public class Anagram {


    public static void doAnagram(int size) {
        if (size == 1) {
            return;
        }
        //
        for (int i = 0; i < size; i++) {
            //全排列n-1
            doAnagram(--size);
            if (size == 2) {
                displayWord();
            }
            rotate(size);
        }
    }

    private static void rotate(int size) {

    }

    private static void displayWord() {
    }
}
