package j$.time.temporal;

import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import j$.lang.Iterable;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.Duration;
import j$.time.LocalDate;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.format.ResolverStyle;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class IsoFields {
    public static final TemporalField BuiltInFictitiousFunctionClassFactory;
    public static final TemporalField KClassImpl$Data$declaredNonStaticMembers$2;
    public static final TemporalField MyBillsEntityDataFactory;
    public static final TemporalUnit getAuthRequestContext;

    /* renamed from: j$.time.temporal.IsoFields$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Unit.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes6.dex */
    public abstract class Field implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES;
        public static final Field DAY_OF_QUARTER;
        private static final int[] QUARTER_DAYS;
        public static final Field QUARTER_OF_YEAR;
        public static final Field WEEK_BASED_YEAR;
        public static final Field WEEK_OF_WEEK_BASED_YEAR;

        static {
            Field field = new Field() { // from class: j$.time.temporal.IsoFields.Field.1
                @Override // j$.time.temporal.TemporalField
                public final Temporal adjustInto(Temporal temporal, long j) {
                    long from = getFrom(temporal);
                    range().checkValidValue(j, this);
                    ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                    return temporal.with((j - from) + temporal.getLong(chronoField), chronoField);
                }

                @Override // j$.time.temporal.TemporalField
                public final long getFrom(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }

                @Override // j$.time.temporal.TemporalField
                public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && Field.access$100(temporalAccessor);
                }

                @Override // j$.time.temporal.TemporalField
                public final ValueRange range() {
                    ValueRange of;
                    of = ValueRange.of(1L, 90L, 92L);
                    return of;
                }

                @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
                public final ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        long j = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                        if (j == 1) {
                            return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                        }
                        return j == 2 ? ValueRange.of(1L, 91L) : (j == 3 || j == 4) ? ValueRange.of(1L, 92L) : range();
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }

                @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
                public final TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                    LocalDate of;
                    long j;
                    ChronoField chronoField = ChronoField.YEAR;
                    Long l = (Long) hashMap.get(chronoField);
                    TemporalField temporalField = Field.QUARTER_OF_YEAR;
                    Long l2 = (Long) hashMap.get(temporalField);
                    if (l == null || l2 == null) {
                        return null;
                    }
                    int checkValidIntValue = chronoField.checkValidIntValue(l.longValue());
                    long longValue = ((Long) hashMap.get(Field.DAY_OF_QUARTER)).longValue();
                    Field.access$300(temporalAccessor);
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        of = LocalDate.of(checkValidIntValue, 1, 1).plusMonths(Iterable.CC.getAuthRequestContext(Iterable.CC.MyBillsEntityDataFactory(l2.longValue(), 1L), 3L));
                        j = Iterable.CC.MyBillsEntityDataFactory(longValue, 1L);
                    } else {
                        of = LocalDate.of(checkValidIntValue, ((temporalField.range().checkValidIntValue(l2.longValue(), temporalField) - 1) * 3) + 1, 1);
                        if (longValue < 1 || longValue > 90) {
                            (resolverStyle == ResolverStyle.STRICT ? rangeRefinedBy(of) : range()).checkValidValue(longValue, this);
                        }
                        j = longValue - 1;
                    }
                    hashMap.remove(this);
                    hashMap.remove(chronoField);
                    hashMap.remove(temporalField);
                    return of.plusDays(j);
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "DayOfQuarter";
                }
            };
            DAY_OF_QUARTER = field;
            Field field2 = new Field() { // from class: j$.time.temporal.IsoFields.Field.2
                @Override // j$.time.temporal.TemporalField
                public final Temporal adjustInto(Temporal temporal, long j) {
                    long from = getFrom(temporal);
                    range().checkValidValue(j, this);
                    ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                    return temporal.with(((j - from) * 3) + temporal.getLong(chronoField), chronoField);
                }

                @Override // j$.time.temporal.TemporalField
                public final long getFrom(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }

                @Override // j$.time.temporal.TemporalField
                public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.access$100(temporalAccessor);
                }

                @Override // j$.time.temporal.TemporalField
                public final ValueRange range() {
                    return ValueRange.of(1L, 4L);
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "QuarterOfYear";
                }
            };
            QUARTER_OF_YEAR = field2;
            Field field3 = new Field() { // from class: j$.time.temporal.IsoFields.Field.3
                @Override // j$.time.temporal.TemporalField
                public final Temporal adjustInto(Temporal temporal, long j) {
                    range().checkValidValue(j, this);
                    return temporal.plus(Iterable.CC.MyBillsEntityDataFactory(j, getFrom(temporal)), ChronoUnit.WEEKS);
                }

                @Override // j$.time.temporal.TemporalField
                public final long getFrom(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        return Field.access$500(LocalDate.from(temporalAccessor));
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }

                @Override // j$.time.temporal.TemporalField
                public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.access$100(temporalAccessor);
                }

                @Override // j$.time.temporal.TemporalField
                public final ValueRange range() {
                    ValueRange of;
                    of = ValueRange.of(1L, 52L, 53L);
                    return of;
                }

                @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
                public final ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        return Field.access$400(LocalDate.from(temporalAccessor));
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }

                @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
                public final TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                    LocalDate with;
                    long j;
                    LocalDate plusWeeks;
                    long j2;
                    TemporalField temporalField = Field.WEEK_BASED_YEAR;
                    Long l = (Long) hashMap.get(temporalField);
                    ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                    Long l2 = (Long) hashMap.get(chronoField);
                    if (l == null || l2 == null) {
                        return null;
                    }
                    int checkValidIntValue = temporalField.range().checkValidIntValue(l.longValue(), temporalField);
                    long longValue = ((Long) hashMap.get(Field.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                    Field.access$300(temporalAccessor);
                    LocalDate of = LocalDate.of(checkValidIntValue, 1, 4);
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        long longValue2 = l2.longValue();
                        if (longValue2 > 7) {
                            j2 = longValue2 - 1;
                            plusWeeks = of.plusWeeks(j2 / 7);
                        } else {
                            j = 1;
                            if (longValue2 < 1) {
                                plusWeeks = of.plusWeeks(Iterable.CC.MyBillsEntityDataFactory(longValue2, 7L) / 7);
                                j2 = longValue2 + 6;
                            }
                            with = of.plusWeeks(Iterable.CC.MyBillsEntityDataFactory(longValue, j)).with(longValue2, (TemporalField) chronoField);
                        }
                        of = plusWeeks;
                        j = 1;
                        longValue2 = (j2 % 7) + 1;
                        with = of.plusWeeks(Iterable.CC.MyBillsEntityDataFactory(longValue, j)).with(longValue2, (TemporalField) chronoField);
                    } else {
                        int checkValidIntValue2 = chronoField.checkValidIntValue(l2.longValue());
                        if (longValue < 1 || longValue > 52) {
                            (resolverStyle == ResolverStyle.STRICT ? Field.access$400(of) : range()).checkValidValue(longValue, this);
                        }
                        with = of.plusWeeks(longValue - 1).with(checkValidIntValue2, (TemporalField) chronoField);
                    }
                    hashMap.remove(this);
                    hashMap.remove(temporalField);
                    hashMap.remove(chronoField);
                    return with;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "WeekOfWeekBasedYear";
                }
            };
            WEEK_OF_WEEK_BASED_YEAR = field3;
            Field field4 = new Field() { // from class: j$.time.temporal.IsoFields.Field.4
                @Override // j$.time.temporal.TemporalField
                public final Temporal adjustInto(Temporal temporal, long j) {
                    if (isSupportedBy(temporal)) {
                        int checkValidIntValue = range().checkValidIntValue(j, Field.WEEK_BASED_YEAR);
                        LocalDate from = LocalDate.from(temporal);
                        int i = from.get(ChronoField.DAY_OF_WEEK);
                        int access$500 = Field.access$500(from);
                        if (access$500 == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                            access$500 = 52;
                        }
                        return temporal.mo3168with(LocalDate.of(checkValidIntValue, 1, 4).plusDays(((access$500 - 1) * 7) + (i - r6.get(r0))));
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }

                @Override // j$.time.temporal.TemporalField
                public final long getFrom(TemporalAccessor temporalAccessor) {
                    if (isSupportedBy(temporalAccessor)) {
                        return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                    }
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }

                @Override // j$.time.temporal.TemporalField
                public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                    return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.access$100(temporalAccessor);
                }

                @Override // j$.time.temporal.TemporalField
                public final ValueRange range() {
                    return ChronoField.YEAR.range();
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "WeekBasedYear";
                }
            };
            WEEK_BASED_YEAR = field4;
            $VALUES = new Field[]{field, field2, field3, field4};
            QUARTER_DAYS = new int[]{0, 90, 181, LZMA_Base.kMatchMaxLen, 0, 91, 182, 274};
        }

        Field(String str, int i) {
        }

        static boolean access$100(TemporalAccessor temporalAccessor) {
            return ((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor)).equals(IsoChronology.INSTANCE);
        }

        static void access$300(TemporalAccessor temporalAccessor) {
            if (!((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor)).equals(IsoChronology.INSTANCE)) {
                throw new DateTimeException("Resolve requires IsoChronology");
            }
        }

        static ValueRange access$400(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        static int access$500(LocalDate localDate) {
            int ordinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i = (3 - ordinal) + dayOfYear;
            int i2 = (i - ((i / 7) * 7)) - 3;
            if (i2 < -3) {
                i2 += 7;
            }
            if (dayOfYear < i2) {
                return (int) ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate.withDayOfYear(180).plusYears(-1L)))).getMaximum();
            }
            int i3 = ((dayOfYear - i2) / 7) + 1;
            if (i3 == 53) {
                if (!(i2 == -3 || (i2 == -2 && localDate.isLeapYear()))) {
                    return 1;
                }
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            } else if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            } else {
                return year;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i) {
            LocalDate of = LocalDate.of(i, 1, 1);
            if (of.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (of.getDayOfWeek() == DayOfWeek.WEDNESDAY && of.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }

        public static Field valueOf(String str) {
            return (Field) Enum.valueOf(Field.class, str);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        @Override // j$.time.temporal.TemporalField
        public final boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public final boolean isTimeBased() {
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            return range();
        }

        @Override // j$.time.temporal.TemporalField
        public /* synthetic */ TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears"),
        QUARTER_YEARS("QuarterYears");

        private final String name;

        static {
            Duration.ofSeconds(31556952L);
            Duration.ofSeconds(7889238L);
        }

        Unit(String str) {
            this.name = str;
        }

        @Override // j$.time.temporal.TemporalUnit
        public final Temporal addTo(Temporal temporal, long j) {
            int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[ordinal()];
            if (i == 1) {
                return temporal.with(Iterable.CC.BuiltInFictitiousFunctionClassFactory(temporal.get(r0), j), IsoFields.MyBillsEntityDataFactory);
            } else if (i == 2) {
                return temporal.plus(j / 256, ChronoUnit.YEARS).plus((j % 256) * 3, ChronoUnit.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // j$.time.temporal.TemporalUnit
        public final long between(Temporal temporal, Temporal temporal2) {
            if (temporal.getClass() != temporal2.getClass()) {
                return temporal.until(temporal2, this);
            }
            int i = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[ordinal()];
            if (i == 1) {
                TemporalField temporalField = IsoFields.MyBillsEntityDataFactory;
                return Iterable.CC.MyBillsEntityDataFactory(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            } else if (i == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        @Override // j$.time.temporal.TemporalUnit
        public final boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalUnit
        public final boolean isTimeBased() {
            return false;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.name;
        }
    }

    static {
        Field field = Field.DAY_OF_QUARTER;
        BuiltInFictitiousFunctionClassFactory = Field.QUARTER_OF_YEAR;
        KClassImpl$Data$declaredNonStaticMembers$2 = Field.WEEK_OF_WEEK_BASED_YEAR;
        MyBillsEntityDataFactory = Field.WEEK_BASED_YEAR;
        getAuthRequestContext = Unit.WEEK_BASED_YEARS;
        Unit unit = Unit.WEEK_BASED_YEARS;
    }
}
