package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.view.DefaultAggregation;
import io.opentelemetry.sdk.metrics.internal.view.DropAggregation;
import io.opentelemetry.sdk.metrics.internal.view.ExplicitBucketHistogramAggregation;
import io.opentelemetry.sdk.metrics.internal.view.LastValueAggregation;
import io.opentelemetry.sdk.metrics.internal.view.SumAggregation;
import java.util.List;

/* loaded from: classes2.dex */
public interface Aggregation {

    /* renamed from: io.opentelemetry.sdk.metrics.Aggregation$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static Aggregation drop() {
            return DropAggregation.getInstance();
        }

        public static Aggregation defaultAggregation() {
            return DefaultAggregation.getInstance();
        }

        public static Aggregation sum() {
            return SumAggregation.getInstance();
        }

        public static Aggregation lastValue() {
            return LastValueAggregation.getInstance();
        }

        public static Aggregation explicitBucketHistogram() {
            return ExplicitBucketHistogramAggregation.getDefault();
        }

        public static Aggregation explicitBucketHistogram(List<Double> list) {
            return ExplicitBucketHistogramAggregation.create(list);
        }
    }
}
