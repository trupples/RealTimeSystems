public class Mat {
    public float[][] elems;

    public Mat(float[][] elems) {
        this.elems = elems;
    }

    public static Mat add(Mat a, Mat b) {
        final int n = a.elems.length;
        final int m = a.elems[0].length;

        assert b.elems.length == n;

        Mat result = new Mat(new float[n][m]);

        for(int i = 0; i < n; i++) {
            assert a.elems[i].length == m && b.elems[i].length == m;

            for(int j = 0; j < m; j++) {
                result.elems[i][j] = a.elems[i][j] + b.elems[i][j];
            }
        }

        return result;
    }

    public static Mat mul(Mat a, Mat b) {
        final int n = a.elems.length;
        final int m = b.elems[0].length;
        final int l = a.elems[0].length;

        assert b.elems.length == l;

        Mat result = new Mat(new float[n][m]);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < l; k++) {
                    result.elems[i][j] += a.elems[i][k] * b.elems[k][j];
                }
            }
        }

        return result;
    }

    public String toString() {
        final int n = this.elems.length;
        final int m = this.elems[0].length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j != 0) sb.append('\t');
                sb.append(elems[i][j]);
            }
            if(i != n - 1) sb.append('\n');
        }

        return sb.toString();
    }
}
