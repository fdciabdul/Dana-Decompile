package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.Chronology;
import j$.time.temporal.Temporal;

/* loaded from: classes6.dex */
public final /* synthetic */ class TemporalQueries$$ExternalSyntheticLambda0 implements TemporalAdjuster, TemporalQuery {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ TemporalQueries$$ExternalSyntheticLambda0(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // j$.time.temporal.TemporalQuery
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(TemporalAccessor temporalAccessor) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        ChronoField chronoField = ChronoField.OFFSET_SECONDS;
                        if (temporalAccessor.isSupported(chronoField)) {
                            return ZoneOffset.ofTotalSeconds(temporalAccessor.get(chronoField));
                        }
                        return null;
                    } else if (i == 5) {
                        ZoneId zoneId = (ZoneId) temporalAccessor.query(Temporal.CC.lookAheadTest);
                        return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(Temporal.CC.MyBillsEntityDataFactory);
                    } else if (i != 6) {
                        ChronoField chronoField2 = ChronoField.NANO_OF_DAY;
                        if (temporalAccessor.isSupported(chronoField2)) {
                            return LocalTime.ofNanoOfDay(temporalAccessor.getLong(chronoField2));
                        }
                        return null;
                    } else {
                        ChronoField chronoField3 = ChronoField.EPOCH_DAY;
                        if (temporalAccessor.isSupported(chronoField3)) {
                            return LocalDate.ofEpochDay(temporalAccessor.getLong(chronoField3));
                        }
                        return null;
                    }
                }
                return (TemporalUnit) temporalAccessor.query(Temporal.CC.BuiltInFictitiousFunctionClassFactory);
            }
            return (Chronology) temporalAccessor.query(Temporal.CC.getAuthRequestContext);
        }
        return (ZoneId) temporalAccessor.query(Temporal.CC.lookAheadTest);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        ChronoField chronoField = ChronoField.DAY_OF_MONTH;
        return temporal.with(temporal.range(chronoField).getMaximum(), chronoField);
    }
}
