package com.alibaba.griver.core.embedview;

import com.alibaba.ariver.engine.api.embedview.EmbedViewConstant;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.canvas.misc.CanvasEmbedView;
import com.alibaba.griver.media.live.view.GRVLivePlayerView;
import com.alibaba.griver.video.H5BeeVideoPlayerView;
import com.alipay.mobile.embedview.H5EmbedMapView;

/* loaded from: classes6.dex */
public class NXEmbedViewFactory implements EmbedViewProvider {
    public NXEmbedViewFactory() {
        a();
    }

    private void a() {
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alibaba.griver.core.embedview.NXEmbedWebView", EmbedViewConstant.TYPE_WEBVIEW));
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alibaba.griver.canvas.misc.CanvasEmbedView", "canvas"));
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alipay.mobile.embedview.H5EmbedMapView", "map"));
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alibaba.griver.core.embedview.H5BeeLottieView", "lottieview"));
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alibaba.griver.video.H5BeeVideoPlayerView", "video"));
        NXEmbedViewConfigManager.getInstance().addTypeConfig(new H5EmbedViewConfig("mobile-nebulaintegration", "com.alibaba.griver.media.live.view.GRVLivePlayerView", "live-player"));
    }

    @Override // com.alibaba.ariver.engine.api.embedview.EmbedViewProvider
    public IEmbedView createEmbedView(String str) {
        IEmbedView a2 = a(str);
        if (a2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("getEmbedView from no warp type=");
            sb.append(str);
            RVLogger.d("Griver:NXEmbedViewFactory", sb.toString());
            return a2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getEmbedView from legacy type=");
        sb2.append(str);
        RVLogger.w("Griver:NXEmbedViewFactory", sb2.toString());
        return null;
    }

    private IEmbedView a(String str) {
        try {
            if (NXEmbedViewConfigManager.getInstance().getConfig(str) != null) {
                if (EmbedViewConstant.TYPE_WEBVIEW.equals(str)) {
                    return new NXEmbedWebView();
                }
                if ("canvas".equals(str)) {
                    return new CanvasEmbedView();
                }
                if ("map".equals(str)) {
                    return new H5EmbedMapView();
                }
                if ("lottieview".equals(str)) {
                    return new H5BeeLottieView();
                }
                if ("video".equals(str)) {
                    return new H5BeeVideoPlayerView();
                }
                if ("live-player".equals(str)) {
                    return new GRVLivePlayerView();
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getEmbedView error:");
            sb.append(th);
            RVLogger.e("Griver:NXEmbedViewFactory", sb.toString());
            return null;
        }
    }
}
