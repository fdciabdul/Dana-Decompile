package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes6.dex */
public interface LongHistogram {
    void record(long j);

    void record(long j, Attributes attributes);

    void record(long j, Attributes attributes, Context context);
}
