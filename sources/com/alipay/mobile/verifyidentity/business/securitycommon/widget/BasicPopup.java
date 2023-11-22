package com.alipay.mobile.verifyidentity.business.securitycommon.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public abstract class BasicPopup<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    protected Activity activity;
    private FrameLayout contentLayout;
    private Dialog dialog;
    private boolean isPrepared = false;
    protected int screenHeightPixels;
    protected int screenWidthPixels;

    protected abstract V makeContentView();

    protected void setContentViewAfter(V v) {
    }

    protected void setContentViewBefore() {
    }

    protected void showAfter() {
    }

    public BasicPopup(Activity activity) {
        this.activity = activity;
        DisplayMetrics displayMetrics = ScreenUtils.displayMetrics(activity);
        this.screenWidthPixels = displayMetrics.widthPixels;
        this.screenHeightPixels = displayMetrics.heightPixels;
        initDialog();
    }

    private void initDialog() {
        FrameLayout frameLayout = new FrameLayout(this.activity);
        this.contentLayout = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.contentLayout.setFocusable(true);
        this.contentLayout.setFocusableInTouchMode(true);
        Dialog dialog = new Dialog(this.activity);
        this.dialog = dialog;
        dialog.setCanceledOnTouchOutside(true);
        this.dialog.setCancelable(true);
        this.dialog.setOnKeyListener(this);
        this.dialog.setOnDismissListener(this);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.contentLayout);
        }
        setSize(this.screenWidthPixels, -2);
    }

    public int getScreenWidthPixels() {
        return this.screenWidthPixels;
    }

    public int getScreenHeightPixels() {
        return this.screenHeightPixels;
    }

    public void setFillScreen(boolean z) {
        if (z) {
            setSize(this.screenWidthPixels, (int) (this.screenHeightPixels * 0.85f));
        }
    }

    public void setHalfScreen(boolean z) {
        if (z) {
            setSize(this.screenWidthPixels, this.screenHeightPixels / 2);
        }
    }

    public void setGravity(int i) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(i);
        }
        if (i == 17) {
            setWidth((int) (this.screenWidthPixels * 0.7f));
        }
    }

    public void setContentView(View view) {
        this.contentLayout.removeAllViews();
        this.contentLayout.addView(view);
    }

    public void setFitsSystemWindows(boolean z) {
        this.contentLayout.setFitsSystemWindows(z);
    }

    public void setAnimationStyle(int i) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(i);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.dialog.setCanceledOnTouchOutside(z);
    }

    public void setCancelable(boolean z) {
        this.dialog.setCancelable(z);
    }

    public void setOnDismissListener(final DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.alipay.mobile.verifyidentity.business.securitycommon.widget.BasicPopup.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BasicPopup.this.onDismiss(dialogInterface);
                onDismissListener.onDismiss(dialogInterface);
            }
        });
    }

    public void setOnKeyListener(final DialogInterface.OnKeyListener onKeyListener) {
        this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.alipay.mobile.verifyidentity.business.securitycommon.widget.BasicPopup.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                BasicPopup.this.onKey(dialogInterface, i, keyEvent);
                return onKeyListener.onKey(dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r3 == 0) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSize(int r2, int r3) {
        /*
            r1 = this;
            r0 = -1
            if (r2 != r0) goto L5
            int r2 = r1.screenWidthPixels
        L5:
            if (r2 != 0) goto Lc
            if (r3 != 0) goto Lc
            int r2 = r1.screenWidthPixels
            goto L13
        Lc:
            if (r2 != 0) goto L11
            int r2 = r1.screenWidthPixels
            goto L14
        L11:
            if (r3 != 0) goto L14
        L13:
            r3 = -2
        L14:
            android.widget.FrameLayout r0 = r1.contentLayout
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L22
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r2, r3)
            goto L26
        L22:
            r0.width = r2
            r0.height = r3
        L26:
            android.widget.FrameLayout r2 = r1.contentLayout
            r2.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.securitycommon.widget.BasicPopup.setSize(int, int):void");
    }

    public void setWidth(int i) {
        setSize(i, 0);
    }

    public void setHeight(int i) {
        setSize(0, i);
    }

    public void setPrepared(boolean z) {
        this.isPrepared = z;
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    public final void show() {
        if (this.isPrepared) {
            this.dialog.show();
            showAfter();
            return;
        }
        setContentViewBefore();
        V makeContentView = makeContentView();
        setContentView(makeContentView);
        setContentViewAfter(makeContentView);
        this.isPrepared = true;
        this.dialog.show();
        showAfter();
    }

    public void dismiss() {
        dismissImmediately();
    }

    protected final void dismissImmediately() {
        this.dialog.dismiss();
    }

    public boolean onBackPress() {
        dismiss();
        return false;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 4) {
            onBackPress();
            return false;
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        dismiss();
    }

    public Context getContext() {
        return this.dialog.getContext();
    }

    public Window getWindow() {
        return this.dialog.getWindow();
    }

    public View getContentView() {
        return this.contentLayout.getChildAt(0);
    }

    public ViewGroup getRootView() {
        return this.contentLayout;
    }
}
