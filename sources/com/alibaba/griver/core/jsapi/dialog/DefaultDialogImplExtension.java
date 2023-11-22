package com.alibaba.griver.core.jsapi.dialog;

import android.app.Activity;
import android.app.Dialog;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;

/* loaded from: classes6.dex */
public class DefaultDialogImplExtension implements DialogPoint {
    private static final String TAG = "AriverAPI:DefaultDialogImplExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.dialog.DialogPoint
    public Dialog createDialog(Activity activity, CreateDialogParam createDialogParam) {
        if (activity == null || activity.isFinishing()) {
            RVLogger.d(TAG, "activity is finishing");
            return null;
        }
        return ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).createDialog(activity, createDialogParam);
    }
}
