package com.cafebabe.datastructure.sort;

import com.cafebabe.datastructure.arrayutils.RandomArrayGenerator;

import java.util.Arrays;

/**
 * @author cafebabe on 2022/1/16 19:55
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] data = RandomArrayGenerator.generate(2);
        System.out.println(Arrays.toString(data));
        shellSort2(data);
        System.out.println(Arrays.toString(data));
    }

    private static void shellSort(int[] data) {
        if (data.length < 2) {
            return;
        }
        //shell 排序的思想是先局部有序，然后进一步有序。 局部有序可以保证，插入排序时减少不必要的移动次数。
        //最外层循环，根据步长分组，然后先将分组内的插入排序好,这里注意：步长的选值应大于等于 数组的长度，不然for循环进不去。 这里的步长是2
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            //System.out.println(gap);
            // 从gap开始，然后依次往前（向数组左）差距gap个单位比较一次。 其他跟插入排序一毛一样
            for (int i = gap; i < data.length; i++) {
                int index = i;
                int temp = data[index];
                while (index - gap >= 0 && data[index - gap] > temp) {
                    data[index] = data[index - gap];
                    index = index - gap;
                }
                data[index] = temp;
            }
        }

    }

    /**
     * 这里的排序第一次为每三个一组，如果此时数组长度为2，第一个for循环就进步了，然后没有排序，比如数组元素为[1,0]
     *
     * @param data
     */
    private static void shellSort2(int[] data) {
        for (int gap = data.length / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < data.length; i++) {
                System.out.println(gap);
                int index = i;
                int temp = data[index];
                while (index - gap >= 0 && data[index - gap] > temp) {
                    data[index] = data[index - gap];
                    index = index - gap;
                }
                data[index] = temp;
            }
        }
    }
}
