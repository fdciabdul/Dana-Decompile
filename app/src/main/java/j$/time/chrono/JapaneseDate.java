package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.Period;
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
public final class JapaneseDate extends ChronoLocalDateImpl {
    static final LocalDate MEIJI_6_ISODATE = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final transient LocalDate isoDate;
    private transient int yearOfEra;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.JapaneseDate$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[ChronoField.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[ChronoField.YEAR_OF_ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[ChronoField.ERA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                getAuthRequestContext[ChronoField.YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JapaneseDate(LocalDate localDate) {
        if (localDate.isBefore(MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.era = JapaneseEra.from(localDate);
        this.yearOfEra = (localDate.getYear() - this.era.getSince().getYear()) + 1;
        this.isoDate = localDate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JapaneseDate(JapaneseEra japaneseEra, int i, LocalDate localDate) {
        if (localDate.isBefore(MEIJI_6_ISODATE)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.era = japaneseEra;
        this.yearOfEra = i;
        this.isoDate = localDate;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
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
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final Chronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final Era getEra() {
        return this.era;
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final JapaneseEra getEra() {
        return this.era;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            switch (AnonymousClass1.getAuthRequestContext[((ChronoField) temporalField).ordinal()]) {
                case 2:
                    return this.yearOfEra == 1 ? (this.isoDate.getDayOfYear() - this.era.getSince().getDayOfYear()) + 1 : this.isoDate.getDayOfYear();
                case 3:
                    return this.yearOfEra;
                case 4:
                case 5:
                case 6:
                case 7:
                    throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
                case 8:
                    return this.era.getValue();
                default:
                    return this.isoDate.getLong(temporalField);
            }
        }
        return temporalField.getFrom(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        JapaneseChronology japaneseChronology = JapaneseChronology.INSTANCE;
        return this.isoDate.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return temporalField instanceof ChronoField ? temporalField.isDateBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final int lengthOfYear() {
        JapaneseEra next = this.era.next();
        int lengthOfYear = (next == null || next.getSince().getYear() != this.isoDate.getYear()) ? this.isoDate.lengthOfYear() : next.getSince().getDayOfYear() - 1;
        return this.yearOfEra == 1 ? lengthOfYear - (this.era.getSince().getDayOfYear() - 1) : lengthOfYear;
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate minus(long j, ChronoUnit chronoUnit) {
        return (JapaneseDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return (JapaneseDate) super.minus(j, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate plus(Period period) {
        return (JapaneseDate) super.plus(period);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final JapaneseDate plus(long j, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j, temporalUnit);
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
        int lengthOfMonth;
        long j;
        if (temporalField instanceof ChronoField) {
            if (isSupported(temporalField)) {
                ChronoField chronoField = (ChronoField) temporalField;
                int i = AnonymousClass1.getAuthRequestContext[chronoField.ordinal()];
                if (i == 1) {
                    lengthOfMonth = this.isoDate.lengthOfMonth();
                } else if (i != 2) {
                    if (i != 3) {
                        return JapaneseChronology.INSTANCE.range(chronoField);
                    }
                    int year = this.era.getSince().getYear();
                    JapaneseEra next = this.era.next();
                    j = next != null ? (next.getSince().getYear() - year) + 1 : 999999999 - year;
                    return ValueRange.of(1L, j);
                } else {
                    lengthOfMonth = lengthOfYear();
                }
                j = lengthOfMonth;
                return ValueRange.of(1L, j);
            }
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    public final JapaneseDate with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            if (getLong(chronoField) == j) {
                return this;
            }
            int[] iArr = AnonymousClass1.getAuthRequestContext;
            int i = iArr[chronoField.ordinal()];
            if (i == 3 || i == 8 || i == 9) {
                JapaneseChronology japaneseChronology = JapaneseChronology.INSTANCE;
                int checkValidIntValue = japaneseChronology.range(chronoField).checkValidIntValue(j, chronoField);
                int i2 = iArr[chronoField.ordinal()];
                if (i2 == 3) {
                    return with(this.isoDate.withYear(japaneseChronology.prolepticYear(this.era, checkValidIntValue)));
                } else if (i2 == 8) {
                    return with(this.isoDate.withYear(japaneseChronology.prolepticYear(JapaneseEra.of(checkValidIntValue), this.yearOfEra)));
                } else if (i2 == 9) {
                    return with(this.isoDate.withYear(checkValidIntValue));
                }
            }
            return with(this.isoDate.with(j, temporalField));
        }
        return (JapaneseDate) super.with(j, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.chrono.ChronoLocalDate
    public final JapaneseDate with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.with(temporalAdjuster);
    }

    @Override // j$.time.chrono.ChronoLocalDateImpl, j$.time.temporal.Temporal
    /* renamed from: with  reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Temporal mo3168with(LocalDate localDate) {
        return with((TemporalAdjuster) localDate);
    }
}
