package com.alibaba.griver.core.jsapi.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.dialog.GriverCreateDialogParam;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.core.ui.dialog.GriverDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverUniformDialogExtension implements AppOnConfigurationChangedPoint, GriverDialogExtension {
    public static final int MAX_LEN = 1024;
    public static List<WeakReference<GriverDialog>> mDialogList = new ArrayList();

    @Override // com.alibaba.griver.api.ui.dialog.GriverDialogExtension
    public void applyShow(Dialog dialog, CreateDialogParam createDialogParam) {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.griver.api.ui.dialog.GriverDialogExtension
    public Dialog createDialog(Activity activity, CreateDialogParam createDialogParam) {
        if (TextUtils.isEmpty(createDialogParam.getTitle()) && TextUtils.isEmpty(createDialogParam.getMessage())) {
            RVLogger.w("GriverUniformDialogExtension", "empty title and message");
        }
        GriverDialog.Builder builder = new GriverDialog.Builder(activity);
        if (!TextUtils.isEmpty(createDialogParam.getTitle())) {
            builder.title(createDialogParam.getTitle());
        }
        String message = createDialogParam.getMessage();
        if (!TextUtils.isEmpty(message)) {
            if (message.length() > 1024) {
                message = message.substring(0, 1024);
            }
            builder.message(message);
        }
        builder.positiveString(createDialogParam.getPositiveString()).positiveListener(createDialogParam.positiveListener).positiveTextColor(createDialogParam.positiveTextColor);
        builder.negativeString(createDialogParam.getNegativeString()).negativeListener(createDialogParam.negativeListener).negativeTextColor(createDialogParam.negativeTextColor);
        builder.align(createDialogParam.getAlign());
        builder.cancelable(createDialogParam.cancelable);
        builder.cancelListener(createDialogParam.cancelListener);
        if (createDialogParam instanceof GriverCreateDialogParam) {
            builder.view(((GriverCreateDialogParam) createDialogParam).customView);
        }
        GriverDialog create = builder.create();
        mDialogList.add(new WeakReference<>(create));
        return create;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint
    public void onConfigurationChanged(App app, Configuration configuration, String str) {
        Iterator<WeakReference<GriverDialog>> it = mDialogList.iterator();
        while (it.hasNext()) {
            GriverDialog griverDialog = it.next().get();
            if (griverDialog != null && griverDialog.isShowing()) {
                griverDialog.dismiss();
                griverDialog.show();
            }
        }
    }
}
