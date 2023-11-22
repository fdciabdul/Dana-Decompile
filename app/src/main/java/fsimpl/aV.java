package fsimpl;

import android.graphics.drawable.Drawable;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class aV {

    /* renamed from: a  reason: collision with root package name */
    private static fg f7836a = new fg();
    private static WeakHashMap b = new WeakHashMap();

    public static int a(Drawable drawable) {
        return f7836a.b(drawable);
    }

    public static void a(Drawable drawable, int i) {
        f7836a.a(drawable, i);
        b.put(drawable, fc.a(drawable));
    }

    public static fc b(Drawable drawable) {
        return (fc) b.get(drawable);
    }
}
