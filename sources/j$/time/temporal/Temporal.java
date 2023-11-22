package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.LocalDate;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public interface Temporal extends TemporalAccessor {

    /* renamed from: j$.time.temporal.Temporal$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class CC {
        static final TemporalQueries$$ExternalSyntheticLambda0 lookAheadTest = new TemporalQueries$$ExternalSyntheticLambda0(0);
        static final TemporalQueries$$ExternalSyntheticLambda0 getAuthRequestContext = new TemporalQueries$$ExternalSyntheticLambda0(2);
        static final TemporalQueries$$ExternalSyntheticLambda0 BuiltInFictitiousFunctionClassFactory = new TemporalQueries$$ExternalSyntheticLambda0(3);
        static final TemporalQueries$$ExternalSyntheticLambda0 MyBillsEntityDataFactory = new TemporalQueries$$ExternalSyntheticLambda0(4);
        static final TemporalQueries$$ExternalSyntheticLambda0 getErrorConfigVersion = new TemporalQueries$$ExternalSyntheticLambda0(5);
        static final TemporalQueries$$ExternalSyntheticLambda0 PlaceComponentResult = new TemporalQueries$$ExternalSyntheticLambda0(6);
        static final TemporalQueries$$ExternalSyntheticLambda0 KClassImpl$Data$declaredNonStaticMembers$2 = new TemporalQueries$$ExternalSyntheticLambda0(7);

        public static int BuiltInFictitiousFunctionClassFactory(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            ValueRange range = temporalAccessor.range(temporalField);
            if (!range.isIntValue()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid field ");
                sb.append(temporalField);
                sb.append(" for get() method, use getLong() instead");
                throw new UnsupportedTemporalTypeException(sb.toString());
            }
            long j = temporalAccessor.getLong(temporalField);
            if (range.isValidValue(j)) {
                return (int) j;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid value for ");
            sb2.append(temporalField);
            sb2.append(" (valid values ");
            sb2.append(range);
            sb2.append("): ");
            sb2.append(j);
            throw new DateTimeException(sb2.toString());
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 BuiltInFictitiousFunctionClassFactory() {
            return MyBillsEntityDataFactory;
        }

        public static Object BuiltInFictitiousFunctionClassFactory(TemporalAccessor temporalAccessor, TemporalQuery temporalQuery) {
            if (temporalQuery == lookAheadTest || temporalQuery == getAuthRequestContext || temporalQuery == BuiltInFictitiousFunctionClassFactory) {
                return null;
            }
            return temporalQuery.KClassImpl$Data$declaredNonStaticMembers$2(temporalAccessor);
        }

        public static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int i2 = i % 7;
            if (i2 == 0) {
                return 0;
            }
            return (((i ^ 7) >> 31) | 1) > 0 ? i2 : i2 + 7;
        }

        public static Temporal MyBillsEntityDataFactory(Temporal temporal, long j, ChronoUnit chronoUnit) {
            long j2;
            if (j == Long.MIN_VALUE) {
                temporal = temporal.plus(LongCompanionObject.MAX_VALUE, chronoUnit);
                j2 = 1;
            } else {
                j2 = -j;
            }
            return temporal.plus(j2, chronoUnit);
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 MyBillsEntityDataFactory() {
            return BuiltInFictitiousFunctionClassFactory;
        }

        public static ValueRange MyBillsEntityDataFactory(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            if (temporalField instanceof ChronoField) {
                if (temporalAccessor.isSupported(temporalField)) {
                    return temporalField.range();
                }
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            } else if (temporalField != null) {
                return temporalField.rangeRefinedBy(temporalAccessor);
            } else {
                throw new NullPointerException("field");
            }
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 PlaceComponentResult() {
            return PlaceComponentResult;
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 getAuthRequestContext() {
            return getAuthRequestContext;
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 getErrorConfigVersion() {
            return getErrorConfigVersion;
        }

        public static TemporalQueries$$ExternalSyntheticLambda0 moveToNextValue() {
            return lookAheadTest;
        }
    }

    Temporal minus(long j, ChronoUnit chronoUnit);

    Temporal plus(long j, TemporalUnit temporalUnit);

    long until(Temporal temporal, TemporalUnit temporalUnit);

    Temporal with(long j, TemporalField temporalField);

    /* renamed from: with */
    Temporal mo3168with(LocalDate localDate);
}
