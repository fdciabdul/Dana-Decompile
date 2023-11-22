package j$.time;

import j$.time.temporal.TemporalField;

/* loaded from: classes.dex */
public abstract /* synthetic */ class DayOfWeek$$ExternalSyntheticOutline0 {
    public static /* synthetic */ String BuiltInFictitiousFunctionClassFactory(int i) {
        return i == 1 ? "REFERENCE" : i == 2 ? "INT_VALUE" : i == 3 ? "LONG_VALUE" : i == 4 ? "DOUBLE_VALUE" : "null";
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(int i) {
        return i == 1 ? "UTC" : i == 2 ? "WALL" : i == 3 ? "STANDARD" : "null";
    }

    public static String MyBillsEntityDataFactory(String str, TemporalField temporalField) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(temporalField);
        return sb.toString();
    }

    public static StringBuilder PlaceComponentResult(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }
}
