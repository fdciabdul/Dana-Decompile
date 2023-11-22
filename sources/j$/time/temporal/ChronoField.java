package j$.time.temporal;

import j$.time.format.ResolverStyle;
import java.util.HashMap;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DAY_OF_MONTH' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ChronoField implements TemporalField {
    private static final /* synthetic */ ChronoField[] $VALUES;
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_MONTH;
    public static final ChronoField ALIGNED_DAY_OF_WEEK_IN_YEAR;
    public static final ChronoField ALIGNED_WEEK_OF_MONTH;
    public static final ChronoField ALIGNED_WEEK_OF_YEAR;
    public static final ChronoField AMPM_OF_DAY;
    public static final ChronoField CLOCK_HOUR_OF_AMPM;
    public static final ChronoField CLOCK_HOUR_OF_DAY;
    public static final ChronoField DAY_OF_MONTH;
    public static final ChronoField DAY_OF_WEEK;
    public static final ChronoField DAY_OF_YEAR;
    public static final ChronoField EPOCH_DAY;
    public static final ChronoField ERA;
    public static final ChronoField HOUR_OF_AMPM;
    public static final ChronoField HOUR_OF_DAY;
    public static final ChronoField INSTANT_SECONDS;
    public static final ChronoField MICRO_OF_DAY;
    public static final ChronoField MICRO_OF_SECOND;
    public static final ChronoField MILLI_OF_DAY;
    public static final ChronoField MILLI_OF_SECOND;
    public static final ChronoField MINUTE_OF_DAY;
    public static final ChronoField MINUTE_OF_HOUR;
    public static final ChronoField MONTH_OF_YEAR;
    public static final ChronoField NANO_OF_DAY;
    public static final ChronoField NANO_OF_SECOND;
    public static final ChronoField OFFSET_SECONDS;
    public static final ChronoField PROLEPTIC_MONTH;
    public static final ChronoField SECOND_OF_DAY;
    public static final ChronoField SECOND_OF_MINUTE;
    public static final ChronoField YEAR;
    public static final ChronoField YEAR_OF_ERA;
    private final String name;
    private final ValueRange range;

    static {
        ValueRange of;
        ValueRange of2;
        ValueRange of3;
        ValueRange of4;
        ChronoUnit chronoUnit = ChronoUnit.NANOS;
        ChronoField chronoField = new ChronoField("NANO_OF_SECOND", 0, "NanoOfSecond", ValueRange.of(0L, 999999999L));
        NANO_OF_SECOND = chronoField;
        ChronoField chronoField2 = new ChronoField("NANO_OF_DAY", 1, "NanoOfDay", ValueRange.of(0L, 86399999999999L));
        NANO_OF_DAY = chronoField2;
        ChronoField chronoField3 = new ChronoField("MICRO_OF_SECOND", 2, "MicroOfSecond", ValueRange.of(0L, 999999L));
        MICRO_OF_SECOND = chronoField3;
        ChronoField chronoField4 = new ChronoField("MICRO_OF_DAY", 3, "MicroOfDay", ValueRange.of(0L, 86399999999L));
        MICRO_OF_DAY = chronoField4;
        ChronoField chronoField5 = new ChronoField("MILLI_OF_SECOND", 4, "MilliOfSecond", ValueRange.of(0L, 999L));
        MILLI_OF_SECOND = chronoField5;
        ChronoField chronoField6 = new ChronoField("MILLI_OF_DAY", 5, "MilliOfDay", ValueRange.of(0L, 86399999L));
        MILLI_OF_DAY = chronoField6;
        ChronoField chronoField7 = new ChronoField("SECOND_OF_MINUTE", 6, "SecondOfMinute", ValueRange.of(0L, 59L), 0);
        SECOND_OF_MINUTE = chronoField7;
        ChronoField chronoField8 = new ChronoField("SECOND_OF_DAY", 7, "SecondOfDay", ValueRange.of(0L, 86399L));
        SECOND_OF_DAY = chronoField8;
        ChronoField chronoField9 = new ChronoField("MINUTE_OF_HOUR", 8, "MinuteOfHour", ValueRange.of(0L, 59L), 0);
        MINUTE_OF_HOUR = chronoField9;
        ChronoField chronoField10 = new ChronoField("MINUTE_OF_DAY", 9, "MinuteOfDay", ValueRange.of(0L, 1439L));
        MINUTE_OF_DAY = chronoField10;
        ChronoField chronoField11 = new ChronoField("HOUR_OF_AMPM", 10, "HourOfAmPm", ValueRange.of(0L, 11L));
        HOUR_OF_AMPM = chronoField11;
        ChronoField chronoField12 = new ChronoField("CLOCK_HOUR_OF_AMPM", 11, "ClockHourOfAmPm", ValueRange.of(1L, 12L));
        CLOCK_HOUR_OF_AMPM = chronoField12;
        ChronoField chronoField13 = new ChronoField("HOUR_OF_DAY", 12, "HourOfDay", ValueRange.of(0L, 23L), 0);
        HOUR_OF_DAY = chronoField13;
        ChronoField chronoField14 = new ChronoField("CLOCK_HOUR_OF_DAY", 13, "ClockHourOfDay", ValueRange.of(1L, 24L));
        CLOCK_HOUR_OF_DAY = chronoField14;
        ChronoField chronoField15 = new ChronoField("AMPM_OF_DAY", 14, "AmPmOfDay", ValueRange.of(0L, 1L), 0);
        AMPM_OF_DAY = chronoField15;
        ChronoField chronoField16 = new ChronoField("DAY_OF_WEEK", 15, "DayOfWeek", ValueRange.of(1L, 7L), 0);
        DAY_OF_WEEK = chronoField16;
        ChronoField chronoField17 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_MONTH", 16, "AlignedDayOfWeekInMonth", ValueRange.of(1L, 7L));
        ALIGNED_DAY_OF_WEEK_IN_MONTH = chronoField17;
        ChronoField chronoField18 = new ChronoField("ALIGNED_DAY_OF_WEEK_IN_YEAR", 17, "AlignedDayOfWeekInYear", ValueRange.of(1L, 7L));
        ALIGNED_DAY_OF_WEEK_IN_YEAR = chronoField18;
        of = ValueRange.of(1L, 28L, 31L);
        ChronoField chronoField19 = new ChronoField("DAY_OF_MONTH", 18, "DayOfMonth", of, 0);
        DAY_OF_MONTH = chronoField19;
        of2 = ValueRange.of(1L, 365L, 366L);
        ChronoField chronoField20 = new ChronoField("DAY_OF_YEAR", 19, "DayOfYear", of2);
        DAY_OF_YEAR = chronoField20;
        ChronoField chronoField21 = new ChronoField("EPOCH_DAY", 20, "EpochDay", ValueRange.of(-365249999634L, 365249999634L));
        EPOCH_DAY = chronoField21;
        of3 = ValueRange.of(1L, 4L, 5L);
        ChronoField chronoField22 = new ChronoField("ALIGNED_WEEK_OF_MONTH", 21, "AlignedWeekOfMonth", of3);
        ALIGNED_WEEK_OF_MONTH = chronoField22;
        ChronoField chronoField23 = new ChronoField("ALIGNED_WEEK_OF_YEAR", 22, "AlignedWeekOfYear", ValueRange.of(1L, 53L));
        ALIGNED_WEEK_OF_YEAR = chronoField23;
        ChronoField chronoField24 = new ChronoField("MONTH_OF_YEAR", 23, "MonthOfYear", ValueRange.of(1L, 12L), 0);
        MONTH_OF_YEAR = chronoField24;
        ChronoField chronoField25 = new ChronoField("PROLEPTIC_MONTH", 24, "ProlepticMonth", ValueRange.of(-11999999988L, 11999999999L));
        PROLEPTIC_MONTH = chronoField25;
        of4 = ValueRange.of(1L, 999999999L, 1000000000L);
        ChronoField chronoField26 = new ChronoField("YEAR_OF_ERA", 25, "YearOfEra", of4);
        YEAR_OF_ERA = chronoField26;
        ChronoField chronoField27 = new ChronoField("YEAR", 26, "Year", ValueRange.of(-999999999L, 999999999L), 0);
        YEAR = chronoField27;
        ChronoField chronoField28 = new ChronoField("ERA", 27, "Era", ValueRange.of(0L, 1L), 0);
        ERA = chronoField28;
        ChronoField chronoField29 = new ChronoField("INSTANT_SECONDS", 28, "InstantSeconds", ValueRange.of(Long.MIN_VALUE, LongCompanionObject.MAX_VALUE));
        INSTANT_SECONDS = chronoField29;
        ChronoField chronoField30 = new ChronoField("OFFSET_SECONDS", 29, "OffsetSeconds", ValueRange.of(-64800L, 64800L));
        OFFSET_SECONDS = chronoField30;
        $VALUES = new ChronoField[]{chronoField, chronoField2, chronoField3, chronoField4, chronoField5, chronoField6, chronoField7, chronoField8, chronoField9, chronoField10, chronoField11, chronoField12, chronoField13, chronoField14, chronoField15, chronoField16, chronoField17, chronoField18, chronoField19, chronoField20, chronoField21, chronoField22, chronoField23, chronoField24, chronoField25, chronoField26, chronoField27, chronoField28, chronoField29, chronoField30};
    }

    private ChronoField(String str, int i, String str2, ValueRange valueRange) {
        this.name = str2;
        this.range = valueRange;
    }

    private ChronoField(String str, int i, String str2, ValueRange valueRange, int i2) {
        this.name = str2;
        this.range = valueRange;
    }

    public static ChronoField valueOf(String str) {
        return (ChronoField) Enum.valueOf(ChronoField.class, str);
    }

    public static ChronoField[] values() {
        return (ChronoField[]) $VALUES.clone();
    }

    @Override // j$.time.temporal.TemporalField
    public final Temporal adjustInto(Temporal temporal, long j) {
        return temporal.with(j, this);
    }

    public final int checkValidIntValue(long j) {
        return this.range.checkValidIntValue(j, this);
    }

    public final void checkValidValue(long j) {
        this.range.checkValidValue(j, this);
    }

    @Override // j$.time.temporal.TemporalField
    public final long getFrom(TemporalAccessor temporalAccessor) {
        return temporalAccessor.getLong(this);
    }

    @Override // j$.time.temporal.TemporalField
    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    @Override // j$.time.temporal.TemporalField
    public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.isSupported(this);
    }

    @Override // j$.time.temporal.TemporalField
    public final boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // j$.time.temporal.TemporalField
    public final ValueRange range() {
        return this.range;
    }

    @Override // j$.time.temporal.TemporalField
    public final ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
        return temporalAccessor.range(this);
    }

    @Override // j$.time.temporal.TemporalField
    public final /* synthetic */ TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
        return null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.name;
    }
}
