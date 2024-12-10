import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatrixTest {

    @Test
    public void testDivideByMax_case1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] expected = {
                {1.0 / 9, 2.0 / 9, 3.0 / 9},
                {4.0 / 9, 5.0 / 9, 6.0 / 9},
                {7.0 / 9, 8.0 / 9, 1.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    @Test
    public void testDivideByMax_case2() {
        int[][] matrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        double[][] expected = {
                {1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    @Test
    public void testDivideByMax_case3() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        double[][] expected = {
                {0.25, 0.5},
                {0.75, 1.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    @Test
    public void testDivideByMax_case4() {
        int[][] matrix = {
                {5}
        };
        double[][] expected = {
                {1.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    @Test
    public void testDivideByMax_case5() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double[][] expected = {
                {1.0 / 16, 2.0 / 16, 3.0 / 16, 4.0 / 16},
                {5.0 / 16, 6.0 / 16, 7.0 / 16, 8.0 / 16},
                {9.0 / 16, 10.0 / 16, 11.0 / 16, 12.0 / 16},
                {13.0 / 16, 14.0 / 16, 15.0 / 16, 1.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    @Test
    public void testDivideByMax_case6() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        double[][] expected = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}
        };
        double[][] result = divideByMax(matrix);
        assertArrayEquals(expected, result, String.valueOf(0.001));
    }

    // Метод для деления элементов матрицы на наибольший элемент
    private double[][] divideByMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                max = Math.max(max, val);
            }
        }

        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Проверяем, чтобы избежать деления на ноль
                if (max != 0) {
                    result[i][j] = (double) matrix[i][j] / max;
                } else {
                    result[i][j] = 0.0; // Если максимальный элемент 0, все элементы будут 0
                }
            }
        }
        return result;
    }
}
