import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ThomasAlgorithmTest {

    private final int size = 10;
    private double[][] matrix;
    private double[] root;

    @Before
    public void setUp() {
        double min = -50f, max = 50f;
        root = new double[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
        matrix = MatrixGenerator.getRandomTridiagonal(root, min, max);
    }

    @Test
    public void solve() throws InterruptedException {
        ThomasAlgorithm algorithm = new ThomasAlgorithm(matrix);
        double[] result = algorithm.solve();
        assertArrayEquals(root, result, 0.1e-5f);
    }


}