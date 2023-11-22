package j$.time;

import j$.time.Month;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes9.dex */
public final class MonthDay implements TemporalAccessor, TemporalAdjuster, Comparable, Serializable {
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* renamed from: j$.time.MonthDay$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MonthDay(int i, int i2) {
        this.month = i;
        this.day = i2;
    }

    public static MonthDay readExternal(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        Month of = Month.of(readByte);
        if (of != null) {
            ChronoField.DAY_OF_MONTH.checkValidValue(readByte2);
            if (readByte2 <= of.maxLength()) {
                return new MonthDay(of.getValue(), readByte2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal value for DayOfMonth field, value ");
            sb.append((int) readByte2);
            sb.append(" is not valid for month ");
            sb.append(of.name());
            throw new DateTimeException(sb.toString());
        }
        throw new NullPointerException("month");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 13, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        if (((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporal)).equals(IsoChronology.INSTANCE)) {
            Temporal with = temporal.with(this.month, ChronoField.MONTH_OF_YEAR);
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            return with.with(Math.min(with.range(chronoField).getMaximum(), this.day), chronoField);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        MonthDay monthDay = (MonthDay) obj;
        int i = this.month - monthDay.month;
        return i == 0 ? this.day - monthDay.day : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MonthDay) {
            MonthDay monthDay = (MonthDay) obj;
            return this.month == monthDay.month && this.day == monthDay.day;
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
            int i2 = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            if (i2 == 1) {
                i = this.day;
            } else if (i2 != 2) {
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            } else {
                i = this.month;
            }
            return i;
        }
        return temporalField.getFrom(this);
    }

    public final int hashCode() {
        return (this.month << 6) + this.day;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.getAuthRequestContext() ? IsoChronology.INSTANCE : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        ValueRange of;
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.range();
        }
        if (temporalField == ChronoField.DAY_OF_MONTH) {
            int i = Month.AnonymousClass1.BuiltInFictitiousFunctionClassFactory[Month.of(this.month).ordinal()];
            of = ValueRange.of(1L, i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : 28, Month.of(this.month).maxLength());
            return of;
        }
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.month < 10 ? "0" : "");
        sb.append(this.month);
        sb.append(this.day < 10 ? "-0" : "-");
        sb.append(this.day);
        return sb.toString();
    }

    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.PlaceComponentResult("--");
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(ChronoField.MONTH_OF_YEAR, 2);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(ChronoField.DAY_OF_MONTH, 2);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), ResolverStyle.SMART, null);
    }
}
