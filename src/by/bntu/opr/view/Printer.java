package by.bntu.opr.view;

public class Printer {
    public static void print(Object str) {
        System.out.println(str);
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
