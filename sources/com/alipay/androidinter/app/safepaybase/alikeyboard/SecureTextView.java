package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;

/* loaded from: classes6.dex */
public class SecureTextView extends TextView {
    private SendAccessiBilityEventListener mSabEventListener;

    /* loaded from: classes6.dex */
    interface SendAccessiBilityEventListener {
        boolean handleAccessiBilityEvent(SecureTextView secureTextView, int i);
    }

    public SecureTextView(Context context) {
        super(context);
        this.mSabEventListener = null;
    }

    public SecureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSabEventListener = null;
    }

    public SecureTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSabEventListener = null;
    }

    public void setSendAccessiBilityEventListener(SendAccessiBilityEventListener sendAccessiBilityEventListener) {
        this.mSabEventListener = sendAccessiBilityEventListener;
    }

    @Override // android.widget.TextView, android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 65536 || eventType == 32768) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        SendAccessiBilityEventListener sendAccessiBilityEventListener = this.mSabEventListener;
        if (sendAccessiBilityEventListener != null ? sendAccessiBilityEventListener.handleAccessiBilityEvent(this, i) : false) {
            return;
        }
        super.sendAccessibilityEvent(i);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }
}
