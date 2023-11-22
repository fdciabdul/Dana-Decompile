package j$.time;

import com.alibaba.wireless.security.SecExceptionCode;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
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
public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    private static final Month[] ENUMS = values();

    /* renamed from: j$.time.Month$1 */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Month.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Month.FEBRUARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.APRIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.JUNE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.SEPTEMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.NOVEMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.JANUARY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.MARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.MAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.JULY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.AUGUST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.OCTOBER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Month.DECEMBER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Month of(int i) {
        if (i <= 0 || i > 12) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid value for MonthOfYear: ");
            sb.append(i);
            throw new DateTimeException(sb.toString());
        }
        return ENUMS[i - 1];
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        if (((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporal)).equals(IsoChronology.INSTANCE)) {
            return temporal.with(getValue(), ChronoField.MONTH_OF_YEAR);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public final int firstDayOfYear(boolean z) {
        switch (AnonymousClass1.BuiltInFictitiousFunctionClassFactory[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + 91;
            case 3:
                return (z ? 1 : 0) + 152;
            case 4:
                return (z ? 1 : 0) + 244;
            case 5:
                return (z ? 1 : 0) + SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE_DATA;
            case 6:
                return 1;
            case 7:
                return (z ? 1 : 0) + 60;
            case 8:
                return (z ? 1 : 0) + 121;
            case 9:
                return (z ? 1 : 0) + 182;
            case 10:
                return (z ? 1 : 0) + 213;
            case 11:
                return (z ? 1 : 0) + 274;
            default:
                return (z ? 1 : 0) + 335;
        }
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? getValue() : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
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
        return temporalField instanceof ChronoField ? temporalField == ChronoField.MONTH_OF_YEAR : temporalField != null && temporalField.isSupportedBy(this);
    }

    public final int length(boolean z) {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public final int maxLength() {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31;
        }
        return 29;
    }

    public final Month plus() {
        return ENUMS[(ordinal() + 13) % 12];
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.getAuthRequestContext() ? IsoChronology.INSTANCE : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.MONTHS : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        return temporalField == ChronoField.MONTH_OF_YEAR ? temporalField.range() : Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }
}
