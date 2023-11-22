package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.Period;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;

/* loaded from: classes6.dex */
public interface ChronoLocalDate extends Temporal, TemporalAdjuster, Comparable {
    ChronoLocalDateTime atTime(LocalTime localTime);

    int compareTo(ChronoLocalDate chronoLocalDate);

    boolean equals(Object obj);

    Chronology getChronology();

    Era getEra();

    int hashCode();

    boolean isLeapYear();

    @Override // j$.time.temporal.TemporalAccessor
    boolean isSupported(TemporalField temporalField);

    int lengthOfYear();

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate minus(long j, ChronoUnit chronoUnit);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate plus(long j, TemporalUnit temporalUnit);

    ChronoLocalDate plus(Period period);

    long toEpochDay();

    String toString();

    @Override // j$.time.temporal.Temporal
    long until(Temporal temporal, TemporalUnit temporalUnit);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate with(long j, TemporalField temporalField);

    ChronoLocalDate with(TemporalAdjuster temporalAdjuster);
}
