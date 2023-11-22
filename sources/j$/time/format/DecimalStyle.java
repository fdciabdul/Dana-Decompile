package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public final class DecimalStyle {
    public static final DecimalStyle getAuthRequestContext = new DecimalStyle();

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private DecimalStyle() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(char c) {
        int i = c - '0';
        if (i < 0 || i > 9) {
            return -1;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecimalStyle) {
            DecimalStyle decimalStyle = (DecimalStyle) obj;
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 182;
    }

    public final String toString() {
        return "DecimalStyle[0+-.]";
    }
}
