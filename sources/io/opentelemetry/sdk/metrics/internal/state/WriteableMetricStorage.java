package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* loaded from: classes6.dex */
public interface WriteableMetricStorage {
    BoundStorageHandle bind(Attributes attributes);

    void recordDouble(double d, Attributes attributes, Context context);

    void recordLong(long j, Attributes attributes, Context context);

    /* renamed from: io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static void $default$recordLong(WriteableMetricStorage writeableMetricStorage, long j, Attributes attributes, Context context) {
            BoundStorageHandle bind = writeableMetricStorage.bind(attributes);
            try {
                bind.recordLong(j, attributes, context);
            } finally {
                bind.release();
            }
        }

        public static void $default$recordDouble(WriteableMetricStorage writeableMetricStorage, double d, Attributes attributes, Context context) {
            BoundStorageHandle bind = writeableMetricStorage.bind(attributes);
            try {
                bind.recordDouble(d, attributes, context);
            } finally {
                bind.release();
            }
        }
    }
}
