package o;

/* loaded from: classes3.dex */
public class NetworkUserEntityData$$ExternalSyntheticLambda4 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] PlaceComponentResult(int i, int i2) {
        long[] jArr = new long[4];
        jArr[0] = (i2 & 4294967295L) | ((i & 4294967295L) << 32);
        for (int i3 = 1; i3 < 4; i3++) {
            long j = jArr[i3 - 1];
            jArr[i3] = ((j ^ (j >> 30)) * 1812433253) + i3;
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(long[] jArr, long[] jArr2, int i) {
        int i2 = (i + 2) % 4;
        long j = ((jArr[i % 4] * 2147483085) + jArr2[i2]) % 2147483647L;
        int i3 = (i + 3) % 4;
        jArr2[i3] = ((jArr[i3] * 2147483085) + jArr2[i2]) / 2147483647L;
        jArr[i3] = j;
    }
}
