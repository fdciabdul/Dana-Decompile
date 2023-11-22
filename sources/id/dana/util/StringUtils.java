package id.dana.util;

/* loaded from: classes2.dex */
public final class StringUtils {
    private StringUtils() {
    }

    public static boolean PlaceComponentResult(String str, String... strArr) {
        if (str != null) {
            int length = strArr.length;
            for (int i = 0; i < 4; i++) {
                if (str.contains(strArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
