package com.alibaba.griver.core.embedview;

import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.core.render.H5WebView;

/* loaded from: classes6.dex */
public class NXEmbedBackIntercept {
    /* JADX INFO: Access modifiers changed from: protected */
    public boolean interceptBack(PageNode pageNode) {
        try {
            if (pageNode == null) {
                RVLogger.e("Griver:NXEmbedBackIntercept", " embedPage is null");
                return false;
            } else if (EmbedType.MINI == pageNode.getEmbedType()) {
                RVLogger.d("Griver:NXEmbedBackIntercept", "mini embed webView  not interceptBack ");
                return false;
            } else {
                GriverWebRenderImpl griverWebRenderImpl = (GriverWebRenderImpl) pageNode.getRender();
                GriverWebRenderImpl griverWebRenderImpl2 = griverWebRenderImpl;
                if (griverWebRenderImpl.isVideoFullscreen()) {
                    RVLogger.d("Griver:NXEmbedBackIntercept", "embedPage video full screen playing intercept");
                    return true;
                }
                GriverWebRenderImpl griverWebRenderImpl3 = (GriverWebRenderImpl) pageNode.getRender();
                GriverWebRenderImpl griverWebRenderImpl4 = griverWebRenderImpl3;
                H5WebView h5WebView = griverWebRenderImpl3.getH5WebView();
                if (h5WebView != null && h5WebView.canGoBack()) {
                    if (h5WebView.copyBackForwardList().getCurrentIndex() <= 0) {
                        GriverLogger.d("Griver:NXEmbedBackIntercept", "interceptBackEvent...webview with no history");
                        return false;
                    }
                    GriverLogger.e("Griver:NXEmbedBackIntercept", "interceptBackEvent...go back");
                    h5WebView.goBack();
                    return true;
                }
                GriverLogger.d("Griver:NXEmbedBackIntercept", "interceptBackEvent...can not go back");
                return false;
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("interceptBackEvent...e=");
            sb.append(th);
            GriverLogger.e("Griver:NXEmbedBackIntercept", sb.toString());
            return false;
        }
    }
}
