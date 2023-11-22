package com.alibaba.ariver.kernel.common.service;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public interface RVEnvironmentService extends Proxiable {
    public static final String GROUP_ALI_APP = "AliApp";
    public static final String GROUP_ARIVER_APP = "AriverApp";
    public static final String PLATFORM_AP = "AP";
    public static final String PLATFORM_TB = "TB";

    String convertPlatform(String str);

    String defaultPlatform();

    String extractAppIdFromUrl(String str);

    String getAppCurrency();

    String getAppExternalStoragePath();

    String getAppGroup();

    String getAppLanguage();

    int getAppLayoutDirection();

    String getAppName();

    String getAppRegion();

    Application getApplicationContext();

    int getLpid();

    String getProductId();

    String getProductVersion();

    Resources getResources(String str);

    WeakReference<Activity> getTopActivity();

    String getXTap();

    boolean isBackgroundRunning();

    void openUrl(String str);
}
