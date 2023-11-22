package fsimpl;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.fullstory.jni.FSNative;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bE {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7871a;
    private static final Class b;
    private static final Class c;
    private static final Field d;
    private static final Field e;
    private static final Field f;

    static {
        Field field = null;
        if (FSNative.b) {
            Class a2 = eV.a("android.graphics.drawable.LayerDrawable$LayerState");
            b = a2;
            d = eV.a(30, a2, "mNumChildren");
            e = eV.a(b, "mChildren");
            Class a3 = eV.a("android.graphics.drawable.LayerDrawable$ChildDrawable");
            c = a3;
            field = eV.a(a3, "mDrawable");
        } else {
            b = null;
            d = null;
            e = null;
            c = null;
        }
        f = field;
        f7871a = (b == null || d == null || e == null || c == null || field == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bA bAVar, Resources resources, Object obj, long j) {
        try {
            int intValue = ((Integer) d.get(obj)).intValue();
            Object[] objArr = (Object[]) e.get(obj);
            for (int i = 0; i < intValue; i++) {
                Object obj2 = objArr[i];
                if (b(obj2)) {
                    try {
                        Drawable drawable = (Drawable) f.get(obj2);
                        if (drawable instanceof BitmapDrawable) {
                            bC.a(bAVar, resources, ((BitmapDrawable) drawable).getBitmap(), -1L);
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj) {
        if (f7871a) {
            return b.isInstance(obj);
        }
        return false;
    }

    private static boolean b(Object obj) {
        if (f7871a) {
            return c.isInstance(obj);
        }
        return false;
    }
}
