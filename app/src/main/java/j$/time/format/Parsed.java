package j$.time.format;

import j$.lang.Iterable;
import j$.time.DateTimeException;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes9.dex */
public final class Parsed implements TemporalAccessor {
    Chronology BuiltInFictitiousFunctionClassFactory;
    ResolverStyle MyBillsEntityDataFactory;
    ChronoLocalDate getAuthRequestContext;
    ZoneId getErrorConfigVersion;
    LocalTime lookAheadTest;
    final HashMap PlaceComponentResult = new HashMap();
    Period KClassImpl$Data$declaredNonStaticMembers$2 = Period.ZERO;

    private void getAuthRequestContext(ZoneId zoneId) {
        HashMap hashMap = this.PlaceComponentResult;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.zonedDateTime(Instant.ofEpochSecond(((Long) hashMap.remove(chronoField)).longValue()), zoneId).toLocalDate());
        KClassImpl$Data$declaredNonStaticMembers$2(chronoField, ChronoField.SECOND_OF_DAY, Long.valueOf(r5.toLocalTime().toSecondOfDay()));
    }

    public final void BuiltInFictitiousFunctionClassFactory(long j, long j2, long j3, long j4) {
        LocalTime of;
        Period period;
        if (this.MyBillsEntityDataFactory == ResolverStyle.LENIENT) {
            long BuiltInFictitiousFunctionClassFactory = Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(j, 3600000000000L), Iterable.CC.getAuthRequestContext(j2, 60000000000L)), Iterable.CC.getAuthRequestContext(j3, 1000000000L)), j4);
            int PlaceComponentResult = (int) Iterable.CC.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, 86400000000000L);
            of = LocalTime.ofNanoOfDay(Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, 86400000000000L));
            period = Period.ofDays(PlaceComponentResult);
        } else {
            int checkValidIntValue = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(j2);
            int checkValidIntValue2 = ChronoField.NANO_OF_SECOND.checkValidIntValue(j4);
            if (this.MyBillsEntityDataFactory == ResolverStyle.SMART && j == 24 && checkValidIntValue == 0 && j3 == 0 && checkValidIntValue2 == 0) {
                of = LocalTime.MIDNIGHT;
                period = Period.ofDays(1);
            } else {
                of = LocalTime.of(ChronoField.HOUR_OF_DAY.checkValidIntValue(j), checkValidIntValue, ChronoField.SECOND_OF_MINUTE.checkValidIntValue(j3), checkValidIntValue2);
                period = Period.ZERO;
            }
        }
        PlaceComponentResult(of, period);
    }

    public final void BuiltInFictitiousFunctionClassFactory(TemporalAccessor temporalAccessor) {
        Iterator it = this.PlaceComponentResult.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            TemporalField temporalField = (TemporalField) entry.getKey();
            if (temporalAccessor.isSupported(temporalField)) {
                try {
                    long j = temporalAccessor.getLong(temporalField);
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (j != longValue) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Conflict found: Field ");
                        sb.append(temporalField);
                        sb.append(" ");
                        sb.append(j);
                        sb.append(" differs from ");
                        sb.append(temporalField);
                        sb.append(" ");
                        sb.append(longValue);
                        sb.append(" derived from ");
                        sb.append(temporalAccessor);
                        throw new DateTimeException(sb.toString());
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ChronoField chronoField;
        Long valueOf;
        HashMap hashMap = this.PlaceComponentResult;
        ChronoField chronoField2 = ChronoField.CLOCK_HOUR_OF_DAY;
        if (hashMap.containsKey(chronoField2)) {
            long longValue = ((Long) this.PlaceComponentResult.remove(chronoField2)).longValue();
            ResolverStyle resolverStyle = this.MyBillsEntityDataFactory;
            if (resolverStyle == ResolverStyle.STRICT || (resolverStyle == ResolverStyle.SMART && longValue != 0)) {
                chronoField2.checkValidValue(longValue);
            }
            ChronoField chronoField3 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField2, chronoField3, Long.valueOf(longValue));
        }
        HashMap hashMap2 = this.PlaceComponentResult;
        ChronoField chronoField4 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (hashMap2.containsKey(chronoField4)) {
            long longValue2 = ((Long) this.PlaceComponentResult.remove(chronoField4)).longValue();
            ResolverStyle resolverStyle2 = this.MyBillsEntityDataFactory;
            if (resolverStyle2 == ResolverStyle.STRICT || (resolverStyle2 == ResolverStyle.SMART && longValue2 != 0)) {
                chronoField4.checkValidValue(longValue2);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField4, ChronoField.HOUR_OF_AMPM, Long.valueOf(longValue2 != 12 ? longValue2 : 0L));
        }
        HashMap hashMap3 = this.PlaceComponentResult;
        ChronoField chronoField5 = ChronoField.AMPM_OF_DAY;
        if (hashMap3.containsKey(chronoField5)) {
            HashMap hashMap4 = this.PlaceComponentResult;
            ChronoField chronoField6 = ChronoField.HOUR_OF_AMPM;
            if (hashMap4.containsKey(chronoField6)) {
                long longValue3 = ((Long) this.PlaceComponentResult.remove(chronoField5)).longValue();
                long longValue4 = ((Long) this.PlaceComponentResult.remove(chronoField6)).longValue();
                if (this.MyBillsEntityDataFactory == ResolverStyle.LENIENT) {
                    chronoField = ChronoField.HOUR_OF_DAY;
                    valueOf = Long.valueOf(Iterable.CC.BuiltInFictitiousFunctionClassFactory(Iterable.CC.getAuthRequestContext(longValue3, 12L), longValue4));
                } else {
                    chronoField5.checkValidValue(longValue3);
                    chronoField6.checkValidValue(longValue3);
                    chronoField = ChronoField.HOUR_OF_DAY;
                    valueOf = Long.valueOf((longValue3 * 12) + longValue4);
                }
                KClassImpl$Data$declaredNonStaticMembers$2(chronoField5, chronoField, valueOf);
            }
        }
        HashMap hashMap5 = this.PlaceComponentResult;
        ChronoField chronoField7 = ChronoField.NANO_OF_DAY;
        if (hashMap5.containsKey(chronoField7)) {
            long longValue5 = ((Long) this.PlaceComponentResult.remove(chronoField7)).longValue();
            if (this.MyBillsEntityDataFactory != ResolverStyle.LENIENT) {
                chronoField7.checkValidValue(longValue5);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField7, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField7, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField7, ChronoField.SECOND_OF_MINUTE, Long.valueOf((longValue5 / 1000000000) % 60));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField7, ChronoField.NANO_OF_SECOND, Long.valueOf(longValue5 % 1000000000));
        }
        HashMap hashMap6 = this.PlaceComponentResult;
        ChronoField chronoField8 = ChronoField.MICRO_OF_DAY;
        if (hashMap6.containsKey(chronoField8)) {
            long longValue6 = ((Long) this.PlaceComponentResult.remove(chronoField8)).longValue();
            if (this.MyBillsEntityDataFactory != ResolverStyle.LENIENT) {
                chronoField8.checkValidValue(longValue6);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField8, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField8, ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        HashMap hashMap7 = this.PlaceComponentResult;
        ChronoField chronoField9 = ChronoField.MILLI_OF_DAY;
        if (hashMap7.containsKey(chronoField9)) {
            long longValue7 = ((Long) this.PlaceComponentResult.remove(chronoField9)).longValue();
            if (this.MyBillsEntityDataFactory != ResolverStyle.LENIENT) {
                chronoField9.checkValidValue(longValue7);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField9, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField9, ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        HashMap hashMap8 = this.PlaceComponentResult;
        ChronoField chronoField10 = ChronoField.SECOND_OF_DAY;
        if (hashMap8.containsKey(chronoField10)) {
            long longValue8 = ((Long) this.PlaceComponentResult.remove(chronoField10)).longValue();
            if (this.MyBillsEntityDataFactory != ResolverStyle.LENIENT) {
                chronoField10.checkValidValue(longValue8);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField10, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue8 / 3600));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField10, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField10, ChronoField.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        HashMap hashMap9 = this.PlaceComponentResult;
        ChronoField chronoField11 = ChronoField.MINUTE_OF_DAY;
        if (hashMap9.containsKey(chronoField11)) {
            long longValue9 = ((Long) this.PlaceComponentResult.remove(chronoField11)).longValue();
            if (this.MyBillsEntityDataFactory != ResolverStyle.LENIENT) {
                chronoField11.checkValidValue(longValue9);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField11, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            KClassImpl$Data$declaredNonStaticMembers$2(chronoField11, ChronoField.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        HashMap hashMap10 = this.PlaceComponentResult;
        ChronoField chronoField12 = ChronoField.NANO_OF_SECOND;
        if (hashMap10.containsKey(chronoField12)) {
            long longValue10 = ((Long) this.PlaceComponentResult.get(chronoField12)).longValue();
            ResolverStyle resolverStyle3 = this.MyBillsEntityDataFactory;
            ResolverStyle resolverStyle4 = ResolverStyle.LENIENT;
            if (resolverStyle3 != resolverStyle4) {
                chronoField12.checkValidValue(longValue10);
            }
            HashMap hashMap11 = this.PlaceComponentResult;
            ChronoField chronoField13 = ChronoField.MICRO_OF_SECOND;
            if (hashMap11.containsKey(chronoField13)) {
                long longValue11 = ((Long) this.PlaceComponentResult.remove(chronoField13)).longValue();
                if (this.MyBillsEntityDataFactory != resolverStyle4) {
                    chronoField13.checkValidValue(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                KClassImpl$Data$declaredNonStaticMembers$2(chronoField13, chronoField12, Long.valueOf(longValue10));
            }
            HashMap hashMap12 = this.PlaceComponentResult;
            ChronoField chronoField14 = ChronoField.MILLI_OF_SECOND;
            if (hashMap12.containsKey(chronoField14)) {
                long longValue12 = ((Long) this.PlaceComponentResult.remove(chronoField14)).longValue();
                if (this.MyBillsEntityDataFactory != resolverStyle4) {
                    chronoField14.checkValidValue(longValue12);
                }
                KClassImpl$Data$declaredNonStaticMembers$2(chronoField14, chronoField12, Long.valueOf((longValue10 % 1000000) + (longValue12 * 1000000)));
            }
        }
        HashMap hashMap13 = this.PlaceComponentResult;
        ChronoField chronoField15 = ChronoField.HOUR_OF_DAY;
        if (hashMap13.containsKey(chronoField15)) {
            HashMap hashMap14 = this.PlaceComponentResult;
            ChronoField chronoField16 = ChronoField.MINUTE_OF_HOUR;
            if (hashMap14.containsKey(chronoField16)) {
                HashMap hashMap15 = this.PlaceComponentResult;
                ChronoField chronoField17 = ChronoField.SECOND_OF_MINUTE;
                if (hashMap15.containsKey(chronoField17) && this.PlaceComponentResult.containsKey(chronoField12)) {
                    BuiltInFictitiousFunctionClassFactory(((Long) this.PlaceComponentResult.remove(chronoField15)).longValue(), ((Long) this.PlaceComponentResult.remove(chronoField16)).longValue(), ((Long) this.PlaceComponentResult.remove(chronoField17)).longValue(), ((Long) this.PlaceComponentResult.remove(chronoField12)).longValue());
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ChronoField chronoField, ChronoField chronoField2, Long l) {
        Long l2 = (Long) this.PlaceComponentResult.put(chronoField2, l);
        if (l2 == null || l2.longValue() == l.longValue()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Conflict found: ");
        sb.append(chronoField2);
        sb.append(" ");
        sb.append(l2);
        sb.append(" differs from ");
        sb.append(chronoField2);
        sb.append(" ");
        sb.append(l);
        sb.append(" while resolving  ");
        sb.append(chronoField);
        throw new DateTimeException(sb.toString());
    }

    public final void PlaceComponentResult() {
        if (this.PlaceComponentResult.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.getErrorConfigVersion;
            if (zoneId == null) {
                Long l = (Long) this.PlaceComponentResult.get(ChronoField.OFFSET_SECONDS);
                if (l == null) {
                    return;
                }
                zoneId = ZoneOffset.ofTotalSeconds(l.intValue());
            }
            getAuthRequestContext(zoneId);
        }
    }

    public final void PlaceComponentResult(LocalTime localTime, Period period) {
        LocalTime localTime2 = this.lookAheadTest;
        if (localTime2 == null) {
            this.lookAheadTest = localTime;
        } else if (!localTime2.equals(localTime)) {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Conflict found: Fields resolved to different times: ");
            PlaceComponentResult.append(this.lookAheadTest);
            PlaceComponentResult.append(" ");
            PlaceComponentResult.append(localTime);
            throw new DateTimeException(PlaceComponentResult.toString());
        } else {
            Period period2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Period period3 = Period.ZERO;
            if (!(period2 == period3)) {
                if (!(period == period3) && !this.KClassImpl$Data$declaredNonStaticMembers$2.equals(period)) {
                    StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Conflict found: Fields resolved to different excess periods: ");
                    PlaceComponentResult2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    PlaceComponentResult2.append(" ");
                    PlaceComponentResult2.append(period);
                    throw new DateTimeException(PlaceComponentResult2.toString());
                }
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = period;
    }

    public final void PlaceComponentResult(ChronoLocalDate chronoLocalDate) {
        ChronoLocalDate chronoLocalDate2 = this.getAuthRequestContext;
        if (chronoLocalDate2 != null) {
            if (chronoLocalDate == null || chronoLocalDate2.equals(chronoLocalDate)) {
                return;
            }
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Conflict found: Fields resolved to two different dates: ");
            PlaceComponentResult.append(this.getAuthRequestContext);
            PlaceComponentResult.append(" ");
            PlaceComponentResult.append(chronoLocalDate);
            throw new DateTimeException(PlaceComponentResult.toString());
        } else if (chronoLocalDate != null) {
            if (((AbstractChronology) this.BuiltInFictitiousFunctionClassFactory).equals(chronoLocalDate.getChronology())) {
                this.getAuthRequestContext = chronoLocalDate;
                return;
            }
            StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("ChronoLocalDate must use the effective parsed chronology: ");
            PlaceComponentResult2.append(this.BuiltInFictitiousFunctionClassFactory);
            throw new DateTimeException(PlaceComponentResult2.toString());
        }
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int get(TemporalField temporalField) {
        return Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField != null) {
            Long l = (Long) this.PlaceComponentResult.get(temporalField);
            if (l != null) {
                return l.longValue();
            }
            ChronoLocalDate chronoLocalDate = this.getAuthRequestContext;
            if (chronoLocalDate == null || !chronoLocalDate.isSupported(temporalField)) {
                LocalTime localTime = this.lookAheadTest;
                if (localTime == null || !localTime.isSupported(temporalField)) {
                    if (temporalField instanceof ChronoField) {
                        throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
                    }
                    return temporalField.getFrom(this);
                }
                return this.lookAheadTest.getLong(temporalField);
            }
            return this.getAuthRequestContext.getLong(temporalField);
        }
        throw new NullPointerException("field");
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        ChronoLocalDate chronoLocalDate;
        LocalTime localTime;
        return this.PlaceComponentResult.containsKey(temporalField) || ((chronoLocalDate = this.getAuthRequestContext) != null && chronoLocalDate.isSupported(temporalField)) || (((localTime = this.lookAheadTest) != null && localTime.isSupported(temporalField)) || !(temporalField == null || (temporalField instanceof ChronoField) || !temporalField.isSupportedBy(this)));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
        if (temporalQuery == Temporal.CC.moveToNextValue()) {
            return this.getErrorConfigVersion;
        }
        if (temporalQuery == Temporal.CC.getAuthRequestContext()) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        if (temporalQuery == Temporal.CC.PlaceComponentResult()) {
            ChronoLocalDate chronoLocalDate = this.getAuthRequestContext;
            if (chronoLocalDate != null) {
                return LocalDate.from(chronoLocalDate);
            }
            return null;
        }
        temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
        if (temporalQuery == temporalQueries$$ExternalSyntheticLambda0) {
            return this.lookAheadTest;
        }
        if (temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory()) {
            return temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        if (temporalQuery == Temporal.CC.MyBillsEntityDataFactory()) {
            return null;
        }
        return temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.PlaceComponentResult);
        sb.append(',');
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        if (this.getErrorConfigVersion != null) {
            sb.append(',');
            sb.append(this.getErrorConfigVersion);
        }
        if (this.getAuthRequestContext != null || this.lookAheadTest != null) {
            sb.append(" resolved to ");
            ChronoLocalDate chronoLocalDate = this.getAuthRequestContext;
            if (chronoLocalDate != null) {
                sb.append(chronoLocalDate);
                if (this.lookAheadTest != null) {
                    sb.append('T');
                }
            }
            sb.append(this.lookAheadTest);
        }
        return sb.toString();
    }
}
