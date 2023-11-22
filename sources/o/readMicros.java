package o;

/* loaded from: classes7.dex */
public final class readMicros {
    public static void BuiltInFictitiousFunctionClassFactory(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
