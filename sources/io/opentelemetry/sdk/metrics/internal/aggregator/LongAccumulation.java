package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class LongAccumulation {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<LongExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LongAccumulation create(long j, List<LongExemplarData> list) {
        return new AutoValue_LongAccumulation(j, list);
    }

    static LongAccumulation create(long j) {
        return create(j, Collections.emptyList());
    }
}
