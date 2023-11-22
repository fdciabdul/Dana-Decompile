package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.api.common.Attributes;
import java.util.List;

/* loaded from: classes9.dex */
public interface PointData {
    Attributes getAttributes();

    long getEpochNanos();

    List<? extends ExemplarData> getExemplars();

    long getStartEpochNanos();
}
