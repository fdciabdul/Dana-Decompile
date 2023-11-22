package j$.time.chrono;

import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;

/* loaded from: classes9.dex */
public enum ThaiBuddhistEra implements Era {
    BEFORE_BE,
    BE;

    @Override // j$.time.temporal.TemporalAdjuster
    public final /* synthetic */ Temporal adjustInto(Temporal temporal) {
        return Era.CC.BuiltInFictitiousFunctionClassFactory(this, temporal);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int get(TemporalField temporalField) {
        return Era.CC.PlaceComponentResult(this, (ChronoField) temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ long getLong(TemporalField temporalField) {
        return Era.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    @Override // j$.time.chrono.Era
    public final int getValue() {
        return ordinal();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ boolean isSupported(TemporalField temporalField) {
        return Era.CC.getAuthRequestContext(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object query(TemporalQuery temporalQuery) {
        return Era.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }
}
