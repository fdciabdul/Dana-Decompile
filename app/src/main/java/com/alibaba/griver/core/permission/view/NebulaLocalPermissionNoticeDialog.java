package com.alibaba.griver.core.permission.view;

import android.content.Context;
import android.content.DialogInterface;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.ariver.permission.view.PermissionPermitListener;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.R;
import java.util.Map;

/* loaded from: classes6.dex */
public class NebulaLocalPermissionNoticeDialog implements LocalPermissionDialog {

    /* renamed from: a  reason: collision with root package name */
    private String f6434a;
    private String b;
    private PermissionPermitListener c;
    Context context;

    @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
    public void setDialogExtraData(Map<String, String> map) {
    }

    public NebulaLocalPermissionNoticeDialog(Context context) {
        this.context = context;
    }

    @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
    public void setDialogContent(String str, String str2, String str3) {
        this.f6434a = str2;
        this.b = str;
    }

    @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
    public void setPermissionPermitListener(PermissionPermitListener permissionPermitListener) {
        this.c = permissionPermitListener;
    }

    @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
    public void show() {
        CreateDialogParam createDialogParam = new CreateDialogParam(this.f6434a, this.b, this.context.getString(R.string.griver_core_allow), this.context.getString(R.string.griver_core_deny), null);
        createDialogParam.cancelable = false;
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.permission.view.NebulaLocalPermissionNoticeDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                NebulaLocalPermissionNoticeDialog.this.c.onSuccess();
            }
        };
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.permission.view.NebulaLocalPermissionNoticeDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                NebulaLocalPermissionNoticeDialog.this.c.onFailed(-1, NebulaLocalPermissionNoticeDialog.this.context.getString(R.string.griver_core_user_unauthorized), true);
            }
        };
        ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(GriverEnv.getTopActivity().get(), createDialogParam).show();
    }
}
