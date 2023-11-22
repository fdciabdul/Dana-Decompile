package j$.time.chrono;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes9.dex */
public interface Era extends TemporalAccessor, TemporalAdjuster {

    /* renamed from: j$.time.chrono.Era$-CC */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class CC {
        public static int BuiltInFictitiousFunctionClassFactory(ChronoLocalDateTime chronoLocalDateTime, ChronoLocalDateTime chronoLocalDateTime2) {
            int compareTo = chronoLocalDateTime.toLocalDate().compareTo(chronoLocalDateTime2.toLocalDate());
            if (compareTo == 0) {
                int compareTo2 = chronoLocalDateTime.toLocalTime().compareTo(chronoLocalDateTime2.toLocalTime());
                if (compareTo2 == 0) {
                    return ((AbstractChronology) chronoLocalDateTime.getChronology()).compareTo(chronoLocalDateTime2.getChronology());
                }
                return compareTo2;
            }
            return compareTo;
        }

        public static int BuiltInFictitiousFunctionClassFactory(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
            int compare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
            if (compare == 0) {
                int nano = chronoZonedDateTime.toLocalTime().getNano() - chronoZonedDateTime2.toLocalTime().getNano();
                if (nano == 0) {
                    int compareTo = chronoZonedDateTime.toLocalDateTime().compareTo(chronoZonedDateTime2.toLocalDateTime());
                    if (compareTo == 0) {
                        int compareTo2 = chronoZonedDateTime.getZone().getId().compareTo(chronoZonedDateTime2.getZone().getId());
                        if (compareTo2 == 0) {
                            return ((AbstractChronology) chronoZonedDateTime.getChronology()).compareTo(chronoZonedDateTime2.getChronology());
                        }
                        return compareTo2;
                    }
                    return compareTo;
                }
                return nano;
            }
            return compare;
        }

        public static int BuiltInFictitiousFunctionClassFactory(ChronoZonedDateTime chronoZonedDateTime, TemporalField temporalField) {
            if (temporalField instanceof ChronoField) {
                int i = ChronoZonedDateTime.AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[((ChronoField) temporalField).ordinal()];
                if (i != 1) {
                    return i != 2 ? chronoZonedDateTime.toLocalDateTime().get(temporalField) : chronoZonedDateTime.getOffset().getTotalSeconds();
                }
                throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            return Temporal.CC.BuiltInFictitiousFunctionClassFactory(chronoZonedDateTime, temporalField);
        }

        public static long BuiltInFictitiousFunctionClassFactory(ChronoZonedDateTime chronoZonedDateTime) {
            return ((chronoZonedDateTime.toLocalDate().toEpochDay() * TimeUtils.DAY_TO_SECOND) + chronoZonedDateTime.toLocalTime().toSecondOfDay()) - chronoZonedDateTime.getOffset().getTotalSeconds();
        }

        public static Chronology BuiltInFictitiousFunctionClassFactory(TemporalAccessor temporalAccessor) {
            if (temporalAccessor != null) {
                Chronology chronology = (Chronology) temporalAccessor.query(Temporal.CC.getAuthRequestContext());
                return chronology == null ? IsoChronology.INSTANCE : chronology;
            }
            throw new NullPointerException("temporal");
        }

        public static Temporal BuiltInFictitiousFunctionClassFactory(Era era, Temporal temporal) {
            return temporal.with(era.getValue(), ChronoField.ERA);
        }

        public static Object BuiltInFictitiousFunctionClassFactory(ChronoZonedDateTime chronoZonedDateTime, TemporalQuery temporalQuery) {
            TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
            if (temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.moveToNextValue()) {
                return chronoZonedDateTime.getZone();
            }
            if (temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory()) {
                return chronoZonedDateTime.getOffset();
            }
            temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
            return temporalQuery == temporalQueries$$ExternalSyntheticLambda0 ? chronoZonedDateTime.toLocalTime() : temporalQuery == Temporal.CC.getAuthRequestContext() ? chronoZonedDateTime.getChronology() : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.NANOS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(chronoZonedDateTime);
        }

        public static int KClassImpl$Data$declaredNonStaticMembers$2(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            int compare = Long.compare(chronoLocalDate.toEpochDay(), chronoLocalDate2.toEpochDay());
            if (compare == 0) {
                return ((AbstractChronology) chronoLocalDate.getChronology()).compareTo(chronoLocalDate2.getChronology());
            }
            return compare;
        }

        public static Temporal KClassImpl$Data$declaredNonStaticMembers$2(ChronoLocalDateTime chronoLocalDateTime, Temporal temporal) {
            return temporal.with(chronoLocalDateTime.toLocalDate().toEpochDay(), ChronoField.EPOCH_DAY).with(chronoLocalDateTime.toLocalTime().toNanoOfDay(), ChronoField.NANO_OF_DAY);
        }

        public static Object KClassImpl$Data$declaredNonStaticMembers$2(ChronoLocalDate chronoLocalDate, TemporalQuery temporalQuery) {
            TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
            if (temporalQuery == Temporal.CC.moveToNextValue() || temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory()) {
                return null;
            }
            temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
            if (temporalQuery == temporalQueries$$ExternalSyntheticLambda0) {
                return null;
            }
            return temporalQuery == Temporal.CC.getAuthRequestContext() ? chronoLocalDate.getChronology() : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.DAYS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(chronoLocalDate);
        }

        public static Object KClassImpl$Data$declaredNonStaticMembers$2(Era era, TemporalQuery temporalQuery) {
            return temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.ERAS : Temporal.CC.BuiltInFictitiousFunctionClassFactory(era, temporalQuery);
        }

        public static long MyBillsEntityDataFactory(Era era, TemporalField temporalField) {
            if (temporalField == ChronoField.ERA) {
                return era.getValue();
            }
            if (temporalField instanceof ChronoField) {
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            }
            return temporalField.getFrom(era);
        }

        public static int PlaceComponentResult(Era era, ChronoField chronoField) {
            return chronoField == ChronoField.ERA ? era.getValue() : Temporal.CC.BuiltInFictitiousFunctionClassFactory(era, chronoField);
        }

        public static Instant PlaceComponentResult(ChronoLocalDateTime chronoLocalDateTime, ZoneOffset zoneOffset) {
            return Instant.ofEpochSecond(chronoLocalDateTime.toEpochSecond(zoneOffset), chronoLocalDateTime.toLocalTime().getNano());
        }

        public static Object PlaceComponentResult(ChronoLocalDateTime chronoLocalDateTime, TemporalQuery temporalQuery) {
            TemporalQueries$$ExternalSyntheticLambda0 temporalQueries$$ExternalSyntheticLambda0;
            if (temporalQuery == Temporal.CC.moveToNextValue() || temporalQuery == Temporal.CC.getErrorConfigVersion() || temporalQuery == Temporal.CC.BuiltInFictitiousFunctionClassFactory()) {
                return null;
            }
            temporalQueries$$ExternalSyntheticLambda0 = Temporal.CC.KClassImpl$Data$declaredNonStaticMembers$2;
            return temporalQuery == temporalQueries$$ExternalSyntheticLambda0 ? chronoLocalDateTime.toLocalTime() : temporalQuery == Temporal.CC.getAuthRequestContext() ? chronoLocalDateTime.getChronology() : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.NANOS : temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(chronoLocalDateTime);
        }

        public static boolean PlaceComponentResult(ChronoLocalDate chronoLocalDate, TemporalField temporalField) {
            return temporalField instanceof ChronoField ? temporalField.isDateBased() : temporalField != null && temporalField.isSupportedBy(chronoLocalDate);
        }

        public static long getAuthRequestContext(ChronoLocalDateTime chronoLocalDateTime, ZoneOffset zoneOffset) {
            if (zoneOffset != null) {
                return ((chronoLocalDateTime.toLocalDate().toEpochDay() * TimeUtils.DAY_TO_SECOND) + chronoLocalDateTime.toLocalTime().toSecondOfDay()) - zoneOffset.getTotalSeconds();
            }
            throw new NullPointerException("offset");
        }

        public static Temporal getAuthRequestContext(ChronoLocalDate chronoLocalDate, Temporal temporal) {
            return temporal.with(chronoLocalDate.toEpochDay(), ChronoField.EPOCH_DAY);
        }

        public static boolean getAuthRequestContext(Era era, TemporalField temporalField) {
            return temporalField instanceof ChronoField ? temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(era);
        }
    }

    int getValue();
}
