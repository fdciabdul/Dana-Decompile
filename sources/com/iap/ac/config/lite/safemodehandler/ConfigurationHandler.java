package com.iap.ac.config.lite.safemodehandler;

import android.app.Application;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.safemode.api.IAPSafeHandler;

/* loaded from: classes8.dex */
public class ConfigurationHandler extends IAPSafeHandler {
    @Override // com.iap.safemode.api.IAPSafeHandler
    public void recover(Application application) {
        ConfigCenter.getInstance().handleSafemodeRecover(application);
    }
}
