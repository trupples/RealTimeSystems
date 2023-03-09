public class Complex {
    public float real, imag;

    public Complex(float real, float imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        return String.format("%f%+fi", real, imag);
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }

    public static Complex mul(Complex a, Complex b) {
        return new Complex(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }
}
