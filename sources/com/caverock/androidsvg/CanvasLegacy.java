package com.caverock.androidsvg;

import android.graphics.Canvas;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class CanvasLegacy {
    static final int MATRIX_SAVE_FLAG;
    private static final Method SAVE;

    CanvasLegacy() {
    }

    static {
        try {
            MATRIX_SAVE_FLAG = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            SAVE = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void save(Canvas canvas, int i) {
        try {
            SAVE.invoke(canvas, Integer.valueOf(i));
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    private static RuntimeException sneakyThrow(Throwable th) {
        if (th == null) {
            throw new NullPointerException(SecurityConstants.KEY_TEXT);
        }
        return (RuntimeException) sneakyThrow0(th);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable th) throws Throwable {
        throw th;
    }
}
