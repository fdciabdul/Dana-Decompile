package com.iap.ac.android.acs.operation.biz.region.utils;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.iap.ac.android.acs.operation.R;
import java.util.Objects;

/* loaded from: classes8.dex */
public class PopupWindowToast extends PopupWindow implements Runnable {
    public static final int LONG_DELAY = 3500;
    public static final int SHORT_DELAY = 2000;
    public Activity mActivity;
    public Handler mHandler;
    public int mShowTime;
    public TextView mTipsText;

    public PopupWindowToast(Activity activity) {
        this(activity, 0);
    }

    private boolean activityDestroyed() {
        return Build.VERSION.SDK_INT >= 17 && this.mActivity.isDestroyed();
    }

    private void initView(Activity activity, int i) {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.core_toast, (ViewGroup) null);
        setWidth(-2);
        setHeight(-2);
        this.mTipsText = (TextView) inflate.findViewById(R.id.h5_mini_toast_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.h5_mini_toast_icon);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setBackgroundResource(i);
        }
        setContentView(inflate);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.mActivity.isFinishing() || activityDestroyed() || !isShowing()) {
            return;
        }
        try {
            super.dismiss();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        dismiss();
    }

    public void setMessage(int i) {
        this.mTipsText.setText(i);
    }

    public void show() {
        if (this.mActivity.isFinishing() || activityDestroyed()) {
            return;
        }
        showAtLocation(this.mActivity.findViewById(16908290), 17, 0, 0);
        this.mHandler.postDelayed(this, this.mShowTime);
    }

    public void showTime(int i) {
        this.mShowTime = i;
    }

    public PopupWindowToast(Activity activity, int i) {
        this.mShowTime = 2500;
        this.mHandler = new Handler();
        this.mActivity = activity;
        initView(activity, i);
    }

    public void setMessage(CharSequence charSequence) {
        if (this.mActivity == null) {
            Objects.toString(charSequence);
        }
        this.mTipsText.setText(charSequence);
    }
}
