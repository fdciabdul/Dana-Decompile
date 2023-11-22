package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface AuthSettingProxy extends Proxiable {
    boolean closeFailureSwitch(App app);

    boolean closeGetAuthorize();

    void goToAuthSetting(App app);

    boolean openGetAuthorizeSuccess();
}
