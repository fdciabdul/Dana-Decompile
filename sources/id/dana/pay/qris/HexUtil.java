package id.dana.pay.qris;

/* loaded from: classes5.dex */
class HexUtil {
    private HexUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] MyBillsEntityDataFactory(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PlaceComponentResult(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes()) {
            sb.append(new String(new char[]{Character.forDigit((b >> 4) & 15, 16), Character.forDigit(b & 15, 16)}));
        }
        return sb.toString();
    }
}
