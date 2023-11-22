package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes6.dex */
public interface Chronology extends Comparable {
    ChronoLocalDate date(int i, int i2, int i3);

    ChronoLocalDate date(TemporalAccessor temporalAccessor);

    ChronoLocalDate dateEpochDay(long j);

    ChronoLocalDate dateYearDay(int i, int i2);

    Era eraOf(int i);

    List eras();

    String getCalendarType();

    String getId();

    boolean isLeapYear(long j);

    ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor);

    int prolepticYear(Era era, int i);

    ValueRange range(ChronoField chronoField);

    ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle);

    ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId);

    ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor);
}
