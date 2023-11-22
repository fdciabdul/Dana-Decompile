package Catalano.Statistics.Kernels;

/* loaded from: classes6.dex */
public class Tensor implements IMercerKernel<double[]> {
    private IMercerKernel<double[]>[] kernels;

    public Tensor(IMercerKernel<double[]>[] iMercerKernelArr) {
        this.kernels = iMercerKernelArr;
    }

    @Override // Catalano.Statistics.Kernels.IMercerKernel
    public double Function(double[] dArr, double[] dArr2) {
        double d = 1.0d;
        int i = 0;
        while (true) {
            IMercerKernel<double[]>[] iMercerKernelArr = this.kernels;
            if (i >= iMercerKernelArr.length) {
                return d;
            }
            d *= iMercerKernelArr[i].Function(dArr, dArr2);
            i++;
        }
    }
}
