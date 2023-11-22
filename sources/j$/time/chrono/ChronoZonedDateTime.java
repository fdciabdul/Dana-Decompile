package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalField;

/* loaded from: classes6.dex */
public interface ChronoZonedDateTime extends Temporal, Comparable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.ChronoZonedDateTime$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[ChronoField.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    Chronology getChronology();

    @Override // j$.time.temporal.TemporalAccessor
    long getLong(TemporalField temporalField);

    ZoneOffset getOffset();

    ZoneId getZone();

    long toEpochSecond();

    ChronoLocalDate toLocalDate();

    ChronoLocalDateTime toLocalDateTime();

    LocalTime toLocalTime();

    ChronoZonedDateTime withZoneSameInstant(ZoneOffset zoneOffset);

    ChronoZonedDateTime withZoneSameLocal(ZoneId zoneId);
}
