package com.alibaba.griver.core.jsapi.pullrefresh;

import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;
import com.alibaba.griver.ui.container.GriverPageContainer;

/* loaded from: classes2.dex */
public class PullRefreshBridgeExtension implements BridgeExtension {
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
    public void startPullDownRefresh(@BindingApiContext ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (bridgeCallback == null) {
            GriverLogger.e("PullRefreshBridgeExtension", "start pull down refresh callback is null, return directly");
            return;
        }
        Context appContext = apiContext != null ? apiContext.getAppContext() : null;
        if (appContext == null) {
            appContext = GriverEnv.getApplicationContext();
        }
        if (appContext == null) {
            GriverLogger.e("PullRefreshBridgeExtension", "start pull down refresh, but context is null, return error");
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "system error"));
        } else if (page == null) {
            GriverLogger.e("PullRefreshBridgeExtension", "start pull down refresh, but page is null, return error");
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, appContext.getString(R.string.griver_core_system_error)));
        } else {
            boolean z = page.getStartParams() != null && ((Boolean) page.getStartParams().get("pullRefresh")).booleanValue();
            boolean z2 = page.getStartParams() == null || ((Boolean) page.getStartParams().get("canPullDown")).booleanValue();
            if (!z) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, appContext.getString(R.string.griver_core_need_enable_pull_refresh)));
            } else if (!z2) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, appContext.getString(R.string.griver_core_need_enable_pull_down)));
            } else {
                GriverLogger.d("PullRefreshBridgeExtension", "start pull down refresh");
                if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null) {
                    if (bridgeCallback != null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "Pull refresh is not enabled on the current page"));
                    }
                } else if (!(page.getPageContext().getPageContainer() instanceof GriverPageContainer)) {
                    if (bridgeCallback != null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "Pull refresh is not enabled on the current page"));
                    }
                } else {
                    ((GriverPageContainer) page.getPageContext().getPageContainer()).startPullDownRefresh();
                    if (bridgeCallback != null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    }
                }
            }
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void restorePullToRefresh(@BindingApiContext ApiContext apiContext, @BindingParam({"canPullDown"}) Boolean bool, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "pull to refresh is not enabled"));
            }
        } else if (!(page.getPageContext().getPageContainer() instanceof GriverPageContainer)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "pull to refresh is not enabled"));
            }
        } else {
            ((GriverPageContainer) page.getPageContext().getPageContainer()).restorePullToRefresh();
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setCanPullDown(@BindingApiContext ApiContext apiContext, @BindingParam({"canPullDown"}) boolean z, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null || !(page.getPageContext().getPageContainer() instanceof GriverPageContainer)) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, "set failed in current page"));
                return;
            }
            return;
        }
        ((GriverPageContainer) page.getPageContext().getPageContainer()).setCanPullDown(z);
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }
}
