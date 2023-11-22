package j$.time.zone;

import com.alibaba.wireless.security.SecExceptionCode;
import id.dana.domain.featureconfig.model.UgcConfig;
import j$.time.DayOfWeek;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.LocalTime;
import j$.time.Month;
import j$.time.ZoneOffset;
import j$.time.chrono.IsoChronology;
import j$.time.format.SignStyle$EnumUnboxingLocalUtility;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda3;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes6.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final int timeDefinition;
    private final boolean timeEndOfDay;

    /* renamed from: j$.time.zone.ZoneOffsetTransitionRule$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[SignStyle$EnumUnboxingLocalUtility.KClassImpl$Data$declaredNonStaticMembers$2(3).length];
            PlaceComponentResult = iArr;
            try {
                iArr[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(1)] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(3)] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    ZoneOffsetTransitionRule(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, int i2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month;
        this.dom = (byte) i;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.timeEndOfDay = z;
        this.timeDefinition = i2;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneOffsetTransitionRule readExternal(DataInput dataInput) {
        int readInt = dataInput.readInt();
        Month of = Month.of(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        DayOfWeek of2 = i2 == 0 ? null : DayOfWeek.of(i2);
        int i3 = (507904 & readInt) >>> 14;
        int i4 = SignStyle$EnumUnboxingLocalUtility.KClassImpl$Data$declaredNonStaticMembers$2(3)[(readInt & 12288) >>> 12];
        int i5 = (readInt & 4080) >>> 4;
        int i6 = (readInt & 12) >>> 2;
        int i7 = readInt & 3;
        LocalTime ofSecondOfDay = i3 == 31 ? LocalTime.ofSecondOfDay(dataInput.readInt()) : LocalTime.of(i3 % 24);
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i5 == 255 ? dataInput.readInt() : (i5 - 128) * SecExceptionCode.SEC_ERROR_UMID_VALID);
        ZoneOffset ofTotalSeconds2 = i6 == 3 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i6 * 1800) + ofTotalSeconds.getTotalSeconds());
        ZoneOffset ofTotalSeconds3 = i7 == 3 ? ZoneOffset.ofTotalSeconds(dataInput.readInt()) : ZoneOffset.ofTotalSeconds((i7 * 1800) + ofTotalSeconds.getTotalSeconds());
        boolean z = i3 == 24;
        if (of != null) {
            if (ofSecondOfDay != null) {
                if (i4 != 0) {
                    if (i < -28 || i > 31 || i == 0) {
                        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
                    }
                    if (!z || ofSecondOfDay.equals(LocalTime.MIDNIGHT)) {
                        return new ZoneOffsetTransitionRule(of, i, of2, ofSecondOfDay, z, i4, ofTotalSeconds, ofTotalSeconds2, ofTotalSeconds3);
                    }
                    throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
                }
                throw new NullPointerException("timeDefnition");
            }
            throw new NullPointerException("time");
        }
        throw new NullPointerException("month");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public final ZoneOffsetTransition createTransition(int i) {
        LocalDate of;
        TemporalAdjusters$$ExternalSyntheticLambda3 temporalAdjusters$$ExternalSyntheticLambda3;
        int totalSeconds;
        int totalSeconds2;
        byte b = this.dom;
        int i2 = 1;
        if (b < 0) {
            Month month = this.month;
            of = LocalDate.of(i, month, month.length(IsoChronology.INSTANCE.isLeapYear(i)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                temporalAdjusters$$ExternalSyntheticLambda3 = new TemporalAdjusters$$ExternalSyntheticLambda3(dayOfWeek.getValue(), 0);
                of = of.with((TemporalAdjuster) temporalAdjusters$$ExternalSyntheticLambda3);
            }
        } else {
            of = LocalDate.of(i, this.month, b);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                temporalAdjusters$$ExternalSyntheticLambda3 = new TemporalAdjusters$$ExternalSyntheticLambda3(dayOfWeek2.getValue(), i2);
                of = of.with((TemporalAdjuster) temporalAdjusters$$ExternalSyntheticLambda3);
            }
        }
        if (this.timeEndOfDay) {
            of = of.plusDays(1L);
        }
        LocalDateTime of2 = LocalDateTime.of(of, this.time);
        int i3 = this.timeDefinition;
        ZoneOffset zoneOffset = this.standardOffset;
        ZoneOffset zoneOffset2 = this.offsetBefore;
        if (i3 != 0) {
            int i4 = AnonymousClass1.PlaceComponentResult[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(i3)];
            if (i4 != 1) {
                if (i4 == 2) {
                    totalSeconds = zoneOffset2.getTotalSeconds();
                    totalSeconds2 = zoneOffset.getTotalSeconds();
                }
                return new ZoneOffsetTransition(of2, this.offsetBefore, this.offsetAfter);
            }
            totalSeconds = zoneOffset2.getTotalSeconds();
            totalSeconds2 = ZoneOffset.UTC.getTotalSeconds();
            of2 = of2.plusSeconds(totalSeconds - totalSeconds2);
            return new ZoneOffsetTransition(of2, this.offsetBefore, this.offsetAfter);
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ZoneOffsetTransitionRule) {
            ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
            return this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.time.equals(zoneOffsetTransitionRule.time) && this.timeEndOfDay == zoneOffsetTransitionRule.timeEndOfDay && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter);
        }
        return false;
    }

    public final int hashCode() {
        int secondOfDay = this.time.toSecondOfDay();
        boolean z = this.timeEndOfDay;
        int ordinal = this.month.ordinal();
        byte b = this.dom;
        DayOfWeek dayOfWeek = this.dow;
        return ((this.standardOffset.hashCode() ^ (SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(this.timeDefinition) + (((((secondOfDay + (z ? 1 : 0)) << 15) + (ordinal << 11)) + ((b + 32) << 5)) + ((dayOfWeek == null ? 7 : dayOfWeek.ordinal()) << 2)))) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            r3 = this;
            java.lang.String r0 = "TransitionRule["
            java.lang.StringBuilder r0 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult(r0)
            j$.time.ZoneOffset r1 = r3.offsetBefore
            j$.time.ZoneOffset r2 = r3.offsetAfter
            int r1 = r1.compareTo2(r2)
            if (r1 <= 0) goto L13
            java.lang.String r1 = "Gap "
            goto L15
        L13:
            java.lang.String r1 = "Overlap "
        L15:
            r0.append(r1)
            j$.time.ZoneOffset r1 = r3.offsetBefore
            r0.append(r1)
            java.lang.String r1 = " to "
            r0.append(r1)
            j$.time.ZoneOffset r1 = r3.offsetAfter
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            j$.time.DayOfWeek r1 = r3.dow
            if (r1 == 0) goto L62
            byte r2 = r3.dom
            java.lang.String r1 = r1.name()
            r0.append(r1)
            r1 = -1
            if (r2 != r1) goto L3f
            java.lang.String r1 = " on or before last day of "
            goto L50
        L3f:
            if (r2 >= 0) goto L5d
            java.lang.String r1 = " on or before last day minus "
            r0.append(r1)
            byte r1 = r3.dom
            int r1 = -r1
            int r1 = r1 + (-1)
            r0.append(r1)
            java.lang.String r1 = " of "
        L50:
            r0.append(r1)
            j$.time.Month r1 = r3.month
            java.lang.String r1 = r1.name()
            r0.append(r1)
            goto L75
        L5d:
            java.lang.String r1 = " on or after "
            r0.append(r1)
        L62:
            j$.time.Month r1 = r3.month
            java.lang.String r1 = r1.name()
            r0.append(r1)
            r1 = 32
            r0.append(r1)
            byte r1 = r3.dom
            r0.append(r1)
        L75:
            java.lang.String r1 = " at "
            r0.append(r1)
            boolean r1 = r3.timeEndOfDay
            if (r1 == 0) goto L81
            java.lang.String r1 = "24:00"
            goto L87
        L81:
            j$.time.LocalTime r1 = r3.time
            java.lang.String r1 = r1.toString()
        L87:
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            int r1 = r3.timeDefinition
            java.lang.String r1 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory(r1)
            r0.append(r1)
            java.lang.String r1 = ", standard offset "
            r0.append(r1)
            j$.time.ZoneOffset r1 = r3.standardOffset
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.ZoneOffsetTransitionRule.toString():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeExternal(DataOutput dataOutput) {
        int secondOfDay = this.timeEndOfDay ? UgcConfig.DEFAULT_UGC_INTERVAL : this.time.toSecondOfDay();
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        int hour = secondOfDay % 3600 == 0 ? this.timeEndOfDay ? 24 : this.time.getHour() : 31;
        int i = totalSeconds % SecExceptionCode.SEC_ERROR_UMID_VALID == 0 ? (totalSeconds / SecExceptionCode.SEC_ERROR_UMID_VALID) + 128 : 255;
        int i2 = (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) ? totalSeconds2 / 1800 : 3;
        int i3 = (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) ? totalSeconds3 / 1800 : 3;
        DayOfWeek dayOfWeek = this.dow;
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + ((dayOfWeek == null ? 0 : dayOfWeek.getValue()) << 19) + (hour << 14) + (SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(this.timeDefinition) << 12) + (i << 4) + (i2 << 2) + i3);
        if (hour == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i2 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (i3 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }
}
