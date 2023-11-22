package fsimpl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.fullstory.jni.FSNative;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bB {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7868a;
    private static final Class b;
    private static final Field c;

    static {
        Field field = null;
        if (FSNative.b) {
            Class a2 = eV.a("android.graphics.drawable.BitmapDrawable$BitmapState");
            b = a2;
            field = eV.a(30, a2, "mBitmap");
        } else {
            b = null;
        }
        c = field;
        f7868a = (b == null || field == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(bA bAVar, Resources resources, Object obj, long j) {
        try {
            bC.a(bAVar, resources, (Bitmap) c.get(obj), j);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj) {
        if (f7868a) {
            return b.isInstance(obj);
        }
        return false;
    }
}
