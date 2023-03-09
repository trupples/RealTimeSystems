public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(2, 5);
        Complex b = new Complex(4, -1);

        System.out.println(a + " + " + b + " = " + Complex.add(a, b));
        System.out.println(a + " * " + b + " = " + Complex.mul(a, b));
    }
}