package com.alibaba.griver.base.common.env;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverRVEnvironmentServiceImpl implements RVEnvironmentService {
    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String extractAppIdFromUrl(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppCurrency() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppExternalStoragePath() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppGroup() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public int getAppLayoutDirection() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppRegion() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getProductId() {
        return "Android-Container";
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getXTap() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public Application getApplicationContext() {
        return GriverEnv.getApplicationContext();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public WeakReference<Activity> getTopActivity() {
        return GriverEnv.getTopActivity();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public int getLpid() {
        return GriverEnv.getLpid();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public boolean isBackgroundRunning() {
        return GriverEnv.isBackgroundRunning();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public Resources getResources(String str) {
        return GriverEnv.getResources();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public void openUrl(String str) {
        GriverEnv.openUrl(str);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getProductVersion() {
        return GriverEnv.getProductVersion();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String convertPlatform(String str) {
        return GriverEnv.convertPlatform(str);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String defaultPlatform() {
        return GriverEnv.defaultPlatform();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppName() {
        return GriverEnv.getAppName();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppLanguage() {
        String appLanguage = GriverEnv.getAppLanguage();
        if (!appLanguage.startsWith("zh-CN") && !appLanguage.startsWith("zh-Hans")) {
            if (appLanguage.startsWith("zh-HK")) {
                return "zh-HK";
            }
            if (appLanguage.startsWith("zh-TW")) {
                return "zh-Hant";
            }
            if (!appLanguage.startsWith("zh")) {
                return appLanguage.startsWith("en") ? "en" : appLanguage;
            }
        }
        return "zh-Hans";
    }
}
