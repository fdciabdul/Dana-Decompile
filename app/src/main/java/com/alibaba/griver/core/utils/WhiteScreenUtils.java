package com.alibaba.griver.core.utils;

import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverWhiteScreenStageMonitor;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.griver.core.ui.GriverPage;

/* loaded from: classes3.dex */
public class WhiteScreenUtils {

    /* loaded from: classes3.dex */
    public interface WhiteScreenCallBack {
        void next();
    }

    private WhiteScreenUtils() {
    }

    private static JSONObject a() {
        JSONObject jSONObject;
        try {
            jSONObject = JSON.parseObject(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_WHITE_SCREEN_CONFIG, GriverConfigConstants.DEFAULT_WHITE_SCREEN_CONFIG));
        } catch (Exception e) {
            GriverLogger.w("WhiteScreenManager", "parse white screen config failed", e);
            jSONObject = null;
        }
        return jSONObject == null ? JSONUtils.parseObject(GriverConfigConstants.DEFAULT_WHITE_SCREEN_CONFIG) : jSONObject;
    }

    private static int b() {
        return JSONUtils.getInt(a(), GriverConfigConstants.PARAM_WHITE_SCREEN_MINI_THRESHOLD, 5);
    }

    private static boolean c() {
        return JSONUtils.getBoolean(a(), "enable", true);
    }

    private static int d() {
        return JSONUtils.getInt(a(), GriverConfigConstants.PARAM_WHITE_SCREEN_H5_THRESHOLD, 8);
    }

    private static Pair<Boolean, String> a(Page page) {
        boolean z = BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false);
        Boolean bool = Boolean.TRUE;
        if (z) {
            return new Pair<>(bool, page.getRender().getCurrentUri());
        }
        for (IEmbedView iEmbedView : page.getPageContext().getEmbedViewManager().findAllEmbedView()) {
            if (iEmbedView instanceof NXEmbedWebView) {
                return new Pair<>(bool, ((NXEmbedWebView) iEmbedView).getEmbedPage().getRender().getCurrentUri());
            }
        }
        if (PWAUtils.isPwaApp(page)) {
            return new Pair<>(bool, PWAUtils.getPwaUrl((AppModel) BundleUtils.getParcelable(page.getSceneParams(), "appInfo")));
        }
        return new Pair<>(Boolean.FALSE, page.getRender().getCurrentUri());
    }

    public static void initPageEnterTime(Page page) {
        if (page instanceof GriverPage) {
            ((GriverPage) page).setPageStartTime(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Boolean bool, Boolean bool2, GriverStageMonitor griverStageMonitor, App app) {
        if (griverStageMonitor != null && (griverStageMonitor instanceof GriverWhiteScreenStageMonitor) && bool2.booleanValue()) {
            ((GriverWhiteScreenStageMonitor) griverStageMonitor).uploadWhiteScreen(GriverMonitorConstants.EVENT_PWA_SHELL_APP_WHITE_SCREEN, app);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void trackWhiteDate(int r20, long r21, com.alibaba.ariver.app.api.Page r23, final com.alibaba.griver.core.utils.WhiteScreenUtils.WhiteScreenCallBack r24) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.utils.WhiteScreenUtils.trackWhiteDate(int, long, com.alibaba.ariver.app.api.Page, com.alibaba.griver.core.utils.WhiteScreenUtils$WhiteScreenCallBack):void");
    }
}
