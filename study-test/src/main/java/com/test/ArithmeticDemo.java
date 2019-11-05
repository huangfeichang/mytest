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
        for (int i = 0; i < test.length; i++) {
            for (int j = i; j > 0; j--) {
                if (test[j] < test[j - 1]) {
                    int temp = test[j];
                    test[j] = test[j - 1] ;
                    test[j - 1] = temp;
                }
            }
        }
    }

    // 希尔排序【缩小增量排序】【插入排序改进版】
    public static void shellSort(int[] test) {
        // 选取增量步长
        for (int i = test.length / 2; i > 0; i /= 2) {
            // 从步长位置开始向后一个一个比较
            for (int j = i; j < test.length; j++) {
                int temp = test[j];
                while (j - i > 0 && test[j - i] > temp) {
                    test[j] = test[j - i];
                    j = j - i;
                }
                test[j] = temp;
            }
        }
    }

    // 选择排序 找出最小的与参考位置之交换
    public static void selectSort(int[] test) {
        for (int i = 0; i < test.length; i++) {
            int minIndex = i;
            for (int j = i; j < test.length; j++) {
                if (test[j] < test[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = test[minIndex];
            test[minIndex] = test[i];
            test[i] = temp;
        }
    }

    // 归并排序
    public static void mergerSort(int[] test, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergerSort(test, start, mid);
            mergerSort(test, mid + 1, end);
            int[] temp = new int[test.length];
            int p1 = start;
            int p2 = mid + 1;
            int k = 0;
            while (p1 <= mid && p2 <= end) {
                if (test[p1] <= test[p2]) {
                    temp[k++] = test[p1++];
                } else {
                    temp[k++] = test[p2++];
                }
            }
            while (p1 <= mid) {
                temp[k++] = test[p1++];
            }
            while (p2 <= end) {
                temp[k++] = test[p2++];
            }
            for (int i = 0; i < k; i++) {
                test[start + i] = temp[i];
            }
        }

    }

    public static void main(String[] args) {
//         bubbleSort(test);
//         quickSort(test, 0 , test.length - 1);
//        insertSort(test);
//        selectSort(test);
//        shellSort(test);
        mergerSort(test, 0 , test.length - 1);
        for (int i = 0; i < test.length; i++) {
            System.err.println(test[i]);
        }
    }
}
