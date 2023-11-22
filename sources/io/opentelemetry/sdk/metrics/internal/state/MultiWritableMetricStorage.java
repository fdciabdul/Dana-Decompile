package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MultiWritableMetricStorage implements WriteableMetricStorage {
    private final List<? extends WriteableMetricStorage> underlyingMetrics;

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordDouble(double d, Attributes attributes, Context context) {
        WriteableMetricStorage.CC.$default$recordDouble(this, d, attributes, context);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordLong(long j, Attributes attributes, Context context) {
        WriteableMetricStorage.CC.$default$recordLong(this, j, attributes, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiWritableMetricStorage(List<? extends WriteableMetricStorage> list) {
        this.underlyingMetrics = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        ArrayList arrayList = new ArrayList(this.underlyingMetrics.size());
        Iterator<? extends WriteableMetricStorage> it = this.underlyingMetrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().bind(attributes));
        }
        return new MultiBoundStorageHandle(arrayList);
    }
}
