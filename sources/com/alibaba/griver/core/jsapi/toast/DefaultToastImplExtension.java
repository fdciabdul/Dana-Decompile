package com.alibaba.griver.core.jsapi.toast;

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
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AndroidVersionUtils;
import com.alibaba.griver.core.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class DefaultToastImplExtension implements ToastPoint {
    private static final int MAX_DURATION = 5000;
    private static final String TAG = "DefaultToastImplExtension";
    private WeakReference<PopupWindowToast> mSuperToastReference;
    private WeakReference<Toast> mToastWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
    public void showToast(Context context, String str, int i, String str2, int i2, int i3) {
        try {
            int imageResId = getImageResId(str2);
            if (!isNotifyAllowed(context) && (context instanceof Activity)) {
                GriverLogger.d(TAG, "use PopupWindow toast");
                showPopupWindowToast(context, str, imageResId, i);
                return;
            }
            GriverLogger.d(TAG, "use system toast");
            showSysToast(context, str, imageResId, i, i2, i3);
        } catch (Exception e) {
            RVLogger.e("", e);
        }
    }

    private void showPopupWindowToast(Context context, String str, int i, int i2) {
        PopupWindowToast popupWindowToast = new PopupWindowToast((Activity) context, i);
        this.mSuperToastReference = new WeakReference<>(popupWindowToast);
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

    private void showSysToast(Context context, String str, int i, int i2, int i3, int i4) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.griver_core_toast, (ViewGroup) null);
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
        this.mToastWeakReference = new WeakReference<>(toast);
        if (AndroidVersionUtils.isRAndAbove() && !GriverEnv.isForeground()) {
            toast.setText(str);
        } else {
            toast.setView(inflate);
        }
        toast.setGravity(17, i3, i4);
        int i5 = 1;
        if (i2 <= 2000 && i2 != 1) {
            i5 = 0;
        }
        toast.setDuration(i5);
        toast.show();
    }

    private int getImageResId(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != 3135262) {
                if (hashCode == 1481625679 && str.equals("exception")) {
                    c = 2;
                }
            } else if (str.equals("fail")) {
                c = 1;
            }
        } else if (str.equals("success")) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return 0;
                }
                return R.drawable.griver_core_toast_exception;
            }
            return R.drawable.griver_core_toast_false;
        }
        return R.drawable.griver_core_toast_ok;
    }

    @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
    public void hideToast() {
        WeakReference<Toast> weakReference = this.mToastWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            try {
                this.mToastWeakReference.get().cancel();
                GriverLogger.d(TAG, "toast hided");
            } catch (Throwable th) {
                RVLogger.e(TAG, "hideToast error!", th);
            }
        }
        WeakReference<PopupWindowToast> weakReference2 = this.mSuperToastReference;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        this.mSuperToastReference.get().dismiss();
    }

    public static boolean isNotifyAllowed(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return i < 18 || 1 != checkOp(context, 11);
        }
        Object systemService = context.getSystemService("notification");
        try {
            int intValue = ((Integer) systemService.getClass().getDeclaredMethod("getImportance", new Class[0]).invoke(systemService, new Object[0])).intValue();
            StringBuilder sb = new StringBuilder();
            sb.append("notification importance: ");
            sb.append(intValue);
            GriverLogger.d(TAG, sb.toString());
            return intValue != 0;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isNotifyChangedAllowed");
            sb2.append(th.getMessage());
            GriverLogger.e(TAG, sb2.toString());
            return true;
        }
    }

    public static int checkOp(Context context, int i) {
        Object systemService = context.getSystemService("appops");
        try {
            return ((Integer) systemService.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(systemService, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
        } catch (Throwable th) {
            GriverLogger.e(TAG, th.getMessage());
            return -1;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.mToastWeakReference = null;
        this.mSuperToastReference = null;
    }
}
