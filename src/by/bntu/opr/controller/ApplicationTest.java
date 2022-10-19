package by.bntu.opr.controller;

import by.bntu.opr.input.Input;
import by.bntu.opr.logic.MinElement;
import by.bntu.opr.view.Printer;

public class ApplicationTest {
    public static void main(String[] args) {
        int[][] matrix = Input.matrixInputByScanner("Input matrix:");
        Printer.printMatrix(matrix);
        Printer.print(MinElement.min(matrix));

        if (MinElement.solvability(matrix)){
            MinElement.minMethod(matrix);
        } else {
            Printer.print("No solutions");
        }
        Printer.print(matrix[MinElement.index_min_i][3]);
        Printer.print(matrix[3][MinElement.index_min_j]);
        Printer.print(MinElement.index_min_i);
        Printer.print(MinElement.index_min_j);
//        if (matrix[MinElement.index_min_i][3] < matrix[3][MinElement.index_min_j]) {
//            Printer.print("true");
//        }
    }
}
