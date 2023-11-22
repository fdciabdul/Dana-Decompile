package com.alibaba.griver.core.extensions;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.api.APWebSettings;
import com.alibaba.griver.base.common.webview.WebViewSettingExtension;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.core.render.H5WebView;

/* loaded from: classes6.dex */
public class DefaultWebViewSettingExtensionImpl implements WebViewSettingExtension {
    @Override // com.alibaba.griver.base.common.webview.WebViewSettingExtension
    public APWebSettings getWebViewSettings(Page page) {
        if (page == null) {
            RVLogger.e("GriverWebViewUtils", "page is null");
            return null;
        }
        H5WebView h5WebView = ((GriverWebRenderImpl) page.getRender()).getH5WebView();
        if (h5WebView == null) {
            RVLogger.e("GriverWebViewUtils", "webView is null");
            return null;
        }
        return h5WebView.getSettings();
    }
}
