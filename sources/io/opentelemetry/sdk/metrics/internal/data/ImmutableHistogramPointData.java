package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.internal.PrimitiveLongList;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public abstract class ImmutableHistogramPointData implements HistogramPointData {
    public static ImmutableHistogramPointData create(long j, long j2, Attributes attributes, double d, @Nullable Double d2, @Nullable Double d3, List<Double> list, List<Long> list2) {
        return create(j, j2, attributes, d, d2, d3, list, list2, Collections.emptyList());
    }

    public static ImmutableHistogramPointData create(long j, long j2, Attributes attributes, double d, @Nullable Double d2, @Nullable Double d3, List<Double> list, List<Long> list2, List<DoubleExemplarData> list3) {
        if (list2.size() != list.size() + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("invalid counts: size should be ");
            sb.append(list.size() + 1);
            sb.append(" instead of ");
            sb.append(list2.size());
            throw new IllegalArgumentException(sb.toString());
        } else if (!isStrictlyIncreasing(list)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid boundaries: ");
            sb2.append(list);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!list.isEmpty() && (list.get(0).isInfinite() || list.get(list.size() - 1).isInfinite())) {
            throw new IllegalArgumentException("invalid boundaries: contains explicit +/-Inf");
        } else {
            long j3 = 0;
            for (long j4 : PrimitiveLongList.toArray(list2)) {
                j3 += j4;
            }
            return new AutoValue_ImmutableHistogramPointData(j, j2, attributes, d, j3, d2 != null, d2 != null ? d2.doubleValue() : -1.0d, d3 != null, d3 != null ? d3.doubleValue() : -1.0d, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)), list3);
        }
    }

    private static boolean isStrictlyIncreasing(List<Double> list) {
        int i = 0;
        while (i < list.size() - 1) {
            Double d = list.get(i);
            i++;
            if (d.compareTo(list.get(i)) >= 0) {
                return false;
            }
        }
        return true;
    }
}
