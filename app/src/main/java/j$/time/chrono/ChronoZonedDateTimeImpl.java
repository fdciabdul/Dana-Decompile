package j$.time.chrono;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: classes9.dex */
public final class ChronoZonedDateTimeImpl implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final transient ChronoLocalDateTimeImpl dateTime;
    private final transient ZoneOffset offset;
    private final transient ZoneId zone;

    /* renamed from: j$.time.chrono.ChronoZonedDateTimeImpl$1 */
    /* loaded from: classes9.dex */
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

    private ChronoZonedDateTimeImpl(ZoneId zoneId, ZoneOffset zoneOffset, ChronoLocalDateTimeImpl chronoLocalDateTimeImpl) {
        if (chronoLocalDateTimeImpl == null) {
            throw new NullPointerException("dateTime");
        }
        this.dateTime = chronoLocalDateTimeImpl;
        if (zoneOffset == null) {
            throw new NullPointerException("offset");
        }
        this.offset = zoneOffset;
        if (zoneId == null) {
            throw new NullPointerException("zone");
        }
        this.zone = zoneId;
    }

    static ChronoZonedDateTimeImpl ensureValid(Chronology chronology, Temporal temporal) {
        ChronoZonedDateTimeImpl chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        AbstractChronology abstractChronology = (AbstractChronology) chronology;
        if (abstractChronology.equals(chronoZonedDateTimeImpl.getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Chronology mismatch, required: ");
        PlaceComponentResult.append(abstractChronology.getId());
        PlaceComponentResult.append(", actual: ");
        PlaceComponentResult.append(chronoZonedDateTimeImpl.getChronology().getId());
        throw new ClassCastException(PlaceComponentResult.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
    
        if (r2.contains(r6) != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static j$.time.chrono.ChronoZonedDateTime ofBest(j$.time.ZoneId r5, j$.time.ZoneOffset r6, j$.time.chrono.ChronoLocalDateTimeImpl r7) {
        /*
            if (r7 == 0) goto L66
            if (r5 == 0) goto L5e
            boolean r0 = r5 instanceof j$.time.ZoneOffset
            if (r0 == 0) goto L11
            j$.time.chrono.ChronoZonedDateTimeImpl r6 = new j$.time.chrono.ChronoZonedDateTimeImpl
            r0 = r5
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            r6.<init>(r5, r0, r7)
            return r6
        L11:
            j$.time.zone.ZoneRules r0 = r5.getRules()
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.from(r7)
            java.util.List r2 = r0.getValidOffsets(r1)
            int r3 = r2.size()
            r4 = 1
            if (r3 == r4) goto L47
            int r3 = r2.size()
            if (r3 != 0) goto L3f
            j$.time.zone.ZoneOffsetTransition r6 = r0.getTransition(r1)
            j$.time.Duration r0 = r6.getDuration()
            long r0 = r0.getSeconds()
            j$.time.chrono.ChronoLocalDateTimeImpl r7 = r7.plusSeconds(r0)
            j$.time.ZoneOffset r6 = r6.getOffsetAfter()
            goto L4e
        L3f:
            if (r6 == 0) goto L47
            boolean r0 = r2.contains(r6)
            if (r0 != 0) goto L4e
        L47:
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            j$.time.ZoneOffset r6 = (j$.time.ZoneOffset) r6
        L4e:
            if (r6 == 0) goto L56
            j$.time.chrono.ChronoZonedDateTimeImpl r0 = new j$.time.chrono.ChronoZonedDateTimeImpl
            r0.<init>(r5, r6, r7)
            return r0
        L56:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "offset"
            r5.<init>(r6)
            throw r5
        L5e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "zone"
            r5.<init>(r6)
            throw r5
        L66:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "localDateTime"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.ChronoZonedDateTimeImpl.ofBest(j$.time.ZoneId, j$.time.ZoneOffset, j$.time.chrono.ChronoLocalDateTimeImpl):j$.time.chrono.ChronoZonedDateTime");
    }

    public static ChronoZonedDateTimeImpl ofInstant(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        if (offset != null) {
            return new ChronoZonedDateTimeImpl(zoneId, offset, (ChronoLocalDateTimeImpl) chronology.localDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset)));
        }
        throw new NullPointerException("offset");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime chronoZonedDateTime) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, chronoZonedDateTime);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && Era.CC.BuiltInFictitiousFunctionClassFactory(this, (ChronoZonedDateTime) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int get(TemporalField temporalField) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = ChronoZonedDateTime.AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[((ChronoField) temporalField).ordinal()];
            return i != 1 ? i != 2 ? ((ChronoLocalDateTimeImpl) toLocalDateTime()).getLong(temporalField) : getOffset().getTotalSeconds() : toEpochSecond();
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

    public final ChronoZonedDateTime minus(long j, TemporalUnit temporalUnit) {
        return ensureValid(getChronology(), Temporal.CC.MyBillsEntityDataFactory(this, j, (ChronoUnit) temporalUnit));
    }

    @Override // j$.time.temporal.Temporal
    public final /* bridge */ /* synthetic */ Temporal minus(long j, ChronoUnit chronoUnit) {
        return minus(j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final ChronoZonedDateTime plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return ensureValid(getChronology(), this.dateTime.plus(j, temporalUnit).adjustInto(this));
        }
        return ensureValid(getChronology(), temporalUnit.addTo(this, j));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : ((ChronoLocalDateTimeImpl) toLocalDateTime()).range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long toEpochSecond() {
        return Era.CC.BuiltInFictitiousFunctionClassFactory((ChronoZonedDateTime) this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoLocalDate toLocalDate() {
        return ((ChronoLocalDateTimeImpl) toLocalDateTime()).toLocalDate();
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoLocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final LocalTime toLocalTime() {
        return ((ChronoLocalDateTimeImpl) toLocalDateTime()).toLocalTime();
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
        if (temporal != null) {
            ChronoZonedDateTime zonedDateTime = getChronology().zonedDateTime(temporal);
            if (temporalUnit instanceof ChronoUnit) {
                return this.dateTime.until(zonedDateTime.withZoneSameInstant(this.offset).toLocalDateTime(), temporalUnit);
            } else if (temporalUnit != null) {
                return temporalUnit.between(this, zonedDateTime);
            } else {
                throw new NullPointerException(OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT);
            }
        }
        throw new NullPointerException("endExclusive");
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return ofBest(this.zone, this.offset, this.dateTime.with(j, temporalField));
                }
                return ofInstant(getChronology(), Era.CC.PlaceComponentResult(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j))), this.zone);
            }
            return plus(j - Era.CC.BuiltInFictitiousFunctionClassFactory((ChronoZonedDateTime) this), (TemporalUnit) ChronoUnit.SECONDS);
        }
        return ensureValid(getChronology(), temporalField.adjustInto(this, j));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return ensureValid(getChronology(), localDate.adjustInto(this));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime withZoneSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset != null) {
            if (this.zone.equals(zoneOffset)) {
                return this;
            }
            return ofInstant(getChronology(), Era.CC.PlaceComponentResult(this.dateTime, this.offset), zoneOffset);
        }
        throw new NullPointerException("zone");
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime withZoneSameLocal(ZoneId zoneId) {
        return ofBest(zoneId, this.offset, this.dateTime);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.dateTime);
        objectOutput.writeObject(this.offset);
        objectOutput.writeObject(this.zone);
    }
}
