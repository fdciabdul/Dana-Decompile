package com.alibaba.griver.core.embedview;

import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.video.BeePlayerManager;
import com.iap.ac.android.biz.common.utils.Utils;

/* loaded from: classes6.dex */
public class NXEmbedAppExtension extends NXEmbedBackIntercept implements BackKeyDownPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.BackKeyDownPoint
    public Boolean intercept(App app) {
        RVLogger.d("Griver:NXEmbedAppExtension", "intercept  app back down ");
        Boolean bool = Boolean.FALSE;
        if (app == null || app.getActivePage() == null || app.getActivePage().getRender() == null) {
            RVLogger.d("Griver:NXEmbedAppExtension", " not exist active page ,don't intercept ");
            return bool;
        } else if (Utils.checkClassExist("com.alibaba.griver.video.H5BeeVideoPlayerView") && BeePlayerManager.getInstance().exitFullScreen()) {
            return Boolean.TRUE;
        } else {
            if (((GriverWebRenderImpl) app.getActivePage().getRender()).isVideoFullscreen()) {
                RVLogger.d("Griver:NXEmbedAppExtension", "video full screen playing intercept");
                return Boolean.TRUE;
            }
            PageNode pageNode = (PageNode) app.getActivePage();
            if (AppInfoUtils.isEmbeddedApp(app.getActivePage())) {
                return Boolean.valueOf(interceptBack(pageNode));
            }
            if (pageNode.getEmbedPage() == null) {
                RVLogger.d("Griver:NXEmbedAppExtension", " not exist embed page  ,don't intercept ");
                return bool;
            }
            return Boolean.valueOf(interceptBack((PageNode) pageNode.getEmbedPage()));
        }
    }
}
