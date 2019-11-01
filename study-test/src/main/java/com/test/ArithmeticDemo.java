package com.test;

public class ArithmeticDemo {
    private static int[] test = new int[]{1, 200, 164, 29, 298, 188, 34, 52, 287, 100, 33};

    // 冒泡升序 时间复杂度O(n)
    public static void bubbleSort(int[] test) {
        for (int i = 0; i < test.length; i++) {
            for (int j = i; j < test.length; j++) {
                if (test[i] > test[j]) {
                    int temp = test[i];
                    test[i] = test[j];
                    test[j] = temp;
                }
            }
        }
    }

    // 快速排序 【递归调用】时间复杂度O(log n)
    public static void quickSort(int[] test, int left, int right) {
        if (left > right) {
            return;
        }
        int baseV = test[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (test[j] >= baseV && i < j) {
                j--;
            }
            while (test[i] <= baseV && i < j) {
                i++;
            }
            if (i < j) {
                int temp = test[i];
                test[i] = test[j];
                test[j] = temp;
            }
        }
        test[left] = test[i];
        test[i] = baseV;

        quickSort(test, left, i - 1);
        quickSort(test, i + 1, right);
    }

    // 插入排序 时间复杂度O(n)
    public static void insertSort(int[] test) {
        for (int i = 1; i < test.length; i++) {
            for (int j = i; j > 0; j--) {
                if (test[j] < test[j - 1]) {
                    int temp = test[j];
                    test[j] = test[j - 1];
                    test[j - 1] = temp;
                }
            }
        }
    }

    // 选择排序 找出最小的与参考位置之交换
    public static void selectSort(int[] test) {
        for (int i = 0; i < test.length; i++) {
            int minValIndex = i;
            // 循环找出最小值的索引位置
            for (int j = i; j < test.length; j++) {
                if (test[j] < test[minValIndex]) {
                    minValIndex = j;
                }
            }
            // 交换位置
            int temp = test[i];
            test[i] = test[minValIndex];
            test[minValIndex] = temp;
        }
    }

    // 希尔排序


    public static void main(String[] args) {
//         bubbleSort(test);
        // quickSort(test, 0 , test.length - 1);
//        insertSort(test);
        selectSort(test);
        for (int i = 0; i < test.length; i++) {
            System.err.println(test[i]);
        }
    }
}
