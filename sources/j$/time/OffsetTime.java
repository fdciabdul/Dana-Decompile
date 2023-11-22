package j$.time;

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
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes9.dex */
public final class OffsetTime implements Temporal, TemporalAdjuster, Comparable, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;

    /* renamed from: j$.time.OffsetTime$1 */
    /* loaded from: classes9.dex */
    abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                PlaceComponentResult[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                PlaceComponentResult[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        of(LocalTime.MIN, ZoneOffset.MAX);
        of(LocalTime.MAX, ZoneOffset.MIN);
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        if (localTime == null) {
            throw new NullPointerException("time");
        }
        this.time = localTime;
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        this.offset = zoneOffset;
    }

    public static OffsetTime of(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    public static OffsetTime readExternal(ObjectInput objectInput) {
        return new OffsetTime(LocalTime.readExternal(objectInput), ZoneOffset.readExternal(objectInput));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (this.offset.getTotalSeconds() * 1000000000);
    }

    private OffsetTime with(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.time == localTime && this.offset.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }

    private Object writeReplace() {
        return new Ser((byte) 9, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(this.time.toNanoOfDay(), ChronoField.NANO_OF_DAY).with(this.offset.getTotalSeconds(), ChronoField.OFFSET_SECONDS);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int compare;
        OffsetTime offsetTime = (OffsetTime) obj;
        return (this.offset.equals(offsetTime.offset) || (compare = Long.compare(toEpochNano(), offsetTime.toEpochNano())) == 0) ? this.time.compareTo(offsetTime.time) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetTime) {
            OffsetTime offsetTime = (OffsetTime) obj;
            return this.time.equals(offsetTime.time) && this.offset.equals(offsetTime.offset);
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS ? this.offset.getTotalSeconds() : this.time.getLong(temporalField) : temporalField.getFrom(this);
    }

    public final int hashCode() {
        return this.time.hashCode() ^ this.offset.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() || temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final OffsetTime plus(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? with(this.time.plus(j, temporalUnit), this.offset) : (OffsetTime) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory() || temporalQuery == Temporal.CC.getErrorConfigVersion()) {
            return this.offset;
        }
        if (((temporalQuery == Temporal.CC.moveToNextValue()) || (temporalQuery == Temporal.CC.getAuthRequestContext())) || temporalQuery == Temporal.CC.PlaceComponentResult()) {
            return null;
        }
        temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
        return temporalQuery == temporalQueries$$ExternalSyntheticLambda0 ? this.time : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.NANOS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS ? temporalField.range() : Temporal.CC.MyBillsEntityDataFactory(this.time, temporalField) : temporalField.rangeRefinedBy(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.time.toString());
        sb.append(this.offset.toString());
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetTime offsetTime;
        long j;
        if (temporal instanceof OffsetTime) {
            offsetTime = (OffsetTime) temporal;
        } else {
            try {
                offsetTime = new OffsetTime(LocalTime.from(temporal), ZoneOffset.from((TemporalAccessor) temporal));
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain OffsetTime from TemporalAccessor: ");
                sb.append(temporal);
                sb.append(" of type ");
                sb.append(temporal.getClass().getName());
                throw new DateTimeException(sb.toString(), e);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long epochNano = offsetTime.toEpochNano() - toEpochNano();
            switch (AnonymousClass1.PlaceComponentResult[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return epochNano;
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
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unsupported unit: ");
                    sb2.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb2.toString());
            }
            return epochNano / j;
        }
        return temporalUnit.between(this, offsetTime);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal with(long j, TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS ? with(this.time, ZoneOffset.ofTotalSeconds(((ChronoField) temporalField).checkValidIntValue(j))) : with(this.time.with(j, temporalField), this.offset) : (OffsetTime) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (OffsetTime) Era.CC.getAuthRequestContext(localDate, this);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        this.time.writeExternal(objectOutput);
        this.offset.writeExternal(objectOutput);
    }
}
