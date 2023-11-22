package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class ImmutableDoublePointData implements DoublePointData {
    public static DoublePointData create(long j, long j2, Attributes attributes, double d) {
        return create(j, j2, attributes, d, Collections.emptyList());
    }

    public static DoublePointData create(long j, long j2, Attributes attributes, double d, List<DoubleExemplarData> list) {
        return new AutoValue_ImmutableDoublePointData(j, j2, attributes, d, list);
    }
}
