package com.alibaba.griver.base.common.webview;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.griver.base.api.APWebSettings;

/* loaded from: classes6.dex */
public interface WebViewSettingExtension extends Proxiable {
    APWebSettings getWebViewSettings(Page page);
}
