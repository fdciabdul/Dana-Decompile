package id.dana.utils;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes3.dex */
public class ContextUtil {
    private ContextUtil() {
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        if (!(context instanceof Activity)) {
            return context != null;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }
}
