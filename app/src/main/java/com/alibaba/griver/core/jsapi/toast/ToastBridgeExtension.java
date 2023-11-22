package com.alibaba.griver.core.jsapi.toast;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class ToastBridgeExtension implements BridgeExtension {
    private static final String TAG = "ToastBridgeExtension";

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
    public void toast(@BindingParam({"content"}) String str, @BindingParam(intDefault = 2000, value = {"duration"}) int i, @BindingParam({"type"}) String str2, @BindingParam({"xOffset"}) int i2, @BindingParam({"yOffset"}) int i3, @BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page == null || page.getPageContext() == null || page.getPageContext().getActivity() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        Activity activity = page.getPageContext().getActivity();
        final ToastPoint toastPoint = (ToastPoint) ExtensionPoint.as(ToastPoint.class).node(page).create();
        toastPoint.showToast(activity, str, i, str2, i2, i3);
        StringBuilder sb = new StringBuilder();
        sb.append("toast duration: ");
        sb.append(i);
        GriverLogger.d(TAG, sb.toString());
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.jsapi.toast.ToastBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                toastPoint.hideToast();
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }, i);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideToast(@BindingNode(Page.class) Page page) {
        ((ToastPoint) ExtensionPoint.as(ToastPoint.class).node(page).create()).hideToast();
        return BridgeResponse.SUCCESS;
    }
}
