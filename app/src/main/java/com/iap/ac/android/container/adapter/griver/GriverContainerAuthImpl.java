package com.iap.ac.android.container.adapter.griver;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.iap.ac.android.common.container.auth.IContainerAuth;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class GriverContainerAuthImpl implements IContainerAuth {
    @Override // com.iap.ac.android.common.container.auth.IContainerAuth
    public Map<String, Boolean> getDeviceAuthSetting(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            RVLogger.d("GriverContainerAuthImpl", "appId or userId is null");
            return null;
        }
        HashMap hashMap = new HashMap();
        AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        if (authenticationProxy == null) {
            RVLogger.d("GriverContainerAuthImpl", "getSetting, service is null");
            return hashMap;
        }
        return authenticationProxy.getAllPermissions(str2, str, (AppModel) null, "");
    }
}
