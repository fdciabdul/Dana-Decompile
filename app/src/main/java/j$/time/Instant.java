package j$.time;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import j$.lang.Iterable;
import j$.time.chrono.Era;
import j$.time.format.DateTimeFormatter;
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
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.DurationKt;

/* loaded from: classes2.dex */
public final class Instant implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    public static final Instant EPOCH = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.Instant$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.INSTANT_SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        ofEpochSecond(-31557014167219200L, 0L);
        ofEpochSecond(31556889864403199L, 999999999L);
    }

    private Instant(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    private static Instant create(long j, int i) {
        if ((i | j) == 0) {
            return EPOCH;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j, i);
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        if (temporalAccessor != null) {
            try {
                return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), temporalAccessor.get(ChronoField.NANO_OF_SECOND));
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain Instant from TemporalAccessor: ");
                sb.append(temporalAccessor);
                sb.append(" of type ");
                sb.append(temporalAccessor.getClass().getName());
                throw new DateTimeException(sb.toString(), e);
            }
        }
        throw new NullPointerException("temporal");
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j) {
        return create(Iterable.CC.PlaceComponentResult(j, 1000L), ((int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j, 1000L)) * DurationKt.NANOS_IN_MILLIS);
    }

    public static Instant ofEpochSecond(long j) {
        return create(j, 0);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return create(Iterable.CC.BuiltInFictitiousFunctionClassFactory(j, Iterable.CC.PlaceComponentResult(j2, 1000000000L)), (int) Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j2, 1000000000L));
    }

    private Instant plus(long j, long j2) {
        return (j | j2) == 0 ? this : ofEpochSecond(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.BuiltInFictitiousFunctionClassFactory(this.seconds, j), j2 / 1000000000), this.nanos + (j2 % 1000000000));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant instant) {
        long MyBillsEntityDataFactory = Iterable.CC.MyBillsEntityDataFactory(instant.seconds, this.seconds);
        long j = instant.nanos - this.nanos;
        return (MyBillsEntityDataFactory <= 0 || j >= 0) ? (MyBillsEntityDataFactory >= 0 || j <= 0) ? MyBillsEntityDataFactory : MyBillsEntityDataFactory + 1 : MyBillsEntityDataFactory - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(this.seconds, ChronoField.INSTANT_SECONDS).with(this.nanos, ChronoField.NANO_OF_SECOND);
    }

    public final OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    public final ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this, zoneId);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        int compare = Long.compare(this.seconds, instant.seconds);
        return compare != 0 ? compare : this.nanos - instant.nanos;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            return this.seconds == instant.seconds && this.nanos == instant.nanos;
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            ChronoField.INSTANT_SECONDS.checkValidIntValue(this.seconds);
                        }
                        throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
                    }
                    return this.nanos / DurationKt.NANOS_IN_MILLIS;
                }
                return this.nanos / 1000;
            }
            return this.nanos;
        }
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
    }

    public final long getEpochSecond() {
        return this.seconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        int i;
        if (temporalField instanceof ChronoField) {
            int i2 = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            if (i2 == 1) {
                i = this.nanos;
            } else if (i2 == 2) {
                i = this.nanos / 1000;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return this.seconds;
                }
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            } else {
                i = this.nanos / DurationKt.NANOS_IN_MILLIS;
            }
            return i;
        }
        return temporalField.getFrom(this);
    }

    public final int getNano() {
        return this.nanos;
    }

    public final int hashCode() {
        long j = this.seconds;
        return (this.nanos * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final Instant plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plus(0L, j);
                case 2:
                    return plus(j / 1000000, (j % 1000000) * 1000);
                case 3:
                    return plus(j / 1000, (j % 1000) * 1000000);
                case 4:
                    return plus(j, 0L);
                case 5:
                    return plus(Iterable.CC.getAuthRequestContext(j, 60L), 0L);
                case 6:
                    return plus(Iterable.CC.getAuthRequestContext(j, 3600L), 0L);
                case 7:
                    return plus(Iterable.CC.getAuthRequestContext(j, 43200L), 0L);
                case 8:
                    return plus(Iterable.CC.getAuthRequestContext(j, TimeUtils.DAY_TO_SECOND), 0L);
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
        }
        return (Instant) temporalUnit.addTo(this, j);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalQuery == Temporal.CC.MyBillsEntityDataFactory()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == Temporal.CC.getAuthRequestContext() || temporalQuery == Temporal.CC.moveToNextValue() || temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory() || temporalQuery == Temporal.CC.PlaceComponentResult()) {
            return null;
        }
        temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
        if (temporalQuery != temporalQueries$$ExternalSyntheticLambda0) {
            return temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        return null;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final long toEpochMilli() {
        long authRequestContext;
        int i;
        long j = this.seconds;
        if (j >= 0 || this.nanos <= 0) {
            authRequestContext = Iterable.CC.getAuthRequestContext(j, 1000L);
            i = this.nanos / DurationKt.NANOS_IN_MILLIS;
        } else {
            authRequestContext = Iterable.CC.getAuthRequestContext(j + 1, 1000L);
            i = (this.nanos / DurationKt.NANOS_IN_MILLIS) - 1000;
        }
        return Iterable.CC.BuiltInFictitiousFunctionClassFactory(authRequestContext, i);
    }

    public final String toString() {
        return DateTimeFormatter.getAuthRequestContext.MyBillsEntityDataFactory(this);
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant from = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.MyBillsEntityDataFactory[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(Iterable.CC.MyBillsEntityDataFactory(from.seconds, this.seconds), 1000000000L), from.nanos - this.nanos);
                case 2:
                    return Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(Iterable.CC.MyBillsEntityDataFactory(from.seconds, this.seconds), 1000000000L), from.nanos - this.nanos) / 1000;
                case 3:
                    return Iterable.CC.MyBillsEntityDataFactory(from.toEpochMilli(), toEpochMilli());
                case 4:
                    return secondsUntil(from);
                case 5:
                    return secondsUntil(from) / 60;
                case 6:
                    return secondsUntil(from) / 3600;
                case 7:
                    return secondsUntil(from) / 43200;
                case 8:
                    return secondsUntil(from) / TimeUtils.DAY_TO_SECOND;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsupported unit: ");
                    sb.append(temporalUnit);
                    throw new UnsupportedTemporalTypeException(sb.toString());
            }
        }
        return temporalUnit.between(this, from);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 != r2.nanos) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r4 != r2.nanos) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r0 = r2.seconds;
     */
    @Override // j$.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.temporal.Temporal with(long r3, j$.time.temporal.TemporalField r5) {
        /*
            r2 = this;
            boolean r0 = r5 instanceof j$.time.temporal.ChronoField
            if (r0 == 0) goto L5d
            r0 = r5
            j$.time.temporal.ChronoField r0 = (j$.time.temporal.ChronoField) r0
            r0.checkValidValue(r3)
            int[] r1 = j$.time.Instant.AnonymousClass1.BuiltInFictitiousFunctionClassFactory
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L4c
            r1 = 2
            if (r0 == r1) goto L42
            r1 = 3
            if (r0 == r1) goto L37
            r1 = 4
            if (r0 != r1) goto L2b
            long r0 = r2.seconds
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L5b
            int r5 = r2.nanos
            j$.time.Instant r3 = create(r3, r5)
            goto L63
        L2b:
            java.lang.String r3 = "Unsupported field: "
            java.lang.String r3 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory(r3, r5)
            j$.time.temporal.UnsupportedTemporalTypeException r4 = new j$.time.temporal.UnsupportedTemporalTypeException
            r4.<init>(r3)
            throw r4
        L37:
            int r4 = (int) r3
            r3 = 1000000(0xf4240, float:1.401298E-39)
            int r4 = r4 * r3
            int r3 = r2.nanos
            if (r4 == r3) goto L5b
            goto L49
        L42:
            int r4 = (int) r3
            int r4 = r4 * 1000
            int r3 = r2.nanos
            if (r4 == r3) goto L5b
        L49:
            long r0 = r2.seconds
            goto L56
        L4c:
            int r5 = r2.nanos
            long r0 = (long) r5
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 == 0) goto L5b
            long r0 = r2.seconds
            int r4 = (int) r3
        L56:
            j$.time.Instant r3 = create(r0, r4)
            goto L63
        L5b:
            r3 = r2
            goto L63
        L5d:
            j$.time.temporal.Temporal r3 = r5.adjustInto(r2, r3)
            j$.time.Instant r3 = (j$.time.Instant) r3
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.with(long, j$.time.temporal.TemporalField):j$.time.temporal.Temporal");
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (Instant) Era.CC.getAuthRequestContext(localDate, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }
}
