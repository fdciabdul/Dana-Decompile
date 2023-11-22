package id.dana.utils;

/* loaded from: classes2.dex */
public class MaskedTextUtil {
    private MaskedTextUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String PlaceComponentResult(String str) {
        return str.replace("*", "•");
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, boolean z) {
        String replace;
        if (z) {
            replace = str.replace("+62", "0");
        } else {
            replace = str.replace("62-", "0");
        }
        return replace.replace("*", "•");
    }

    public static String MyBillsEntityDataFactory(String str) {
        String replace;
        if (str.contains("62-")) {
            replace = str.replace("62-", "0");
        } else {
            replace = str.replace("+62", "0");
        }
        return replace.replace("*", "•");
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (str != null) {
            String errorConfigVersion = TextUtil.getErrorConfigVersion(str);
            StringBuilder sb = new StringBuilder();
            sb.append("****");
            sb.append(errorConfigVersion);
            return sb.toString();
        }
        return str;
    }

    public static String PlaceComponentResult(String str, String str2) {
        if (str != null) {
            String substring = str.substring(0, str.length() - (str2.length() * 2));
            String substring2 = str.substring(str.length() - str2.length());
            StringBuilder sb = new StringBuilder();
            sb.append(substring);
            sb.append(str2);
            sb.append(substring2);
            return sb.toString();
        }
        return null;
    }
}
