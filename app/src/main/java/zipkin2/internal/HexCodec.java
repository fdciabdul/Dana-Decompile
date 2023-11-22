package zipkin2.internal;

/* loaded from: classes6.dex */
public final class HexCodec {
    public static final char[] BuiltInFictitiousFunctionClassFactory = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static long BuiltInFictitiousFunctionClassFactory(String str) {
        int length = str.length();
        if (length <= 0 || length > 32) {
            throw PlaceComponentResult(str);
        }
        return MyBillsEntityDataFactory(str, length > 16 ? length - 16 : 0);
    }

    public static long MyBillsEntityDataFactory(String str, int i) {
        int i2;
        int min = Math.min(i + 16, str.length());
        long j = 0;
        while (i < min) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i2 = charAt - '0';
            } else if (charAt < 'a' || charAt > 'f') {
                throw PlaceComponentResult(str);
            } else {
                i2 = (charAt - 'a') + 10;
            }
            j = (j << 4) | i2;
            i++;
        }
        return j;
    }

    private static NumberFormatException PlaceComponentResult(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" should be a 1 to 32 character lower-hex string with no prefix");
        throw new NumberFormatException(sb.toString());
    }

    HexCodec() {
    }
}
