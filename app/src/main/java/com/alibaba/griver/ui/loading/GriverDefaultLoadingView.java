package com.alibaba.griver.ui.loading;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension;
import id.dana.globalsearch.constants.GlobalSearchErrorCode;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverDefaultLoadingView implements GriverLoadingViewExtension {
    private WeakReference<GriverLoadingDialog> referenceDialog;

    @Override // com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension
    public void show(Context context, String str, boolean z) {
        synchronized (this) {
            if (Looper.getMainLooper() == Looper.myLooper() && context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
                dismiss();
                GriverLoadingDialog griverLoadingDialog = new GriverLoadingDialog(context);
                if (TextUtils.isEmpty(str)) {
                    str = GlobalSearchErrorCode.LOADING;
                }
                griverLoadingDialog.setMessage(str);
                griverLoadingDialog.setCancelable(z);
                griverLoadingDialog.show();
                this.referenceDialog = new WeakReference<>(griverLoadingDialog);
            }
        }
    }

    @Override // com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension
    public void dismiss() {
        WeakReference<GriverLoadingDialog> weakReference;
        GriverLoadingDialog griverLoadingDialog;
        synchronized (this) {
            if (Looper.getMainLooper() == Looper.myLooper() && (weakReference = this.referenceDialog) != null && (griverLoadingDialog = weakReference.get()) != null) {
                griverLoadingDialog.dismiss();
                this.referenceDialog.clear();
            }
        }
    }

    @Override // com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension
    public boolean onBackPressed() {
        GriverLoadingDialog griverLoadingDialog;
        synchronized (this) {
            WeakReference<GriverLoadingDialog> weakReference = this.referenceDialog;
            if (weakReference == null || (griverLoadingDialog = weakReference.get()) == null || !griverLoadingDialog.isShowing()) {
                return false;
            }
            dismiss();
            return true;
        }
    }
}
