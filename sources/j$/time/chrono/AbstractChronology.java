package j$.time.chrono;

import j$.lang.Iterable;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda3;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import j$.time.temporal.TemporalUnit;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ServiceLoader;

/* loaded from: classes6.dex */
public abstract class AbstractChronology implements Chronology {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final ConcurrentHashMap CHRONOS_BY_ID;
    private static final ConcurrentHashMap CHRONOS_BY_TYPE;

    static {
        new AbstractChronology$$ExternalSyntheticLambda0();
        new AbstractChronology$$ExternalSyntheticLambda1();
        new AbstractChronology$$ExternalSyntheticLambda2();
        CHRONOS_BY_ID = new ConcurrentHashMap();
        CHRONOS_BY_TYPE = new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    public static void addFieldValue(HashMap hashMap, ChronoField chronoField, long j) {
        Long l = (Long) hashMap.get(chronoField);
        if (l == null || l.longValue() == j) {
            hashMap.put(chronoField, Long.valueOf(j));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Conflict found: ");
        sb.append(chronoField);
        sb.append(" ");
        sb.append(l);
        sb.append(" differs from ");
        sb.append(chronoField);
        sb.append(" ");
        sb.append(j);
        throw new DateTimeException(sb.toString());
    }

    public static Chronology of(String str) {
        boolean z;
        if (str == null) {
            throw new NullPointerException("id");
        }
        do {
            ConcurrentHashMap concurrentHashMap = CHRONOS_BY_ID;
            Chronology chronology = (Chronology) concurrentHashMap.get(str);
            if (chronology == null) {
                chronology = (Chronology) CHRONOS_BY_TYPE.get(str);
            }
            if (chronology != null) {
                return chronology;
            }
            if (concurrentHashMap.get("ISO") == 0) {
                HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
                registerChrono(hijrahChronology, hijrahChronology.getId());
                JapaneseChronology japaneseChronology = JapaneseChronology.INSTANCE;
                registerChrono(japaneseChronology, japaneseChronology.getId());
                MinguoChronology minguoChronology = MinguoChronology.INSTANCE;
                registerChrono(minguoChronology, minguoChronology.getId());
                ThaiBuddhistChronology thaiBuddhistChronology = ThaiBuddhistChronology.INSTANCE;
                registerChrono(thaiBuddhistChronology, thaiBuddhistChronology.getId());
                Iterator it = ServiceLoader.load(AbstractChronology.class, null).iterator();
                while (it.hasNext()) {
                    AbstractChronology abstractChronology = (AbstractChronology) it.next();
                    if (!abstractChronology.getId().equals("ISO")) {
                        registerChrono(abstractChronology, abstractChronology.getId());
                    }
                }
                IsoChronology isoChronology = IsoChronology.INSTANCE;
                registerChrono(isoChronology, isoChronology.getId());
                z = true;
            } else {
                z = false;
            }
        } while (z);
        Iterator it2 = ServiceLoader.load(Chronology.class).iterator();
        while (it2.hasNext()) {
            Chronology chronology2 = (Chronology) it2.next();
            if (str.equals(chronology2.getId()) || str.equals(chronology2.getCalendarType())) {
                return chronology2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown chronology: ");
        sb.append(str);
        throw new DateTimeException(sb.toString());
    }

    public static Chronology registerChrono(AbstractChronology abstractChronology, String str) {
        String calendarType;
        Chronology chronology = (Chronology) CHRONOS_BY_ID.putIfAbsent(str, abstractChronology);
        if (chronology == null && (calendarType = abstractChronology.getCalendarType()) != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, abstractChronology);
        }
        return chronology;
    }

    static ChronoLocalDate resolveAligned(ChronoLocalDate chronoLocalDate, long j, long j2, long j3) {
        long j4;
        ChronoLocalDate plus = chronoLocalDate.plus(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        ChronoLocalDate plus2 = plus.plus(j2, (TemporalUnit) chronoUnit);
        if (j3 <= 7) {
            if (j3 < 1) {
                plus2 = plus2.plus(Iterable.CC.MyBillsEntityDataFactory(j3, 7L) / 7, (TemporalUnit) chronoUnit);
                j4 = j3 + 6;
            }
            return plus2.with(new TemporalAdjusters$$ExternalSyntheticLambda3(DayOfWeek.of((int) j3).getValue(), 1));
        }
        j4 = j3 - 1;
        plus2 = plus2.plus(j4 / 7, (TemporalUnit) chronoUnit);
        j3 = (j4 % 7) + 1;
        return plus2.with(new TemporalAdjusters$$ExternalSyntheticLambda3(DayOfWeek.of((int) j3).getValue(), 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    public abstract /* synthetic */ ChronoLocalDate dateNow();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractChronology) && compareTo((Chronology) ((AbstractChronology) obj)) == 0;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    @Override // j$.time.chrono.Chronology
    public ChronoLocalDateTime localDateTime(TemporalAccessor temporalAccessor) {
        try {
            return date(temporalAccessor).atTime(LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            PlaceComponentResult.append(temporalAccessor.getClass());
            throw new DateTimeException(PlaceComponentResult.toString(), e);
        }
    }

    @Override // j$.time.chrono.Chronology
    public ChronoLocalDate resolveDate(HashMap hashMap, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (hashMap.containsKey(chronoField)) {
            return dateEpochDay(((Long) hashMap.remove(chronoField)).longValue());
        }
        resolveProlepticMonth(hashMap, resolverStyle);
        ChronoLocalDate resolveYearOfEra = resolveYearOfEra(hashMap, resolverStyle);
        if (resolveYearOfEra != null) {
            return resolveYearOfEra;
        }
        ChronoField chronoField2 = ChronoField.YEAR;
        if (hashMap.containsKey(chronoField2)) {
            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
            int i = 1;
            if (hashMap.containsKey(chronoField3)) {
                if (hashMap.containsKey(ChronoField.DAY_OF_MONTH)) {
                    return resolveYMD(hashMap, resolverStyle);
                }
                ChronoField chronoField4 = ChronoField.ALIGNED_WEEK_OF_MONTH;
                if (hashMap.containsKey(chronoField4)) {
                    ChronoField chronoField5 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (hashMap.containsKey(chronoField5)) {
                        int checkValidIntValue = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            long MyBillsEntityDataFactory = Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField3)).longValue(), 1L);
                            return date(checkValidIntValue, 1, 1).plus(MyBillsEntityDataFactory, (TemporalUnit) ChronoUnit.MONTHS).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField4)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField5)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                        }
                        int checkValidIntValue2 = range(chronoField3).checkValidIntValue(((Long) hashMap.remove(chronoField3)).longValue(), chronoField3);
                        int checkValidIntValue3 = range(chronoField4).checkValidIntValue(((Long) hashMap.remove(chronoField4)).longValue(), chronoField4);
                        ChronoLocalDate plus = date(checkValidIntValue, checkValidIntValue2, 1).plus((range(chronoField5).checkValidIntValue(((Long) hashMap.remove(chronoField5)).longValue(), chronoField5) - 1) + ((checkValidIntValue3 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField3) == checkValidIntValue2) {
                            return plus;
                        }
                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                    }
                    ChronoField chronoField6 = ChronoField.DAY_OF_WEEK;
                    if (hashMap.containsKey(chronoField6)) {
                        int checkValidIntValue4 = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
                        if (resolverStyle == ResolverStyle.LENIENT) {
                            return resolveAligned(date(checkValidIntValue4, 1, 1), Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField3)).longValue(), 1L), Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField4)).longValue(), 1L), Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField6)).longValue(), 1L));
                        }
                        int checkValidIntValue5 = range(chronoField3).checkValidIntValue(((Long) hashMap.remove(chronoField3)).longValue(), chronoField3);
                        ChronoLocalDate with = date(checkValidIntValue4, checkValidIntValue5, 1).plus((range(chronoField4).checkValidIntValue(((Long) hashMap.remove(chronoField4)).longValue(), chronoField4) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(new TemporalAdjusters$$ExternalSyntheticLambda3(DayOfWeek.of(range(chronoField6).checkValidIntValue(((Long) hashMap.remove(chronoField6)).longValue(), chronoField6)).getValue(), i));
                        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField3) == checkValidIntValue5) {
                            return with;
                        }
                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                    }
                }
            }
            ChronoField chronoField7 = ChronoField.DAY_OF_YEAR;
            if (hashMap.containsKey(chronoField7)) {
                int checkValidIntValue6 = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    return dateYearDay(checkValidIntValue6, 1).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField7)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                }
                return dateYearDay(checkValidIntValue6, range(chronoField7).checkValidIntValue(((Long) hashMap.remove(chronoField7)).longValue(), chronoField7));
            }
            ChronoField chronoField8 = ChronoField.ALIGNED_WEEK_OF_YEAR;
            if (hashMap.containsKey(chronoField8)) {
                ChronoField chronoField9 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (hashMap.containsKey(chronoField9)) {
                    int checkValidIntValue7 = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return dateYearDay(checkValidIntValue7, 1).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField8)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField9)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int checkValidIntValue8 = range(chronoField8).checkValidIntValue(((Long) hashMap.remove(chronoField8)).longValue(), chronoField8);
                    ChronoLocalDate plus2 = dateYearDay(checkValidIntValue7, 1).plus((range(chronoField9).checkValidIntValue(((Long) hashMap.remove(chronoField9)).longValue(), chronoField9) - 1) + ((checkValidIntValue8 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                    if (resolverStyle != ResolverStyle.STRICT || plus2.get(chronoField2) == checkValidIntValue7) {
                        return plus2;
                    }
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                }
                ChronoField chronoField10 = ChronoField.DAY_OF_WEEK;
                if (hashMap.containsKey(chronoField10)) {
                    int checkValidIntValue9 = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
                    if (resolverStyle == ResolverStyle.LENIENT) {
                        return resolveAligned(dateYearDay(checkValidIntValue9, 1), 0L, Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField8)).longValue(), 1L), Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(chronoField10)).longValue(), 1L));
                    }
                    ChronoLocalDate with2 = dateYearDay(checkValidIntValue9, 1).plus((range(chronoField8).checkValidIntValue(((Long) hashMap.remove(chronoField8)).longValue(), chronoField8) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(new TemporalAdjusters$$ExternalSyntheticLambda3(DayOfWeek.of(range(chronoField10).checkValidIntValue(((Long) hashMap.remove(chronoField10)).longValue(), chronoField10)).getValue(), i));
                    if (resolverStyle != ResolverStyle.STRICT || with2.get(chronoField2) == checkValidIntValue9) {
                        return with2;
                    }
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                }
                return null;
            }
            return null;
        }
        return null;
    }

    void resolveProlepticMonth(HashMap hashMap, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.PROLEPTIC_MONTH;
        Long l = (Long) hashMap.remove(chronoField);
        if (l != null) {
            if (resolverStyle != ResolverStyle.LENIENT) {
                chronoField.checkValidValue(l.longValue());
            }
            ChronoLocalDate with = dateNow().with(1L, (TemporalField) ChronoField.DAY_OF_MONTH).with(l.longValue(), (TemporalField) chronoField);
            addFieldValue(hashMap, ChronoField.MONTH_OF_YEAR, with.get(r0));
            addFieldValue(hashMap, ChronoField.YEAR, with.get(r0));
        }
    }

    ChronoLocalDate resolveYMD(HashMap hashMap, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) hashMap.remove(chronoField)).longValue(), chronoField);
        int i = 1;
        if (resolverStyle == ResolverStyle.LENIENT) {
            long MyBillsEntityDataFactory = Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(MyBillsEntityDataFactory, (TemporalUnit) ChronoUnit.MONTHS).plus(Iterable.CC.MyBillsEntityDataFactory(((Long) hashMap.remove(ChronoField.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) hashMap.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) hashMap.remove(chronoField3)).longValue(), chronoField3);
        if (resolverStyle == ResolverStyle.SMART) {
            try {
                return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
            } catch (DateTimeException unused) {
                return date(checkValidIntValue, checkValidIntValue2, 1).with(new TemporalQueries$$ExternalSyntheticLambda0(i));
            }
        }
        return date(checkValidIntValue, checkValidIntValue2, checkValidIntValue3);
    }

    ChronoLocalDate resolveYearOfEra(HashMap hashMap, ResolverStyle resolverStyle) {
        Era era;
        long j;
        ChronoField chronoField = ChronoField.YEAR_OF_ERA;
        Long l = (Long) hashMap.remove(chronoField);
        if (l == null) {
            ChronoField chronoField2 = ChronoField.ERA;
            if (hashMap.containsKey(chronoField2)) {
                range(chronoField2).checkValidValue(((Long) hashMap.get(chronoField2)).longValue(), chronoField2);
                return null;
            }
            return null;
        }
        Long l2 = (Long) hashMap.remove(ChronoField.ERA);
        int checkValidIntValue = resolverStyle != ResolverStyle.LENIENT ? range(chronoField).checkValidIntValue(l.longValue(), chronoField) : Iterable.CC.BuiltInFictitiousFunctionClassFactory(l.longValue());
        if (l2 != null) {
            addFieldValue(hashMap, ChronoField.YEAR, prolepticYear(eraOf(range(r2).checkValidIntValue(l2.longValue(), r2)), checkValidIntValue));
            return null;
        }
        ChronoField chronoField3 = ChronoField.YEAR;
        if (hashMap.containsKey(chronoField3)) {
            era = dateYearDay(range(chronoField3).checkValidIntValue(((Long) hashMap.get(chronoField3)).longValue(), chronoField3), 1).getEra();
        } else if (resolverStyle == ResolverStyle.STRICT) {
            hashMap.put(chronoField, l);
            return null;
        } else {
            List eras = eras();
            if (eras.isEmpty()) {
                j = checkValidIntValue;
                addFieldValue(hashMap, chronoField3, j);
                return null;
            }
            era = (Era) eras.get(eras.size() - 1);
        }
        j = prolepticYear(era, checkValidIntValue);
        addFieldValue(hashMap, chronoField3, j);
        return null;
    }

    public final String toString() {
        return getId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [j$.time.chrono.ChronoZonedDateTime] */
    @Override // j$.time.chrono.Chronology
    public ChronoZonedDateTime zonedDateTime(TemporalAccessor temporalAccessor) {
        try {
            ZoneId from = ZoneId.from(temporalAccessor);
            try {
                temporalAccessor = zonedDateTime(Instant.from(temporalAccessor), from);
                return temporalAccessor;
            } catch (DateTimeException unused) {
                return ChronoZonedDateTimeImpl.ofBest(from, null, ChronoLocalDateTimeImpl.ensureValid(this, localDateTime(temporalAccessor)));
            }
        } catch (DateTimeException e) {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unable to obtain ChronoZonedDateTime from TemporalAccessor: ");
            PlaceComponentResult.append(temporalAccessor.getClass());
            throw new DateTimeException(PlaceComponentResult.toString(), e);
        }
    }
}
