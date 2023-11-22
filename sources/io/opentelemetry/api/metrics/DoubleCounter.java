package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes6.dex */
public interface DoubleCounter {
    void add(double d);

    void add(double d, Attributes attributes);

    void add(double d, Attributes attributes, Context context);
}
