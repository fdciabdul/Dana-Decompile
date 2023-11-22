package fsimpl;

import android.animation.AnimatorSet;
import android.graphics.ColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import com.fullstory.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class fd {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7984a = eV.a(28, -1, AnimatedVectorDrawable.class, "mAnimatorSet");
    static final Method b = eV.a(28, 30, C0355ez.f7980a, "isInfinite", new Class[0]);
    static final Field c = eV.a(28, 30, C0355ez.b, "mVectorDrawable");
    static final Field d = eV.a(-1, 31, VectorDrawable.class, "mTintFilter");
    static final Field e = eV.a(29, 30, VectorDrawable.class, "mBlendModeColorFilter");

    public static boolean a(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof AnimatedVectorDrawable);
    }

    public static boolean b(Drawable drawable) {
        Object obj;
        if (drawable instanceof AnimatedVectorDrawable) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            if (animatedVectorDrawable.isRunning()) {
                try {
                    obj = f7984a.get(animatedVectorDrawable);
                } catch (Throwable unused) {
                    Log.e("Error grabbing animator set from animated vector drawable");
                }
                if (obj instanceof AnimatorSet) {
                    return ((AnimatorSet) obj).getTotalDuration() != -1;
                }
                if (C0355ez.f7980a != null && C0355ez.f7980a.isInstance(obj)) {
                    return !((Boolean) b.invoke(obj, new Object[0])).booleanValue();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static ColorFilter c(Drawable drawable) {
        while (!(drawable instanceof VectorDrawable)) {
            if (!(drawable instanceof AnimatedVectorDrawable) || c == null) {
                return null;
            }
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!C0355ez.b.isInstance(constantState)) {
                return null;
            }
            drawable = (VectorDrawable) eV.a(c, constantState);
        }
        Field field = e;
        if (field == null) {
            field = d;
        }
        return (ColorFilter) eV.a(field, drawable);
    }
}
