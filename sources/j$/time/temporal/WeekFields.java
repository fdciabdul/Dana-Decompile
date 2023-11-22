package j$.time.temporal;

import j$.lang.Iterable;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.Era;
import j$.time.format.ResolverStyle;
import j$.time.temporal.Temporal;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes6.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentHashMap CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final TemporalUnit WEEK_BASED_YEARS;
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField weekBasedYear;
    private final transient TemporalField weekOfWeekBasedYear;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.BuiltInFictitiousFunctionClassFactory(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.getAuthRequestContext(this);

    static {
        new WeekFields(DayOfWeek.MONDAY, 4);
        of(DayOfWeek.SUNDAY, 1);
        WEEK_BASED_YEARS = IsoFields.getAuthRequestContext;
    }

    private WeekFields(DayOfWeek dayOfWeek, int i) {
        ChronoUnit chronoUnit = ChronoUnit.NANOS;
        this.weekOfWeekBasedYear = ComputedDayOfField.KClassImpl$Data$declaredNonStaticMembers$2(this);
        this.weekBasedYear = ComputedDayOfField.MyBillsEntityDataFactory(this);
        if (dayOfWeek == null) {
            throw new NullPointerException("firstDayOfWeek");
        }
        if (i <= 0 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = i;
    }

    public static WeekFields of(DayOfWeek dayOfWeek, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(dayOfWeek.toString());
        sb.append(i);
        String obj = sb.toString();
        ConcurrentHashMap concurrentHashMap = CACHE;
        WeekFields weekFields = (WeekFields) concurrentHashMap.get(obj);
        if (weekFields == null) {
            concurrentHashMap.putIfAbsent(obj, new WeekFields(dayOfWeek, i));
            return (WeekFields) concurrentHashMap.get(obj);
        }
        return weekFields;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.firstDayOfWeek == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i = this.minimalDays;
        if (i <= 0 || i > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e) {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Invalid serialized WeekFields: ");
            PlaceComponentResult.append(e.getMessage());
            throw new InvalidObjectException(PlaceComponentResult.toString());
        }
    }

    public final TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public final DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public final int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public final int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public final String toString() {
        StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("WeekFields[");
        PlaceComponentResult.append(this.firstDayOfWeek);
        PlaceComponentResult.append(',');
        PlaceComponentResult.append(this.minimalDays);
        PlaceComponentResult.append(']');
        return PlaceComponentResult.toString();
    }

    public final TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public final TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public final TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    /* loaded from: classes6.dex */
    final class ComputedDayOfField implements TemporalField {
        private static final ValueRange PlaceComponentResult;
        private final TemporalUnit BuiltInFictitiousFunctionClassFactory;
        private final WeekFields NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ValueRange getErrorConfigVersion;
        private final TemporalUnit lookAheadTest;
        private final String moveToNextValue;
        private static final ValueRange MyBillsEntityDataFactory = ValueRange.of(1, 7);
        private static final ValueRange KClassImpl$Data$declaredNonStaticMembers$2 = ValueRange.of(0, 4, 6);
        private static final ValueRange getAuthRequestContext = ValueRange.of(0, 52, 54);

        static {
            ValueRange of;
            of = ValueRange.of(1L, 52L, 53L);
            PlaceComponentResult = of;
        }

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.moveToNextValue = str;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = weekFields;
            this.BuiltInFictitiousFunctionClassFactory = temporalUnit;
            this.lookAheadTest = temporalUnit2;
            this.getErrorConfigVersion = valueRange;
        }

        static ComputedDayOfField BuiltInFictitiousFunctionClassFactory(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, MyBillsEntityDataFactory);
        }

        static ComputedDayOfField KClassImpl$Data$declaredNonStaticMembers$2(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.getAuthRequestContext, PlaceComponentResult);
        }

        static ComputedDayOfField MyBillsEntityDataFactory(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.getAuthRequestContext, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        static ComputedDayOfField getAuthRequestContext(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // j$.time.temporal.TemporalField
        public final Temporal adjustInto(Temporal temporal, long j) {
            if (this.getErrorConfigVersion.checkValidIntValue(j, this) == temporal.get(this)) {
                return temporal;
            }
            if (this.lookAheadTest == ChronoUnit.FOREVER) {
                return KClassImpl$Data$declaredNonStaticMembers$2(Era.CC.BuiltInFictitiousFunctionClassFactory(temporal), (int) j, temporal.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear), temporal.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0.dayOfWeek));
            }
            return temporal.plus(r0 - r1, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.time.temporal.TemporalField
        public final boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public final boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            if (temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                TemporalUnit temporalUnit = this.lookAheadTest;
                if (temporalUnit == ChronoUnit.WEEKS) {
                    return true;
                }
                if (temporalUnit == ChronoUnit.MONTHS) {
                    chronoField = ChronoField.DAY_OF_MONTH;
                } else if (temporalUnit == ChronoUnit.YEARS || temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                    chronoField = ChronoField.DAY_OF_YEAR;
                } else if (temporalUnit != ChronoUnit.FOREVER) {
                    return false;
                } else {
                    chronoField = ChronoField.YEAR;
                }
                return temporalAccessor.isSupported(chronoField);
            }
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public final boolean isTimeBased() {
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public final ValueRange range() {
            return this.getErrorConfigVersion;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.moveToNextValue);
            sb.append("[");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0.toString());
            sb.append("]");
            return sb.toString();
        }

        private int getAuthRequestContext(TemporalAccessor temporalAccessor) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
            int i = temporalAccessor.get(ChronoField.YEAR);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int i2 = temporalAccessor.get(chronoField);
            int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(i2 - KClassImpl$Data$declaredNonStaticMembers$22);
            int i3 = -KClassImpl$Data$declaredNonStaticMembers$23;
            if (KClassImpl$Data$declaredNonStaticMembers$23 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                i3 = 7 - KClassImpl$Data$declaredNonStaticMembers$23;
            }
            int i4 = i3 + 7;
            int i5 = ((i2 - 1) + i4) / 7;
            if (i5 == 0) {
                return i - 1;
            }
            return i5 >= (((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(chronoField).getMaximum())) + (-1)) + i4) / 7 ? i + 1 : i;
        }

        private long PlaceComponentResult(TemporalAccessor temporalAccessor) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
            int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_MONTH) - KClassImpl$Data$declaredNonStaticMembers$22);
            int i = -KClassImpl$Data$declaredNonStaticMembers$23;
            if (KClassImpl$Data$declaredNonStaticMembers$23 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                i = 7 - KClassImpl$Data$declaredNonStaticMembers$23;
            }
            return ((r5 - 1) + (i + 7)) / 7;
        }

        private long KClassImpl$Data$declaredNonStaticMembers$2(TemporalAccessor temporalAccessor) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
            int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_YEAR) - KClassImpl$Data$declaredNonStaticMembers$22);
            int i = -KClassImpl$Data$declaredNonStaticMembers$23;
            if (KClassImpl$Data$declaredNonStaticMembers$23 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                i = 7 - KClassImpl$Data$declaredNonStaticMembers$23;
            }
            return ((r5 - 1) + (i + 7)) / 7;
        }

        private ChronoLocalDate KClassImpl$Data$declaredNonStaticMembers$2(Chronology chronology, int i, int i2, int i3) {
            ChronoLocalDate date = chronology.date(i, 1, 1);
            int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(1 - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(date.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1));
            int i4 = -KClassImpl$Data$declaredNonStaticMembers$22;
            if (KClassImpl$Data$declaredNonStaticMembers$22 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                i4 = 7 - KClassImpl$Data$declaredNonStaticMembers$22;
            }
            return date.plus(((Math.min(i2, ((((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek() + date.lengthOfYear()) - 1) + (i4 + 7)) / 7) - 1) - 1) * 7) + (i3 - 1) + (-i4), (TemporalUnit) ChronoUnit.DAYS);
        }

        private ValueRange getAuthRequestContext(TemporalAccessor temporalAccessor, ChronoField chronoField) {
            int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(chronoField) - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1));
            int i = -KClassImpl$Data$declaredNonStaticMembers$22;
            if (KClassImpl$Data$declaredNonStaticMembers$22 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                i = 7 - KClassImpl$Data$declaredNonStaticMembers$22;
            }
            ValueRange range = temporalAccessor.range(chronoField);
            int i2 = i + 7;
            return ValueRange.of(((((int) range.getMinimum()) - 1) + i2) / 7, ((((int) range.getMaximum()) - 1) + i2) / 7);
        }

        @Override // j$.time.temporal.TemporalField
        public final long getFrom(TemporalAccessor temporalAccessor) {
            int authRequestContext;
            int i;
            int i2;
            TemporalUnit temporalUnit = this.lookAheadTest;
            if (temporalUnit == ChronoUnit.WEEKS) {
                authRequestContext = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
            } else if (temporalUnit == ChronoUnit.MONTHS) {
                return PlaceComponentResult(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.YEARS) {
                    return KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor);
                }
                if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                    while (true) {
                        int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
                        int i3 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
                        int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(i3 - KClassImpl$Data$declaredNonStaticMembers$22);
                        int i4 = -KClassImpl$Data$declaredNonStaticMembers$23;
                        if (KClassImpl$Data$declaredNonStaticMembers$23 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                            i4 = 7 - KClassImpl$Data$declaredNonStaticMembers$23;
                        }
                        i = i4 + 7;
                        i2 = ((i3 - 1) + i) / 7;
                        if (i2 != 0) {
                            break;
                        }
                        temporalAccessor = Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor).date(temporalAccessor).minus(i3, ChronoUnit.DAYS);
                    }
                    if (i2 > 50) {
                        int minimalDaysInFirstWeek = (((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(r1).getMaximum())) - 1) + i) / 7;
                        if (i2 >= minimalDaysInFirstWeek) {
                            i2 = (i2 - minimalDaysInFirstWeek) + 1;
                        }
                    }
                    authRequestContext = i2;
                } else if (temporalUnit != ChronoUnit.FOREVER) {
                    StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("unreachable, rangeUnit: ");
                    PlaceComponentResult2.append(this.lookAheadTest);
                    PlaceComponentResult2.append(", this: ");
                    PlaceComponentResult2.append(this);
                    throw new IllegalStateException(PlaceComponentResult2.toString());
                } else {
                    authRequestContext = getAuthRequestContext(temporalAccessor);
                }
            }
            return authRequestContext;
        }

        @Override // j$.time.temporal.TemporalField
        public final ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            TemporalUnit temporalUnit = this.lookAheadTest;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.getErrorConfigVersion;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return getAuthRequestContext(temporalAccessor, ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return getAuthRequestContext(temporalAccessor, ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit != WeekFields.WEEK_BASED_YEARS) {
                if (temporalUnit == ChronoUnit.FOREVER) {
                    return ChronoField.YEAR.range();
                }
                StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("unreachable, rangeUnit: ");
                PlaceComponentResult2.append(this.lookAheadTest);
                PlaceComponentResult2.append(", this: ");
                PlaceComponentResult2.append(this);
                throw new IllegalStateException(PlaceComponentResult2.toString());
            }
            while (true) {
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                if (!temporalAccessor.isSupported(chronoField)) {
                    return getAuthRequestContext;
                }
                int KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
                int i = temporalAccessor.get(chronoField);
                int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(i - KClassImpl$Data$declaredNonStaticMembers$22);
                int i2 = -KClassImpl$Data$declaredNonStaticMembers$23;
                if (KClassImpl$Data$declaredNonStaticMembers$23 + 1 > this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek()) {
                    i2 = 7 - KClassImpl$Data$declaredNonStaticMembers$23;
                }
                int i3 = i2 + 7;
                int i4 = ((i - 1) + i3) / 7;
                if (i4 == 0) {
                    temporalAccessor = Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor).date(temporalAccessor).minus(i + 7, ChronoUnit.DAYS);
                } else {
                    int maximum = (int) temporalAccessor.range(chronoField).getMaximum();
                    int minimalDaysInFirstWeek = (((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getMinimalDaysInFirstWeek() + maximum) - 1) + i3) / 7;
                    if (i4 < minimalDaysInFirstWeek) {
                        return ValueRange.of(1L, (long) (minimalDaysInFirstWeek - 1));
                    }
                    temporalAccessor = Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor).date(temporalAccessor).plus((maximum - i) + 1 + 7, (TemporalUnit) ChronoUnit.DAYS);
                }
            }
        }

        @Override // j$.time.temporal.TemporalField
        public final TemporalAccessor resolve(HashMap hashMap, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            ChronoLocalDate chronoLocalDate;
            ChronoLocalDate chronoLocalDate2;
            long longValue = ((Long) hashMap.get(this)).longValue();
            int BuiltInFictitiousFunctionClassFactory = Iterable.CC.BuiltInFictitiousFunctionClassFactory(longValue);
            TemporalUnit temporalUnit = this.lookAheadTest;
            TemporalUnit temporalUnit2 = ChronoUnit.WEEKS;
            if (temporalUnit == temporalUnit2) {
                long KClassImpl$Data$declaredNonStaticMembers$22 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2((this.getErrorConfigVersion.checkValidIntValue(longValue, this) - 1) + (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue() - 1)) + 1;
                hashMap.remove(this);
                hashMap.put(ChronoField.DAY_OF_WEEK, Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22));
            } else {
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                if (hashMap.containsKey(chronoField)) {
                    int KClassImpl$Data$declaredNonStaticMembers$23 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(chronoField.checkValidIntValue(((Long) hashMap.get(chronoField)).longValue()) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1;
                    Chronology BuiltInFictitiousFunctionClassFactory2 = Era.CC.BuiltInFictitiousFunctionClassFactory(temporalAccessor);
                    ChronoField chronoField2 = ChronoField.YEAR;
                    if (hashMap.containsKey(chronoField2)) {
                        int checkValidIntValue = chronoField2.checkValidIntValue(((Long) hashMap.get(chronoField2)).longValue());
                        TemporalUnit temporalUnit3 = this.lookAheadTest;
                        TemporalUnit temporalUnit4 = ChronoUnit.MONTHS;
                        if (temporalUnit3 == temporalUnit4) {
                            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
                            if (hashMap.containsKey(chronoField3)) {
                                long longValue2 = ((Long) hashMap.get(chronoField3)).longValue();
                                long j = BuiltInFictitiousFunctionClassFactory;
                                if (resolverStyle == ResolverStyle.LENIENT) {
                                    ChronoLocalDate plus = BuiltInFictitiousFunctionClassFactory2.date(checkValidIntValue, 1, 1).plus(Iterable.CC.MyBillsEntityDataFactory(longValue2, 1L), temporalUnit4);
                                    chronoLocalDate2 = plus.plus(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(Iterable.CC.MyBillsEntityDataFactory(j, PlaceComponentResult(plus)), 7L), KClassImpl$Data$declaredNonStaticMembers$23 - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(plus.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1)), ChronoUnit.DAYS);
                                } else {
                                    ChronoLocalDate plus2 = BuiltInFictitiousFunctionClassFactory2.date(checkValidIntValue, chronoField3.checkValidIntValue(longValue2), 1).plus((((int) (this.getErrorConfigVersion.checkValidIntValue(j, this) - PlaceComponentResult(r5))) * 7) + (KClassImpl$Data$declaredNonStaticMembers$23 - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(r5.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1)), ChronoUnit.DAYS);
                                    if (resolverStyle == ResolverStyle.STRICT && plus2.getLong(chronoField3) != longValue2) {
                                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                                    }
                                    chronoLocalDate2 = plus2;
                                }
                                hashMap.remove(this);
                                hashMap.remove(chronoField2);
                                hashMap.remove(chronoField3);
                                hashMap.remove(chronoField);
                                return chronoLocalDate2;
                            }
                        }
                        if (this.lookAheadTest == ChronoUnit.YEARS) {
                            long j2 = BuiltInFictitiousFunctionClassFactory;
                            ChronoLocalDate date = BuiltInFictitiousFunctionClassFactory2.date(checkValidIntValue, 1, 1);
                            if (resolverStyle == ResolverStyle.LENIENT) {
                                chronoLocalDate = date.plus(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(Iterable.CC.MyBillsEntityDataFactory(j2, KClassImpl$Data$declaredNonStaticMembers$2(date)), 7L), KClassImpl$Data$declaredNonStaticMembers$23 - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(date.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1)), ChronoUnit.DAYS);
                            } else {
                                ChronoLocalDate plus3 = date.plus((((int) (this.getErrorConfigVersion.checkValidIntValue(j2, this) - KClassImpl$Data$declaredNonStaticMembers$2(date))) * 7) + (KClassImpl$Data$declaredNonStaticMembers$23 - (Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2(date.get(ChronoField.DAY_OF_WEEK) - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getFirstDayOfWeek().getValue()) + 1)), ChronoUnit.DAYS);
                                if (resolverStyle == ResolverStyle.STRICT && plus3.getLong(chronoField2) != checkValidIntValue) {
                                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                                }
                                chronoLocalDate = plus3;
                            }
                            hashMap.remove(this);
                            hashMap.remove(chronoField2);
                            hashMap.remove(chronoField);
                            return chronoLocalDate;
                        }
                    } else {
                        TemporalUnit temporalUnit5 = this.lookAheadTest;
                        if ((temporalUnit5 == WeekFields.WEEK_BASED_YEARS || temporalUnit5 == ChronoUnit.FOREVER) && hashMap.containsKey(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekBasedYear) && hashMap.containsKey(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear)) {
                            int checkValidIntValue2 = ((ComputedDayOfField) this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekBasedYear).getErrorConfigVersion.checkValidIntValue(((Long) hashMap.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekBasedYear)).longValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekBasedYear);
                            if (resolverStyle == ResolverStyle.LENIENT) {
                                chronoLocalDate = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, checkValidIntValue2, 1, KClassImpl$Data$declaredNonStaticMembers$23).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear)).longValue(), 1L), temporalUnit2);
                            } else {
                                ChronoLocalDate KClassImpl$Data$declaredNonStaticMembers$24 = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, checkValidIntValue2, ((ComputedDayOfField) this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear).getErrorConfigVersion.checkValidIntValue(((Long) hashMap.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear)).longValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear), KClassImpl$Data$declaredNonStaticMembers$23);
                                if (resolverStyle == ResolverStyle.STRICT && getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$24) != checkValidIntValue2) {
                                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                                }
                                chronoLocalDate = KClassImpl$Data$declaredNonStaticMembers$24;
                            }
                            hashMap.remove(this);
                            hashMap.remove(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekBasedYear);
                            hashMap.remove(this.NetworkUserEntityData$$ExternalSyntheticLambda0.weekOfWeekBasedYear);
                            hashMap.remove(chronoField);
                            return chronoLocalDate;
                        }
                    }
                }
            }
            return null;
        }
    }
}
