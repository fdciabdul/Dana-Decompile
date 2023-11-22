package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.internal.view.ExponentialHistogramAggregation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AggregationUtil {
    private static final String AGGREGATION_DEFAULT = "default";
    private static final String AGGREGATION_DROP = "drop";
    private static final String AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM = "explicit_bucket_histogram";
    private static final String AGGREGATION_EXPONENTIAL_HISTOGRAM = "exponential_bucket_histogram";
    private static final String AGGREGATION_LAST_VALUE = "last_value";
    private static final String AGGREGATION_SUM = "sum";
    private static final Map<String, Aggregation> aggregationByName;
    private static final Map<Class<? extends Aggregation>, String> nameByAggregation;

    static {
        HashMap hashMap = new HashMap();
        aggregationByName = hashMap;
        hashMap.put("default", Aggregation.CC.defaultAggregation());
        hashMap.put(AGGREGATION_SUM, Aggregation.CC.sum());
        hashMap.put(AGGREGATION_LAST_VALUE, Aggregation.CC.lastValue());
        hashMap.put(AGGREGATION_DROP, Aggregation.CC.drop());
        hashMap.put(AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM, Aggregation.CC.explicitBucketHistogram());
        hashMap.put(AGGREGATION_EXPONENTIAL_HISTOGRAM, ExponentialHistogramAggregation.getDefault());
        HashMap hashMap2 = new HashMap();
        nameByAggregation = hashMap2;
        hashMap2.put(Aggregation.CC.defaultAggregation().getClass(), "default");
        hashMap2.put(Aggregation.CC.sum().getClass(), AGGREGATION_SUM);
        hashMap2.put(Aggregation.CC.lastValue().getClass(), AGGREGATION_LAST_VALUE);
        hashMap2.put(Aggregation.CC.drop().getClass(), AGGREGATION_DROP);
        hashMap2.put(Aggregation.CC.explicitBucketHistogram().getClass(), AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM);
        hashMap2.put(ExponentialHistogramAggregation.getDefault().getClass(), AGGREGATION_EXPONENTIAL_HISTOGRAM);
    }

    private AggregationUtil() {
    }

    public static Aggregation forName(String str) {
        Aggregation aggregation = aggregationByName.get(str.toLowerCase());
        if (aggregation != null) {
            return aggregation;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized aggregation name ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String aggregationName(Aggregation aggregation) {
        String str = nameByAggregation.get(aggregation.getClass());
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized aggregation ");
        sb.append(aggregation.getClass().getName());
        throw new IllegalStateException(sb.toString());
    }
}
