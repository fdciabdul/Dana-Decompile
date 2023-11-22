package com.alibaba.griver.core.render.extensions;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.griver.api.webview.GriverWebViewReceivedErrorExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import com.alibaba.griver.core.render.H5ScriptLoader;
import com.alibaba.griver.core.utils.H5ErrorMsgUtil;
import id.dana.data.here.HereOauthManager;

/* loaded from: classes6.dex */
public class GriverDefaultWebViewReceivedErrorExtension implements GriverWebViewReceivedErrorExtension {
    private static final String TAG = "GriverDefaultWebViewReceivedErrorExtension";

    @Override // com.alibaba.griver.api.webview.GriverWebViewReceivedErrorExtension
    public void showError(Page page, String str, int i) {
        String errorMsg = H5ErrorMsgUtil.getErrorMsg(i, false);
        String errorMsg2 = H5ErrorMsgUtil.getErrorMsg(i, true);
        Render render = page.getRender();
        if (render instanceof GriverWebRenderImpl) {
            showDefaultErrorPage(page, (GriverWebRenderImpl) render, str, i, errorMsg, errorMsg2);
        }
    }

    private void showDefaultErrorPage(final Page page, GriverWebRenderImpl griverWebRenderImpl, String str, int i, String str2, String str3) {
        String readAsset = IOUtils.readAsset(GriverEnv.getResources(), ErrorPageUtils.getH5ErrorPage());
        if (readAsset == null) {
            return;
        }
        griverWebRenderImpl.loadDataWithBaseURL(str, readAsset.replaceAll("&&&&", str2).replaceAll("!!!!", String.valueOf(i)), "text/html", HereOauthManager.ENC, str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.griver.core.render.extensions.GriverDefaultWebViewReceivedErrorExtension.1
            @Override // java.lang.Runnable
            public void run() {
                H5ScriptLoader h5ScriptLoader;
                Render render = page.getRender();
                if (!(render instanceof GriverWebRenderImpl) || (h5ScriptLoader = ((GriverWebRenderImpl) render).getH5ScriptLoader()) == null) {
                    return;
                }
                h5ScriptLoader.resetBridge();
                h5ScriptLoader.loadScript();
            }
        }, 300L);
    }
}
