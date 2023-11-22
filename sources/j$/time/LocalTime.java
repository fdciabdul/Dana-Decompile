package j$.time;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import com.alibaba.griver.lottie.utils.Utils;
import id.dana.domain.featureconfig.model.UgcConfig;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.DurationKt;

/* loaded from: classes6.dex */
public final class LocalTime implements Temporal, TemporalAdjuster, Comparable, Serializable {
    private static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX;
    public static final LocalTime MIDNIGHT;
    public static final LocalTime MIN;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.LocalTime$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            PlaceComponentResult = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                PlaceComponentResult[ChronoField.NANO_OF_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                PlaceComponentResult[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                PlaceComponentResult[ChronoField.MICRO_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                PlaceComponentResult[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                PlaceComponentResult[ChronoField.MILLI_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                PlaceComponentResult[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                PlaceComponentResult[ChronoField.SECOND_OF_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                PlaceComponentResult[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                PlaceComponentResult[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                PlaceComponentResult[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                PlaceComponentResult[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                PlaceComponentResult[ChronoField.HOUR_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                PlaceComponentResult[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                PlaceComponentResult[ChronoField.AMPM_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int i = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                LocalTime localTime2 = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[i] = new LocalTime(i, 0, 0, 0);
            i++;
        }
    }

    private LocalTime(int i, int i2, int i3, int i4) {
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    private static LocalTime create(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? HOURS[i] : new LocalTime(i, i2, i3, i4);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalAccessor != null) {
            temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
            LocalTime localTime = (LocalTime) temporalAccessor.query(temporalQueries$$ExternalSyntheticLambda0);
            if (localTime != null) {
                return localTime;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain LocalTime from TemporalAccessor: ");
            sb.append(temporalAccessor);
            sb.append(" of type ");
            sb.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(sb.toString());
        }
        throw new NullPointerException("temporal");
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass1.PlaceComponentResult[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new UnsupportedTemporalTypeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.nano / 1000;
            case 4:
                throw new UnsupportedTemporalTypeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.nano / DurationKt.NANOS_IN_MILLIS;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int i = this.hour % 12;
                if (i % 12 != 0) {
                    return i;
                }
                return 12;
            case 13:
                return this.hour;
            case 14:
                byte b = this.hour;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
    }

    public static LocalTime of(int i) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i);
        return HOURS[i];
    }

    public static LocalTime of(int i, int i2, int i3, int i4) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i2);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i3);
        ChronoField.NANO_OF_SECOND.checkValidValue(i4);
        return create(i, i2, i3, i4);
    }

    public static LocalTime ofNanoOfDay(long j) {
        ChronoField.NANO_OF_DAY.checkValidValue(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (i * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (i2 * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return create(i, i2, i3, (int) (j3 - (i3 * 1000000000)));
    }

    public static LocalTime ofSecondOfDay(long j) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j);
        int i = (int) (j / 3600);
        long j2 = j - (i * 3600);
        return create(i, (int) (j2 / 60), (int) (j2 - (r0 * 60)), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    public static LocalTime readExternal(DataInput dataInput) {
        int readInt;
        byte b;
        byte b2;
        byte b3;
        byte b4;
        int readByte = dataInput.readByte();
        byte b5 = 0;
        if (readByte < 0) {
            readByte ^= -1;
            b3 = 0;
            b4 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                b2 = readByte2 ^ (-1);
                readInt = 0;
                b = b2;
                return of(readByte, b, b5, readInt);
            }
            byte readByte3 = dataInput.readByte();
            if (readByte3 >= 0) {
                readInt = dataInput.readInt();
                b5 = readByte3;
                b = readByte2;
                return of(readByte, b, b5, readInt);
            }
            b4 = readByte2;
            b3 = readByte3 ^ (-1);
        }
        b5 = b3;
        b2 = b4;
        readInt = 0;
        b = b2;
        return of(readByte, b, b5, readInt);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(toNanoOfDay(), ChronoField.NANO_OF_DAY);
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalTime localTime) {
        int compare = Integer.compare(this.hour, localTime.hour);
        if (compare == 0) {
            int compare2 = Integer.compare(this.minute, localTime.minute);
            if (compare2 == 0) {
                int compare3 = Integer.compare(this.second, localTime.second);
                return compare3 == 0 ? Integer.compare(this.nano, localTime.nano) : compare3;
            }
            return compare2;
        }
        return compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    public final int getHour() {
        return this.hour;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.NANO_OF_DAY ? toNanoOfDay() : temporalField == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : get0(temporalField) : temporalField.getFrom(this);
    }

    public final int getNano() {
        return this.nano;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final LocalTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.getAuthRequestContext[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusNanos(j);
                case 2:
                    return plusNanos((j % 86400000000L) * 1000);
                case 3:
                    return plusNanos((j % 86400000) * 1000000);
                case 4:
                    return plusSeconds(j);
                case 5:
                    return plusMinutes(j);
                case 6:
                    return plusHours(j);
                case 7:
                    return plusHours((j % 2) * 12);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
        }
        return (LocalTime) temporalUnit.addTo(this, j);
    }

    public final LocalTime plusHours(long j) {
        return j == 0 ? this : create(((((int) (j % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public final LocalTime plusMinutes(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.hour * 60) + this.minute;
        int i2 = ((((int) (j % TimeUtils.DAY_TO_MIN)) + i) + 1440) % 1440;
        return i == i2 ? this : create(i2 / 60, i2 % 60, this.second, this.nano);
    }

    public final LocalTime plusNanos(long j) {
        if (j == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j2 = (((j % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        return nanoOfDay == j2 ? this : create((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public final LocalTime plusSeconds(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.minute * 60) + (this.hour * 3600) + this.second;
        int i2 = ((((int) (j % TimeUtils.DAY_TO_SECOND)) + i) + UgcConfig.DEFAULT_UGC_INTERVAL) % UgcConfig.DEFAULT_UGC_INTERVAL;
        return i == i2 ? this : create(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.nano);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalQuery == Temporal.CC.getAuthRequestContext() || temporalQuery == Temporal.CC.moveToNextValue() || temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory()) {
            return null;
        }
        temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
        if (temporalQuery == temporalQueries$$ExternalSyntheticLambda0) {
            return this;
        }
        if (temporalQuery == Temporal.CC.PlaceComponentResult()) {
            return null;
        }
        return temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.NANOS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final long toNanoOfDay() {
        return (this.second * 1000000000) + (this.minute * 60000000000L) + (this.hour * 3600000000000L) + this.nano;
    }

    public final int toSecondOfDay() {
        return (this.minute * 60) + (this.hour * 3600) + this.second;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder(18);
        byte b = this.hour;
        byte b2 = this.minute;
        byte b3 = this.second;
        int i2 = this.nano;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || i2 > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append((int) b3);
            if (i2 > 0) {
                sb.append('.');
                int i3 = DurationKt.NANOS_IN_MILLIS;
                if (i2 % DurationKt.NANOS_IN_MILLIS == 0) {
                    i = (i2 / DurationKt.NANOS_IN_MILLIS) + 1000;
                } else {
                    if (i2 % 1000 == 0) {
                        i2 /= 1000;
                    } else {
                        i3 = Utils.SECOND_IN_NANOS;
                    }
                    i = i2 + i3;
                }
                sb.append(Integer.toString(i).substring(1));
            }
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        long j;
        LocalTime from = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            long nanoOfDay = from.toNanoOfDay() - toNanoOfDay();
            switch (AnonymousClass1.getAuthRequestContext[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return nanoOfDay;
                case 2:
                    j = 1000;
                    break;
                case 3:
                    j = 1000000;
                    break;
                case 4:
                    j = 1000000000;
                    break;
                case 5:
                    j = 60000000000L;
                    break;
                case 6:
                    j = 3600000000000L;
                    break;
                case 7:
                    j = 43200000000000L;
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
            return nanoOfDay / j;
        }
        return temporalUnit.between(this, from);
    }

    @Override // j$.time.temporal.Temporal
    public final LocalTime with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j);
            switch (AnonymousClass1.PlaceComponentResult[chronoField.ordinal()]) {
                case 1:
                    return withNano((int) j);
                case 2:
                    return ofNanoOfDay(j);
                case 3:
                    return withNano(((int) j) * 1000);
                case 4:
                    return ofNanoOfDay(j * 1000);
                case 5:
                    return withNano(((int) j) * DurationKt.NANOS_IN_MILLIS);
                case 6:
                    return ofNanoOfDay(j * 1000000);
                case 7:
                    int i = (int) j;
                    if (this.second == i) {
                        return this;
                    }
                    ChronoField.SECOND_OF_MINUTE.checkValidValue(i);
                    return create(this.hour, this.minute, i, this.nano);
                case 8:
                    return plusSeconds(j - toSecondOfDay());
                case 9:
                    int i2 = (int) j;
                    if (this.minute == i2) {
                        return this;
                    }
                    ChronoField.MINUTE_OF_HOUR.checkValidValue(i2);
                    return create(this.hour, i2, this.second, this.nano);
                case 10:
                    return plusMinutes(j - ((this.hour * 60) + this.minute));
                case 11:
                    return plusHours(j - (this.hour % 12));
                case 12:
                    if (j == 12) {
                        j = 0;
                    }
                    return plusHours(j - (this.hour % 12));
                case 13:
                    int i3 = (int) j;
                    if (this.hour == i3) {
                        return this;
                    }
                    ChronoField.HOUR_OF_DAY.checkValidValue(i3);
                    return create(i3, this.minute, this.second, this.nano);
                case 14:
                    if (j == 24) {
                        j = 0;
                    }
                    int i4 = (int) j;
                    if (this.hour == i4) {
                        return this;
                    }
                    ChronoField.HOUR_OF_DAY.checkValidValue(i4);
                    return create(i4, this.minute, this.second, this.nano);
                case 15:
                    return plusHours((j - (this.hour / 12)) * 12);
                default:
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            }
        }
        return (LocalTime) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (LocalTime) Era.CC.getAuthRequestContext(localDate, this);
    }

    public final LocalTime withNano(int i) {
        if (this.nano == i) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue(i);
        return create(this.hour, this.minute, this.second, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        byte b;
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
            return;
        }
        if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            b = this.second;
        } else if (this.minute == 0) {
            b = this.hour;
        } else {
            dataOutput.writeByte(this.hour);
            b = this.minute;
        }
        dataOutput.writeByte(b ^ (-1));
    }
}
