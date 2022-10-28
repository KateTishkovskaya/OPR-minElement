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

    }
}
