package Catalano.Statistics.Kernels;

import Catalano.Math.Matrix;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class Additive implements IMercerKernel<double[]> {
    private IMercerKernel[] kernels;
    private double[] weights;

    public Additive(IMercerKernel[] iMercerKernelArr) {
        this(iMercerKernelArr, Matrix.BuiltInFictitiousFunctionClassFactory(iMercerKernelArr.length));
    }

    public Additive(IMercerKernel[] iMercerKernelArr, double[] dArr) {
        this.kernels = iMercerKernelArr;
        this.weights = dArr;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        while (true) {
            IMercerKernel[] iMercerKernelArr = this.kernels;
            if (i >= iMercerKernelArr.length) {
                return d;
            }
            d += this.weights[i] * iMercerKernelArr[i].Function(dArr, dArr2);
            i++;
        }
    }
}
