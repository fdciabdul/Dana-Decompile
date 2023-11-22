package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class DoubleAccumulation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<DoubleExemplarData> getExemplars();

    public abstract double getValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleAccumulation create(double d, List<DoubleExemplarData> list) {
        return new AutoValue_DoubleAccumulation(d, list);
    }

    public static DoubleAccumulation create(double d) {
        return create(d, Collections.emptyList());
    }
}
