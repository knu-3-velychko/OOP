import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixGeneratorTest {
    @Test
    public void getRandomTridiagonal() {
        int size = 10;
        double[] root = new double[size];
        for (int i = 0; i < size; i++)
            root[i] = (double) i;

        double[][] matrix = MatrixGenerator.getRandomTridiagonal(root, -50f, 50f);
        assertEquals(size, matrix.length);

        for (int i = 0; i < size; i++) {
            double sum = 0.0f;
            assertEquals(size + 1, matrix[i].length);
            for (int j = 0; j < size; j++) {
                if (j < i - 1 || j > i + 1) {
                    assertEquals(0.0, matrix[i][j], 0.1e-12);
                }

                sum += matrix[i][j] * root[j];
            }
            assertEquals(matrix[i][size], sum, 0.1e-12);
        }
    }
}