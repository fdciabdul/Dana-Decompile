package o;

/* loaded from: classes.dex */
public class NetworkUserEntityData$$ExternalSyntheticLambda8 {
    public static void getAuthRequestContext(int i, int i2, boolean z, int i3, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z) {
            KClassImpl$Data$declaredNonStaticMembers$2(iArr);
        }
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        while (i6 < i3) {
            int i7 = i4 ^ iArr[i6];
            int i8 = i5 ^ ((iArr2[2][(i7 >>> 8) & 255] ^ (iArr2[0][(i7 >>> 24) & 255] + iArr2[1][(i7 >>> 16) & 255])) + iArr2[3][i7 & 255]);
            i6++;
            i5 = i7;
            i4 = i8;
        }
        int i9 = i4 ^ iArr[iArr.length - 2];
        int i10 = i5 ^ iArr[iArr.length - 1];
        if (!z) {
            KClassImpl$Data$declaredNonStaticMembers$2(iArr);
        }
        iArr3[0] = i10;
        iArr3[1] = i9;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }
}
