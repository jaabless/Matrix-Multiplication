import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix_Multiplication {
    public static void main(String[] args){

        // This is for Matrix A
        System.out.print("...Matrix Multiplication...\n");
        // Accepts input from user
        Scanner scanner = new Scanner(System.in);
        String message = "Enter the number of rows for Matrix A: ";
        int numberOfRowsA = getValidInt(scanner,message); //accepts the number of rows for matrix A
        message = "Enter the number of columns for Matrix A: ";
        int numberOfColumnsA = getValidInt(scanner,message); //accepts the number of columns for matrix A
        int[][] matrixA = new int[numberOfRowsA][numberOfColumnsA];
        System.out.println("Enter elements of Matrix A: ");
        for (int i = 0; i < numberOfRowsA; i++) {
            for (int j = 0; j < numberOfColumnsA; j++) {
                //matrix to accept all elements of matrix A
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // This is for Matrix B
        message = "Enter the number of rows for Matrix B: ";
        int numberOfRowsB = getValidInt(scanner,message); //accepts the number of rows for matrix B
        message ="Enter the number of columns for Matrix B: ";
//        int numberOfColumnsB = getValidInt(scanner,message);
        int numberOfColumnsB = getValidInt(scanner,message);//accepts the number of columns for matrix B


        // Check if matrix meets rules for multiplication (column of MatrixA must be equal to row of MatrixB)
        if (numberOfColumnsA != numberOfRowsB) {
            System.out.println("Matrix multiplication is not possible. Columns of A must match rows of B.");
            return;// Exits when Matrices doesnt meet the requirements
        }

        int[][] matrixB = new int[numberOfRowsB][numberOfColumnsB];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < numberOfRowsB; i++) {
            for (int j = 0; j < numberOfColumnsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix multiplication (C = A * B)
        int[][] matrixC = new int[numberOfRowsA][numberOfColumnsB];
        for (int i = 0; i < numberOfRowsA; i++) {
            for (int j = 0; j < numberOfColumnsB; j++) {
                matrixC[i][j] = 0; // Initialize result matrix element
                for (int k = 0; k < numberOfColumnsA; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];//Performs the multiplication and store it in Matrix C
                }
            }
        }

        // Display result matrix C
        System.out.println("\nMatrix C (Result of Multiplication):");
        for (int[] row : matrixC) {
            System.out.print("| ");
            for (int value : row) {
                System.out.printf("%-4d", value); // Format for alignment
            }
            System.out.println("|");
        }

        scanner.close();
    }
    private static int getValidInt(Scanner scanner, String message) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }



}
