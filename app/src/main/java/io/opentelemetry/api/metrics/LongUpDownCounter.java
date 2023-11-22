package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes6.dex */
public interface LongUpDownCounter {
    void add(long j);

    void add(long j, Attributes attributes);

    void add(long j, Attributes attributes, Context context);
}
