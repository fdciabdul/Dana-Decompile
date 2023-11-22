package com.alibaba.griver.core.jsapi.ui;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.webview.AndroidWebViewDelegateView;
import com.alibaba.griver.ui.container.GriverPageContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AppearanceBridgeExtension extends SimpleBridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f6423a;

    static {
        ArrayList arrayList = new ArrayList();
        f6423a = arrayList;
        arrayList.add("light");
        arrayList.add("dark");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setBackgroundColor(@BindingNode(Page.class) Page page, @BindingParam(name = {"backgroundColor"}) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        final PageContainer pageContainer = page.getPageContext().getPageContainer();
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        try {
            final int parseColor = Color.parseColor(str);
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.jsapi.ui.AppearanceBridgeExtension.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup view = pageContainer.getView();
                    if (view == null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        return;
                    }
                    PageContainer pageContainer2 = pageContainer;
                    if (pageContainer2 instanceof GriverPageContainer) {
                        View renderView = ((GriverPageContainer) pageContainer2).getRenderView();
                        if (renderView != null) {
                            renderView.setBackgroundColor(parseColor);
                        }
                        if (renderView instanceof AndroidWebViewDelegateView) {
                            AndroidWebViewDelegateView androidWebViewDelegateView = (AndroidWebViewDelegateView) renderView;
                            if (androidWebViewDelegateView.getChildAt(0) != null) {
                                GriverLogger.d("AppearanceBridgeExtension", "apWebView.getView() is AndroidWebView");
                                androidWebViewDelegateView.getChildAt(0).setBackgroundColor(parseColor);
                            }
                        }
                    }
                    view.setBackgroundColor(parseColor);
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                }
            });
        } catch (Exception e) {
            GriverLogger.e("AppearanceBridgeExtension", "parse color error", e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public BridgeResponse setBackgroundTextStyle(@BindingNode(Page.class) Page page, @BindingParam(name = {"textStyle"}) String str) {
        if (!f6423a.contains(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        return BridgeResponse.UNKNOWN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideShareMenu() {
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideOptionMenuItem(@BindingApiContext ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject) {
        if (jSONObject == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (TextUtils.equals(jSONObject.getString("name"), "backToHome")) {
            Intent intent = new Intent("hide_title_bar_back_to_home");
            intent.putExtra("appId", apiContext.getAppId());
            LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext()).sendBroadcast(intent);
        }
        return BridgeResponse.SUCCESS;
    }
}
