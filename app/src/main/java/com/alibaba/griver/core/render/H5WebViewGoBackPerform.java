package com.alibaba.griver.core.render;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.common.CommonBackPerform;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class H5WebViewGoBackPerform extends CommonBackPerform {

    /* renamed from: a */
    private GriverWebRenderImpl f6453a;

    public H5WebViewGoBackPerform(GriverWebRenderImpl griverWebRenderImpl) {
        super(griverWebRenderImpl);
        this.f6453a = griverWebRenderImpl;
    }

    @Override // com.alibaba.ariver.engine.api.common.CommonBackPerform
    public boolean enableInterceptBack(Render render) {
        if (BundleUtils.getBoolean(render.getStartParams(), RVParams.isTinyApp, false)) {
            if (((TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class)).isInner((App) render.getPage().bubbleFindNode(App.class))) {
                RVLogger.d("H5WebViewGoBackPerform", "innerApp enable back intercept!");
                return true;
            }
            return super.enableInterceptBack(render);
        }
        return true;
    }

    @Override // com.alibaba.ariver.engine.api.common.CommonBackPerform
    public void performBack(GoBackCallback goBackCallback) {
        GriverWebRenderImpl griverWebRenderImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("perform back behavior ");
        sb.append(this.backBehavior);
        GriverLogger.d("H5WebViewGoBackPerform", sb.toString());
        if (this.backBehavior == CommonBackPerform.POP) {
            if (goBackCallback != null) {
                goBackCallback.afterProcess(false);
            }
        } else if (this.backBehavior != CommonBackPerform.BACK || (griverWebRenderImpl = this.f6453a) == null || griverWebRenderImpl.getH5WebView() == null) {
        } else {
            H5WebView h5WebView = this.f6453a.getH5WebView();
            if (!h5WebView.canGoBack()) {
                GriverLogger.d("H5WebViewGoBackPerform", "webview can't go back and do exit!");
                if (goBackCallback != null) {
                    goBackCallback.afterProcess(false);
                }
            } else if (h5WebView.copyBackForwardList().getCurrentIndex() <= 0) {
                GriverLogger.d("H5WebViewGoBackPerform", "webview with no history and do exit!");
                if (goBackCallback != null) {
                    goBackCallback.afterProcess(false);
                }
            } else {
                h5WebView.goBack();
                if (goBackCallback != null) {
                    goBackCallback.afterProcess(true);
                }
            }
        }
    }
}
