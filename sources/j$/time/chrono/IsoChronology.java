package j$.time.chrono;

import j$.lang.Iterable;
import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.Month;
import j$.time.Year;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes6.dex */
public final class IsoChronology extends AbstractChronology implements Serializable {
    public static final IsoChronology INSTANCE = new IsoChronology();
    private static final long serialVersionUID = -1440403870442975015L;

    private IsoChronology() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(int i, int i2, int i3) {
        return LocalDate.of(i, i2, i3);
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        return LocalDate.from(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateEpochDay(long j) {
        return LocalDate.ofEpochDay(j);
    }

    @Override // j$.time.chrono.AbstractChronology
    public final ChronoLocalDate dateNow() {
        return LocalDate.from(LocalDate.now(Clock.systemDefaultZone()));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateYearDay(int i, int i2) {
        return LocalDate.ofYearDay(i, i2);
    }

    @Override // j$.time.chrono.Chronology
    public final Era eraOf(int i) {
        if (i != 0) {
            if (i == 1) {
                return IsoEra.CE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid era: ");
            sb.append(i);
            throw new DateTimeException(sb.toString());
        }
        return IsoEra.BCE;
    }

    @Override // j$.time.chrono.Chronology
    public final List eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // j$.time.chrono.Chronology
    public final String getCalendarType() {
        return "iso8601";
    }

    @Override // j$.time.chrono.Chronology
    public final String getId() {
        return "ISO";
    }

    @Override // j$.time.chrono.Chronology
    public final boolean isLeapYear(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public final int prolepticYear(Era era, int i) {
        if (era instanceof IsoEra) {
            return era != IsoEra.CE ? 1 - i : i;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.Chronology
    public final ValueRange range(ChronoField chronoField) {
        return chronoField.range();
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle) {
        return (LocalDate) super.resolveDate(hashMap, resolverStyle);
    }

    @Override // j$.time.chrono.AbstractChronology
    final void resolveProlepticMonth(HashMap hashMap, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.PROLEPTIC_MONTH;
        Long l = (Long) hashMap.remove(chronoField);
        if (l != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField.checkValidValue(l.longValue());
            }
            AbstractChronology.addFieldValue(hashMap, ChronoField.MONTH_OF_YEAR, ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(l.longValue(), 12L)) + 1);
            AbstractChronology.addFieldValue(hashMap, ChronoField.YEAR, Iterable.CC.PlaceComponentResult(l.longValue(), 12L));
        }
    }

    @Override // j$.time.chrono.AbstractChronology
    final ChronoLocalDate resolveYMD(HashMap hashMap, ResolverStyle resolverStyle) {
        int i;
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = chronoField.checkValidIntValue(((Long) hashMap.remove(chronoField)).longValue());
        boolean z = true;
        if (resolverStyle == ResolverStyle.LENIENT) {
            return LocalDate.of(checkValidIntValue, 1, 1).plusMonths(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L)).plusDays(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(ChronoField.DAY_OF_MONTH)).longValue(), 1L));
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = chronoField2.checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue());
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue3 = chronoField3.checkValidIntValue(((Long) hashMap.remove(chronoField3)).longValue());
        if (resolverStyle == ResolverStyle.SMART) {
            if (checkValidIntValue2 == 4 || checkValidIntValue2 == 6 || checkValidIntValue2 == 9 || checkValidIntValue2 == 11) {
                i = 30;
            } else if (checkValidIntValue2 == 2) {
                Month month = Month.FEBRUARY;
                long j = checkValidIntValue;
                int i2 = Year.$r8$clinit;
                if ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) {
                    z = false;
                }
                i = month.length(z);
            }
            checkValidIntValue3 = Math.min(checkValidIntValue3, i);
        }
        return LocalDate.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x003b, code lost:
    
        if (r7 > 0) goto L63;
     */
    @Override // j$.time.chrono.AbstractChronology
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final j$.time.chrono.ChronoLocalDate resolveYearOfEra(java.util.HashMap r10, j$.time.format.ResolverStyle r11) {
        /*
            r9 = this;
            j$.time.temporal.ChronoField r0 = j$.time.temporal.ChronoField.YEAR_OF_ERA
            java.lang.Object r1 = r10.remove(r0)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L99
            j$.time.format.ResolverStyle r2 = j$.time.format.ResolverStyle.LENIENT
            if (r11 == r2) goto L15
            long r2 = r1.longValue()
            r0.checkValidValue(r2)
        L15:
            j$.time.temporal.ChronoField r2 = j$.time.temporal.ChronoField.ERA
            java.lang.Object r2 = r10.remove(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r3 = 0
            r5 = 1
            if (r2 != 0) goto L5d
            j$.time.temporal.ChronoField r2 = j$.time.temporal.ChronoField.YEAR
            java.lang.Object r7 = r10.get(r2)
            java.lang.Long r7 = (java.lang.Long) r7
            j$.time.format.ResolverStyle r8 = j$.time.format.ResolverStyle.STRICT
            if (r11 != r8) goto L42
            if (r7 == 0) goto L3e
            long r7 = r7.longValue()
            long r0 = r1.longValue()
            int r11 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r11 <= 0) goto L50
            goto L59
        L3e:
            r10.put(r0, r1)
            goto Lae
        L42:
            if (r7 == 0) goto L55
            long r7 = r7.longValue()
            int r11 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r11 > 0) goto L55
            long r0 = r1.longValue()
        L50:
            long r0 = j$.lang.Iterable.CC.MyBillsEntityDataFactory(r5, r0)
            goto L59
        L55:
            long r0 = r1.longValue()
        L59:
            j$.time.chrono.AbstractChronology.addFieldValue(r10, r2, r0)
            goto Lae
        L5d:
            long r7 = r2.longValue()
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L6c
            j$.time.temporal.ChronoField r11 = j$.time.temporal.ChronoField.YEAR
            long r0 = r1.longValue()
            goto L7e
        L6c:
            long r7 = r2.longValue()
            int r11 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r11 != 0) goto L82
            j$.time.temporal.ChronoField r11 = j$.time.temporal.ChronoField.YEAR
            long r0 = r1.longValue()
            long r0 = j$.lang.Iterable.CC.MyBillsEntityDataFactory(r5, r0)
        L7e:
            j$.time.chrono.AbstractChronology.addFieldValue(r10, r11, r0)
            goto Lae
        L82:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Invalid value for era: "
            r10.append(r11)
            r10.append(r2)
            j$.time.DateTimeException r11 = new j$.time.DateTimeException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        L99:
            j$.time.temporal.ChronoField r11 = j$.time.temporal.ChronoField.ERA
            boolean r0 = r10.containsKey(r11)
            if (r0 == 0) goto Lae
            java.lang.Object r10 = r10.get(r11)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            r11.checkValidValue(r0)
        Lae:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.IsoChronology.resolveYearOfEra(java.util.HashMap, j$.time.format.ResolverStyle):j$.time.chrono.ChronoLocalDate");
    }

    final Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(instant, zoneId);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return ZonedDateTime.from(temporalAccessor);
    }
}
