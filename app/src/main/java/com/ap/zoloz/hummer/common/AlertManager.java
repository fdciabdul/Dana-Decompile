package com.ap.zoloz.hummer.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.alipay.mobile.security.bio.utils.StringUtil;
import zoloz.ap.com.toolkit.R2;
import zoloz.ap.com.toolkit.ui.DialogHelper;

/* loaded from: classes7.dex */
public class AlertManager {
    private static AlertManager sInstance;
    private DialogHelper mDialogHelper;

    public static AlertManager getInstance() {
        if (sInstance == null) {
            synchronized (AlertManager.class) {
                if (sInstance == null) {
                    sInstance = new AlertManager();
                }
            }
        }
        return sInstance;
    }

    public void release() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.release();
            this.mDialogHelper = null;
        }
        sInstance = null;
    }

    public void setContext(Context context) {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null) {
            this.mDialogHelper = new DialogHelper((Activity) context);
        } else {
            dialogHelper.setActivity((Activity) context);
        }
    }

    public void alert(String str, String str2, String str3, String str4, final IAlertCallback iAlertCallback) {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper == null) {
            return;
        }
        dialogHelper.dismissDialog();
        if (StringUtil.isNullorEmpty(str4)) {
            this.mDialogHelper.alert(str, str2, str3, new DialogInterface.OnClickListener() { // from class: com.ap.zoloz.hummer.common.AlertManager.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    iAlertCallback.onPositive();
                }
            }, null, null);
        } else {
            this.mDialogHelper.alert(str, str2, str3, new DialogInterface.OnClickListener() { // from class: com.ap.zoloz.hummer.common.AlertManager.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    iAlertCallback.onPositive();
                }
            }, str4, new DialogInterface.OnClickListener() { // from class: com.ap.zoloz.hummer.common.AlertManager.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    iAlertCallback.onNegative();
                }
            });
        }
    }

    public void alertSystemError(final IAlertManagerCallback iAlertManagerCallback) {
        alert(R2.string.system_error_title(), R2.string.system_error_msg(), R2.string.system_error_got_it(), null, new IAlertCallback() { // from class: com.ap.zoloz.hummer.common.AlertManager.4
            @Override // com.ap.zoloz.hummer.common.IAlertCallback
            public void onNegative() {
            }

            @Override // com.ap.zoloz.hummer.common.IAlertCallback
            public void onPositive() {
                IAlertManagerCallback iAlertManagerCallback2 = iAlertManagerCallback;
                if (iAlertManagerCallback2 != null) {
                    iAlertManagerCallback2.onHandelSystemError();
                }
            }
        });
    }

    public void showProgressDialog(String str, boolean z, DialogInterface.OnCancelListener onCancelListener, boolean z2) {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.showProgressDialog(str, z, onCancelListener, z2);
        }
    }

    public void dismissDialog() {
        DialogHelper dialogHelper = this.mDialogHelper;
        if (dialogHelper != null) {
            dialogHelper.dismissDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void alertNetworkError(final IAlertManagerCallback iAlertManagerCallback) {
        getInstance().alert(R2.string.network_error_title(), R2.string.network_error_msg(), R2.string.network_error_retry(), R2.string.network_error_exit(), new IAlertCallback() { // from class: com.ap.zoloz.hummer.common.AlertManager.5
            @Override // com.ap.zoloz.hummer.common.IAlertCallback
            public void onPositive() {
                IAlertManagerCallback iAlertManagerCallback2 = iAlertManagerCallback;
                if (iAlertManagerCallback2 != null) {
                    iAlertManagerCallback2.onHandelNetworkError(true);
                }
            }

            @Override // com.ap.zoloz.hummer.common.IAlertCallback
            public void onNegative() {
                IAlertManagerCallback iAlertManagerCallback2 = iAlertManagerCallback;
                if (iAlertManagerCallback2 != null) {
                    iAlertManagerCallback2.onHandelNetworkError(false);
                }
            }
        });
    }
}
