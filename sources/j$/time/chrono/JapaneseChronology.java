package j$.time.chrono;

import j$.lang.Iterable;
import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes9.dex */
public final class JapaneseChronology extends AbstractChronology implements Serializable {
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();
    private static final long serialVersionUID = 459996390165777884L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.chrono.JapaneseChronology$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[ChronoField.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.YEAR_OF_ERA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.DAY_OF_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoField.ERA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private JapaneseChronology() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(int i, int i2, int i3) {
        return new JapaneseDate(LocalDate.of(i, i2, i3));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate date(TemporalAccessor temporalAccessor) {
        return temporalAccessor instanceof JapaneseDate ? (JapaneseDate) temporalAccessor : new JapaneseDate(LocalDate.from(temporalAccessor));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateEpochDay(long j) {
        return new JapaneseDate(LocalDate.ofEpochDay(j));
    }

    @Override // j$.time.chrono.AbstractChronology
    public final ChronoLocalDate dateNow() {
        return new JapaneseDate(LocalDate.from(LocalDate.now(Clock.systemDefaultZone())));
    }

    @Override // j$.time.chrono.Chronology
    public final ChronoLocalDate dateYearDay(int i, int i2) {
        return new JapaneseDate(LocalDate.ofYearDay(i, i2));
    }

    @Override // j$.time.chrono.Chronology
    public final Era eraOf(int i) {
        return JapaneseEra.of(i);
    }

    @Override // j$.time.chrono.Chronology
    public final List eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // j$.time.chrono.Chronology
    public final String getCalendarType() {
        return "japanese";
    }

    @Override // j$.time.chrono.Chronology
    public final String getId() {
        return "Japanese";
    }

    @Override // j$.time.chrono.Chronology
    public final boolean isLeapYear(long j) {
        return IsoChronology.INSTANCE.isLeapYear(j);
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        return super.localDateTime(temporalAccessor);
    }

    @Override // j$.time.chrono.Chronology
    public final int prolepticYear(Era era, int i) {
        if (era instanceof JapaneseEra) {
            JapaneseEra japaneseEra = (JapaneseEra) era;
            int year = (japaneseEra.getSince().getYear() + i) - 1;
            if (i == 1) {
                return year;
            }
            if (year < -999999999 || year > 999999999 || year < japaneseEra.getSince().getYear() || era != JapaneseEra.from(LocalDate.of(year, 1, 1))) {
                throw new DateTimeException("Invalid yearOfEra value");
            }
            return year;
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // j$.time.chrono.Chronology
    public final ValueRange range(ChronoField chronoField) {
        ValueRange of;
        ValueRange of2;
        switch (AnonymousClass1.BuiltInFictitiousFunctionClassFactory[chronoField.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported field: ");
                sb.append(chronoField);
                throw new UnsupportedTemporalTypeException(sb.toString());
            case 5:
                of = ValueRange.of(1L, JapaneseEra.shortestYearsOfEra(), 999999999 - JapaneseEra.getCurrentEra().getSince().getYear());
                return of;
            case 6:
                of2 = ValueRange.of(1L, JapaneseEra.shortestDaysOfYear(), ChronoField.DAY_OF_YEAR.range().getMaximum());
                return of2;
            case 7:
                return ValueRange.of(JapaneseDate.MEIJI_6_ISODATE.getYear(), 999999999L);
            case 8:
                return ValueRange.of(JapaneseEra.MEIJI.getValue(), JapaneseEra.getCurrentEra().getValue());
            default:
                return chronoField.range();
        }
    }

    @Override // j$.time.chrono.AbstractChronology, j$.time.chrono.Chronology
    public final ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle) {
        return (JapaneseDate) super.resolveDate(hashMap, resolverStyle);
    }

    @Override // j$.time.chrono.AbstractChronology
    final ChronoLocalDate resolveYearOfEra(HashMap hashMap, ResolverStyle resolverStyle) {
        JapaneseDate with;
        ChronoField chronoField = ChronoField.ERA;
        Long l = (Long) hashMap.get(chronoField);
        JapaneseEra of = l != null ? JapaneseEra.of(range(chronoField).checkValidIntValue(l.longValue(), chronoField)) : null;
        ChronoField chronoField2 = ChronoField.YEAR_OF_ERA;
        Long l2 = (Long) hashMap.get(chronoField2);
        int checkValidIntValue = l2 != null ? range(chronoField2).checkValidIntValue(l2.longValue(), chronoField2) : 0;
        int i = 1;
        if (of == null && l2 != null && !hashMap.containsKey(ChronoField.YEAR) && resolverStyle != ResolverStyle.STRICT) {
            of = JapaneseEra.values()[JapaneseEra.values().length - 1];
        }
        if (l2 != null && of != null) {
            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
            if (hashMap.containsKey(chronoField3)) {
                ChronoField chronoField4 = ChronoField.DAY_OF_MONTH;
                if (hashMap.containsKey(chronoField4)) {
                    hashMap.remove(chronoField);
                    hashMap.remove(chronoField2);
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return new JapaneseDate(LocalDate.of((of.getSince().getYear() + checkValidIntValue) - 1, 1, 1)).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField3)).longValue(), 1L), (TemporalUnit) ChronoUnit.MONTHS).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField4)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue2 = range(chronoField3).checkValidIntValue(((Long) hashMap.remove(chronoField3)).longValue(), chronoField3);
                    int checkValidIntValue3 = range(chronoField4).checkValidIntValue(((Long) hashMap.remove(chronoField4)).longValue(), chronoField4);
                    if (resolverStyle != ResolverStyle.SMART) {
                        LocalDate localDate = JapaneseDate.MEIJI_6_ISODATE;
                        LocalDate of2 = LocalDate.of((of.getSince().getYear() + checkValidIntValue) - 1, checkValidIntValue2, checkValidIntValue3);
                        if (of2.isBefore(of.getSince()) || of != JapaneseEra.from(of2)) {
                            throw new DateTimeException("year, month, and day not valid for Era");
                        }
                        return new JapaneseDate(of, checkValidIntValue, of2);
                    } else if (checkValidIntValue <= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid YearOfEra: ");
                        sb.append(checkValidIntValue);
                        throw new DateTimeException(sb.toString());
                    } else {
                        int year = (of.getSince().getYear() + checkValidIntValue) - 1;
                        try {
                            with = new JapaneseDate(LocalDate.of(year, checkValidIntValue2, checkValidIntValue3));
                        } catch (DateTimeException unused) {
                            with = new JapaneseDate(LocalDate.of(year, checkValidIntValue2, 1)).with((TemporalAdjuster) new TemporalQueries$$ExternalSyntheticLambda0(i));
                        }
                        if (with.getEra() == of || Temporal.CC.BuiltInFictitiousFunctionClassFactory(with, ChronoField.YEAR_OF_ERA) <= 1 || checkValidIntValue <= 1) {
                            return with;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid YearOfEra for Era: ");
                        sb2.append(of);
                        sb2.append(" ");
                        sb2.append(checkValidIntValue);
                        throw new DateTimeException(sb2.toString());
                    }
                }
            }
            ChronoField chronoField5 = ChronoField.DAY_OF_YEAR;
            if (hashMap.containsKey(chronoField5)) {
                hashMap.remove(chronoField);
                hashMap.remove(chronoField2);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return new JapaneseDate(LocalDate.ofYearDay((of.getSince().getYear() + checkValidIntValue) - 1, 1)).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField5)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                }
                int checkValidIntValue4 = range(chronoField5).checkValidIntValue(((Long) hashMap.remove(chronoField5)).longValue(), chronoField5);
                LocalDate localDate2 = JapaneseDate.MEIJI_6_ISODATE;
                int year2 = of.getSince().getYear();
                LocalDate ofYearDay = checkValidIntValue == 1 ? LocalDate.ofYearDay(year2, (of.getSince().getDayOfYear() + checkValidIntValue4) - 1) : LocalDate.ofYearDay((year2 + checkValidIntValue) - 1, checkValidIntValue4);
                if (ofYearDay.isBefore(of.getSince()) || of != JapaneseEra.from(ofYearDay)) {
                    throw new DateTimeException("Invalid parameters");
                }
                return new JapaneseDate(of, checkValidIntValue, ofYearDay);
            }
        }
        return null;
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
