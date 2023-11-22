package fsimpl;

import android.graphics.Color;

/* loaded from: classes8.dex */
public class eA {
    public static int a(long j) {
        return Color.argb(Color.alpha(j), Color.red(j), Color.green(j), Color.blue(j));
    }

    public static int[] a(long[] jArr) {
        int length = jArr != null ? jArr.length : 0;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = a(jArr[i]);
        }
        return iArr;
    }
}
