package j$.time;

import j$.lang.Iterable;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
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
import java.util.Locale;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes9.dex */
public final class YearMonth implements Temporal, TemporalAdjuster, Comparable, Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    /* renamed from: j$.time.YearMonth$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[ChronoUnit.MONTHS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[ChronoUnit.YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[ChronoUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[ChronoUnit.CENTURIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[ChronoUnit.MILLENNIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[ChronoUnit.ERAS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            MyBillsEntityDataFactory = iArr2;
            try {
                iArr2[ChronoField.MONTH_OF_YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.PROLEPTIC_MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR_OF_ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private YearMonth(int i, int i2) {
        this.year = i;
        this.month = i2;
    }

    private long getProlepticMonth() {
        return ((this.year * 12) + this.month) - 1;
    }

    public static YearMonth of(int i, int i2) {
        ChronoField.YEAR.checkValidValue(i);
        ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
        return new YearMonth(i, i2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private YearMonth with(int i, int i2) {
        return (this.year == i && this.month == i2) ? this : new YearMonth(i, i2);
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        if (((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporal)).equals(IsoChronology.INSTANCE)) {
            return temporal.with(getProlepticMonth(), ChronoField.PROLEPTIC_MONTH);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        YearMonth yearMonth = (YearMonth) obj;
        int i = this.year - yearMonth.year;
        return i == 0 ? this.month - yearMonth.month : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YearMonth) {
            YearMonth yearMonth = (YearMonth) obj;
            return this.year == yearMonth.year && this.month == yearMonth.month;
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        int i;
        if (temporalField instanceof ChronoField) {
            int i2 = AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()];
            if (i2 == 1) {
                i = this.month;
            } else if (i2 == 2) {
                return getProlepticMonth();
            } else {
                if (i2 == 3) {
                    int i3 = this.year;
                    if (i3 <= 0) {
                        i3 = 1 - i3;
                    }
                    return i3;
                } else if (i2 != 4) {
                    if (i2 == 5) {
                        return this.year <= 0 ? 0 : 1;
                    }
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
                } else {
                    i = this.year;
                }
            }
            return i;
        }
        return temporalField.getFrom(this);
    }

    public final int hashCode() {
        return this.year ^ (this.month << 27);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final YearMonth plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.getAuthRequestContext[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusMonths(j);
                case 2:
                    return plusYears(j);
                case 3:
                    return plusYears(Iterable.CC.getAuthRequestContext(j, 10L));
                case 4:
                    return plusYears(Iterable.CC.getAuthRequestContext(j, 100L));
                case 5:
                    return plusYears(Iterable.CC.getAuthRequestContext(j, 1000L));
                case 6:
                    ChronoField chronoField = ChronoField.ERA;
                    return with(Iterable.CC.BuiltInFictitiousFunctionClassFactory(getLong(chronoField), j), (TemporalField) chronoField);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
        }
        return (YearMonth) temporalUnit.addTo(this, j);
    }

    public final YearMonth plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.year * 12) + ((long) (this.month - 1)) + j;
        return with(ChronoField.YEAR.checkValidIntValue(Iterable.CC.PlaceComponentResult(j2, 12L)), ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j2, 12L)) + 1);
    }

    public final YearMonth plusYears(long j) {
        return j == 0 ? this : with(ChronoField.YEAR.checkValidIntValue(this.year + j), this.month);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.getAuthRequestContext() ? IsoChronology.INSTANCE : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.MONTHS : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, this.year <= 0 ? 1000000000L : 999999999L);
        }
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final String toString() {
        int i;
        int abs = Math.abs(this.year);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i2 = this.year;
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            sb.append(this.year);
        }
        sb.append(this.month < 10 ? "-0" : "-");
        sb.append(this.month);
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth of;
        if (temporal instanceof YearMonth) {
            of = (YearMonth) temporal;
        } else if (temporal == null) {
            throw new NullPointerException("temporal");
        } else {
            try {
                if (!IsoChronology.INSTANCE.equals(Era.CC.BuiltInFictitiousFunctionClassFactory(temporal))) {
                    temporal = LocalDate.from(temporal);
                }
                of = of(temporal.get(ChronoField.YEAR), temporal.get(ChronoField.MONTH_OF_YEAR));
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain YearMonth from TemporalAccessor: ");
                sb.append(temporal);
                sb.append(" of type ");
                sb.append(temporal.getClass().getName());
                throw new DateTimeException(sb.toString(), e);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long prolepticMonth = of.getProlepticMonth() - getProlepticMonth();
            switch (AnonymousClass1.getAuthRequestContext[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return prolepticMonth;
                case 2:
                    return prolepticMonth / 12;
                case 3:
                    return prolepticMonth / 120;
                case 4:
                    return prolepticMonth / 1200;
                case 5:
                    return prolepticMonth / 12000;
                case 6:
                    ChronoField chronoField = ChronoField.ERA;
                    return of.getLong(chronoField) - getLong(chronoField);
                default:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unsupported unit: ");
                    sb2.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb2.toString());
            }
        }
        return temporalUnit.between(this, of);
    }

    @Override // j$.time.temporal.Temporal
    public final YearMonth with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j);
            int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
            if (i == 1) {
                int i2 = (int) j;
                ChronoField.MONTH_OF_YEAR.checkValidValue(i2);
                return with(this.year, i2);
            } else if (i != 2) {
                if (i == 3) {
                    if (this.year <= 0) {
                        j = 1 - j;
                    }
                    int i3 = (int) j;
                    ChronoField.YEAR.checkValidValue(i3);
                    return with(i3, this.month);
                } else if (i == 4) {
                    int i4 = (int) j;
                    ChronoField.YEAR.checkValidValue(i4);
                    return with(i4, this.month);
                } else if (i == 5) {
                    if (getLong(ChronoField.ERA) == j) {
                        return this;
                    }
                    int i5 = 1 - this.year;
                    ChronoField.YEAR.checkValidValue(i5);
                    return with(i5, this.month);
                } else {
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
                }
            } else {
                return plusMonths(j - getProlepticMonth());
            }
        }
        return (YearMonth) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (YearMonth) Era.CC.getAuthRequestContext(localDate, this);
    }

    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(ChronoField.YEAR, 4, 10, 5);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(ChronoField.MONTH_OF_YEAR, 2);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), ResolverStyle.SMART, null);
    }
}
