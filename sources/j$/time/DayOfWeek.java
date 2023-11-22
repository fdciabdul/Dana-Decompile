package j$.time;

import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;

/* loaded from: classes6.dex */
public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final DayOfWeek[] ENUMS = values();

    public static DayOfWeek of(int i) {
        if (i <= 0 || i > 7) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid value for DayOfWeek: ");
            sb.append(i);
            throw new DateTimeException(sb.toString());
        }
        return ENUMS[i - 1];
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        return temporal.with(getValue(), ChronoField.DAY_OF_WEEK);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField == ChronoField.DAY_OF_WEEK ? getValue() : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return getValue();
        }
        if (temporalField instanceof ChronoField) {
            throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
        }
        return temporalField.getFrom(this);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.DAY_OF_WEEK : temporalField != null && temporalField.isSupportedBy(this);
    }

    public final DayOfWeek plus(long j) {
        return ENUMS[((((int) (j % 7)) + 7) + ordinal()) % 7];
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.DAYS : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField == ChronoField.DAY_OF_WEEK ? temporalField.range() : Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }
}
