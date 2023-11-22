package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.griver.api.common.env.GriverTopAppInfoExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AOMPFileTinyAppUtils;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alibaba.griver.beehive.lottie.adapter.listener.H5ListenerAdapter;

/* loaded from: classes6.dex */
public class H5UtilsAdapter {
    private static final String TAG = "H5UtilsAdapter";

    public static void openUrl(String str) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            rVEnvironmentService.openUrl(str);
        }
    }

    public static String getTinyFullPath(String str) {
        Bundle topAppStartBundle;
        GriverTopAppInfoExtension griverTopAppInfoExtension = (GriverTopAppInfoExtension) RVProxy.get(GriverTopAppInfoExtension.class);
        if (griverTopAppInfoExtension != null && (topAppStartBundle = griverTopAppInfoExtension.getTopAppStartBundle()) != null) {
            String string = topAppStartBundle.getString("url");
            if (!TextUtils.isEmpty(string)) {
                str = TinyUtils.getAbsoluteUrlV2(string, str, null);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("abUrl: ");
        sb.append(str);
        GriverLogger.d(TAG, sb.toString());
        return str;
    }

    public static void getTinyRes(String str, H5ListenerAdapter h5ListenerAdapter) {
        Resource load;
        GriverTopAppInfoExtension griverTopAppInfoExtension = (GriverTopAppInfoExtension) RVProxy.get(GriverTopAppInfoExtension.class);
        if (griverTopAppInfoExtension != null) {
            Bundle topAppStartBundle = griverTopAppInfoExtension.getTopAppStartBundle();
            Page page = griverTopAppInfoExtension.getPage();
            if (topAppStartBundle != null) {
                String string = topAppStartBundle.getString("url");
                if (!TextUtils.isEmpty(string)) {
                    String absoluteUrlV2 = TinyUtils.getAbsoluteUrlV2(string, str, null);
                    if (page != null && (load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(page).create()).load(ResourceLoadContext.newBuilder().originUrl(absoluteUrlV2).isMainDoc(false).build())) != null) {
                        h5ListenerAdapter.onProviderCallBack(load.getStream(), null);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("abUrl: ");
                    sb.append(absoluteUrlV2);
                    GriverLogger.d(TAG, sb.toString());
                    return;
                }
                h5ListenerAdapter.onProviderCallBack(null, "response is null.");
                return;
            }
            h5ListenerAdapter.onProviderCallBack(null, "response is null.");
            return;
        }
        h5ListenerAdapter.onProviderCallBack(null, "response is null.");
    }

    public static String transferApPathToLocalPath(String str) {
        return AOMPFileTinyAppUtils.transferApPathToLocalPath(str);
    }
}
