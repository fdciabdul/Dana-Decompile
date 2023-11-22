package io.opentelemetry.exporter.zipkin;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import j$.util.function.BiConsumer;
import j$.util.function.Supplier;
import java.net.InetAddress;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import zipkin2.Endpoint;
import zipkin2.Span;

/* loaded from: classes6.dex */
public final class OtelToZipkinSpanTransformer {
    static final String KEY_INSTRUMENTATION_LIBRARY_NAME = "otel.library.name";
    static final String KEY_INSTRUMENTATION_LIBRARY_VERSION = "otel.library.version";
    static final String KEY_INSTRUMENTATION_SCOPE_NAME = "otel.scope.name";
    static final String KEY_INSTRUMENTATION_SCOPE_VERSION = "otel.scope.version";
    static final String OTEL_DROPPED_ATTRIBUTES_COUNT = "otel.dropped_attributes_count";
    static final String OTEL_DROPPED_EVENTS_COUNT = "otel.dropped_events_count";
    static final String OTEL_STATUS_CODE = "otel.status_code";
    static final AttributeKey<String> STATUS_ERROR = AttributeKey.CC.stringKey("error");
    private final Supplier<InetAddress> ipAddressSupplier;

    private static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static OtelToZipkinSpanTransformer create(Supplier<InetAddress> supplier) {
        return new OtelToZipkinSpanTransformer(supplier);
    }

    private OtelToZipkinSpanTransformer(Supplier<InetAddress> supplier) {
        this.ipAddressSupplier = supplier;
    }

    public final Span generateSpan(SpanData spanData) {
        Endpoint endpoint = getEndpoint(spanData);
        long epochMicros = toEpochMicros(spanData.getStartEpochNanos());
        long epochMicros2 = toEpochMicros(spanData.getEndEpochNanos());
        Span.Builder newBuilder = Span.newBuilder();
        newBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = Span.normalizeTraceId(spanData.getTraceId());
        final Span.Builder KClassImpl$Data$declaredNonStaticMembers$2 = newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(spanData.getSpanId());
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = toSpanKind(spanData);
        String name = spanData.getName();
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (name == null || name.isEmpty()) ? null : name.toLowerCase(Locale.ROOT);
        long epochMicros3 = toEpochMicros(spanData.getStartEpochNanos());
        if (epochMicros3 < 0) {
            epochMicros3 = 0;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = epochMicros3;
        long max = Math.max(1L, epochMicros2 - epochMicros);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = max >= 0 ? max : 0L;
        if (Span.EMPTY_ENDPOINT.equals(endpoint)) {
            endpoint = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = endpoint;
        if (spanData.getParentSpanContext().isValid()) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(spanData.getParentSpanId());
        }
        Attributes attributes = spanData.getAttributes();
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.exporter.zipkin.OtelToZipkinSpanTransformer$$ExternalSyntheticLambda0
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Span.Builder.this.PlaceComponentResult(r2.getKey(), OtelToZipkinSpanTransformer.valueToString((AttributeKey) obj, obj2));
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        int totalAttributeCount = spanData.getTotalAttributeCount() - attributes.size();
        if (totalAttributeCount > 0) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(OTEL_DROPPED_ATTRIBUTES_COUNT, String.valueOf(totalAttributeCount));
        }
        StatusData status = spanData.getStatus();
        if (status.getStatusCode() != StatusCode.UNSET) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(OTEL_STATUS_CODE, status.getStatusCode().toString());
            if (status.getStatusCode() == StatusCode.ERROR) {
                AttributeKey<String> attributeKey = STATUS_ERROR;
                if (attributes.get(attributeKey) == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(attributeKey.getKey(), nullToEmpty(status.getDescription()));
                }
            }
        }
        InstrumentationScopeInfo instrumentationScopeInfo = spanData.getInstrumentationScopeInfo();
        if (!instrumentationScopeInfo.getName().isEmpty()) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(KEY_INSTRUMENTATION_SCOPE_NAME, instrumentationScopeInfo.getName());
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(KEY_INSTRUMENTATION_LIBRARY_NAME, instrumentationScopeInfo.getName());
        }
        if (instrumentationScopeInfo.getVersion() != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(KEY_INSTRUMENTATION_SCOPE_VERSION, instrumentationScopeInfo.getVersion());
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(KEY_INSTRUMENTATION_LIBRARY_VERSION, instrumentationScopeInfo.getVersion());
        }
        for (EventData eventData : spanData.getEvents()) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(toEpochMicros(eventData.getEpochNanos()), eventData.getName());
        }
        int totalRecordedEvents = spanData.getTotalRecordedEvents() - spanData.getEvents().size();
        if (totalRecordedEvents > 0) {
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(OTEL_DROPPED_EVENTS_COUNT, String.valueOf(totalRecordedEvents));
        }
        return KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    private Endpoint getEndpoint(SpanData spanData) {
        Attributes attributes = spanData.getResource().getAttributes();
        Endpoint.Builder newBuilder = Endpoint.newBuilder();
        newBuilder.PlaceComponentResult(this.ipAddressSupplier.get());
        String str = (String) attributes.get(ResourceAttributes.SERVICE_NAME);
        if (str == null) {
            str = (String) Resource.getDefault().getAttribute(ResourceAttributes.SERVICE_NAME);
        }
        if (str != null) {
            newBuilder.lookAheadTest = (str == null || str.isEmpty()) ? null : str.toLowerCase(Locale.ROOT);
        }
        return new Endpoint(newBuilder);
    }

    @Nullable
    private static Span.Kind toSpanKind(SpanData spanData) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanData.getKind().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return Span.Kind.CONSUMER;
                }
                return Span.Kind.PRODUCER;
            }
            return Span.Kind.CLIENT;
        }
        return Span.Kind.SERVER;
    }

    private static long toEpochMicros(long j) {
        return TimeUnit.NANOSECONDS.toMicros(j);
    }

    /* renamed from: io.opentelemetry.exporter.zipkin.OtelToZipkinSpanTransformer$1 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$common$AttributeType;
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$trace$SpanKind;

        static {
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$io$opentelemetry$api$common$AttributeType = iArr;
            try {
                iArr[AttributeType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.STRING_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.LONG_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SpanKind.values().length];
            $SwitchMap$io$opentelemetry$api$trace$SpanKind = iArr2;
            try {
                iArr2[SpanKind.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.PRODUCER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CONSUMER.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.INTERNAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static String valueToString(AttributeKey<?> attributeKey, Object obj) {
        AttributeType type = attributeKey.getType();
        switch (AnonymousClass1.$SwitchMap$io$opentelemetry$api$common$AttributeType[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return String.valueOf(obj);
            case 5:
            case 6:
            case 7:
            case 8:
                return commaSeparated((List) obj);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown attribute type: ");
                sb.append(type);
                throw new IllegalStateException(sb.toString());
        }
    }

    private static String commaSeparated(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (sb.length() != 0) {
                sb.append(',');
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
