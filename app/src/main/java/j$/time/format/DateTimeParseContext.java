package j$.time.format;

import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.TemporalField;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class DateTimeParseContext {
    DateTimeFormatter BuiltInFictitiousFunctionClassFactory;
    final ArrayList MyBillsEntityDataFactory;
    ArrayList getAuthRequestContext;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    boolean PlaceComponentResult = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory = arrayList;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = dateTimeFormatter;
        arrayList.add(new Parsed());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(char c, char c2) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 ? c == c2 : KClassImpl$Data$declaredNonStaticMembers$2(c, c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(boolean z) {
        ArrayList arrayList;
        int size;
        if (z) {
            arrayList = this.MyBillsEntityDataFactory;
            size = arrayList.size() - 2;
        } else {
            arrayList = this.MyBillsEntityDataFactory;
            size = arrayList.size() - 1;
        }
        arrayList.remove(size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            char charAt = charSequence.charAt(i + i5);
            char charAt2 = charSequence2.charAt(i2 + i5);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Chronology BuiltInFictitiousFunctionClassFactory() {
        Chronology chronology = ((Parsed) this.MyBillsEntityDataFactory.get(r0.size() - 1)).BuiltInFictitiousFunctionClassFactory;
        if (chronology == null) {
            Chronology chronology2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
        }
        return chronology;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(TemporalField temporalField, long j, int i, int i2) {
        if (temporalField != null) {
            Long l = (Long) ((Parsed) this.MyBillsEntityDataFactory.get(r0.size() - 1)).PlaceComponentResult.put(temporalField, Long.valueOf(j));
            return (l == null || l.longValue() == j) ? i2 : i ^ (-1);
        }
        throw new NullPointerException("field");
    }

    public final String toString() {
        return ((Parsed) this.MyBillsEntityDataFactory.get(r0.size() - 1)).toString();
    }
}
