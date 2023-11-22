package com.alipay;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUiInterface;
import com.alipay.mobile.verifyidentity.uitools.dialog.CommonDialog;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobile.verifyidentity.uitools.dialog.SubmittingDialog;
import com.alipay.mobile.verifyidentity.uitools.toast.CenterToast;
import com.alipay.mobile.verifyidentity.uitools.toast.TipToast;

/* loaded from: classes3.dex */
public class CustomUiImpl implements CustomUiInterface {
    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public Typeface bodyContentTextType() {
        return null;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public Typeface bodyTitleTextType() {
        return null;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public Typeface titleTextType() {
        return null;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public boolean showTipToast(Activity activity, int i, String str) {
        TipToast tipToast = new TipToast(activity);
        tipToast.setStatus(i);
        tipToast.setMessage(str);
        tipToast.show();
        return true;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public boolean showCenterToast(Activity activity, String str) {
        CenterToast centerToast = new CenterToast(activity);
        centerToast.setMessage(str);
        centerToast.show();
        return true;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public boolean showCenterToast(Activity activity, String str, int i) {
        CenterToast centerToast = new CenterToast(activity);
        centerToast.setMessage(str);
        centerToast.setDuration(i);
        centerToast.show();
        return true;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public boolean showCenterToast(Activity activity, String str, int i, int i2) {
        CenterToast centerToast = new CenterToast(activity);
        centerToast.setMessage(str);
        centerToast.setDuration(i);
        centerToast.show();
        return true;
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public Dialog createLoadingDialog(Activity activity) {
        return new SubmittingDialog(activity);
    }

    @Override // com.alipay.mobile.verifyidentity.uitools.CustomUiInterface
    public boolean showCommonDialog(Activity activity, String str, String str2, int i, boolean z, ModalInterface modalInterface) {
        CommonDialog commonDialog = new CommonDialog(activity, false, null);
        commonDialog.setModalInterface(modalInterface);
        if (!TextUtils.isEmpty(str)) {
            commonDialog.setTitle(str);
        }
        if (i == 1002) {
            commonDialog.setCancelText("Enter password");
        }
        commonDialog.setMessage(str2);
        commonDialog.setCancelable(z);
        commonDialog.show();
        return true;
    }
}
