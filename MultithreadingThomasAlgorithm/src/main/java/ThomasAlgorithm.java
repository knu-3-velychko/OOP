import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThomasAlgorithm {
    private double[][] matrix;
    private double[] x;
    private int size;


    private CyclicBarrier barrier = new CyclicBarrier(2);
    private volatile double a1;
    private volatile double b1;
    private volatile double a2;
    private volatile double b2;

    ThomasAlgorithm(double[][] matrix) {
        this.matrix = matrix;
        this.x = new double[matrix.length];
        size = matrix.length;
    }

    double[] solve() throws InterruptedException {
        int size = matrix.length;

        Thread left = new Thread(leftForwardSweep(0, size / 2, barrier));
        Thread right = new Thread(rightForwardSweep(size / 2, size, barrier));

        right.start();
        left.start();

        left.join();
        right.join();

        return x;
    }

    private Runnable leftForwardSweep(int start, int end, CyclicBarrier barrier) {
        return () -> {
            double y = matrix[0][0];
            double[] a = new double[size];
            double[] b = new double[size];

            a[0] = -matrix[0][1] / y;
            b[0] = matrix[0][size] / y;

            for (int i = start + 1; i < end; i++) {
                y = matrix[i][i] + matrix[i][i - 1] * a[i - 1];
                a[i] = -matrix[i][i + 1] / y;
                b[i] = (matrix[i][size] - matrix[i][i - 1] * b[i - 1]) / y;
            }

            a1 = a[end - 1];
            b1 = b[end - 1];
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            x[end - 1] = -(a1 * b2 + b1) / (a2 * a1 - 1.0);
            for (int i = end - 2; i >= start; i--) {
                x[i] = a[i] * x[i + 1] + b[i];
            }

        };
    }

    private Runnable rightForwardSweep(int start, int end,CyclicBarrier barrier) {
        return () -> {
            double y = matrix[size - 1][size - 1];
            double[] a = new double[size];
            double[] b = new double[size];

            a[size - 1] = -matrix[size - 1][size - 2] / y;
            b[size - 1] = matrix[size - 1][size] / y;

            for (int i = end - 2; i >= start; i--) {
                y = matrix[i][i] + matrix[i][i + 1] * a[i + 1];
                a[i] = -matrix[i][i - 1] / y;
                b[i] = (matrix[i][size] - matrix[i][i + 1] * b[i + 1]) / y;
            }

            a2 = a[start];
            b2 = b[start];
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            x[start] = -(a2 * b1 + b2) / (a2 * a1 - 1.0);

            for (int i = start; i < end - 1; i++) {
                x[i + 1] = a[i + 1] * x[i] + b[i + 1];
            }

        };
    }
}
