package androidx.room.util;

/* loaded from: classes6.dex */
public class StringUtil {
    public static final String[] BuiltInFictitiousFunctionClassFactory = new String[0];

    public static StringBuilder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new StringBuilder();
    }

    public static void PlaceComponentResult(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    private StringUtil() {
    }
}
