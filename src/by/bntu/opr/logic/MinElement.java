package by.bntu.opr.logic;

import by.bntu.opr.view.Printer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MinElement {

    public static int index_min_i = 0;
    public static int index_min_j = 0;

    public static int min(int[] @NotNull [] matrix) {
        int min = 999;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++){
                if (matrix[i][j] != 0 && min > matrix[i][j]) {
                    min = matrix[i][j];
                    index_min_i = i;
                    index_min_j = j;
                }
            }
        }
        return min;
    }

    public static void minMethod(int[] @NotNull [] matrix) {
        int[][] c = new int[matrix.length -  1][matrix.length - 1];
        int buff;

        while ((summaStocks(matrix) != 0) && (summaRequest(matrix) != 0)) { // считаем пока есть запасы и заявки
            min(matrix);

            if (matrix[index_min_i][3] < matrix[3][index_min_j]) {
                buff = matrix[index_min_i][3];
                c[index_min_i][index_min_j] = buff;
                matrix[index_min_i][index_min_j] = 0;
                matrix[3][index_min_j] -= matrix[index_min_i][3];
                matrix[index_min_i][3] = 0;
            } else {
                buff = matrix[3][index_min_j];
                c[index_min_i][index_min_j] = buff;
                matrix[index_min_i][index_min_j] = 0;
                matrix[index_min_i][3] -= matrix[3][index_min_j];
                matrix[3][index_min_j] = 0;
            }
        }
        Printer.printMatrix(c);
    }

    //сумма запасов
    @Contract(pure = true)
    public static int summaStocks(int[] @NotNull [] matrix) {
        int temp = 0;
        for (int[] ints : matrix) {
            temp += ints[3];
        }
        return (temp);
    }

    //сумма заявок
    @Contract(pure = true)
    public static int summaRequest(int[] @NotNull [] matrix) {
        int temp = 0;
        for (int j = 0; j < matrix.length; j++) {
            temp += matrix[3][j];
        }
        return (temp);
    }

    //проверка на решаемость
    public static boolean solvability(int[][] matrix) {
        return summaRequest(matrix) == summaStocks(matrix);
    }

}
