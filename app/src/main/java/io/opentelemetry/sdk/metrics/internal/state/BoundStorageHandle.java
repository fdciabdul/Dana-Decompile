package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes6.dex */
public interface BoundStorageHandle {
    void recordDouble(double d, Attributes attributes, Context context);

    void recordLong(long j, Attributes attributes, Context context);

    void release();
}
