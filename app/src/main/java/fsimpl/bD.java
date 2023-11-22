package fsimpl;

import android.content.res.AssetManager;
import com.fullstory.jni.FSNative;
import com.fullstory.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class bD {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7870a;
    private static final Method b;

    static {
        Method a2 = FSNative.b ? eV.a(30, AssetManager.class, "getPooledStringForCookie", Integer.TYPE, Integer.TYPE) : null;
        b = a2;
        f7870a = a2 != null;
    }

    public static String a(AssetManager assetManager, long j) {
        if (f7870a && assetManager != null && j != -1) {
            try {
                Object invoke = b.invoke(assetManager, Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) (j & 65535)));
                if (invoke instanceof CharSequence) {
                    return invoke.toString();
                }
            } catch (Throwable unused) {
                boolean z = Log.DISABLE_LOGGING;
            }
        }
        return null;
    }
}
