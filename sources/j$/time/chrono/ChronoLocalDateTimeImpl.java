package j$.time.chrono;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import j$.lang.Iterable;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: classes9.dex */
public final class ChronoLocalDateTimeImpl implements ChronoLocalDateTime, Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    private final transient ChronoLocalDate date;
    private final transient LocalTime time;

    /* renamed from: j$.time.chrono.ChronoLocalDateTimeImpl$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ChronoLocalDateTimeImpl(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        if (chronoLocalDate == null) {
            throw new NullPointerException(MaintenanceBroadcastResult.KEY_DATE);
        }
        if (localTime == null) {
            throw new NullPointerException("time");
        }
        this.date = chronoLocalDate;
        this.time = localTime;
    }

    public static ChronoLocalDateTimeImpl ensureValid(Chronology chronology, Temporal temporal) {
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        AbstractChronology abstractChronology = (AbstractChronology) chronology;
        if (abstractChronology.equals(chronoLocalDateTimeImpl.getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Chronology mismatch, required: ");
        PlaceComponentResult.append(abstractChronology.getId());
        PlaceComponentResult.append(", actual: ");
        PlaceComponentResult.append(chronoLocalDateTimeImpl.getChronology().getId());
        throw new ClassCastException(PlaceComponentResult.toString());
    }

    public static ChronoLocalDateTimeImpl of(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(chronoLocalDate, localTime);
    }

    private ChronoLocalDateTimeImpl plusWithOverflow(ChronoLocalDate chronoLocalDate, long j, long j2, long j3, long j4) {
        LocalTime ofNanoOfDay;
        ChronoLocalDate plus;
        if ((j | j2 | j3 | j4) == 0) {
            ofNanoOfDay = this.time;
            plus = chronoLocalDate;
        } else {
            long j5 = j4 / 86400000000000L;
            long j6 = j3 / TimeUtils.DAY_TO_SECOND;
            long j7 = j2 / TimeUtils.DAY_TO_MIN;
            long j8 = j / 24;
            long nanoOfDay = this.time.toNanoOfDay();
            long j9 = ((j % 24) * 3600000000000L) + ((j2 % TimeUtils.DAY_TO_MIN) * 60000000000L) + ((j3 % TimeUtils.DAY_TO_SECOND) * 1000000000) + (j4 % 86400000000000L) + nanoOfDay;
            long PlaceComponentResult = Iterable.CC.PlaceComponentResult(j9, 86400000000000L);
            long KClassImpl$Data$declaredNonStaticMembers$2 = Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j9, 86400000000000L);
            ofNanoOfDay = KClassImpl$Data$declaredNonStaticMembers$2 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(KClassImpl$Data$declaredNonStaticMembers$2);
            plus = chronoLocalDate.plus(PlaceComponentResult + j8 + j7 + j6 + j5, (TemporalUnit) ChronoUnit.DAYS);
        }
        return with(plus, ofNanoOfDay);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ChronoLocalDateTimeImpl with(Temporal temporal, LocalTime localTime) {
        ChronoLocalDate chronoLocalDate = this.date;
        return (chronoLocalDate == temporal && this.time == localTime) ? this : new ChronoLocalDateTimeImpl(ChronoLocalDateImpl.ensureValid(chronoLocalDate.getChronology(), temporal), localTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final /* synthetic */ Temporal adjustInto(Temporal temporal) {
        Temporal with;
        with = temporal.with(toLocalDate().toEpochDay(), ChronoField.EPOCH_DAY).with(toLocalTime().toNanoOfDay(), ChronoField.NANO_OF_DAY);
        return with;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoZonedDateTime atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(zoneId, null, this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, chronoLocalDateTime);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && Era.CC.BuiltInFictitiousFunctionClassFactory(this, (ChronoLocalDateTime) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public final int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    public final ChronoLocalDateTime minus(long j, TemporalUnit temporalUnit) {
        return ensureValid(getChronology(), Temporal.CC.MyBillsEntityDataFactory(this, j, (ChronoUnit) temporalUnit));
    }

    @Override // j$.time.temporal.Temporal
    public final /* bridge */ /* synthetic */ Temporal minus(long j, ChronoUnit chronoUnit) {
        return minus(j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final ChronoLocalDateTimeImpl plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusWithOverflow(this.date, 0L, 0L, 0L, j);
                case 2:
                    ChronoLocalDateTimeImpl with = with(this.date.plus(j / 86400000000L, (TemporalUnit) ChronoUnit.DAYS), this.time);
                    return with.plusWithOverflow(with.date, 0L, 0L, 0L, (j % 86400000000L) * 1000);
                case 3:
                    ChronoLocalDateTimeImpl with2 = with(this.date.plus(j / 86400000, (TemporalUnit) ChronoUnit.DAYS), this.time);
                    return with2.plusWithOverflow(with2.date, 0L, 0L, 0L, (j % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j);
                case 5:
                    return plusWithOverflow(this.date, 0L, j, 0L, 0L);
                case 6:
                    return plusWithOverflow(this.date, j, 0L, 0L, 0L);
                case 7:
                    ChronoLocalDateTimeImpl with3 = with(this.date.plus(j / 256, (TemporalUnit) ChronoUnit.DAYS), this.time);
                    return with3.plusWithOverflow(with3.date, (j % 256) * 12, 0L, 0L, 0L);
                default:
                    return with(this.date.plus(j, temporalUnit), this.time);
            }
        }
        return ensureValid(this.date.getChronology(), temporalUnit.addTo(this, j));
    }

    public final ChronoLocalDateTimeImpl plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.PlaceComponentResult(this, temporalQuery);
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

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        long j;
        if (temporal != null) {
            ChronoLocalDateTime localDateTime = getChronology().localDateTime(temporal);
            if (!(temporalUnit instanceof ChronoUnit)) {
                if (temporalUnit != null) {
                    return temporalUnit.between(this, localDateTime);
                }
                throw new NullPointerException(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
            } else if (!temporalUnit.isTimeBased()) {
                ChronoLocalDate localDate = localDateTime.toLocalDate();
                if (localDateTime.toLocalTime().compareTo(this.time) < 0) {
                    localDate = localDate.minus(1L, ChronoUnit.DAYS);
                }
                return this.date.until(localDate, temporalUnit);
            } else {
                ChronoField chronoField = ChronoField.EPOCH_DAY;
                long j2 = localDateTime.getLong(chronoField) - this.date.getLong(chronoField);
                switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
                    case 1:
                        j = 86400000000000L;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 2:
                        j = 86400000000L;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 3:
                        j = 86400000;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 4:
                        j = TimeUtils.DAY_TO_SECOND;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 5:
                        j = TimeUtils.DAY_TO_MIN;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 6:
                        j = 24;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    case 7:
                        j = 2;
                        j2 = Iterable.CC.getAuthRequestContext(j2, j);
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                    default:
                        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
                }
            }
        }
        throw new NullPointerException("endExclusive");
    }

    @Override // j$.time.temporal.Temporal
    public final ChronoLocalDateTimeImpl with(long j, TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(j, temporalField)) : with(this.date.with(j, temporalField), this.time) : ensureValid(this.date.getChronology(), temporalField.adjustInto(this, j));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return with(localDate, this.time);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.date);
        objectOutput.writeObject(this.time);
    }
}
