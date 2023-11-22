package com.alibaba.ariver.permission.util;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes6.dex */
public class TRVAuthUtils {
    public static boolean isPlatformTB(App app) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            return true;
        }
        return isPlatformTB(appModel);
    }

    public static boolean isPlatformTB(AppModel appModel) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        return "TB".equals((rVEnvironmentService == null || appModel.getAppInfoModel() == null) ? "AP" : rVEnvironmentService.defaultPlatform());
    }
}
