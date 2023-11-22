package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;

/* loaded from: classes6.dex */
public interface ChronoLocalDateTime extends Temporal, TemporalAdjuster, Comparable {
    ChronoZonedDateTime atZone(ZoneId zoneId);

    int compareTo(ChronoLocalDateTime chronoLocalDateTime);

    Chronology getChronology();

    long toEpochSecond(ZoneOffset zoneOffset);

    ChronoLocalDate toLocalDate();

    LocalTime toLocalTime();
}
