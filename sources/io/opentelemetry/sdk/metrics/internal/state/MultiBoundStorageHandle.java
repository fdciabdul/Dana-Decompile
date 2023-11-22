package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
class MultiBoundStorageHandle implements BoundStorageHandle {
    private final List<BoundStorageHandle> underlyingHandles;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiBoundStorageHandle(List<BoundStorageHandle> list) {
        this.underlyingHandles = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void recordLong(long j, Attributes attributes, Context context) {
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().recordLong(j, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void recordDouble(double d, Attributes attributes, Context context) {
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().recordDouble(d, attributes, context);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void release() {
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
