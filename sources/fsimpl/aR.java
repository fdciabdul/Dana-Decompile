package fsimpl;

import android.graphics.Shader;

/* loaded from: classes4.dex */
public class aR {
    public static byte a(Shader.TileMode tileMode) {
        if (tileMode == null) {
            return (byte) 0;
        }
        int i = aS.f7833a[tileMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? (byte) 0 : (byte) 2;
            }
            return (byte) 3;
        }
        return (byte) 1;
    }
}
