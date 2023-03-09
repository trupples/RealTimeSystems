public class Main {
    public static void main(String[] args) {
        Mat a = new Mat(new float[][]{
                {2, 3, 1},
                {7, 1, 6},
                {9, 2, 4}
        });

        Mat b = new Mat(new float[][]{
                {8, 5, 3},
                {3, 9, 2},
                {2, 7, 3}
        });

        System.out.println("\na = ");
        System.out.println(a);
        System.out.println("\nb = ");
        System.out.println(b);

        System.out.println("\na + b = ");
        System.out.println(Mat.add(a, b));

        System.out.println("\na * b = ");
        System.out.println(Mat.mul(a, b));
    }
}