package com.cafebabe.datastructure.recursive;

public class HanoiTower {

    private static volatile int count = 1;

    public static void doTowers(int topN, char from, char inter, char to) {
        //无论如何，最后一个圆盘总是可以直接从 from 到 to
        if (topN == 1) {
            System.out.println("Disk1 from " + from + " to " + to);
            count++;
        } else {
            //先将子圆盘堆 放入到中介底座上去
            doTowers(topN - 1, from, to, inter);
            //将单个父圆盘直接从 from底座 放入到 to底座
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            count++;
            //再将子圆盘从中介底座 放入到 to 底座上去
            doTowers(topN - 1, inter, from, to);
        }
    }
    public static void main(String[] args) {
        doTowers(3, 'A', 'B', 'C');
        System.out.println(count);
    }


}
