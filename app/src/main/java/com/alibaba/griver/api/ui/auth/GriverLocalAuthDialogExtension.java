package com.alibaba.griver.api.ui.auth;

import android.content.Context;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes6.dex */
public interface GriverLocalAuthDialogExtension extends GriverExtension {
    LocalPermissionDialog createDialog(Context context);
}
