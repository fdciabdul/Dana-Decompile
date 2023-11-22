package com.alibaba.griver.core.extensions;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.bridge.GriverBridgeCallNotFoundEvent;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.utils.MiniProgramMetaUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverBridgeNotFoundExtension implements NativeCallNotFoundPoint, NodeAware<Page> {
    private static final String TAG = "GriverBridgeNotFoundExtension";
    private WeakReference<Page> pageWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint
    public boolean handleNotFound(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        if ("yes".equalsIgnoreCase(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_BRIDGE_NOT_FOUND_EVENT_SWITCH, "YES"))) {
            return false;
        }
        WeakReference<Page> weakReference = this.pageWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            GriverLogger.w(TAG, "page is null, return directly");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("not found internal extension for ");
        sb.append(nativeCallContext.getName());
        GriverLogger.d(TAG, sb.toString());
        GriverBridgeCallNotFoundEvent.BridgeContext bridgeContext = new GriverBridgeCallNotFoundEvent.BridgeContext();
        bridgeContext.jsapiName = nativeCallContext.getName();
        bridgeContext.page = this.pageWeakReference.get();
        bridgeContext.miniProgramPageURL = this.pageWeakReference.get().getOriginalURI();
        MiniProgramMetaUtils.extractAcParams(this.pageWeakReference.get(), bridgeContext, bridgeContext.jsapiName);
        if (nativeCallContext.getParams() != null) {
            bridgeContext.jsParameters = new JSONObject(nativeCallContext.getParams());
        }
        if (nativeCallContext.getRender() != null) {
            bridgeContext.context = nativeCallContext.getRender().getActivity();
            bridgeContext.startParams = nativeCallContext.getRender().getStartParams();
            String appId = nativeCallContext.getRender().getAppId();
            if (BundleUtils.getBoolean(this.pageWeakReference.get().getApp().getStartParams(), RVParams.isH5App, false) && !TextUtils.isEmpty(appId)) {
                if (TextUtils.equals("null_online", appId)) {
                    appId = "";
                } else if (appId.endsWith(GriverBaseConstants.H5_ONLINE_SUFFIX)) {
                    appId = appId.replace(GriverBaseConstants.H5_ONLINE_SUFFIX, "");
                }
            }
            bridgeContext.miniProgramAppID = appId;
        }
        return ((GriverBridgeCallNotFoundEvent) ExtensionPoint.as(GriverBridgeCallNotFoundEvent.class).node(this.pageWeakReference.get()).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.extensions.GriverBridgeNotFoundExtension.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && list.size() != 0) {
                    Iterator<Boolean> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().booleanValue()) {
                            return Boolean.TRUE;
                        }
                    }
                }
                return Boolean.FALSE;
            }
        }).create()).handleBridgeCallNotFound(bridgeContext, new DefaultBridgeCallback(bridgeResponseHelper));
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.pageWeakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }
}
