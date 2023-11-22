package j$.time.format;

import j$.time.DateTimeException;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;

/* loaded from: classes6.dex */
public final class DateTimePrintContext {
    DateTimeFormatter BuiltInFictitiousFunctionClassFactory;
    int MyBillsEntityDataFactory;
    TemporalAccessor PlaceComponentResult;

    public final Object KClassImpl$Data$declaredNonStaticMembers$2(TemporalQuery temporalQuery) {
        Object query = this.PlaceComponentResult.query(temporalQuery);
        if (query == null && this.MyBillsEntityDataFactory == 0) {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unable to extract value: ");
            PlaceComponentResult.append(this.PlaceComponentResult.getClass());
            throw new DateTimeException(PlaceComponentResult.toString());
        }
        return query;
    }

    public final Long PlaceComponentResult(TemporalField temporalField) {
        try {
            return Long.valueOf(this.PlaceComponentResult.getLong(temporalField));
        } catch (DateTimeException e) {
            if (this.MyBillsEntityDataFactory > 0) {
                return null;
            }
            throw e;
        }
    }

    public final String toString() {
        return this.PlaceComponentResult.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DateTimePrintContext(final j$.time.temporal.TemporalAccessor r10, j$.time.format.DateTimeFormatter r11) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimePrintContext.<init>(j$.time.temporal.TemporalAccessor, j$.time.format.DateTimeFormatter):void");
    }
}
