package fsimpl;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import com.fullstory.instrumentation.CurrentPlatform;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class aO {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7831a;
    private static final Method b = eV.a(-1, 31, PorterDuffColorFilter.class, "getColor", new Class[0]);
    private static final Method c;
    private static final boolean d;
    private static final Field e;
    private static final Method f;
    private static final Method g;

    static {
        Method a2 = eV.a(-1, 31, PorterDuffColorFilter.class, "getMode", new Class[0]);
        c = a2;
        f7831a = b == null || a2 == null;
        e = eV.a(30, C0355ez.h, "mXfermode");
        f = eV.a(31, C0355ez.g, "getColor", new Class[0]);
        Method a3 = eV.a(31, C0355ez.g, "getMode", new Class[0]);
        g = a3;
        d = f == null || a3 == null || e == null;
    }

    private void b(PorterDuffColorFilter porterDuffColorFilter, cQ cQVar) {
        int intValue;
        PorterDuff.Mode mode;
        if (CurrentPlatform.SDK_INT_FIXED < 31) {
            intValue = porterDuffColorFilter.getColor();
            mode = porterDuffColorFilter.getMode();
        } else {
            try {
                intValue = ((Integer) b.invoke(porterDuffColorFilter, new Object[0])).intValue();
                try {
                    mode = (PorterDuff.Mode) c.invoke(porterDuffColorFilter, new Object[0]);
                } catch (Throwable th) {
                    cS.a("Failed to get ColorFilter's Mode", th);
                    return;
                }
            } catch (Throwable th2) {
                cS.a("Failed to get ColorFilter's color", th2);
                return;
            }
        }
        cQVar.k(intValue);
        cQVar.l(aN.a(mode));
    }

    public void a(PorterDuffColorFilter porterDuffColorFilter, cQ cQVar) {
        if (f7831a) {
            return;
        }
        b(porterDuffColorFilter, cQVar);
    }

    public void a(PorterDuffXfermode porterDuffXfermode, cQ cQVar) {
        try {
            if (C0249b.a()) {
                cQVar.o(C0249b.a(porterDuffXfermode));
            }
        } catch (Throwable th) {
            cS.a("Failed to get mode", th);
        }
    }

    public void a(Object obj, cQ cQVar) {
        if (!d && C0355ez.g.isInstance(obj)) {
            try {
                cQVar.k(((Integer) f.invoke(obj, new Object[0])).intValue());
                cQVar.l(C0249b.a((Xfermode) e.get(g.invoke(obj, new Object[0]))));
            } catch (Throwable th) {
                cS.a("Failed to get BlendMode's Xfermode", th);
            }
        }
    }
}
