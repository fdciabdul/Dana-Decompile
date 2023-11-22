package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import j$.util.function.BiConsumer;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import zipkin2.Span;

/* loaded from: classes.dex */
public class DanaExporter implements SpanExporter {
    static final AttributeKey<String> MyBillsEntityDataFactory = AttributeKey.CC.stringKey("error");
    ResultCallback getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface ResultCallback {
        void getAuthRequestContext(String str);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public static DanaExporter getAuthRequestContext() {
        return new DanaExporter();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        Span.Kind kind;
        ResultCallback resultCallback;
        for (SpanData spanData : collection) {
            long micros = TimeUnit.NANOSECONDS.toMicros(spanData.getStartEpochNanos());
            long micros2 = TimeUnit.NANOSECONDS.toMicros(spanData.getEndEpochNanos());
            Span.Builder newBuilder = Span.newBuilder();
            newBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = Span.normalizeTraceId(spanData.getTraceId());
            final Span.Builder KClassImpl$Data$declaredNonStaticMembers$2 = newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(spanData.getSpanId());
            int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[spanData.getKind().ordinal()];
            String str = null;
            if (i == 1) {
                kind = Span.Kind.CLIENT;
            } else if (i == 2) {
                kind = Span.Kind.SERVER;
            } else if (i != 3) {
                kind = i != 4 ? null : Span.Kind.PRODUCER;
            } else {
                kind = Span.Kind.CONSUMER;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = kind;
            String name = spanData.getName();
            if (name != null && !name.isEmpty()) {
                str = name.toLowerCase(Locale.ROOT);
            }
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = str;
            long micros3 = TimeUnit.NANOSECONDS.toMicros(spanData.getStartEpochNanos());
            if (micros3 < 0) {
                micros3 = 0;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = micros3;
            long max = Math.max(1L, micros2 - micros);
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = max >= 0 ? max : 0L;
            if (spanData.getParentSpanContext().isValid()) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(spanData.getParentSpanId());
            }
            Attributes attributes = spanData.getAttributes();
            attributes.forEach(new BiConsumer() { // from class: com.splunk.rum.DanaExporter$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    DanaExporter.PlaceComponentResult(Span.Builder.this, (AttributeKey) obj, obj2);
                }

                @Override // j$.util.function.BiConsumer
                public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
                }
            });
            StatusData status = spanData.getStatus();
            if (status.getStatusCode() != StatusCode.UNSET) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.status_code", status.getStatusCode().toString());
                if (status.getStatusCode() == StatusCode.ERROR) {
                    AttributeKey<String> attributeKey = MyBillsEntityDataFactory;
                    if (attributes.get(attributeKey) == null) {
                        String key = attributeKey.getKey();
                        String description = status.getDescription();
                        if (description == null) {
                            description = "";
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(key, description);
                    }
                }
            }
            InstrumentationScopeInfo instrumentationScopeInfo = spanData.getInstrumentationScopeInfo();
            if (!instrumentationScopeInfo.getName().isEmpty()) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.scope.name", instrumentationScopeInfo.getName());
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.library.name", instrumentationScopeInfo.getName());
            }
            if (instrumentationScopeInfo.getVersion() != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.scope.version", instrumentationScopeInfo.getVersion());
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.library.version", instrumentationScopeInfo.getVersion());
            }
            for (EventData eventData : spanData.getEvents()) {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(TimeUnit.NANOSECONDS.toMicros(eventData.getEpochNanos()), eventData.getName());
            }
            int totalRecordedEvents = spanData.getTotalRecordedEvents() - spanData.getEvents().size();
            if (totalRecordedEvents > 0) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("otel.dropped_events_count", String.valueOf(totalRecordedEvents));
            }
            Span authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            StringBuilder sb = new StringBuilder();
            if (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[spanData.getKind().ordinal()] == 1) {
                String str2 = authRequestContext.tags().get("http.method");
                double endEpochNanos = spanData.getEndEpochNanos() - spanData.getStartEpochNanos();
                Double.isNaN(endEpochNanos);
                String valueOf = String.valueOf(Double.valueOf(endEpochNanos / 1000000.0d));
                String str3 = authRequestContext.tags().get("http.status_code");
                String str4 = authRequestContext.tags().get("http.url");
                sb.append("[Network] ");
                sb.append("pending");
                sb.append(System.getProperty("line.separator"));
                sb.append("Method : ");
                sb.append(str2);
                sb.append(System.getProperty("line.separator"));
                sb.append("Duration : ");
                sb.append(valueOf);
                sb.append(System.getProperty("line.separator"));
                sb.append("StatusCode : ");
                sb.append(str3);
                sb.append(System.getProperty("line.separator"));
                sb.append("Url : ");
                sb.append(str4);
                sb.append(System.getProperty("line.separator"));
                if (authRequestContext.tags().get("rpc.message") != null) {
                    sb.append("Exception Message : ");
                    sb.append("rpc.message");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Exception Type : ");
                    sb.append("rpc.type");
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Trace ID : ");
                    sb.append("rpc.traceId");
                }
            } else {
                String name2 = authRequestContext.name();
                String str5 = authRequestContext.tags().get("screen.name");
                double endEpochNanos2 = spanData.getEndEpochNanos() - spanData.getStartEpochNanos();
                Double.isNaN(endEpochNanos2);
                String valueOf2 = String.valueOf(Double.valueOf(endEpochNanos2 / 1000000.0d));
                if (authRequestContext.tags().get("component") != null) {
                    sb.append("[UI] ");
                    sb.append(name2);
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Screen Name : ");
                    sb.append(str5);
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Component : ");
                    sb.append(authRequestContext.tags().get("component"));
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Duration : ");
                    sb.append(valueOf2);
                }
                if (authRequestContext.tags().get("exception.stacktrace") != null) {
                    sb.append(System.getProperty("line.separator"));
                    sb.append("Stack Trace : ");
                    sb.append(authRequestContext.tags().get("exception.stacktrace"));
                }
            }
            if (!sb.toString().isEmpty() && (resultCallback = this.getAuthRequestContext) != null) {
                resultCallback.getAuthRequestContext(sb.toString());
            }
        }
        return CompletableResultCode.ofSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void PlaceComponentResult(Span.Builder builder, AttributeKey attributeKey, Object obj) {
        String valueOf;
        String key = attributeKey.getKey();
        AttributeType type = attributeKey.getType();
        switch (AnonymousClass1.getAuthRequestContext[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                valueOf = String.valueOf(obj);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : (List) obj) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }
                    sb.append(obj2);
                }
                valueOf = sb.toString();
                break;
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown attribute type: ");
                sb2.append(type);
                throw new IllegalStateException(sb2.toString());
        }
        builder.PlaceComponentResult(key, valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.splunk.rum.DanaExporter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[AttributeType.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[AttributeType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[AttributeType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[AttributeType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[AttributeType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[AttributeType.STRING_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[AttributeType.BOOLEAN_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[AttributeType.LONG_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[AttributeType.DOUBLE_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SpanKind.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr2;
            try {
                iArr2[SpanKind.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SpanKind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SpanKind.CONSUMER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SpanKind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SpanKind.INTERNAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return new CompletableResultCode().succeed();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return flush();
    }
}
