package fsimpl;

import android.content.res.Resources;
import android.graphics.NinePatch;
import com.fullstory.jni.FSNative;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bF {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7872a;
    private static final Class b;
    private static final Field c;

    static {
        Field field = null;
        if (FSNative.b) {
            Class a2 = eV.a("android.graphics.drawable.NinePatchDrawable$NinePatchState");
            b = a2;
            field = eV.a(a2, "mNinePatch");
        } else {
            b = null;
        }
        c = field;
        f7872a = (b == null || field == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bA bAVar, Resources resources, Object obj, long j) {
        try {
            NinePatch ninePatch = (NinePatch) c.get(obj);
            if (ninePatch != null) {
                bC.a(bAVar, resources, ninePatch.getBitmap(), j);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj) {
        if (f7872a) {
            return b.isInstance(obj);
        }
        return false;
    }
}
