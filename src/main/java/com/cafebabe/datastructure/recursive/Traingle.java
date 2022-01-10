package com.cafebabe.datastructure.recursive;

/**
 * 三角数的三种写法
 * 三角数，即第N项的值等于第N-1项的值 与 N 的和
 */
public class Traingle {

    public static void main(String[] args) {
        int result = traingleRecursive(5);
        System.out.println(result);

        int result1 = traingleFor(5);
        System.out.println(result1);

        int result2 = traingleWhile(5);
        System.out.println(result2);
    }

    private static int traingleFor(int n) {
        int result = 1;
        if (n == 1)
            return result;
        for (int i = 2; i <= n; i++) {
            result = result + i;
        }
        return result;
    }

    private static int traingleWhile(int n) {
        int result = 1;
        if(n == 1){
            return result;
        }
        int index = 2;
        while (index <= n){
            result = index++ + result;
        }
        return result;
    }

    private static int traingleRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        n = n + traingleRecursive(--n);
        return n;
    }

}
