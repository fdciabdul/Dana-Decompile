package j$.time.chrono;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import j$.lang.Iterable;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.Period;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.Serializable;

/* loaded from: classes9.dex */
public abstract class ChronoLocalDateImpl implements ChronoLocalDate, Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    /* renamed from: j$.time.chrono.ChronoLocalDateImpl$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ChronoLocalDate ensureValid(Chronology chronology, Temporal temporal) {
        ChronoLocalDate chronoLocalDate = (ChronoLocalDate) temporal;
        AbstractChronology abstractChronology = (AbstractChronology) chronology;
        if (abstractChronology.equals(chronoLocalDate.getChronology())) {
            return chronoLocalDate;
        }
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Chronology mismatch, expected: ");
        PlaceComponentResult.append(abstractChronology.getId());
        PlaceComponentResult.append(", actual: ");
        PlaceComponentResult.append(chronoLocalDate.getChronology().getId());
        throw new ClassCastException(PlaceComponentResult.toString());
    }

    private long monthsUntil(ChronoLocalDate chronoLocalDate) {
        if (getChronology().range(ChronoField.MONTH_OF_YEAR).getMaximum() == 12) {
            ChronoField chronoField = ChronoField.PROLEPTIC_MONTH;
            long j = getLong(chronoField);
            ChronoField chronoField2 = ChronoField.DAY_OF_MONTH;
            return (((chronoLocalDate.getLong(chronoField) * 32) + chronoLocalDate.get(chronoField2)) - ((j * 32) + Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, chronoField2))) / 32;
        }
        throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final /* synthetic */ Temporal adjustInto(Temporal temporal) {
        return Era.CC.getAuthRequestContext(this, temporal);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public ChronoLocalDateTime atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoLocalDate chronoLocalDate) {
        return Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, chronoLocalDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (ChronoLocalDate) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int get(TemporalField temporalField) {
        return Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int hashCode() {
        long epochDay = toEpochDay();
        return ((AbstractChronology) getChronology()).hashCode() ^ ((int) (epochDay ^ (epochDay >>> 32)));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.TemporalAccessor
    public /* synthetic */ boolean isSupported(TemporalField temporalField) {
        return Era.CC.PlaceComponentResult(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate minus(long j, ChronoUnit chronoUnit) {
        return ensureValid(getChronology(), Temporal.CC.MyBillsEntityDataFactory(this, j, chronoUnit));
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        boolean z = temporalUnit instanceof ChronoUnit;
        if (!z) {
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported unit: ");
                sb.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(sb.toString());
            }
            return ensureValid(getChronology(), temporalUnit.addTo(this, j));
        }
        switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j);
            case 2:
                return plusDays(Iterable.CC.getAuthRequestContext(j, 7L));
            case 3:
                return plusMonths(j);
            case 4:
                return plusYears(j);
            case 5:
                return plusYears(Iterable.CC.getAuthRequestContext(j, 10L));
            case 6:
                return plusYears(Iterable.CC.getAuthRequestContext(j, 100L));
            case 7:
                return plusYears(Iterable.CC.getAuthRequestContext(j, 1000L));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return with(Iterable.CC.BuiltInFictitiousFunctionClassFactory(getLong(chronoField), j), (TemporalField) chronoField);
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unsupported unit: ");
                sb2.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(sb2.toString());
        }
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public ChronoLocalDate plus(Period period) {
        return ensureValid(getChronology(), period.addTo(this));
    }

    abstract ChronoLocalDate plusDays(long j);

    abstract ChronoLocalDate plusMonths(long j);

    abstract ChronoLocalDate plusYears(long j);

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public /* synthetic */ ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public String toString() {
        long j = getLong(ChronoField.YEAR_OF_ERA);
        long j2 = getLong(ChronoField.MONTH_OF_YEAR);
        long j3 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(((AbstractChronology) getChronology()).getId());
        sb.append(" ");
        sb.append(getEra());
        sb.append(" ");
        sb.append(j);
        sb.append(j2 < 10 ? "-0" : "-");
        sb.append(j2);
        sb.append(j3 < 10 ? "-0" : "-");
        sb.append(j3);
        return sb.toString();
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long epochDay;
        long j;
        if (temporal != null) {
            ChronoLocalDate date = getChronology().date(temporal);
            if (!(temporalUnit instanceof ChronoUnit)) {
                if (temporalUnit != null) {
                    return temporalUnit.between(this, date);
                }
                throw new NullPointerException(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
            }
            switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return date.toEpochDay() - toEpochDay();
                case 2:
                    epochDay = date.toEpochDay() - toEpochDay();
                    j = 7;
                    break;
                case 3:
                    return monthsUntil(date);
                case 4:
                    epochDay = monthsUntil(date);
                    j = 12;
                    break;
                case 5:
                    epochDay = monthsUntil(date);
                    j = 120;
                    break;
                case 6:
                    epochDay = monthsUntil(date);
                    j = 1200;
                    break;
                case 7:
                    epochDay = monthsUntil(date);
                    j = 12000;
                    break;
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return date.getLong(chronoField) - getLong(chronoField);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
            return epochDay / j;
        }
        throw new NullPointerException("endExclusive");
    }

    @Override // j$.time.temporal.Temporal
    public ChronoLocalDate with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return ensureValid(getChronology(), temporalField.adjustInto(this, j));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return ensureValid(getChronology(), temporalAdjuster.adjustInto(this));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public /* bridge */ /* synthetic */ Temporal mo3168with(LocalDate localDate) {
        return with((TemporalAdjuster) localDate);
    }
}
