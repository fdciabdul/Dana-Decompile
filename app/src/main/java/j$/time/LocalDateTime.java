package j$.time;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import j$.lang.Iterable;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.Chronology;
import j$.time.chrono.Era;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public final class LocalDateTime implements Temporal, TemporalAdjuster, ChronoLocalDateTime, Serializable {
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);

    /* renamed from: j$.time.LocalDateTime$1 */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.date);
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.time) : compareTo0;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            sb.append(temporalAccessor);
            sb.append(" of type ");
            sb.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(sb.toString(), e);
        }
    }

    public static LocalDateTime now() {
        Clock systemDefaultZone = Clock.systemDefaultZone();
        Instant instant = systemDefaultZone.instant();
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), systemDefaultZone.getZone().getRules().getOffset(instant));
    }

    public static LocalDateTime of(int i) {
        return new LocalDateTime(LocalDate.of(i, 12, 31), LocalTime.of(0));
    }

    public static LocalDateTime of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new LocalDateTime(LocalDate.of(i, i2, i3), LocalTime.of(i4, i5, i6, 0));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        if (localDate != null) {
            if (localTime != null) {
                return new LocalDateTime(localDate, localTime);
            }
            throw new NullPointerException("time");
        }
        throw new NullPointerException(MaintenanceBroadcastResult.KEY_DATE);
    }

    public static LocalDateTime ofEpochSecond(long j, int i, ZoneOffset zoneOffset) {
        if (zoneOffset != null) {
            long j2 = i;
            ChronoField.NANO_OF_SECOND.checkValidValue(j2);
            return new LocalDateTime(LocalDate.ofEpochDay(Iterable.CC.PlaceComponentResult(j + zoneOffset.getTotalSeconds(), TimeUtils.DAY_TO_SECOND)), LocalTime.ofNanoOfDay((((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(r7, TimeUtils.DAY_TO_SECOND)) * 1000000000) + j2));
        }
        throw new NullPointerException("offset");
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return (LocalDateTime) dateTimeFormatter.MyBillsEntityDataFactory(charSequence, new LocalDateTime$$ExternalSyntheticLambda6());
        }
        throw new NullPointerException("formatter");
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j, long j2, long j3, long j4) {
        LocalTime ofNanoOfDay;
        LocalDate plusDays;
        if ((j | j2 | j3 | j4) == 0) {
            ofNanoOfDay = this.time;
            plusDays = localDate;
        } else {
            long j5 = j4 / 86400000000000L;
            long j6 = j3 / TimeUtils.DAY_TO_SECOND;
            long j7 = j2 / TimeUtils.DAY_TO_MIN;
            long j8 = j / 24;
            long nanoOfDay = this.time.toNanoOfDay();
            long j9 = ((((j % 24) * 3600000000000L) + ((j2 % TimeUtils.DAY_TO_MIN) * 60000000000L) + ((j3 % TimeUtils.DAY_TO_SECOND) * 1000000000) + (j4 % 86400000000000L)) * 1) + nanoOfDay;
            long PlaceComponentResult = Iterable.CC.PlaceComponentResult(j9, 86400000000000L);
            long KClassImpl$Data$declaredNonStaticMembers$2 = Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j9, 86400000000000L);
            ofNanoOfDay = KClassImpl$Data$declaredNonStaticMembers$2 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(KClassImpl$Data$declaredNonStaticMembers$2);
            plusDays = localDate.plusDays(PlaceComponentResult + ((j8 + j7 + j6 + j5) * 1));
        }
        return with(plusDays, ofNanoOfDay);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        Temporal with;
        with = temporal.with(toLocalDate().toEpochDay(), ChronoField.EPOCH_DAY).with(toLocalTime().toNanoOfDay(), ChronoField.NANO_OF_DAY);
        return with;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofLocal(this, zoneId, null);
    }

    @Override // java.lang.Comparable
    public final int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) : Era.CC.BuiltInFictitiousFunctionClassFactory(this, chronoLocalDateTime);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
        }
        return false;
    }

    public final String format(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return dateTimeFormatter.MyBillsEntityDataFactory(this);
        }
        throw new NullPointerException("formatter");
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final Chronology getChronology() {
        return ((LocalDate) toLocalDate()).getChronology();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public final int getNano() {
        return this.time.getNano();
    }

    public final int getSecond() {
        return this.time.getSecond();
    }

    public final int getYear() {
        return this.date.getYear();
    }

    public final int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public final boolean isAfter(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return compareTo0(localDateTime) > 0;
        }
        long epochDay = this.date.toEpochDay();
        long epochDay2 = localDateTime.date.toEpochDay();
        return epochDay > epochDay2 || (epochDay == epochDay2 && this.time.toNanoOfDay() > localDateTime.time.toNanoOfDay());
    }

    public final boolean isBefore(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return compareTo0(localDateTime) < 0;
        }
        long epochDay = this.date.toEpochDay();
        long epochDay2 = localDateTime.date.toEpochDay();
        return epochDay < epochDay2 || (epochDay == epochDay2 && this.time.toNanoOfDay() < localDateTime.time.toNanoOfDay());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final LocalDateTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusWithOverflow(this.date, 0L, 0L, 0L, j);
                case 2:
                    LocalDateTime plusDays = plusDays(j / 86400000000L);
                    return plusDays.plusWithOverflow(plusDays.date, 0L, 0L, 0L, (j % 86400000000L) * 1000);
                case 3:
                    LocalDateTime plusDays2 = plusDays(j / 86400000);
                    return plusDays2.plusWithOverflow(plusDays2.date, 0L, 0L, 0L, (j % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j);
                case 5:
                    return plusWithOverflow(this.date, 0L, j, 0L, 0L);
                case 6:
                    return plusWithOverflow(this.date, j, 0L, 0L, 0L);
                case 7:
                    LocalDateTime plusDays3 = plusDays(j / 256);
                    return plusDays3.plusWithOverflow(plusDays3.date, (j % 256) * 12, 0L, 0L, 0L);
                default:
                    return with(this.date.plus(j, temporalUnit), this.time);
            }
        }
        return (LocalDateTime) temporalUnit.addTo(this, j);
    }

    public final LocalDateTime plusDays(long j) {
        return with(this.date.plusDays(j), this.time);
    }

    public final LocalDateTime plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.PlaceComponentResult() ? this.date : Era.CC.PlaceComponentResult(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? Temporal.CC.MyBillsEntityDataFactory(this.time, temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final /* synthetic */ long toEpochSecond(ZoneOffset zoneOffset) {
        return Era.CC.getAuthRequestContext(this, zoneOffset);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final LocalDate toLocalDate() {
        return this.date;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoLocalDate toLocalDate() {
        return this.date;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final LocalTime toLocalTime() {
        return this.time;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.date.toString());
        sb.append('T');
        sb.append(this.time.toString());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x00ed, code lost:
    
        if ((r12.time.compareTo(r11.time) > 0) != false) goto L157;
     */
    @Override // j$.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long until(j$.time.temporal.Temporal r12, j$.time.temporal.TemporalUnit r13) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.LocalDateTime.until(j$.time.temporal.Temporal, j$.time.temporal.TemporalUnit):long");
    }

    @Override // j$.time.temporal.Temporal
    public final LocalDateTime with(long j, TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(j, temporalField)) : with(this.date.with(j, temporalField), this.time) : (LocalDateTime) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final LocalDateTime mo3168with(LocalDate localDate) {
        return with(localDate, this.time);
    }

    public final void writeExternal(DataOutput dataOutput) {
        this.date.writeExternal(dataOutput);
        this.time.writeExternal(dataOutput);
    }
}
