package io.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes9.dex */
public interface HistogramPointData extends PointData {
    List<Double> getBoundaries();

    long getCount();

    List<Long> getCounts();

    @Override // io.opentelemetry.sdk.metrics.data.PointData
    List<DoubleExemplarData> getExemplars();

    double getMax();

    double getMin();

    double getSum();

    boolean hasMax();

    boolean hasMin();
}
