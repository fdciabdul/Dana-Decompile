package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes3.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    private final int BuiltInFictitiousFunctionClassFactory;
    private final AccessibilityNodeInfoCompat MyBillsEntityDataFactory;
    private final int getAuthRequestContext;

    public AccessibilityClickableSpanCompat(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = accessibilityNodeInfoCompat;
        this.getAuthRequestContext = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.BuiltInFictitiousFunctionClassFactory);
        this.MyBillsEntityDataFactory.getAuthRequestContext(this.getAuthRequestContext, bundle);
    }
}
