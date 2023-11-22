package fsimpl;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.m  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0363m extends C0364n {
    private C0363m(AtomicReference atomicReference, View.AccessibilityDelegate accessibilityDelegate) {
        super(atomicReference, accessibilityDelegate);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(View view) {
        View.AccessibilityDelegate a2 = a();
        return a2 != null ? a2.createAccessibilityNodeInfo(view) : super.createAccessibilityNodeInfo(view);
    }
}
