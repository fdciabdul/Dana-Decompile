package com.splunk.rum;

import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class DefaultMemorySpanBuffer implements MemorySpanBuffer {
    private final Queue<SpanData> getAuthRequestContext = new ArrayDeque();

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void PlaceComponentResult(Collection<SpanData> collection) {
        this.getAuthRequestContext.addAll(collection);
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void MyBillsEntityDataFactory(SpanData spanData) {
        this.getAuthRequestContext.add(spanData);
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final List<SpanData> PlaceComponentResult() {
        ArrayList arrayList = new ArrayList(this.getAuthRequestContext);
        this.getAuthRequestContext.clear();
        return arrayList;
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.isEmpty();
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.clear();
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.size();
    }
}
