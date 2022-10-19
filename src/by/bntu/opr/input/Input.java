package by.bntu.opr.input;

import by.bntu.opr.view.Printer;

import java.util.Scanner;

public class Input {

    @SuppressWarnings(value = "unchecked")
    public static int[][] matrixInputByScanner(String stringInput) {
        int[][] matrix = new int[4][4];

        Scanner input = new Scanner(System.in);
        Printer.print(stringInput);

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }
}
