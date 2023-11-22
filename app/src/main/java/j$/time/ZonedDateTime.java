package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.Chronology;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import j$.time.zone.ZoneOffsetTransition;
import j$.time.zone.ZoneRules;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public final class ZonedDateTime implements Temporal, ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* renamed from: j$.time.ZonedDateTime$1 */
    /* loaded from: classes6.dex */
    abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private static ZonedDateTime create(long j, int i, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(Instant.ofEpochSecond(j, i));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j, i, offset), zoneId, offset);
    }

    public static ZonedDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof ZonedDateTime) {
            return (ZonedDateTime) temporalAccessor;
        }
        try {
            ZoneId from = ZoneId.from(temporalAccessor);
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            return temporalAccessor.isSupported(chronoField) ? create(temporalAccessor.getLong(chronoField), temporalAccessor.get(ChronoField.NANO_OF_SECOND), from) : ofLocal(LocalDateTime.of(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor)), from, null);
        } catch (DateTimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain ZonedDateTime from TemporalAccessor: ");
            sb.append(temporalAccessor);
            sb.append(" of type ");
            sb.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(sb.toString(), e);
        }
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        if (instant != null) {
            if (zoneId != null) {
                return create(instant.getEpochSecond(), instant.getNano(), zoneId);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("instant");
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        if (localDateTime != null) {
            if (zoneId != null) {
                if (zoneId instanceof ZoneOffset) {
                    return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
                }
                ZoneRules rules = zoneId.getRules();
                List validOffsets = rules.getValidOffsets(localDateTime);
                if (validOffsets.size() == 1) {
                    zoneOffset = (ZoneOffset) validOffsets.get(0);
                } else if (validOffsets.size() == 0) {
                    ZoneOffsetTransition transition = rules.getTransition(localDateTime);
                    localDateTime = localDateTime.plusSeconds(transition.getDuration().getSeconds());
                    zoneOffset = transition.getOffsetAfter();
                } else if ((zoneOffset == null || !validOffsets.contains(zoneOffset)) && (zoneOffset = (ZoneOffset) validOffsets.get(0)) == null) {
                    throw new NullPointerException("offset");
                }
                return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
            }
            throw new NullPointerException("zone");
        }
        throw new NullPointerException("localDateTime");
    }

    public static ZonedDateTime readExternal(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        LocalDate localDate = LocalDate.MIN;
        LocalDateTime of = LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.readExternal(objectInput));
        ZoneOffset readExternal = ZoneOffset.readExternal(objectInput);
        ZoneId zoneId = (ZoneId) Ser.read(objectInput);
        if (zoneId != null) {
            if (!(zoneId instanceof ZoneOffset) || readExternal.equals(zoneId)) {
                return new ZonedDateTime(of, zoneId, readExternal);
            }
            throw new IllegalArgumentException("ZoneId must match ZoneOffset");
        }
        throw new NullPointerException("zone");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.getRules().getValidOffsets(this.dateTime).contains(zoneOffset)) ? this : new ZonedDateTime(this.dateTime, this.zone, zoneOffset);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, chronoZonedDateTime);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            return this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone);
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            if (i != 1) {
                return i != 2 ? this.dateTime.get(temporalField) : this.offset.getTotalSeconds();
            }
            throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Chronology getChronology() {
        return ((LocalDate) toLocalDate()).getChronology();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            return i != 1 ? i != 2 ? this.dateTime.getLong(temporalField) : this.offset.getTotalSeconds() : Era.CC.BuiltInFictitiousFunctionClassFactory((ChronoZonedDateTime) this);
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.zone;
    }

    public final int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
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
    public final ZonedDateTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isDateBased()) {
                return ofLocal(this.dateTime.plus(j, temporalUnit), this.zone, this.offset);
            }
            LocalDateTime plus = this.dateTime.plus(j, temporalUnit);
            ZoneOffset zoneOffset = this.offset;
            ZoneId zoneId = this.zone;
            if (plus != null) {
                if (zoneOffset != null) {
                    if (zoneId != null) {
                        return zoneId.getRules().getValidOffsets(plus).contains(zoneOffset) ? new ZonedDateTime(plus, zoneId, zoneOffset) : create(Era.CC.getAuthRequestContext(plus, zoneOffset), plus.getNano(), zoneId);
                    }
                    throw new NullPointerException("zone");
                }
                throw new NullPointerException("offset");
            }
            throw new NullPointerException("localDateTime");
        }
        return (ZonedDateTime) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.PlaceComponentResult() ? toLocalDate() : Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : this.dateTime.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long toEpochSecond() {
        return Era.CC.BuiltInFictitiousFunctionClassFactory((ChronoZonedDateTime) this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoLocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dateTime.toString());
        sb.append(this.offset.toString());
        String obj = sb.toString();
        if (this.offset != this.zone) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append('[');
            sb2.append(this.zone.toString());
            sb2.append(']');
            return sb2.toString();
        }
        return obj;
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime from = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            ZonedDateTime withZoneSameInstant = from.withZoneSameInstant(this.zone);
            return temporalUnit.isDateBased() ? this.dateTime.until(withZoneSameInstant.dateTime, temporalUnit) : OffsetDateTime.of(this.dateTime, this.offset).until(OffsetDateTime.of(withZoneSameInstant.dateTime, withZoneSameInstant.offset), temporalUnit);
        }
        return temporalUnit.between(this, from);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final ZonedDateTime mo3168with(LocalDate localDate) {
        return ofLocal(LocalDateTime.of(localDate, this.dateTime.toLocalTime()), this.zone, this.offset);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[chronoField.ordinal()];
            return i != 1 ? i != 2 ? ofLocal(this.dateTime.with(j, temporalField), this.zone, this.offset) : resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j))) : create(j, this.dateTime.getNano(), this.zone);
        }
        return (ZonedDateTime) temporalField.adjustInto(this, j);
    }

    public final ZonedDateTime withZoneSameInstant(ZoneId zoneId) {
        if (zoneId != null) {
            return this.zone.equals(zoneId) ? this : create(Era.CC.getAuthRequestContext(this.dateTime, this.offset), this.dateTime.getNano(), zoneId);
        }
        throw new NullPointerException("zone");
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* bridge */ /* synthetic */ ChronoZonedDateTime withZoneSameInstant(ZoneOffset zoneOffset) {
        return withZoneSameInstant((ZoneId) zoneOffset);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime withZoneSameLocal(ZoneId zoneId) {
        if (zoneId != null) {
            return this.zone.equals(zoneId) ? this : ofLocal(this.dateTime, zoneId, this.offset);
        }
        throw new NullPointerException("zone");
    }

    public final void writeExternal(DataOutput dataOutput) {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
        this.zone.write(dataOutput);
    }
}
