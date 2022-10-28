package by.bntu.opr.view;

import org.jetbrains.annotations.NotNull;

public class Printer {
    public static void print(Object str) {
        System.out.println(str);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
