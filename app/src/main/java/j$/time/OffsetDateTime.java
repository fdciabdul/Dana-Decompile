package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
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

/* loaded from: classes6.dex */
public final class OffsetDateTime implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;

    /* renamed from: j$.time.OffsetDateTime$1 */
    /* loaded from: classes6.dex */
    abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        of(LocalDateTime.MIN, ZoneOffset.MAX);
        of(LocalDateTime.MAX, ZoneOffset.MIN);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (localDateTime == null) {
            throw new NullPointerException("dateTime");
        }
        this.dateTime = localDateTime;
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        this.offset = zoneOffset;
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        if (instant != null) {
            if (zoneId != null) {
                ZoneOffset offset = zoneId.getRules().getOffset(instant);
                return new OffsetDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset), offset);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("instant");
    }

    public static OffsetDateTime readExternal(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        LocalDate localDate = LocalDate.MIN;
        return new OffsetDateTime(LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.readExternal(objectInput)), ZoneOffset.readExternal(objectInput));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private OffsetDateTime with(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.dateTime == localDateTime && this.offset.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    private Object writeReplace() {
        return new Ser((byte) 10, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(this.dateTime.toLocalDate().toEpochDay(), ChronoField.EPOCH_DAY).with(this.dateTime.toLocalTime().toNanoOfDay(), ChronoField.NANO_OF_DAY).with(this.offset.getTotalSeconds(), ChronoField.OFFSET_SECONDS);
    }

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int compare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.offset.equals(offsetDateTime2.offset)) {
            compare = toLocalDateTime().compareTo((ChronoLocalDateTime) offsetDateTime2.toLocalDateTime());
        } else {
            compare = Long.compare(Era.CC.getAuthRequestContext(this.dateTime, this.offset), Era.CC.getAuthRequestContext(offsetDateTime2.dateTime, offsetDateTime2.offset));
            if (compare == 0) {
                compare = this.dateTime.toLocalTime().getNano() - offsetDateTime2.dateTime.toLocalTime().getNano();
            }
        }
        return compare == 0 ? toLocalDateTime().compareTo((ChronoLocalDateTime) offsetDateTime2.toLocalDateTime()) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            return this.dateTime.equals(offsetDateTime.dateTime) && this.offset.equals(offsetDateTime.offset);
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()];
            if (i != 1) {
                return i != 2 ? this.dateTime.get(temporalField) : this.offset.getTotalSeconds();
            }
            throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()];
            return i != 1 ? i != 2 ? this.dateTime.getLong(temporalField) : this.offset.getTotalSeconds() : Era.CC.getAuthRequestContext(this.dateTime, this.offset);
        }
        return temporalField.getFrom(this);
    }

    public final int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final OffsetDateTime plus(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? with(this.dateTime.plus(j, temporalUnit), this.offset) : (OffsetDateTime) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory() || temporalQuery == Temporal.CC.getErrorConfigVersion()) {
            return this.offset;
        }
        if (temporalQuery == Temporal.CC.moveToNextValue()) {
            return null;
        }
        if (temporalQuery == Temporal.CC.PlaceComponentResult()) {
            return this.dateTime.toLocalDate();
        }
        temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
        return temporalQuery == temporalQueries$$ExternalSyntheticLambda0 ? this.dateTime.toLocalTime() : temporalQuery == Temporal.CC.getAuthRequestContext() ? IsoChronology.INSTANCE : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.NANOS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : this.dateTime.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    public final LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dateTime.toString());
        sb.append(this.offset.toString());
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v16, types: [j$.time.OffsetDateTime] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporal instanceof OffsetDateTime) {
            temporal = (OffsetDateTime) temporal;
        } else {
            try {
                ZoneOffset from = ZoneOffset.from((TemporalAccessor) temporal);
                LocalDate localDate = (LocalDate) temporal.query(Temporal.CC.PlaceComponentResult());
                temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
                LocalTime localTime = (LocalTime) temporal.query(temporalQueries$$ExternalSyntheticLambda0);
                temporal = (localDate == null || localTime == null) ? ofInstant(Instant.from(temporal), from) : new OffsetDateTime(LocalDateTime.of(localDate, localTime), from);
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain OffsetDateTime from TemporalAccessor: ");
                sb.append(temporal);
                sb.append(" of type ");
                sb.append(temporal.getClass().getName());
                throw new DateTimeException(sb.toString(), e);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            ZoneOffset zoneOffset = this.offset;
            boolean equals = zoneOffset.equals(temporal.offset);
            OffsetDateTime offsetDateTime = temporal;
            if (!equals) {
                offsetDateTime = new OffsetDateTime(temporal.dateTime.plusSeconds(zoneOffset.getTotalSeconds() - temporal.offset.getTotalSeconds()), zoneOffset);
            }
            return this.dateTime.until(offsetDateTime.dateTime, temporalUnit);
        }
        return temporalUnit.between(this, temporal);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
            return i != 1 ? i != 2 ? with(this.dateTime.with(j, temporalField), this.offset) : with(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j))) : ofInstant(Instant.ofEpochSecond(j, this.dateTime.getNano()), this.offset);
        }
        return (OffsetDateTime) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return with(this.dateTime.mo3168with(localDate), this.offset);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        this.dateTime.writeExternal(objectOutput);
        this.offset.writeExternal(objectOutput);
    }
}
