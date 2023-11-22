package Catalano.Statistics.Kernels;

import java.io.Serializable;

/* loaded from: classes6.dex */
public interface IMercerKernel<T> extends Serializable {
    double Function(T t, T t2);
}
