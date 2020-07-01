import java.util.Random;

public class MatrixGenerator {
    private static Random r = new Random();

    public static double[][] getRandomTridiagonal(double[] root, double min, double max) {
        int size = root.length;
        double[][] result = new double[size][size + 1];
        for (int i = 1; i < size - 1; i++) {
            result[i][i - 1] = getRandomDouble(min, max);
            result[i][i] = getRandomDouble(min, max);
            result[i][i + 1] = getRandomDouble(min, max);
        }
        result[0][0] = getRandomDouble(min, max);
        result[0][1] = getRandomDouble(min, max);

        result[size - 1][size - 1] = getRandomDouble(min, max);
        result[size - 1][size - 2] = getRandomDouble(min, max);

        double[] constantTerms = getConstantTerms(result, root);
        for (int i = 0; i < size; i++) {
            result[i][size] = constantTerms[i];
        }
        return result;
    }

    private static double[] getConstantTerms(double[][] matrix, double[] root) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i] += matrix[i][j] * root[j];
            }
        }
        return result;
    }

    private static double getRandomDouble(double min, double max) {
        return min + r.nextDouble() * (max - min);
    }
}
