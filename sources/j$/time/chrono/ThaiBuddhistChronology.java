package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes9.dex */
public final class ThaiBuddhistChronology extends AbstractChronology implements Serializable {
    public static final ThaiBuddhistChronology INSTANCE = new ThaiBuddhistChronology();
    private static final long serialVersionUID = 2775954514031616474L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.ThaiBuddhistChronology$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[ChronoField.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[ChronoField.PROLEPTIC_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoField.YEAR_OF_ERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[ChronoField.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    private ThaiBuddhistChronology() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(int i, int i2, int i3) {
        return new ThaiBuddhistDate(LocalDate.of(i - 543, i2, i3));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof ThaiBuddhistDate ? (ThaiBuddhistDate) temporalAccessor : new ThaiBuddhistDate(LocalDate.from(temporalAccessor));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateEpochDay(long j) {
        return new ThaiBuddhistDate(LocalDate.ofEpochDay(j));
    }

    @Override // j$.time.chrono.AbstractChronology
    public final ChronoLocalDate dateNow() {
        return new ThaiBuddhistDate(LocalDate.from(LocalDate.now(Clock.systemDefaultZone())));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateYearDay(int i, int i2) {
        return new ThaiBuddhistDate(LocalDate.ofYearDay(i - 543, i2));
    }

    @Override // j$.time.chrono.Chronology
    public final Era eraOf(int i) {
        if (i != 0) {
            if (i == 1) {
                return ThaiBuddhistEra.BE;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid era: ");
            sb.append(i);
            throw new DateTimeException(sb.toString());
        }
        return ThaiBuddhistEra.BEFORE_BE;
    }

    @Override // j$.time.chrono.Chronology
    public final List eras() {
        return Arrays.asList(ThaiBuddhistEra.values());
    }

    @Override // j$.time.chrono.Chronology
    public final String getCalendarType() {
        return "buddhist";
    }

    @Override // j$.time.chrono.Chronology
    public final String getId() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.Chronology
    public final boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j - 543);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public final int prolepticYear(Era era, int i) {
        if (era instanceof ThaiBuddhistEra) {
            return era != ThaiBuddhistEra.BE ? 1 - i : i;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    @Override // j$.time.chrono.Chronology
    public final ValueRange range(ChronoField chronoField) {
        ValueRange of;
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[chronoField.ordinal()];
        if (i == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.of(range.getMinimum() + 6516, range.getMaximum() + 6516);
        } else if (i == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            of = ValueRange.of(1L, (-(range2.getMinimum() + 543)) + 1, range2.getMaximum() + 543);
            return of;
        } else if (i != 3) {
            return chronoField.range();
        } else {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.of(range3.getMinimum() + 543, range3.getMaximum() + 543);
        }
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle) {
        return (ThaiBuddhistDate) super.resolveDate(hashMap, resolverStyle);
    }

    final Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        return super.zonedDateTime(temporalAccessor);
    }
}
