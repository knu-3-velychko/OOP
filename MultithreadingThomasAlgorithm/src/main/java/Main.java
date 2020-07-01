public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        double min = -50f, max = 50f;
        double[] root = new double[size];
        double[][] matrix;

        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
        matrix = MatrixGenerator.getRandomTridiagonal(root, min, max);
        ThomasAlgorithm algorithm = new ThomasAlgorithm(matrix);
        double[] result = algorithm.solve();
        for (double i : result)
            System.out.println(i);
    }
}
