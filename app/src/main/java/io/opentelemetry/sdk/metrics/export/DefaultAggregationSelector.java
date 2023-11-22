package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes.dex */
public interface DefaultAggregationSelector {
    Aggregation getDefaultAggregation(InstrumentType instrumentType);

    DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation);

    /* renamed from: io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static DefaultAggregationSelector getDefault() {
            return new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
                public final Aggregation getDefaultAggregation(InstrumentType instrumentType) {
                    Aggregation defaultAggregation;
                    defaultAggregation = Aggregation.CC.defaultAggregation();
                    return defaultAggregation;
                }

                @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
                public final /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType, Aggregation aggregation) {
                    return DefaultAggregationSelector.CC.$default$with(this, instrumentType, aggregation);
                }
            };
        }

        public static DefaultAggregationSelector $default$with(final DefaultAggregationSelector defaultAggregationSelector, final InstrumentType instrumentType, final Aggregation aggregation) {
            Objects.requireNonNull(instrumentType, "instrumentType");
            Objects.requireNonNull(aggregation, "aggregation");
            return new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
                public final Aggregation getDefaultAggregation(InstrumentType instrumentType2) {
                    return DefaultAggregationSelector.CC.$private$lambda$with$1(DefaultAggregationSelector.this, instrumentType, aggregation, instrumentType2);
                }

                @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
                public final /* synthetic */ DefaultAggregationSelector with(InstrumentType instrumentType2, Aggregation aggregation2) {
                    return DefaultAggregationSelector.CC.$default$with(this, instrumentType2, aggregation2);
                }
            };
        }

        public static /* synthetic */ Aggregation $private$lambda$with$1(DefaultAggregationSelector defaultAggregationSelector, InstrumentType instrumentType, Aggregation aggregation, InstrumentType instrumentType2) {
            return instrumentType2 == instrumentType ? aggregation : defaultAggregationSelector.getDefaultAggregation(instrumentType2);
        }
    }
}
