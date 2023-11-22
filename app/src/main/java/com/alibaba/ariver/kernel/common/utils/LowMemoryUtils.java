package com.alibaba.ariver.kernel.common.utils;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class LowMemoryUtils {
    public static boolean onLowMemoryMode;
    public static boolean removeApiPermission;
    public static boolean removeAppConfig;
    public static boolean removeIndexWorkerJs;
    public static boolean removePluginIndexWorkerJs;
    public static boolean removeTabBarJson;

    public static void applyConfig(String str) {
        JSONObject parseObject = JSONUtils.parseObject(str);
        if (parseObject != null) {
            onLowMemoryMode = JSONUtils.getBoolean(parseObject, "enable", false);
            removeIndexWorkerJs = JSONUtils.getBoolean(parseObject, "index.worker.js", true);
            removeAppConfig = JSONUtils.getBoolean(parseObject, RVConstants.FILE_APP_CONFIG, true);
            removeApiPermission = JSONUtils.getBoolean(parseObject, RVConstants.FILE_API_PERMISSION, true);
            removeTabBarJson = JSONUtils.getBoolean(parseObject, RVConstants.FILE_TABBAR, true);
            removePluginIndexWorkerJs = JSONUtils.getBoolean(parseObject, "plugin.index.worker.js", true);
        }
    }
}
