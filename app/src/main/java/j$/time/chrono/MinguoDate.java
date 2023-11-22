package j$.time.chrono;

import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.Period;
import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes9.dex */
public final class MinguoDate extends ChronoLocalDateImpl {
    private static final long serialVersionUID = 1300372329181994526L;
    private final transient LocalDate isoDate;

    /* renamed from: j$.time.chrono.MinguoDate$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public MinguoDate(LocalDate localDate) {
        if (localDate == null) {
            throw new NullPointerException("isoDate");
        }
        this.isoDate = localDate;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private MinguoDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new MinguoDate(localDate);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            return this.isoDate.equals(((MinguoDate) obj).isoDate);
        }
        return false;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final Chronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final Era getEra() {
        return getProlepticYear() > 0 ? MinguoEra.ROC : MinguoEra.BEFORE_ROC;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoField) temporalField).ordinal()];
            if (i == 4) {
                int prolepticYear = getProlepticYear();
                if (prolepticYear <= 0) {
                    prolepticYear = 1 - prolepticYear;
                }
                return prolepticYear;
            } else if (i != 5) {
                if (i != 6) {
                    if (i != 7) {
                        return this.isoDate.getLong(temporalField);
                    }
                    return getProlepticYear() <= 0 ? 0 : 1;
                }
                return getProlepticYear();
            } else {
                return ((getProlepticYear() * 12) + this.isoDate.getMonthValue()) - 1;
            }
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        MinguoChronology minguoChronology = MinguoChronology.INSTANCE;
        return this.isoDate.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate minus(long j, ChronoUnit chronoUnit) {
        return (MinguoDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return (MinguoDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate plus(Period period) {
        return (MinguoDate) super.plus(period);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final Temporal plus(long j, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j, temporalUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    final ChronoLocalDate plusDays(long j) {
        return with(this.isoDate.plusDays(j));
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    final ChronoLocalDate plusMonths(long j) {
        return with(this.isoDate.plusMonths(j));
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl
    final ChronoLocalDate plusYears(long j) {
        return with(this.isoDate.plusYears(j));
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (Era.CC.PlaceComponentResult(this, temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[chronoField.ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return this.isoDate.range(temporalField);
                }
                if (i != 4) {
                    return MinguoChronology.INSTANCE.range(chronoField);
                }
                ValueRange range = ChronoField.YEAR.range();
                return ValueRange.of(1L, getProlepticYear() <= 0 ? (-range.getMinimum()) + 1 + 1911 : range.getMaximum() - 1911);
            }
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) super.with(temporalAdjuster);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0022, code lost:
    
        if (r2 != 7) goto L54;
     */
    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final j$.time.chrono.MinguoDate with(long r8, j$.time.temporal.TemporalField r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.ChronoField
            if (r0 == 0) goto La7
            r0 = r10
            j$.time.temporal.ChronoField r0 = (j$.time.temporal.ChronoField) r0
            long r1 = r7.getLong(r0)
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.MinguoDate.AnonymousClass1.BuiltInFictitiousFunctionClassFactory
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L4e
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L4e
            if (r2 == r3) goto L4e
            goto L64
        L25:
            j$.time.chrono.MinguoChronology r10 = j$.time.chrono.MinguoChronology.INSTANCE
            j$.time.temporal.ValueRange r10 = r10.range(r0)
            r10.checkValidValue(r8, r0)
            int r10 = r7.getProlepticYear()
            long r0 = (long) r10
            j$.time.LocalDate r10 = r7.isoDate
            int r10 = r10.getMonthValue()
            long r2 = (long) r10
            j$.time.LocalDate r10 = r7.isoDate
            r4 = 12
            long r0 = r0 * r4
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.LocalDate r8 = r10.plusMonths(r8)
            j$.time.chrono.MinguoDate r8 = r7.with(r8)
            return r8
        L4e:
            j$.time.chrono.MinguoChronology r2 = j$.time.chrono.MinguoChronology.INSTANCE
            j$.time.temporal.ValueRange r2 = r2.range(r0)
            int r2 = r2.checkValidIntValue(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L8f
            if (r0 == r4) goto L82
            if (r0 == r3) goto L6f
        L64:
            j$.time.LocalDate r0 = r7.isoDate
            j$.time.LocalDate r8 = r0.with(r8, r10)
            j$.time.chrono.MinguoDate r8 = r7.with(r8)
            return r8
        L6f:
            j$.time.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            int r9 = 1 - r9
            int r9 = r9 + 1911
            j$.time.LocalDate r8 = r8.withYear(r9)
            j$.time.chrono.MinguoDate r8 = r7.with(r8)
            return r8
        L82:
            j$.time.LocalDate r8 = r7.isoDate
            int r2 = r2 + 1911
            j$.time.LocalDate r8 = r8.withYear(r2)
            j$.time.chrono.MinguoDate r8 = r7.with(r8)
            return r8
        L8f:
            j$.time.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            if (r9 <= 0) goto L9a
            int r2 = r2 + 1911
            goto L9e
        L9a:
            int r9 = 1 - r2
            int r2 = r9 + 1911
        L9e:
            j$.time.LocalDate r8 = r8.withYear(r2)
            j$.time.chrono.MinguoDate r8 = r7.with(r8)
            return r8
        La7:
            j$.time.chrono.ChronoLocalDate r8 = super.with(r8, r10)
            j$.time.chrono.MinguoDate r8 = (j$.time.chrono.MinguoDate) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.MinguoDate.with(long, j$.time.temporal.TemporalField):j$.time.chrono.MinguoDate");
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (MinguoDate) super.with((TemporalAdjuster) localDate);
    }
}
