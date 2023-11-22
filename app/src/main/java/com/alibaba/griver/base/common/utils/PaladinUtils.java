package com.alibaba.griver.base.common.utils;

import android.os.Bundle;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.ContainerModel;

/* loaded from: classes6.dex */
public class PaladinUtils {
    public static final String ENABLE_PALADIN = "enablePaladin";
    public static final String IS_TINY_GAME = "isPaladinApp";
    private static final String TAG = "PaladinUtils";

    public static boolean isTinyGame(AppModel appModel) {
        return isTinyGameSubType(appModel) || enablePaladin(appModel);
    }

    public static boolean isTinyGameSubType(AppModel appModel) {
        AppInfoModel appInfoModel;
        return (appModel == null || (appInfoModel = appModel.getAppInfoModel()) == null || appInfoModel.getSubType() != 8) ? false : true;
    }

    public static boolean enablePaladin(AppModel appModel) {
        if (appModel == null) {
            return false;
        }
        try {
            ContainerModel containerInfo = appModel.getContainerInfo();
            if (containerInfo == null) {
                RVLogger.e(TAG, "containerModel...is null");
                return false;
            }
            String string = JSONUtils.getString(containerInfo.getLaunchParams(), ENABLE_PALADIN);
            StringBuilder sb = new StringBuilder();
            sb.append("enablePaladin..");
            sb.append(string);
            RVLogger.d(TAG, sb.toString());
            return "yes".equalsIgnoreCase(string);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enablePaladin..e=");
            sb2.append(th);
            RVLogger.e(TAG, sb2.toString());
            return false;
        }
    }

    public static void injectPaladinStartParams(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putBoolean(IS_TINY_GAME, true);
        bundle.putString("transparentTitle", RVStartParams.TRANSPARENT_TITLE_ALWAYS);
        bundle.putString(RVParams.LONG_TITLE_PENETRATE, "YES");
        bundle.putString(RVStartParams.KEY_SUPER_SPLASH, "YES");
        bundle.putString(RVStartParams.KEY_GAME_MODE, "YES");
    }
}
