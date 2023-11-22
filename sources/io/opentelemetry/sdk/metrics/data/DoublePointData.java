package io.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes9.dex */
public interface DoublePointData extends PointData {
    @Override // io.opentelemetry.sdk.metrics.data.PointData
    List<DoubleExemplarData> getExemplars();

    double getValue();
}
