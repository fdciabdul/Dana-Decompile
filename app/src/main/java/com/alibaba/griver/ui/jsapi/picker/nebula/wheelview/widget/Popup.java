package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class Popup {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f6717a;
    private FrameLayout b;

    public Popup(Context context) {
        a(context);
    }

    private void a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.b.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
        Dialog dialog = new Dialog(context);
        this.f6717a = dialog;
        dialog.setCanceledOnTouchOutside(true);
        this.f6717a.setCancelable(true);
        Window window = this.f6717a.getWindow();
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.requestFeature(1);
        window.setContentView(this.b);
    }

    public Context getContext() {
        return this.b.getContext();
    }

    public void setAnimationStyle(int i) {
        this.f6717a.getWindow().setWindowAnimations(i);
    }

    public boolean isShowing() {
        return this.f6717a.isShowing();
    }

    public void show() {
        this.f6717a.show();
    }

    public void dismiss() {
        this.f6717a.dismiss();
    }

    public View getContentView() {
        return this.b.getChildAt(0);
    }

    public void setContentView(View view) {
        this.b.removeAllViews();
        this.b.addView(view);
    }

    public void setSize(int i, int i2) {
        GriverLogger.debug("compositeui", String.format("will set popup width/height to: %s/%s", Integer.valueOf(i), Integer.valueOf(i2)));
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        this.b.setLayoutParams(layoutParams);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f6717a.setOnDismissListener(onDismissListener);
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.f6717a.setOnKeyListener(onKeyListener);
    }

    public Window getWindow() {
        return this.f6717a.getWindow();
    }

    public ViewGroup getRootView() {
        return this.b;
    }
}
