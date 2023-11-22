package com.alibaba.griver.core.jsapi.toast;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;

/* loaded from: classes6.dex */
public class PopupWindowToast extends PopupWindow implements Runnable {
    public static final int LONG_DELAY = 3500;
    public static final int SHORT_DELAY = 2000;

    /* renamed from: a  reason: collision with root package name */
    private Activity f6422a;
    private TextView b;
    private int c;
    private Handler d;

    public PopupWindowToast(Activity activity) {
        this(activity, 0);
    }

    public PopupWindowToast(Activity activity, int i) {
        this.c = 2500;
        this.d = new Handler();
        this.f6422a = activity;
        a(activity, i);
    }

    private void a(Activity activity, int i) {
        View inflate = LayoutInflater.from(this.f6422a).inflate(R.layout.griver_core_toast, (ViewGroup) null);
        setWidth(-2);
        setHeight(-2);
        this.b = (TextView) inflate.findViewById(R.id.h5_mini_toast_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.h5_mini_toast_icon);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setBackgroundResource(i);
        }
        setContentView(inflate);
    }

    @Override // java.lang.Runnable
    public void run() {
        dismiss();
    }

    public void setMessage(int i) {
        this.b.setText(i);
    }

    public void setMessage(CharSequence charSequence) {
        String obj;
        Activity activity = this.f6422a;
        if (activity != null) {
            obj = activity.getPackageName();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(", tipSrc:");
            sb.append((Object) charSequence);
            obj = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AUToastPopupWindow ");
        sb2.append(obj);
        GriverLogger.debug("AUToast", sb2.toString());
        this.b.setText(charSequence);
    }

    public void showTime(int i) {
        this.c = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.f6422a.isFinishing() || a()) {
            GriverLogger.d("AUToastPopupWindow", "Activity is finish");
        } else if (isShowing()) {
            GriverLogger.d("AUToastPopupWindow", "isShowing() == true");
            try {
                super.dismiss();
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("IllegalArgumentException: e");
                sb.append(e);
                GriverLogger.e("AUToastPopupWindow", sb.toString());
            }
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && this.f6422a.isDestroyed();
    }

    public void show() {
        if (this.f6422a.isFinishing() || a()) {
            GriverLogger.d("AUToastPopupWindow", "Activity is finish");
            return;
        }
        showAtLocation(this.f6422a.findViewById(16908290), 17, 0, 0);
        this.d.postDelayed(this, this.c);
    }
}
