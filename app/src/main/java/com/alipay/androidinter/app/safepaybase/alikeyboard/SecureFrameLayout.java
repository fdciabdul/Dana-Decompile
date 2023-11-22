package com.alipay.androidinter.app.safepaybase.alikeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* loaded from: classes6.dex */
public class SecureFrameLayout extends FrameLayout {
    private SendAccessiBilityEventListener mSabEventListener;

    /* loaded from: classes6.dex */
    interface SendAccessiBilityEventListener {
        boolean handleAccessiBilityEvent(SecureFrameLayout secureFrameLayout, int i);
    }

    public SecureFrameLayout(Context context) {
        super(context);
        this.mSabEventListener = null;
    }

    public SecureFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSabEventListener = null;
    }

    public SecureFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSabEventListener = null;
    }

    public void setSendAccessiBilityEventListener(SendAccessiBilityEventListener sendAccessiBilityEventListener) {
        this.mSabEventListener = sendAccessiBilityEventListener;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
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
}
