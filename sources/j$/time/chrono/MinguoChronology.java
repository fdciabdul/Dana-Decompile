package j$.time.chrono;

import com.alibaba.wireless.security.SecExceptionCode;
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
public final class MinguoChronology extends AbstractChronology implements Serializable {
    public static final MinguoChronology INSTANCE = new MinguoChronology();
    private static final long serialVersionUID = 1039765215346859963L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.MinguoChronology$1 */
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

    private MinguoChronology() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(int i, int i2, int i3) {
        return new MinguoDate(LocalDate.of(i + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND, i2, i3));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof MinguoDate ? (MinguoDate) temporalAccessor : new MinguoDate(LocalDate.from(temporalAccessor));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateEpochDay(long j) {
        return new MinguoDate(LocalDate.ofEpochDay(j));
    }

    @Override // j$.time.chrono.AbstractChronology
    public final ChronoLocalDate dateNow() {
        return new MinguoDate(LocalDate.from(LocalDate.now(Clock.systemDefaultZone())));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateYearDay(int i, int i2) {
        return new MinguoDate(LocalDate.ofYearDay(i + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND, i2));
    }

    @Override // j$.time.chrono.Chronology
    public final Era eraOf(int i) {
        if (i != 0) {
            if (i == 1) {
                return MinguoEra.ROC;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid era: ");
            sb.append(i);
            throw new DateTimeException(sb.toString());
        }
        return MinguoEra.BEFORE_ROC;
    }

    @Override // j$.time.chrono.Chronology
    public final List eras() {
        return Arrays.asList(MinguoEra.values());
    }

    @Override // j$.time.chrono.Chronology
    public final String getCalendarType() {
        return "roc";
    }

    @Override // j$.time.chrono.Chronology
    public final String getId() {
        return "Minguo";
    }

    @Override // j$.time.chrono.Chronology
    public final boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j + 1911);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public final int prolepticYear(Era era, int i) {
        if (era instanceof MinguoEra) {
            return era != MinguoEra.ROC ? 1 - i : i;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.Chronology
    public final ValueRange range(ChronoField chronoField) {
        ValueRange of;
        int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[chronoField.ordinal()];
        if (i == 1) {
            ValueRange range = ChronoField.PROLEPTIC_MONTH.range();
            return ValueRange.of(range.getMinimum() - 22932, range.getMaximum() - 22932);
        } else if (i == 2) {
            ValueRange range2 = ChronoField.YEAR.range();
            of = ValueRange.of(1L, range2.getMaximum() - 1911, (-range2.getMinimum()) + 1 + 1911);
            return of;
        } else if (i != 3) {
            return chronoField.range();
        } else {
            ValueRange range3 = ChronoField.YEAR.range();
            return ValueRange.of(range3.getMinimum() - 1911, range3.getMaximum() - 1911);
        }
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle) {
        return (MinguoDate) super.resolveDate(hashMap, resolverStyle);
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
