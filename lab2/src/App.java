import java.util.Random;

public class App {
    public static void main(String[] args) {
        // 0408 mod 5 = 3
        // 0408 mod 7 = 2
        // 0408 mod 11 = 1

        // C = A ⊕ B
        // Element type: short
        // Calculate sum of the least elements of every matrix row

        // final int rowAmountA = 1;
        // final int columnAmountA = 1;

        // final int rowAmountB = 1;
        // final int columnAmountB = 1;

        // final short[][] matrixA = generateMatrix(rowAmountA, columnAmountA);
        // final short[][] matrixB = generateMatrix(rowAmountB, columnAmountB);

        final short[][] matrixA = {
            {1, 0},
            {4, 2, 7, 2},
            {3, 8, 5}
        };

        final short[][] matrixB = {
            {8, 6, 4},
            {9, 4},
            {},
            {1}
        };

        short[][] matrix = directSum(matrixA, matrixB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        System.out.println("Matrix:");
        printMatrix(matrix);

        System.out.println("Sum of the least elements, matrix: " + sumOfLeastElements(matrix));
        System.out.println("Sum of the least elements, matrix A: " + sumOfLeastElements(matrixA));
        System.out.println("Sum of the least elements, matrix B: " + sumOfLeastElements(matrixB));
    }

    static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            if (row.length == 0) {
                System.out.print("[empty row]");
            } else {
                for (short value : row) {
                    System.out.print(value + "\t");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    static short[][] generateMatrix(int rowAmount, int columnAmount) {
        Random generator = new Random();

        if (rowAmount <= 0 || columnAmount <= 0) {
            return new short[0][0];
        }

        short[][] result = new short[rowAmount][columnAmount];

        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < columnAmount; j++) {
                // Definition of upper bound and casting to "short" type
                // help us to generate "short" numbers using nextInt()
                result[i][j] = (short) generator.nextInt(Short.MAX_VALUE);
            }
        }

        return result;
    }

    static short[][] directSum(short[][] matrixA, short [][] matrixB) {
        int rowAmountA = matrixA.length;
        int rowAmountB = matrixB.length;

        int columnAmountA = 0;
        if (rowAmountA > 0) {
            for (short[] row : matrixA) {
                int currentColumnAmount = row.length;
                if (currentColumnAmount > columnAmountA) {
                    columnAmountA = currentColumnAmount;
                }
            }
        }

        int columnAmountB = 0;
        if (rowAmountB > 0) {
            for (short[] row : matrixB) {
                int currentColumnAmount = row.length;
                if (currentColumnAmount > columnAmountB) {
                    columnAmountB = currentColumnAmount;
                }
            }
        }
        
        int rowAmount = rowAmountA + rowAmountB;
        int columnAmount = columnAmountA + columnAmountB;
        short[][] result = new short[rowAmount][columnAmount];

        for (int i = 0; i < rowAmountA; i++) {
            short[] row = matrixA[i];

            for (int j = 0; j < row.length; j++) {
                result[i][j] = matrixA[i][j];
            }
        }

        for (int i = 0; i < rowAmountB; i++) {
            short[] row = matrixB[i];

            for (int j = 0; j < row.length; j++) {
                result[i + rowAmountA][j + columnAmountA] = matrixB[i][j];
            }
        }

        return result;
    }

    static int sumOfLeastElements(short[][] matrix) {
        int result = 0;

        for (short[] row : matrix) {
            if (row.length == 0) {
                continue;
            }

            short minimum = row[0];
            short sumOfValues = row[0];

            for (int i = 1; i < row.length; i++) {
                short currentValue = row[i];

                if (currentValue < minimum) {
                    minimum = currentValue;
                    sumOfValues = currentValue;
                } else if (currentValue == minimum) {
                    sumOfValues += currentValue;
                }
            }

            result += sumOfValues;
        }

        return result;
    }
}
