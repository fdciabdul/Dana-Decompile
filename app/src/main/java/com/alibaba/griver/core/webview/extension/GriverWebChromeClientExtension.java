package com.alibaba.griver.core.webview.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.core.render.H5ScriptLoader;
import com.alibaba.griver.core.render.NXWebChromeClient;

/* loaded from: classes6.dex */
public interface GriverWebChromeClientExtension extends GriverExtension {
    NXWebChromeClient createWebChromeClient(Page page, GriverWebRenderImpl griverWebRenderImpl, H5ScriptLoader h5ScriptLoader, boolean z);
}
