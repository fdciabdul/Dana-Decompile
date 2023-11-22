package com.alibaba.griver.core.render.extensions;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.api.ReceivedTitlePoint;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.core.render.H5ScriptLoader;
import com.alibaba.griver.image.photo.PhotoContext;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverBridgeInjectExtension implements PageStartedPoint, NodeAware<Page>, PageFinishedPoint, ReceivedTitlePoint {
    WeakReference<Page> pageWeakReference;
    H5ScriptLoader scriptLoader;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
    public void onStarted(String str) {
        if (!a(str) || this.scriptLoader == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onStarted = ");
        sb.append(str);
        GriverLogger.d("GriverBridgeInjectExtension", sb.toString());
        this.scriptLoader.resetBridge();
        Page page = this.pageWeakReference.get();
        if (page == null || !BundleUtils.getBoolean(page.getStartParams(), "preInjectJSBridge", false)) {
            return;
        }
        this.scriptLoader.loadScript();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.scriptLoader = null;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        if (weakReference != null) {
            this.pageWeakReference = weakReference;
        }
        WeakReference<Page> weakReference2 = this.pageWeakReference;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        Render render = this.pageWeakReference.get().getRender();
        if (render instanceof GriverWebRenderImpl) {
            this.scriptLoader = ((GriverWebRenderImpl) render).getH5ScriptLoader();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.griver.api.webview.PageFinishedPoint
    public void onPageFinished(String str) {
        if (!a(str) || this.scriptLoader == null) {
            return;
        }
        GriverLogger.d("GriverBridgeInjectExtension", "onPageFinished");
        this.scriptLoader.loadScript();
    }

    @Override // com.alibaba.griver.base.api.ReceivedTitlePoint
    public void onReceivedTitle(String str, String str2) {
        if (!a(str) || this.scriptLoader == null) {
            return;
        }
        GriverLogger.d("GriverBridgeInjectExtension", "onReceivedTitle");
        this.scriptLoader.loadScript();
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(PhotoContext.FILE_SCHEME) || str.startsWith("http://") || str.startsWith("https://"));
    }
}
