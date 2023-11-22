package com.iap.ac.android.acs.operation.biz.region.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.acs.operation.R;

/* loaded from: classes8.dex */
public class ToastUtils {
    public static final int MAX_DURATION = 5000;

    public static int checkOp(Context context, int i) {
        Object systemService = context.getSystemService("appops");
        try {
            return ((Integer) systemService.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(systemService, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean isNotifyAllowed(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return i < 18 || 1 != checkOp(context, 11);
        }
        Object systemService = context.getSystemService("notification");
        try {
            return ((Integer) systemService.getClass().getDeclaredMethod("getImportance", new Class[0]).invoke(systemService, new Object[0])).intValue() != 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void showPopupWindowToast(Context context, String str, int i, int i2) {
        PopupWindowToast popupWindowToast = new PopupWindowToast((Activity) context, i);
        popupWindowToast.setMessage(str);
        if (i2 == 1) {
            popupWindowToast.showTime(3500);
        } else if (i2 == 0) {
            popupWindowToast.showTime(2000);
        } else {
            popupWindowToast.showTime(Math.min(i2, 5000));
        }
        popupWindowToast.show();
    }

    public static void showSysToast(Context context, String str, int i, int i2, int i3, int i4) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.core_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.h5_mini_toast_icon);
        if (i != 0) {
            InstrumentInjector.Resources_setImageResource(imageView, i);
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.h5_mini_toast_text);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        inflate.getBackground().setAlpha(192);
        Toast toast = new Toast(context);
        toast.setView(inflate);
        toast.setGravity(17, i3, i4);
        int i5 = 1;
        if (i2 <= 2000 && i2 != 1) {
            i5 = 0;
        }
        toast.setDuration(i5);
        toast.show();
    }

    public static void showToast(Context context, String str, int i, int i2, int i3, int i4) {
        try {
            if (!isNotifyAllowed(context) && (context instanceof Activity)) {
                showPopupWindowToast(context, str, i, i2);
            } else {
                showSysToast(context, str, i, i2, i3, i4);
            }
        } catch (Exception unused) {
        }
    }
}
