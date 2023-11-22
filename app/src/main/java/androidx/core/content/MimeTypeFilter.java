package androidx.core.content;

/* loaded from: classes3.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean PlaceComponentResult(String[] strArr, String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        }
        if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        }
        if (strArr.length != 2) {
            return false;
        }
        if ("*".equals(strArr2[0]) || strArr2[0].equals(strArr[0])) {
            return "*".equals(strArr2[1]) || strArr2[1].equals(strArr[1]);
        }
        return false;
    }

    public static String PlaceComponentResult(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (PlaceComponentResult(split, str2.split("/"))) {
                return str2;
            }
        }
        return null;
    }
}
