package com.iap.ac.android.acs.plugin.core;

import com.iap.ac.android.acs.plugin.biz.auth.AuthResultObserverManager;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class IAPConnectPluginManager {
    public static final String TAG = "IAPConnectPlugin";
    public static volatile IAPConnectPluginManager sInstance;

    public static IAPConnectPluginManager getInstance() {
        if (sInstance == null) {
            synchronized (IAPConnectPluginManager.class) {
                if (sInstance == null) {
                    sInstance = new IAPConnectPluginManager();
                }
            }
        }
        return sInstance;
    }

    public void notifyAuthResult(AuthResult authResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectPluginManager#notifyAuthCode, authResult: ");
        sb.append(authResult);
        ACLog.d("IAPConnectPlugin", sb.toString());
        AuthResultObserverManager.notifyAuthResult(authResult);
    }
}
