package j$.time;

import com.alibaba.wireless.security.SecExceptionCode;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import j$.time.zone.ZoneRules;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes6.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset> {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id  reason: collision with root package name */
    private final transient String f8259id;
    private final int totalSeconds;
    private static final ConcurrentHashMap SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentHashMap ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    public static final ZoneOffset MAX = ofTotalSeconds(64800);

    private ZoneOffset(int i) {
        String obj;
        this.totalSeconds = i;
        if (i == 0) {
            obj = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = abs / 3600;
            int i3 = (abs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            sb.append(i3 < 10 ? ":0" : ":");
            sb.append(i3);
            int i4 = abs % 60;
            if (i4 != 0) {
                sb.append(i4 < 10 ? ":0" : ":");
                sb.append(i4);
            }
            obj = sb.toString();
        }
        this.f8259id = obj;
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor != null) {
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(Temporal.CC.BuiltInFictitiousFunctionClassFactory());
            if (zoneOffset != null) {
                return zoneOffset;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to obtain ZoneOffset from TemporalAccessor: ");
            sb.append(temporalAccessor);
            sb.append(" of type ");
            sb.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(sb.toString());
        }
        throw new NullPointerException("temporal");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static j$.time.ZoneOffset of(java.lang.String r7) {
        /*
            if (r7 == 0) goto Lbf
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.ID_CACHE
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto Ld
            return r0
        Ld:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6a
            r1 = 3
            if (r0 == r1) goto L86
            r4 = 5
            if (r0 == r4) goto L61
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L58
            r5 = 7
            if (r0 == r5) goto L4b
            r1 = 9
            if (r0 != r1) goto L34
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            int r2 = parseNumber(r7, r5, r2)
            goto L8c
        L34:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            r0.append(r1)
            r0.append(r7)
            j$.time.DateTimeException r7 = new j$.time.DateTimeException
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L4b:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            int r2 = parseNumber(r7, r4, r3)
            goto L8c
        L58:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            goto L8b
        L61:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            goto L8b
        L6a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L86:
            int r0 = parseNumber(r7, r2, r3)
            r1 = 0
        L8b:
            r2 = 0
        L8c:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb0
            if (r3 != r5) goto L99
            goto Lb0
        L99:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r0.append(r1)
            r0.append(r7)
            j$.time.DateTimeException r7 = new j$.time.DateTimeException
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        Lb0:
            if (r3 != r5) goto Lba
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = ofHoursMinutesSeconds(r7, r0, r1)
            return r7
        Lba:
            j$.time.ZoneOffset r7 = ofHoursMinutesSeconds(r0, r1, r2)
            return r7
        Lbf:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "offsetId"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.of(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset ofHours(int i) {
        return ofHoursMinutesSeconds(i, 0, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            StringBuilder sb = new StringBuilder();
            sb.append("Zone offset hours not in valid range: value ");
            sb.append(i);
            sb.append(" is not in the range -18 to 18");
            throw new DateTimeException(sb.toString());
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Zone offset minutes not in valid range: value ");
            sb2.append(i2);
            sb2.append(" is not in the range -59 to 59");
            throw new DateTimeException(sb2.toString());
        } else if (i3 >= -59 && i3 <= 59) {
            if (Math.abs(i) != 18 || (i2 | i3) == 0) {
                return ofTotalSeconds((i2 * 60) + (i * 3600) + i3);
            }
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Zone offset seconds not in valid range: value ");
            sb3.append(i3);
            sb3.append(" is not in the range -59 to 59");
            throw new DateTimeException(sb3.toString());
        }
    }

    public static ZoneOffset ofTotalSeconds(int i) {
        if (i < -64800 || i > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % SecExceptionCode.SEC_ERROR_UMID_VALID == 0) {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentHashMap concurrentHashMap = SECONDS_CACHE;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset == null) {
                concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i));
                ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
                ID_CACHE.putIfAbsent(zoneOffset2.f8259id, zoneOffset2);
                return zoneOffset2;
            }
            return zoneOffset;
        }
        return new ZoneOffset(i);
    }

    private static int parseNumber(CharSequence charSequence, int i, boolean z) {
        if (z && charSequence.charAt(i - 1) != ':') {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ID for ZoneOffset, colon not found when expected: ");
            sb.append((Object) charSequence);
            throw new DateTimeException(sb.toString());
        }
        char charAt = charSequence.charAt(i);
        char charAt2 = charSequence.charAt(i + 1);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid ID for ZoneOffset, non numeric characters found: ");
            sb2.append((Object) charSequence);
            throw new DateTimeException(sb2.toString());
        }
        return (charAt2 - '0') + ((charAt - '0') * 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffset readExternal(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(this.totalSeconds, ChronoField.OFFSET_SECONDS);
    }

    /* renamed from: compareTo  reason: avoid collision after fix types in other method */
    public final int compareTo2(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f8259id;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.ZoneId
    public final ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public final int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.totalSeconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return (temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory() || temporalQuery == Temporal.CC.getErrorConfigVersion()) ? this : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f8259id;
    }

    @Override // j$.time.ZoneId
    final void write(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        int i = this.totalSeconds;
        int i2 = i % SecExceptionCode.SEC_ERROR_UMID_VALID == 0 ? i / SecExceptionCode.SEC_ERROR_UMID_VALID : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }
}
