package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector;

@FunctionalInterface
/* loaded from: classes.dex */
public interface AggregationTemporalitySelector {
    AggregationTemporality getAggregationTemporality(InstrumentType instrumentType);

    /* renamed from: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static AggregationTemporalitySelector alwaysCumulative() {
            return new AggregationTemporalitySelector() { // from class: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
                public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
                    AggregationTemporality aggregationTemporality;
                    aggregationTemporality = AggregationTemporality.CUMULATIVE;
                    return aggregationTemporality;
                }
            };
        }

        public static AggregationTemporalitySelector deltaPreferred() {
            return new AggregationTemporalitySelector() { // from class: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
                public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
                    return AggregationTemporalitySelector.CC.lambda$deltaPreferred$1(instrumentType);
                }
            };
        }

        public static /* synthetic */ AggregationTemporality lambda$deltaPreferred$1(InstrumentType instrumentType) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[instrumentType.ordinal()];
            if (i == 1 || i == 2) {
                return AggregationTemporality.CUMULATIVE;
            }
            return AggregationTemporality.DELTA;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType;

        static {
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
