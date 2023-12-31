package com.alibaba.ariver.permission.api.proxy;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.permission.view.IOpenAuthDialog;
import com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;

/* loaded from: classes6.dex */
public interface AuthDialogProxy extends Proxiable {
    IOpenAuthNoticeDialog getAuthNoticeDialog(Context context);

    LocalPermissionDialog getLocalPermissionDialog(Context context);

    IOpenAuthDialog getOpenAuthDialog(Context context);

    void showErrorTipDialog(Context context, String str, String str2);

    void showErrorTipDialog(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2);
}
