package fsimpl;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ProgressBar;
import com.fullstory.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: fsimpl.i  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC0359i extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f7995a;
    static final Method b;
    static final Field c;

    static {
        boolean z = Build.VERSION.SDK_INT < 26;
        f7995a = z;
        if (z) {
            b = null;
            c = eV.a(28, -1, ProgressBar.class, "mMirrorForRtl");
            return;
        }
        b = eV.a(28, 30, ProgressBar.class, "getMirrorForRtl", new Class[0]);
        c = null;
    }

    public static Drawable a(ProgressBar progressBar) {
        return progressBar.isIndeterminate() ? progressBar.getIndeterminateDrawable() : progressBar.getProgressDrawable();
    }

    public static boolean b(ProgressBar progressBar) {
        try {
            if (f7995a) {
                if (c != null) {
                    return ((Boolean) c.get(progressBar)).booleanValue();
                }
                return true;
            } else if (b != null) {
                return ((Boolean) b.invoke(progressBar, new Object[0])).booleanValue();
            } else {
                return true;
            }
        } catch (Throwable th) {
            Log.e(f7995a ? "Could not get the value of mMirrorForRtl on given ProgressBar" : "Could not invoke getMirrorForRtl on given ProgressBar", th);
            return true;
        }
    }
}
