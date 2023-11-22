package j$.time.chrono;

import j$.lang.Iterable;
import j$.time.DateTimeException;
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
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

/* loaded from: classes9.dex */
public final class HijrahDate extends ChronoLocalDateImpl {
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient HijrahChronology chrono;
    private final transient int dayOfMonth;
    private final transient int monthOfYear;
    private final transient int prolepticYear;

    /* renamed from: j$.time.chrono.HijrahDate$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.DAY_OF_WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.EPOCH_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.MONTH_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.PROLEPTIC_MONTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR_OF_ERA.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private HijrahDate(HijrahChronology hijrahChronology, int i, int i2, int i3) {
        hijrahChronology.getEpochDay(i, i2, i3);
        this.chrono = hijrahChronology;
        this.prolepticYear = i;
        this.monthOfYear = i2;
        this.dayOfMonth = i3;
    }

    private HijrahDate(HijrahChronology hijrahChronology, long j) {
        int[] hijrahDateInfo = hijrahChronology.getHijrahDateInfo((int) j);
        this.chrono = hijrahChronology;
        this.prolepticYear = hijrahDateInfo[0];
        this.monthOfYear = hijrahDateInfo[1];
        this.dayOfMonth = hijrahDateInfo[2];
    }

    private int getDayOfWeek() {
        return ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(toEpochDay() + 3, 7L)) + 1;
    }

    private int getDayOfYear() {
        return this.chrono.getDayOfYear(this.prolepticYear, this.monthOfYear) + this.dayOfMonth;
    }

    public static HijrahDate of(HijrahChronology hijrahChronology, int i, int i2, int i3) {
        return new HijrahDate(hijrahChronology, i, i2, i3);
    }

    public static HijrahDate ofEpochDay(HijrahChronology hijrahChronology, long j) {
        return new HijrahDate(hijrahChronology, j);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private HijrahDate resolvePreviousValid(int i, int i2, int i3) {
        int monthLength = this.chrono.getMonthLength(i, i2);
        if (i3 > monthLength) {
            i3 = monthLength;
        }
        return new HijrahDate(this.chrono, i, i2, i3);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HijrahDate) {
            HijrahDate hijrahDate = (HijrahDate) obj;
            return this.prolepticYear == hijrahDate.prolepticYear && this.monthOfYear == hijrahDate.monthOfYear && this.dayOfMonth == hijrahDate.dayOfMonth && this.chrono.equals(hijrahDate.chrono);
        }
        return false;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final Chronology getChronology() {
        return this.chrono;
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final Era getEra() {
        return HijrahEra.AH;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        int i;
        int i2;
        int dayOfWeek;
        int i3;
        if (temporalField instanceof ChronoField) {
            switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()]) {
                case 1:
                    i = this.dayOfMonth;
                    break;
                case 2:
                    i = getDayOfYear();
                    break;
                case 3:
                    i2 = this.dayOfMonth;
                    i3 = (i2 - 1) / 7;
                    i = i3 + 1;
                    break;
                case 4:
                    i = getDayOfWeek();
                    break;
                case 5:
                    dayOfWeek = getDayOfWeek();
                    i3 = (dayOfWeek - 1) % 7;
                    i = i3 + 1;
                    break;
                case 6:
                    dayOfWeek = getDayOfYear();
                    i3 = (dayOfWeek - 1) % 7;
                    i = i3 + 1;
                    break;
                case 7:
                    return toEpochDay();
                case 8:
                    i2 = getDayOfYear();
                    i3 = (i2 - 1) / 7;
                    i = i3 + 1;
                    break;
                case 9:
                    i = this.monthOfYear;
                    break;
                case 10:
                    return ((this.prolepticYear * 12) + this.monthOfYear) - 1;
                case 11:
                case 12:
                    i = this.prolepticYear;
                    break;
                case 13:
                    return this.prolepticYear <= 1 ? 0 : 1;
                default:
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            }
            return i;
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        int i = this.prolepticYear;
        int i2 = this.monthOfYear;
        return ((i & (-2048)) ^ this.chrono.getId().hashCode()) ^ (((i << 11) + (i2 << 6)) + this.dayOfMonth);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final boolean isLeapYear() {
        return this.chrono.isLeapYear(this.prolepticYear);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final int lengthOfYear() {
        return this.chrono.getYearLength(this.prolepticYear);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate minus(long j, ChronoUnit chronoUnit) {
        return (HijrahDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return (HijrahDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate plus(Period period) {
        return (HijrahDate) super.plus(period);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final Temporal plus(long j, TemporalUnit temporalUnit) {
        return (HijrahDate) super.plus(j, temporalUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    public final HijrahDate plusDays(long j) {
        return new HijrahDate(this.chrono, toEpochDay() + j);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    public final HijrahDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.prolepticYear * 12) + ((long) (this.monthOfYear - 1)) + j;
        HijrahChronology hijrahChronology = this.chrono;
        long PlaceComponentResult = Iterable.CC.PlaceComponentResult(j2, 12L);
        if (PlaceComponentResult < hijrahChronology.getMinimumYear() || PlaceComponentResult > hijrahChronology.getMaximumYear()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Hijrah year: ");
            sb.append(PlaceComponentResult);
            throw new DateTimeException(sb.toString());
        }
        return resolvePreviousValid((int) PlaceComponentResult, ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j2, 12L)) + 1, this.dayOfMonth);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    final ChronoLocalDate plusYears(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.prolepticYear + ((int) j);
        int i = (int) j2;
        if (j2 == i) {
            return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
        }
        throw new ArithmeticException();
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        int monthLength;
        long j;
        if (temporalField instanceof ChronoField) {
            if (Era.CC.PlaceComponentResult(this, temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
                if (i == 1) {
                    monthLength = this.chrono.getMonthLength(this.prolepticYear, this.monthOfYear);
                } else if (i != 2) {
                    if (i != 3) {
                        return this.chrono.range(chronoField);
                    }
                    j = 5;
                    return ValueRange.of(1L, j);
                } else {
                    monthLength = lengthOfYear();
                }
                j = monthLength;
                return ValueRange.of(1L, j);
            }
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.chrono.getEpochDay(this.prolepticYear, this.monthOfYear, this.dayOfMonth);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (HijrahDate) super.with(temporalAdjuster);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final HijrahDate with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            this.chrono.range(chronoField).checkValidValue(j, chronoField);
            int i = (int) j;
            switch (AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()]) {
                case 1:
                    return resolvePreviousValid(this.prolepticYear, this.monthOfYear, i);
                case 2:
                    return plusDays(Math.min(i, lengthOfYear()) - getDayOfYear());
                case 3:
                    return plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
                case 4:
                    return plusDays(j - getDayOfWeek());
                case 5:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 6:
                    return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 7:
                    return new HijrahDate(this.chrono, j);
                case 8:
                    return plusDays((j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
                case 9:
                    return resolvePreviousValid(this.prolepticYear, i, this.dayOfMonth);
                case 10:
                    return plusMonths(j - (((this.prolepticYear * 12) + this.monthOfYear) - 1));
                case 11:
                    if (this.prolepticYear <= 0) {
                        i = 1 - i;
                    }
                    return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
                case 12:
                    return resolvePreviousValid(i, this.monthOfYear, this.dayOfMonth);
                case 13:
                    return resolvePreviousValid(1 - this.prolepticYear, this.monthOfYear, this.dayOfMonth);
                default:
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            }
        }
        return (HijrahDate) super.with(j, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (HijrahDate) super.with((TemporalAdjuster) localDate);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.chrono);
        objectOutput.writeInt(Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, ChronoField.YEAR));
        objectOutput.writeByte(Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, ChronoField.MONTH_OF_YEAR));
        objectOutput.writeByte(Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, ChronoField.DAY_OF_MONTH));
    }
}
