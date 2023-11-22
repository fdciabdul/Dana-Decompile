package fsimpl;

import android.os.Build;
import android.view.View;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* renamed from: fsimpl.f  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0356f extends View {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7981a = eV.a(View.class, "mAccessibilityDelegate");

    public static View.AccessibilityDelegate a(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : b(view);
    }

    public static void a(View view, View.AccessibilityDelegate accessibilityDelegate) {
        Field field = f7981a;
        if (field == null) {
            return;
        }
        try {
            field.set(view, accessibilityDelegate);
        } catch (IllegalAccessException e) {
            Log.e("Unable to set the value of mAccessibilityDelegate", e);
        }
    }

    private static View.AccessibilityDelegate b(View view) {
        Field field = f7981a;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
        } catch (IllegalAccessException e) {
            Log.e("Unable to get the value of mAccessibilityDelegate", e);
        }
        return null;
    }
}
