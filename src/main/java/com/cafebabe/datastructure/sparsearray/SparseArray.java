package com.cafebabe.datastructure.sparsearray;

public class SparseArray {

    public static int[][] generateSparseArray(int[][] orginalArr){
        //获取棋盘上不为0的的棋子的个数
        int count = 0;
        for (int[] ints : orginalArr) {
            for (int anInt : ints) {
                if (0 != anInt) {
                    count++;
                }
            }
        }
        //创建稀疏数组的第一行数据;
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = orginalArr.length;
        sparseArr[0][1] = orginalArr.length;
        sparseArr[0][2] = count;

        //遍历原始数组
        int num = 1;
        for (int i = 0; i < orginalArr.length; i++) {
            for (int j = 0; j < orginalArr[i].length; j++) {
                if (0 != orginalArr[i][j]) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = orginalArr[i][j];
                    num++;
                }
            }
        }
        return sparseArr;
    }


    public static int[][] generateArrBySparse(int[][] sparseArray){
        if(sparseArray[0][0] == 0 || sparseArray[0][1] == 0){
            System.out.println("稀疏数组为空");
        }
        int[][] arr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return  arr;
    }
}
