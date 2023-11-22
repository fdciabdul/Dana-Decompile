package fsimpl;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Pair;
import com.fullstory.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes8.dex */
public class aW {
    private aJ e;
    private Map c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    fg f7837a = new fg();
    WeakHashMap b = new WeakHashMap();
    private eK d = new eK(256, 0.75f);

    public aW(aJ aJVar) {
        this.e = aJVar;
    }

    private int a(Drawable drawable, int i, fc fcVar, boolean z) {
        int a2 = this.e.a();
        if (Build.VERSION.SDK_INT < 26 && (drawable instanceof AnimatedVectorDrawable)) {
            try {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState == null) {
                    Log.d("Could not get AnimatedVectorDrawable state, skipping recording the drawable");
                    return 0;
                }
                Field a3 = eV.a(28, -1, constantState.getClass(), "mVectorDrawable");
                if (a3 == null) {
                    Log.d("Could not get underlying VectorDrawable, skipping recording the drawable");
                    return 0;
                }
                drawable = (Drawable) a3.get(constantState);
            } catch (Throwable th) {
                Log.e("Error thrown while trying to avoid drawing AnimatedVectorDrawable", th);
                return 0;
            }
        }
        this.c.put(Integer.valueOf(a2), Pair.create(drawable, fcVar));
        if (z) {
            this.f7837a.a(drawable, a2);
            this.b.put(drawable, fcVar);
            if (i != 0) {
                this.d.b(i, a2);
            }
        }
        return a2;
    }

    public int a(Drawable drawable) {
        if (!fd.a(drawable)) {
            Log.e("Only VectorDrawables and AnimatedVectorDrawables are allowed");
            return 0;
        }
        fc a2 = fc.a(drawable);
        int a3 = aV.a(drawable);
        if (fd.b(drawable)) {
            this.f7837a.d(drawable);
            this.b.remove(drawable);
            if (a3 != 0) {
                this.d.b(a3);
            }
            return a(drawable, a3, a2, false);
        }
        if (a3 != 0) {
            int a4 = this.d.a(a3);
            fc b = aV.b(drawable);
            if (a4 != 0 && a2.equals(b)) {
                return a4;
            }
        }
        int b2 = this.f7837a.b(drawable);
        return (b2 == 0 || !a2.equals((fc) this.b.get(drawable))) ? a(drawable, a3, a2, true) : b2;
    }

    public Map a() {
        if (this.c.size() == 0) {
            return null;
        }
        Map map = this.c;
        this.c = new HashMap();
        return map;
    }
}
