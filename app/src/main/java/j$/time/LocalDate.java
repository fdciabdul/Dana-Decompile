package j$.time;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import j$.lang.Iterable;
import j$.time.Clock;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.Chronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.chrono.IsoEra;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public final class LocalDate implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(-999999999, 1, 1);
    public static final LocalDate MAX = of(999999999, 12, 31);

    /* renamed from: j$.time.LocalDate$1 */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                PlaceComponentResult[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                PlaceComponentResult[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                PlaceComponentResult[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            MyBillsEntityDataFactory = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (short) i2;
        this.day = (short) i3;
    }

    private static LocalDate create(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (IsoChronology.INSTANCE.isLeapYear(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid date 'February 29' as '");
                    sb.append(i);
                    sb.append("' is not a leap year");
                    throw new DateTimeException(sb.toString());
                }
                StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Invalid date '");
                PlaceComponentResult.append(Month.of(i2).name());
                PlaceComponentResult.append(" ");
                PlaceComponentResult.append(i3);
                PlaceComponentResult.append("'");
                throw new DateTimeException(PlaceComponentResult.toString());
            }
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor != null) {
            LocalDate localDate = (LocalDate) temporalAccessor.query(Temporal.CC.PlaceComponentResult());
            if (localDate != null) {
                return localDate;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain LocalDate from TemporalAccessor: ");
            sb.append(temporalAccessor);
            sb.append(" of type ");
            sb.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(sb.toString());
        }
        throw new NullPointerException("temporal");
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i = this.year;
                return i <= 0 ? 1 - i : i;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new UnsupportedTemporalTypeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new UnsupportedTemporalTypeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.year;
            case 13:
                return this.year <= 0 ? 0 : 1;
            default:
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
    }

    private long getProlepticMonth() {
        return ((this.year * 12) + this.month) - 1;
    }

    private long monthsUntil(LocalDate localDate) {
        long prolepticMonth = getProlepticMonth();
        return (((localDate.getProlepticMonth() * 32) + localDate.day) - ((prolepticMonth * 32) + this.day)) / 32;
    }

    public static LocalDate now(Clock clock) {
        return ofEpochDay(Iterable.CC.PlaceComponentResult(clock.instant().getEpochSecond() + clock.getZone().getRules().getOffset(r0).getTotalSeconds(), TimeUtils.DAY_TO_SECOND));
    }

    public static LocalDate now(ZoneId zoneId) {
        if (zoneId != null) {
            return now(new Clock.SystemClock(zoneId));
        }
        throw new NullPointerException("zone");
    }

    public static LocalDate of(int i, int i2, int i3) {
        ChronoField.YEAR.checkValidValue(i);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
        ChronoField.DAY_OF_MONTH.checkValidValue(i3);
        return create(i, i2, i3);
    }

    public static LocalDate of(int i, Month month, int i2) {
        ChronoField.YEAR.checkValidValue(i);
        if (month != null) {
            ChronoField.DAY_OF_MONTH.checkValidValue(i2);
            return create(i, month.getValue(), i2);
        }
        throw new NullPointerException("month");
    }

    public static LocalDate ofEpochDay(long j) {
        long j2;
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j5 + j2 + (i2 / 10)), ((i2 + 2) % 12) + 1, (i - (((i2 * SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i, int i2) {
        long j = i;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.DAY_OF_YEAR.checkValidValue(i2);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j);
        if (i2 == 366 && !isLeapYear) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid date 'DayOfYear 366' as '");
            sb.append(i);
            sb.append("' is not a leap year");
            throw new DateTimeException(sb.toString());
        }
        Month of = Month.of(((i2 - 1) / 31) + 1);
        if (i2 > (of.length(isLeapYear) + of.firstDayOfYear(isLeapYear)) - 1) {
            of = of.plus();
        }
        return new LocalDate(i, of.getValue(), (i2 - of.firstDayOfYear(isLeapYear)) + 1);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i, int i2, int i3) {
        int i4;
        if (i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
                i4 = 30;
            }
            return new LocalDate(i, i2, i3);
        }
        i4 = IsoChronology.INSTANCE.isLeapYear((long) i) ? 29 : 28;
        i3 = Math.min(i3, i4);
        return new LocalDate(i, i2, i3);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return Era.CC.getAuthRequestContext(this, temporal);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // java.lang.Comparable
    public final int compareTo(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) : Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, chronoLocalDate);
    }

    public final int compareTo0(LocalDate localDate) {
        int i = this.year - localDate.year;
        if (i == 0) {
            int i2 = this.month - localDate.month;
            return i2 == 0 ? this.day - localDate.day : i2;
        }
        return i;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final Chronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public final DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(toEpochDay() + 3, 7L)) + 1);
    }

    public final int getDayOfYear() {
        return (Month.of(this.month).firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final Era getEra() {
        return this.year > 0 ? IsoEra.CE : IsoEra.BCE;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.EPOCH_DAY ? toEpochDay() : temporalField == ChronoField.PROLEPTIC_MONTH ? getProlepticMonth() : get0(temporalField) : temporalField.getFrom(this);
    }

    public final int getMonthValue() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        int i = this.year;
        return (i & (-2048)) ^ (((i << 11) + (this.month << 6)) + this.day);
    }

    public final boolean isBefore(LocalDate localDate) {
        return localDate instanceof LocalDate ? compareTo0(localDate) < 0 : toEpochDay() < localDate.toEpochDay();
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return Era.CC.PlaceComponentResult(this, temporalField);
    }

    public final int lengthOfMonth() {
        short s = this.month;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // j$.time.temporal.Temporal
    public final LocalDate minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final LocalDate plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.PlaceComponentResult[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j);
                case 2:
                    return plusWeeks(j);
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
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
        }
        return (LocalDate) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate plus(Period period) {
        if (period instanceof Period) {
            return plusMonths(period.toTotalMonths()).plusDays(period.getDays());
        }
        if (period != null) {
            return (LocalDate) period.addTo(this);
        }
        throw new NullPointerException("amountToAdd");
    }

    public final LocalDate plusDays(long j) {
        return j == 0 ? this : ofEpochDay(Iterable.CC.BuiltInFictitiousFunctionClassFactory(toEpochDay(), j));
    }

    public final LocalDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.year * 12) + ((long) (this.month - 1)) + j;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Iterable.CC.PlaceComponentResult(j2, 12L)), ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j2, 12L)) + 1, this.day);
    }

    public final LocalDate plusWeeks(long j) {
        return plusDays(Iterable.CC.getAuthRequestContext(j, 7L));
    }

    public final LocalDate plusYears(long j) {
        return j == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j), this.month, this.day);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.PlaceComponentResult() ? this : Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        int lengthOfMonth;
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            if (chronoField.isDateBased()) {
                int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
                if (i == 1) {
                    lengthOfMonth = lengthOfMonth();
                } else if (i != 2) {
                    if (i == 3) {
                        return ValueRange.of(1L, (Month.of(this.month) != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
                    } else if (i != 4) {
                        return temporalField.range();
                    } else {
                        return ValueRange.of(1L, this.year <= 0 ? 1000000000L : 999999999L);
                    }
                } else {
                    lengthOfMonth = lengthOfYear();
                }
                return ValueRange.of(1L, lengthOfMonth);
            }
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        long j;
        long j2 = this.year;
        long j3 = this.month;
        long j4 = (365 * j2) + 0;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.day - 1));
        if (j3 > 2) {
            j5--;
            if (!isLeapYear()) {
                j5--;
            }
        }
        return j5 - 719528;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final String toString() {
        int i;
        int i2 = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        long epochDay;
        long j;
        LocalDate from = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.PlaceComponentResult[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return from.toEpochDay() - toEpochDay();
                case 2:
                    epochDay = from.toEpochDay() - toEpochDay();
                    j = 7;
                    break;
                case 3:
                    return monthsUntil(from);
                case 4:
                    epochDay = monthsUntil(from);
                    j = 12;
                    break;
                case 5:
                    epochDay = monthsUntil(from);
                    j = 120;
                    break;
                case 6:
                    epochDay = monthsUntil(from);
                    j = 1200;
                    break;
                case 7:
                    epochDay = monthsUntil(from);
                    j = 12000;
                    break;
                case 8:
                    ChronoField chronoField = ChronoField.ERA;
                    return from.getLong(chronoField) - getLong(chronoField);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
            return epochDay / j;
        }
        return temporalUnit.between(this, from);
    }

    @Override // j$.time.temporal.Temporal
    public final LocalDate with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j);
            switch (AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()]) {
                case 1:
                    int i = (int) j;
                    return this.day == i ? this : of(this.year, this.month, i);
                case 2:
                    return withDayOfYear((int) j);
                case 3:
                    return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    if (this.year <= 0) {
                        j = 1 - j;
                    }
                    return withYear((int) j);
                case 5:
                    return plusDays(j - getDayOfWeek().getValue());
                case 6:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(j);
                case 9:
                    return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    int i2 = (int) j;
                    if (this.month == i2) {
                        return this;
                    }
                    ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
                    return resolvePreviousValid(this.year, i2, this.day);
                case 11:
                    return plusMonths(j - getProlepticMonth());
                case 12:
                    return withYear((int) j);
                case 13:
                    return getLong(ChronoField.ERA) == j ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            }
        }
        return (LocalDate) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final LocalDate with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? (LocalDate) temporalAdjuster : (LocalDate) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final /* bridge */ /* synthetic */ Temporal mo3168with(LocalDate localDate) {
        return with((TemporalAdjuster) localDate);
    }

    public final LocalDate withDayOfYear(int i) {
        return getDayOfYear() == i ? this : ofYearDay(this.year, i);
    }

    public final LocalDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(i);
        return resolvePreviousValid(i, this.month, this.day);
    }

    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }
}
