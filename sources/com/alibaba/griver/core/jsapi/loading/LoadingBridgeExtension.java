package com.alibaba.griver.core.jsapi.loading;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.permission.api.RVFlag;

/* loaded from: classes2.dex */
public class LoadingBridgeExtension implements BridgeExtension {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showLoading(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"text"}) String str, @BindingParam({"delay"}) int i, @BindingParam(booleanDefault = true, value = {"cancelable"}) boolean z) {
        PageContext pageContext = page.getPageContext();
        if (pageContext != null && pageContext.getLoadingView() != null) {
            pageContext.getLoadingView().dismiss();
            pageContext.getLoadingView().show(str, i, z, true);
            RVFlag.hasShowLoading = true;
        }
        return BridgeResponse.newValue("success", Boolean.TRUE);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideLoading(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        boolean useSuperSplash = SplashUtils.useSuperSplash(app.getStartParams());
        RVFlag.hasShowLoading = false;
        SplashView splashView = app.getAppContext() == null ? null : ((AppUIContext) app.getAppContext()).getSplashView();
        if (useSuperSplash && splashView != null && splashView.getStatus() == SplashView.Status.LOADING) {
            splashView.exit(null);
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext != null && pageContext.getLoadingView() != null) {
            pageContext.getLoadingView().dismiss();
        }
        return BridgeResponse.newValue("success", Boolean.TRUE);
    }
}
