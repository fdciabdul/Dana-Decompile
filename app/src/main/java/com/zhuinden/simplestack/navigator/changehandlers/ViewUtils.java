package com.zhuinden.simplestack.navigator.changehandlers;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes2.dex */
final class ViewUtils {

    /* loaded from: classes4.dex */
    public interface OnMeasuredCallback {
        void onMeasured(View view, int i, int i2);
    }

    public static void waitForMeasure(final View view, final OnMeasuredCallback onMeasuredCallback) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0) {
            onMeasuredCallback.onMeasured(view, width, height);
        } else {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.zhuinden.simplestack.navigator.changehandlers.ViewUtils.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                    OnMeasuredCallback onMeasuredCallback2 = onMeasuredCallback;
                    View view2 = view;
                    onMeasuredCallback2.onMeasured(view2, view2.getWidth(), view.getHeight());
                    return true;
                }
            });
        }
    }

    private ViewUtils() {
    }
}
