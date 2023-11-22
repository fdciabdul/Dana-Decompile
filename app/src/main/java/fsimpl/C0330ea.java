package fsimpl;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.InputStream;
import java.lang.reflect.Method;

/* renamed from: fsimpl.ea  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0330ea {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f7965a;
    public static final boolean b;

    static {
        Method a2 = (Build.VERSION.SDK_INT < 28 || Build.VERSION.SDK_INT > 29) ? null : eV.a(-1, AssetManager.AssetInputStream.class, "getNativeAsset", new Class[0]);
        f7965a = a2;
        b = a2 != null;
    }

    public static Long a(InputStream inputStream) {
        if (b && (inputStream instanceof AssetManager.AssetInputStream)) {
            try {
                Long l = (Long) f7965a.invoke(inputStream, new Object[0]);
                if (l instanceof Long) {
                    return l;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
