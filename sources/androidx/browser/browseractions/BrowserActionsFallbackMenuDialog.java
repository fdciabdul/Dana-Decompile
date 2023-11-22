package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
/* loaded from: classes6.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {
    private final View getAuthRequestContext;

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getAuthRequestContext(true);
        super.show();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        getAuthRequestContext(false);
    }

    private void getAuthRequestContext(final boolean z) {
        float f = z ? 0.0f : 1.0f;
        float f2 = z ? 1.0f : 0.0f;
        long j = z ? 250L : 150L;
        this.getAuthRequestContext.setScaleX(f);
        this.getAuthRequestContext.setScaleY(f);
        this.getAuthRequestContext.animate().scaleX(f2).scaleY(f2).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                BrowserActionsFallbackMenuDialog.super.dismiss();
            }
        }).start();
    }
}
