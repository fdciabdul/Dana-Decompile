package fsimpl;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* renamed from: fsimpl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0249b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7866a;
    private static Field b;
    private static Field c;

    static {
        String str;
        boolean z;
        if (Build.VERSION.SDK_INT < 26) {
            Field a2 = eV.a(PorterDuffXfermode.class, "mode");
            b = a2;
            if (a2 == null) {
                str = "Failed to locate PorterDuffXfermode native field 'mode'";
                Log.e(str);
                z = true;
            }
            z = false;
        } else {
            Field a3 = eV.a(-1, 31, Xfermode.class, "porterDuffMode");
            c = a3;
            if (a3 == null) {
                str = "Failed to locate Xfermode native field 'porterDuffMode'";
                Log.e(str);
                z = true;
            }
            z = false;
        }
        f7866a = z;
    }

    public static int a(Xfermode xfermode) {
        if (f7866a) {
            throw new IllegalAccessException("mode");
        }
        return b(xfermode);
    }

    public static boolean a() {
        return !f7866a;
    }

    private static int b(Xfermode xfermode) {
        Field field = b;
        return (field == null || !(xfermode instanceof PorterDuffXfermode)) ? aN.a(((Integer) c.get(xfermode)).intValue()) : aN.a((PorterDuff.Mode) field.get(xfermode));
    }
}
