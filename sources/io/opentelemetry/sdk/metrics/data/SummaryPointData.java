package io.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes9.dex */
public interface SummaryPointData extends PointData {
    long getCount();

    double getSum();

    List<ValueAtQuantile> getValues();
}
