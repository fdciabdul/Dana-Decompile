package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;

/* loaded from: classes6.dex */
public class SecureEditText extends EditText {
    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
    }

    @Override // android.widget.TextView, android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
    }

    public SecureEditText(Context context) {
        super(context);
    }

    public SecureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SecureEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
