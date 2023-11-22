package Catalano.Statistics.Kernels;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class Anova implements IMercerKernel<double[]> {
    private double[][][] K;
    private int n;
    private int p;

    public Anova(int i, int i2) {
        this.n = i;
        this.p = i2;
        this.K = (double[][][]) Array.newInstance(Double.TYPE, i, i, i2);
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        int i = 0;
        while (true) {
            int i2 = this.p;
            if (i < i2) {
                for (int i3 = 0; i3 < this.n; i3++) {
                    for (int i4 = 0; i4 < this.n; i4++) {
                        this.K[i3][i4][i] = kernel(dArr, i3, dArr2, i4, i);
                    }
                }
                i++;
            } else {
                double[][][] dArr3 = this.K;
                int i5 = this.n - 1;
                return dArr3[i5][i5][i2 - 1];
            }
        }
    }

    private double kernel(double[] dArr, int i, double[] dArr2, int i2, int i3) {
        double d = (i == 0 || i2 == 0) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : this.K[i - 1][i2 - 1][i3];
        double d2 = dArr[i] * dArr2[i2];
        return i3 == 0 ? d + d2 : (i == 0 || i2 == 0) ? d : d + (d2 * this.K[i - 1][i2 - 1][i3 - 1]);
    }
}
