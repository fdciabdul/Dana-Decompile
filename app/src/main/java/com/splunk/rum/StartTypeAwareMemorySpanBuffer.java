package com.splunk.rum;

import io.opentelemetry.sdk.trace.data.SpanData;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class StartTypeAwareMemorySpanBuffer implements MemorySpanBuffer {
    private final VisibleScreenTracker PlaceComponentResult;
    private final Queue<SpanData> getAuthRequestContext = new ArrayDeque();
    private final Queue<SpanData> BuiltInFictitiousFunctionClassFactory = new ArrayDeque();

    public StartTypeAwareMemorySpanBuffer(VisibleScreenTracker visibleScreenTracker) {
        this.PlaceComponentResult = visibleScreenTracker;
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void PlaceComponentResult(Collection<SpanData> collection) {
        VisibleScreenTracker visibleScreenTracker = this.PlaceComponentResult;
        String str = visibleScreenTracker.getAuthRequestContext.get();
        if (str == null) {
            str = visibleScreenTracker.MyBillsEntityDataFactory.get();
        }
        if (str == null) {
            this.BuiltInFictitiousFunctionClassFactory.addAll(collection);
        } else {
            this.getAuthRequestContext.addAll(collection);
        }
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void MyBillsEntityDataFactory(SpanData spanData) {
        VisibleScreenTracker visibleScreenTracker = this.PlaceComponentResult;
        String str = visibleScreenTracker.getAuthRequestContext.get();
        if (str == null) {
            str = visibleScreenTracker.MyBillsEntityDataFactory.get();
        }
        if (str == null) {
            this.BuiltInFictitiousFunctionClassFactory.add(spanData);
        } else {
            this.getAuthRequestContext.add(spanData);
        }
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final List<SpanData> PlaceComponentResult() {
        ArrayList arrayList = new ArrayList(this.getAuthRequestContext);
        this.getAuthRequestContext.clear();
        VisibleScreenTracker visibleScreenTracker = this.PlaceComponentResult;
        String str = visibleScreenTracker.getAuthRequestContext.get();
        if (str == null) {
            str = visibleScreenTracker.MyBillsEntityDataFactory.get();
        }
        if (str != null) {
            arrayList.addAll(this.BuiltInFictitiousFunctionClassFactory);
            this.BuiltInFictitiousFunctionClassFactory.clear();
        }
        return arrayList;
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.isEmpty() && this.BuiltInFictitiousFunctionClassFactory.isEmpty();
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.clear();
        this.BuiltInFictitiousFunctionClassFactory.clear();
    }

    @Override // com.splunk.rum.MemorySpanBuffer
    public final int BuiltInFictitiousFunctionClassFactory() {
        VisibleScreenTracker visibleScreenTracker = this.PlaceComponentResult;
        String str = visibleScreenTracker.getAuthRequestContext.get();
        if (str == null) {
            str = visibleScreenTracker.MyBillsEntityDataFactory.get();
        }
        if (str == null) {
            return this.BuiltInFictitiousFunctionClassFactory.size();
        }
        return this.getAuthRequestContext.size();
    }
}
