package fsimpl;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.fullstory.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fsimpl.j  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0360j {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f7996a;
    private final AbstractC0361k b;

    public C0360j(Context context) {
        AtomicReference atomicReference = new AtomicReference();
        this.f7996a = atomicReference;
        this.b = AbstractC0361k.create(atomicReference, null);
        if (Build.VERSION.SDK_INT == 28 && "samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                Field declaredField = AccessibilityManager.class.getDeclaredField("mIsEnabled");
                declaredField.setAccessible(true);
                Field declaredField2 = AccessibilityManager.class.getDeclaredField("mUIAutomatorRunning");
                declaredField2.setAccessible(true);
                AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(context);
                declaredField.set(accessibilityManager, Boolean.TRUE);
                declaredField2.set(accessibilityManager, Boolean.TRUE);
            } catch (Throwable th) {
                Log.e("Unable to detect click events on this device ", th);
            }
        }
    }

    private AbstractC0361k b(View view, View.AccessibilityDelegate accessibilityDelegate) {
        AbstractC0361k create;
        boolean z = true;
        if (accessibilityDelegate == null) {
            create = this.b;
        } else if (accessibilityDelegate instanceof AbstractC0361k) {
            create = (AbstractC0361k) accessibilityDelegate;
            z = false;
        } else {
            create = AbstractC0361k.create(this.f7996a, accessibilityDelegate);
        }
        if (z) {
            AbstractC0356f.a(view, create);
        }
        return create;
    }

    public C a() {
        return (C) this.f7996a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        b(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i));
            }
        }
    }

    public void a(View view, View.AccessibilityDelegate accessibilityDelegate) {
        view.setAccessibilityDelegate(accessibilityDelegate);
        b(view);
    }

    public void a(C c) {
        this.f7996a.set(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        b(view, AbstractC0356f.a(view));
    }

    public View.AccessibilityDelegate c(View view) {
        return b(view, AbstractC0356f.a(view)).a();
    }
}
