package io.opentelemetry.sdk.metrics.internal.exemplar;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableDoubleExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongExemplarData;
import j$.util.function.Predicate;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
class ReservoirCell {
    @Nullable
    private Attributes attributes;
    private final Clock clock;
    private double doubleValue;
    private long longValue;
    private long recordTime;
    private SpanContext spanContext = SpanContext.CC.getInvalid();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReservoirCell(Clock clock) {
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordLongMeasurement(long j, Attributes attributes, Context context) {
        synchronized (this) {
            this.longValue = j;
            offerMeasurement(attributes, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recordDoubleMeasurement(double d, Attributes attributes, Context context) {
        synchronized (this) {
            this.doubleValue = d;
            offerMeasurement(attributes, context);
        }
    }

    private void offerMeasurement(Attributes attributes, Context context) {
        this.attributes = attributes;
        this.recordTime = this.clock.now();
        Span fromContext = Span.CC.fromContext(context);
        if (fromContext.getSpanContext().isValid()) {
            this.spanContext = fromContext.getSpanContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public LongExemplarData getAndResetLong(Attributes attributes) {
        synchronized (this) {
            Attributes attributes2 = this.attributes;
            if (attributes2 == null) {
                return null;
            }
            LongExemplarData create = ImmutableLongExemplarData.create(filtered(attributes2, attributes), this.recordTime, this.spanContext, this.longValue);
            reset();
            return create;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public DoubleExemplarData getAndResetDouble(Attributes attributes) {
        synchronized (this) {
            Attributes attributes2 = this.attributes;
            if (attributes2 == null) {
                return null;
            }
            DoubleExemplarData create = ImmutableDoubleExemplarData.create(filtered(attributes2, attributes), this.recordTime, this.spanContext, this.doubleValue);
            reset();
            return create;
        }
    }

    void reset() {
        synchronized (this) {
            this.attributes = null;
            this.longValue = 0L;
            this.doubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.spanContext = SpanContext.CC.getInvalid();
            this.recordTime = 0L;
        }
    }

    private static Attributes filtered(Attributes attributes, Attributes attributes2) {
        if (attributes2.isEmpty()) {
            return attributes;
        }
        final Set<AttributeKey<?>> keySet = attributes2.asMap().keySet();
        AttributesBuilder builder = attributes.toBuilder();
        Objects.requireNonNull(keySet);
        return builder.removeIf(new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCell$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return keySet.contains((AttributeKey) obj);
            }
        }).build();
    }
}
