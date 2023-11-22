package com.alibaba.griver.core.extensions;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.model.AuthProtocol;
import com.alibaba.ariver.permission.view.IOpenAuthDialog;
import com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.R;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class NebulaAuthDialogProxy implements AuthDialogProxy {
    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public IOpenAuthDialog getOpenAuthDialog(Context context) {
        return new IOpenAuthDialog() { // from class: com.alibaba.griver.core.extensions.NebulaAuthDialogProxy.1
            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public void cancel() {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public List<String> getLocalFailScopeList(App app) {
                return null;
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public void setContent(String str, String str2, App app, List<String> list, List<String> list2, List<AuthProtocol> list3, String str3, Map<String, String> map) {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public void setOnCloseClickListener(View.OnClickListener onClickListener) {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public void setOnConfirmClickListener(View.OnClickListener onClickListener) {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthDialog
            public void show() {
            }
        };
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public IOpenAuthNoticeDialog getAuthNoticeDialog(Context context) {
        return new IOpenAuthNoticeDialog() { // from class: com.alibaba.griver.core.extensions.NebulaAuthDialogProxy.2
            @Override // com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog
            public void cancel() {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog
            public void setNegativeListener(View.OnClickListener onClickListener) {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog
            public void setPositiveListener(View.OnClickListener onClickListener) {
            }

            @Override // com.alibaba.ariver.permission.view.IOpenAuthNoticeDialog
            public void show() {
            }
        };
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public void showErrorTipDialog(Context context, String str, String str2) {
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, context.getString(R.string.griver_base_confirm), null, null);
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.extensions.NebulaAuthDialogProxy.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        };
        ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(GriverEnv.getTopActivity().get(), createDialogParam).show();
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public void showErrorTipDialog(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        CreateDialogParam createDialogParam = new CreateDialogParam(str, str2, context.getString(R.string.griver_base_confirm), null, null);
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.extensions.NebulaAuthDialogProxy.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        };
        ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(GriverEnv.getTopActivity().get(), createDialogParam).show();
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public LocalPermissionDialog getLocalPermissionDialog(Context context) {
        return ((GriverLocalAuthDialogExtension) RVProxy.get(GriverLocalAuthDialogExtension.class)).createDialog(context);
    }
}
