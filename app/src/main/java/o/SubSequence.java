package o;

/* loaded from: classes7.dex */
public class SubSequence {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
