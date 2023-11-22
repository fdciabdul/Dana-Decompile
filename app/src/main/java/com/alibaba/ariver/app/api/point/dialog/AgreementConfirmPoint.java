package com.alibaba.ariver.app.api.point.dialog;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface AgreementConfirmPoint extends Extension {
    boolean hasPermission(App app, String str);

    void onAgreementClick(App app, String str);
}
