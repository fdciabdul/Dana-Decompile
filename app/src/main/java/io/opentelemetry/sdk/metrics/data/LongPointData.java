package io.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes9.dex */
public interface LongPointData extends PointData {
    @Override // io.opentelemetry.sdk.metrics.data.PointData
    List<LongExemplarData> getExemplars();

    long getValue();
}
