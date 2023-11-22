package id.dana.utils.android;

import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/utils/android/OSUtil;", "", "", "BuiltInFictitiousFunctionClassFactory", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OSUtil {
    public static final OSUtil INSTANCE = new OSUtil();

    private OSUtil() {
    }

    public static int BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT;
    }
}
