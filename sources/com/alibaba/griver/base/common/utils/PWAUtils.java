package com.alibaba.griver.base.common.utils;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.base.common.config.GriverInnerConfig;

/* loaded from: classes2.dex */
public class PWAUtils {
    public static final boolean DEFAULT_PWA_DOWNGRADE_TO_TEMPLATE = false;
    public static final String KEY_PWA_DOWNGRADE_TO_TEMPLATE = "pwa_downgrade_to_template";

    public static boolean isLoadOldWay() {
        return GriverInnerConfig.getConfigBoolean(KEY_PWA_DOWNGRADE_TO_TEMPLATE, false);
    }

    public static boolean isLoadNewWay() {
        return !isLoadOldWay();
    }

    public static boolean isPwaApp(AppModel appModel) {
        return !TextUtils.isEmpty(AppInfoUtils.getEmbeddedAppMainUrl(appModel));
    }

    public static boolean isPwaApp(Page page) {
        return AppInfoUtils.isEmbeddedApp(page);
    }

    public static boolean isPwaApp(App app) {
        return AppInfoUtils.isEmbeddedApp(app);
    }

    public static String getPwaUrl(AppModel appModel) {
        return AppInfoUtils.getEmbeddedAppMainUrl(appModel);
    }

    public static boolean isPwaAppAndLoadNewWay(Page page) {
        return isPwaApp(page) && isLoadNewWay();
    }

    public static boolean isPwaAppAndLoadNewWay(App app) {
        return isPwaApp(app) && isLoadNewWay();
    }

    public static boolean isPwaAppAndLoadOldWay(Page page) {
        return isPwaApp(page) && isLoadOldWay();
    }

    public static boolean isPwaAppAndLoadNewWay(AppModel appModel) {
        return isPwaApp(appModel) && isLoadNewWay();
    }
}
