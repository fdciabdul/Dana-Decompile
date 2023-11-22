package j$.time.temporal;

import j$.time.format.ResolverStyle;
import java.util.HashMap;

/* loaded from: classes2.dex */
public interface TemporalField {
    Temporal adjustInto(Temporal temporal, long j);

    long getFrom(TemporalAccessor temporalAccessor);

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor temporalAccessor);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor);

    TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle);
}
