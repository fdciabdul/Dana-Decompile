package com.alibaba.griver.core.ui.auth;

import android.content.Context;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension;
import com.alibaba.griver.core.permission.view.NebulaLocalPermissionNoticeDialog;

/* loaded from: classes6.dex */
public class GriverLocalAuthDialogExtensionImpl implements GriverLocalAuthDialogExtension {
    @Override // com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension
    public LocalPermissionDialog createDialog(Context context) {
        return new NebulaLocalPermissionNoticeDialog(context);
    }
}
