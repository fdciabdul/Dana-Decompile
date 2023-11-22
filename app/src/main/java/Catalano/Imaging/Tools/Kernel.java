package Catalano.Imaging.Tools;

import Catalano.Math.Decompositions.SingularValueDecomposition;

/* loaded from: classes6.dex */
public class Kernel {
    public static double[][] BuiltInFictitiousFunctionClassFactory(double[][] dArr) {
        SingularValueDecomposition singularValueDecomposition = new SingularValueDecomposition(dArr);
        double[][] u = singularValueDecomposition.getU();
        double[][] v = singularValueDecomposition.getV();
        double sqrt = Math.sqrt(singularValueDecomposition.getS()[0][0]);
        int length = singularValueDecomposition.getU().length;
        double[] dArr2 = new double[length];
        int length2 = singularValueDecomposition.getV().length;
        double[] dArr3 = new double[length2];
        double[][] dArr4 = new double[2];
        for (int i = 0; i < length; i++) {
            dArr2[i] = u[i][0] * sqrt;
        }
        for (int i2 = 0; i2 < length2; i2++) {
            dArr3[i2] = v[i2][0] * sqrt;
        }
        dArr4[0] = dArr2;
        dArr4[1] = dArr3;
        return dArr4;
    }
}
