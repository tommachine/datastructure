package com.cafebabe.datastructure.recursive;

/**
 * 阶乘的三种简单写法，但是没有考虑到int值溢出
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialFor(4));
        System.out.println(factorialWhile(4));
        System.out.println(factorialRecursive(4));
    }


    private static int factorialFor(int n) {
        int result = 1;
        if (n == 1)
            return result;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    private static int factorialWhile(int n) {
        int result = 1;
        int index = 1;
        if (n == 1)
            return result;
        while (index <= n) {
            result = result * index;
            index ++ ;
        }
        return result;
    }

    private static int factorialRecursive(int n){
        int result =1;
        if(n == 1){
            return result;
        }
        return n * (factorialRecursive(--n));
    }

}
