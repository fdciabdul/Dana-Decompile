package fsimpl;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.fullstory.instrumentation.CurrentPlatform;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fsimpl.k  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0361k extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7997a;
    private static final boolean b;
    private final AtomicReference c;
    private View.AccessibilityDelegate d;

    static {
        f7997a = Build.VERSION.SDK_INT >= 31;
        b = CurrentPlatform.TARGET_SDK == -1 || CurrentPlatform.TARGET_SDK >= 31;
    }

    private AbstractC0361k(AtomicReference atomicReference, View.AccessibilityDelegate accessibilityDelegate) {
        this.c = atomicReference;
        this.d = accessibilityDelegate;
    }

    private void a(View view) {
        C c = (C) this.c.get();
        if (c != null) {
            if (C0373w.a(view)) {
                c.a(view);
            } else {
                c.b(view);
            }
        }
    }

    public static AbstractC0361k create(AtomicReference atomicReference, View.AccessibilityDelegate accessibilityDelegate) {
        C0362l c0362l = null;
        return (f7997a && b) ? new C0364n(atomicReference, accessibilityDelegate) : new C0363m(atomicReference, accessibilityDelegate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        View.AccessibilityDelegate accessibilityDelegate;
        synchronized (this) {
            accessibilityDelegate = this.d;
        }
        return accessibilityDelegate;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
        } else {
            super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate a2 = a();
        return a2 != null ? a2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            return a2.getAccessibilityNodeProvider(view);
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.onInitializeAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        } else {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.onPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate a2 = a();
        return a2 != null ? a2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        View.AccessibilityDelegate a2 = a();
        return a2 != null ? a2.performAccessibilityAction(view, i, bundle) : super.performAccessibilityAction(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        C c;
        if (i == 1) {
            a(view);
        } else if (i == 2 && (c = (C) this.c.get()) != null) {
            c.c(view);
        }
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.sendAccessibilityEvent(view, i);
        } else {
            super.sendAccessibilityEvent(view, i);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        View.AccessibilityDelegate a2 = a();
        if (a2 != null) {
            a2.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        } else {
            super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }
}
