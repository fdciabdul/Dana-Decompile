package com.alibaba.ariver.app.api.point.dialog;

import android.app.Activity;
import android.app.Dialog;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.extension.Extension;

@DefaultImpl("com.alibaba.ariver.jsapi.dialog.DefaultPromptImplExtension")
/* loaded from: classes6.dex */
public interface PromptPoint extends Extension {
    Dialog createDialog(Activity activity, CreatePromptParam createPromptParam);
}
