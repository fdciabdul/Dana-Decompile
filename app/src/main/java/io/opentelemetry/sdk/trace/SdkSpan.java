package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanContextKey;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributeUtil;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class SdkSpan implements ReadWriteSpan {
    private static final Logger logger = Logger.getLogger(SdkSpan.class.getName());
    @Nullable
    private AttributesMap attributes;
    private final AnchoredClock clock;
    private final SpanContext context;
    private long endEpochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final SpanKind kind;
    private final List<LinkData> links;
    private String name;
    private final SpanContext parentSpanContext;
    private final Resource resource;
    private final SpanLimits spanLimits;
    private final SpanProcessor spanProcessor;
    private final long startEpochNanos;
    private final int totalRecordedLinks;
    private final Object lock = new Object();
    private int totalRecordedEvents = 0;
    private StatusData status = StatusData.CC.unset();
    private boolean hasEnded = false;
    private final List<EventData> events = new ArrayList();

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span addEvent(String str, Attributes attributes, Instant instant) {
        return Span.CC.$default$addEvent(this, str, attributes, instant);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span addEvent(String str, Instant instant) {
        return Span.CC.$default$addEvent(this, str, instant);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ void end(Instant instant) {
        Span.CC.$default$end(this, instant);
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Scope makeCurrent() {
        Scope makeCurrent;
        makeCurrent = Context.CC.current().with(this).makeCurrent();
        return makeCurrent;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAllAttributes(Attributes attributes) {
        return Span.CC.$default$setAllAttributes(this, attributes);
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(AttributeKey attributeKey, int i) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey<AttributeKey>>) ((AttributeKey<AttributeKey>) attributeKey), (AttributeKey<AttributeKey>) ((AttributeKey) Long.valueOf(i)));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(String str, double d) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey<AttributeKey<Double>>>) ((AttributeKey<AttributeKey<Double>>) AttributeKey.CC.doubleKey(str)), (AttributeKey<AttributeKey<Double>>) ((AttributeKey<Double>) Double.valueOf(d)));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(String str, long j) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey<AttributeKey<Long>>>) ((AttributeKey<AttributeKey<Long>>) AttributeKey.CC.longKey(str)), (AttributeKey<AttributeKey<Long>>) ((AttributeKey<Long>) Long.valueOf(j)));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(String str, String str2) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey<AttributeKey<String>>>) ((AttributeKey<AttributeKey<String>>) AttributeKey.CC.stringKey(str)), (AttributeKey<AttributeKey<String>>) ((AttributeKey<String>) str2));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setAttribute(String str, boolean z) {
        Span attribute;
        attribute = setAttribute((AttributeKey<AttributeKey<AttributeKey<Boolean>>>) ((AttributeKey<AttributeKey<Boolean>>) AttributeKey.CC.booleanKey(str)), (AttributeKey<AttributeKey<Boolean>>) ((AttributeKey<Boolean>) Boolean.valueOf(z)));
        return attribute;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* synthetic */ Span setStatus(StatusCode statusCode) {
        Span status;
        status = setStatus(statusCode, "");
        return status;
    }

    @Override // io.opentelemetry.api.trace.Span, io.opentelemetry.context.ImplicitContextKeyed
    public final /* synthetic */ Context storeInContext(Context context) {
        Context with;
        with = context.with(SpanContextKey.KEY, this);
        return with;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final /* bridge */ /* synthetic */ Span setAttribute(AttributeKey attributeKey, Object obj) {
        return setAttribute((AttributeKey<AttributeKey>) attributeKey, (AttributeKey) obj);
    }

    private SdkSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, SpanContext spanContext2, SpanLimits spanLimits, SpanProcessor spanProcessor, AnchoredClock anchoredClock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i, long j) {
        this.context = spanContext;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.parentSpanContext = spanContext2;
        this.links = list;
        this.totalRecordedLinks = i;
        this.name = str;
        this.kind = spanKind;
        this.spanProcessor = spanProcessor;
        this.resource = resource;
        this.clock = anchoredClock;
        this.startEpochNanos = j;
        this.attributes = attributesMap;
        this.spanLimits = spanLimits;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SdkSpan startSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, Span span, Context context, SpanLimits spanLimits, SpanProcessor spanProcessor, Clock clock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i, long j) {
        AnchoredClock create;
        boolean z;
        long j2;
        long now;
        if (span instanceof SdkSpan) {
            create = ((SdkSpan) span).clock;
            z = false;
        } else {
            create = AnchoredClock.create(clock);
            z = true;
        }
        AnchoredClock anchoredClock = create;
        if (j == 0) {
            if (z) {
                now = anchoredClock.startTime();
            } else {
                now = anchoredClock.now();
            }
            j2 = now;
        } else {
            j2 = j;
        }
        SdkSpan sdkSpan = new SdkSpan(spanContext, str, instrumentationScopeInfo, spanKind, span.getSpanContext(), spanLimits, spanProcessor, anchoredClock, resource, attributesMap, list, i, j2);
        spanProcessor.onStart(context, sdkSpan);
        return sdkSpan;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final SpanData toSpanData() {
        SpanWrapper create;
        synchronized (this.lock) {
            List<LinkData> list = this.links;
            List<EventData> immutableTimedEvents = getImmutableTimedEvents();
            Attributes immutableAttributes = getImmutableAttributes();
            AttributesMap attributesMap = this.attributes;
            create = SpanWrapper.create(this, list, immutableTimedEvents, immutableAttributes, attributesMap == null ? 0 : attributesMap.getTotalAddedValues(), this.totalRecordedEvents, this.status, this.name, this.endEpochNanos, this.hasEnded);
        }
        return create;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    @Nullable
    public final <T> T getAttribute(AttributeKey<T> attributeKey) {
        T t;
        synchronized (this.lock) {
            AttributesMap attributesMap = this.attributes;
            t = attributesMap == null ? null : (T) attributesMap.get((AttributeKey) attributeKey);
        }
        return t;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final boolean hasEnded() {
        boolean z;
        synchronized (this.lock) {
            z = this.hasEnded;
        }
        return z;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final SpanContext getSpanContext() {
        return this.context;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final SpanContext getParentSpanContext() {
        return this.parentSpanContext;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final String getName() {
        String str;
        synchronized (this.lock) {
            str = this.name;
        }
        return str;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    @Deprecated
    public final InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        return InstrumentationScopeUtil.toInstrumentationLibraryInfo(getInstrumentationScopeInfo());
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final long getLatencyNanos() {
        long now;
        long j;
        synchronized (this.lock) {
            now = this.hasEnded ? this.endEpochNanos : this.clock.now();
            j = this.startEpochNanos;
        }
        return now - j;
    }

    final AnchoredClock getClock() {
        return this.clock;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final <T> ReadWriteSpan setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling setAttribute() on an ended Span.");
                return this;
            }
            if (this.attributes == null) {
                this.attributes = AttributesMap.create(this.spanLimits.getMaxNumberOfAttributes(), this.spanLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey<AttributeKey<T>>) attributeKey, (AttributeKey<T>) t);
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan addEvent(String str) {
        if (str == null) {
            return this;
        }
        addTimedEvent(EventData.CC.create(this.clock.now(), str, Attributes.CC.empty(), 0));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan addEvent(String str, long j, TimeUnit timeUnit) {
        if (str != null && timeUnit != null) {
            addTimedEvent(EventData.CC.create(timeUnit.toNanos(j), str, Attributes.CC.empty(), 0));
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan addEvent(String str, Attributes attributes) {
        if (str == null) {
            return this;
        }
        if (attributes == null) {
            attributes = Attributes.CC.empty();
        }
        addTimedEvent(EventData.CC.create(this.clock.now(), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit) {
        if (str != null && timeUnit != null) {
            if (attributes == null) {
                attributes = Attributes.CC.empty();
            }
            addTimedEvent(EventData.CC.create(timeUnit.toNanos(j), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        }
        return this;
    }

    private void addTimedEvent(EventData eventData) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling addEvent() on an ended Span.");
                return;
            }
            if (this.events.size() < this.spanLimits.getMaxNumberOfEvents()) {
                this.events.add(eventData);
            }
            this.totalRecordedEvents++;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan setStatus(StatusCode statusCode, @Nullable String str) {
        if (statusCode == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling setStatus() on an ended Span.");
                return this;
            }
            this.status = StatusData.CC.create(statusCode, str);
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan recordException(Throwable th) {
        recordException(th, Attributes.CC.empty());
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan recordException(Throwable th, Attributes attributes) {
        if (th == null) {
            return this;
        }
        if (attributes == null) {
            attributes = Attributes.CC.empty();
        }
        addTimedEvent(ExceptionEventData.CC.create(this.spanLimits, this.clock.now(), th, attributes));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public final ReadWriteSpan updateName(String str) {
        if (str == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling updateName() on an ended Span.");
                return this;
            }
            this.name = str;
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public final void end() {
        endInternal(this.clock.now());
    }

    @Override // io.opentelemetry.api.trace.Span
    public final void end(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        endInternal(j == 0 ? this.clock.now() : timeUnit.toNanos(j));
    }

    private void endInternal(long j) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling end() on an ended Span.");
                return;
            }
            this.endEpochNanos = j;
            this.hasEnded = true;
            this.spanProcessor.onEnd(this);
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public final boolean isRecording() {
        boolean z;
        synchronized (this.lock) {
            z = !this.hasEnded;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public final SpanKind getKind() {
        return this.kind;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getTotalRecordedLinks() {
        return this.totalRecordedLinks;
    }

    private List<EventData> getImmutableTimedEvents() {
        if (this.events.isEmpty()) {
            return Collections.emptyList();
        }
        if (this.hasEnded) {
            return Collections.unmodifiableList(this.events);
        }
        return Collections.unmodifiableList(new ArrayList(this.events));
    }

    private Attributes getImmutableAttributes() {
        AttributesMap attributesMap = this.attributes;
        if (attributesMap == null || attributesMap.isEmpty()) {
            return Attributes.CC.empty();
        }
        if (this.hasEnded) {
            return this.attributes;
        }
        return this.attributes.immutableCopy();
    }

    public final String toString() {
        String str;
        String valueOf;
        String valueOf2;
        long j;
        long j2;
        synchronized (this.lock) {
            str = this.name;
            valueOf = String.valueOf(this.attributes);
            valueOf2 = String.valueOf(this.status);
            j = this.totalRecordedEvents;
            j2 = this.endEpochNanos;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SdkSpan{traceId=");
        sb.append(this.context.getTraceId());
        sb.append(", spanId=");
        sb.append(this.context.getSpanId());
        sb.append(", parentSpanContext=");
        sb.append(this.parentSpanContext);
        sb.append(", name=");
        sb.append(str);
        sb.append(", kind=");
        sb.append(this.kind);
        sb.append(", attributes=");
        sb.append(valueOf);
        sb.append(", status=");
        sb.append(valueOf2);
        sb.append(", totalRecordedEvents=");
        sb.append(j);
        sb.append(", totalRecordedLinks=");
        sb.append(this.totalRecordedLinks);
        sb.append(", startEpochNanos=");
        sb.append(this.startEpochNanos);
        sb.append(", endEpochNanos=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
