package by.bntu.opr.logic;

import by.bntu.opr.view.Printer;

public class MinElement {

    public static int index_min_i = 0;
    public static int index_min_j = 0;

    public static int min(int matrix[][]) {
        int min = matrix[0][0];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++){
                if (matrix[i][j] != 0) {
                    if (min > matrix[i][j]) {
                        min = matrix[i][j];
                        index_min_i = i;
                        index_min_j = j;
                    }
                }
            }
        }
        return min;
    }

    public static void minMethod(int[][] matrix) {
        int[][] c = new int[matrix.length -  1][matrix.length - 1];
        int buff;

        while ((summaStocks(matrix) != 0) && (summaRequest(matrix) != 0)) { // считаем пока есть запасы и заявки
            min(matrix);

            if (matrix[index_min_i][3] < matrix[3][index_min_j]) {
                buff = matrix[index_min_i][3];
                c[index_min_i][index_min_j] = buff;
                matrix[index_min_i][index_min_j] = 0;
                matrix[3][index_min_j] -= matrix[index_min_i][3];
                for (int i = index_min_i; i <= index_min_i; i++) {
                    for (int j = 0; j < matrix[i].length - 1; j++) {
                        matrix[i][j] = 0;
                    }
                }
                matrix[index_min_i][3] = 0;
            } else {
                buff = matrix[3][index_min_j];
                c[index_min_i][index_min_j] = buff;
                matrix[index_min_i][index_min_j] = 0;
                matrix[index_min_i][3] -= matrix[3][index_min_j];
                for (int i = 0; i < matrix.length - 1; i++) {
                    for (int j = index_min_j; j <= index_min_j; j++) {
                        matrix[i][j] = 0;
                    }
                }
                matrix[3][index_min_j] = 0;
            }
        }
        Printer.printMatrix(c);
    }

    //сумма запасов
    public static int summaStocks(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            temp += matrix[i][3];
        }
        return (temp);
    }

    //сумма заявок
    public static int summaRequest(int[][] matrix) {
        int temp = 0;
        for (int j = 0; j < matrix.length; j++) {
            temp += matrix[3][j];
        }
        return (temp);
    }

    //проверка на решаемость
    public static boolean solvability(int[][] matrix) {
        if (summaRequest(matrix) == summaStocks(matrix)) {
            return true;
        } else {
            return false;
        }
    }


}
