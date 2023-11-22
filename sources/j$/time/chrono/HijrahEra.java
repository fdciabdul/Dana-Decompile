package j$.time.chrono;

import j$.time.chrono.Era;
import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes9.dex */
public final class HijrahEra implements Era {
    private static final /* synthetic */ HijrahEra[] $VALUES;
    public static final HijrahEra AH;

    static {
        HijrahEra hijrahEra = new HijrahEra();
        AH = hijrahEra;
        $VALUES = new HijrahEra[]{hijrahEra};
    }

    private HijrahEra() {
    }

    public static HijrahEra valueOf(String str) {
        return (HijrahEra) Enum.valueOf(HijrahEra.class, str);
    }

    public static HijrahEra[] values() {
        return (HijrahEra[]) $VALUES.clone();
    }

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
        return 1;
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
        return temporalField == ChronoField.ERA ? ValueRange.of(1L, 1L) : Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }
}
