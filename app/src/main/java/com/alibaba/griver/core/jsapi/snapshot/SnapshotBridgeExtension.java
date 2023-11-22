package com.alibaba.griver.core.jsapi.snapshot;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class SnapshotBridgeExtension implements BridgeExtension {
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

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse saveSnapshot(@BindingNode(App.class) App app, @BindingParam({"snapshot"}) String str, @BindingParam({"pagePath"}) String str2, @BindingParam(name = {"preRender"}) boolean z, @BindingParam(name = {"progressive"}) boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            RVLogger.e("AriverAPI:SnapshotBridgeExtension", "saveSnapshot pagePath is null");
            return BridgeResponse.INVALID_PARAM;
        } else if ("yes".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "ignoreSnapshot"))) {
            return BridgeResponse.SUCCESS;
        } else {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel == null) {
                RVLogger.d("AriverAPI:SnapshotBridgeExtension", "saveSnapshot failed, appModel is null");
                return BridgeResponse.SUCCESS;
            }
            synchronized (this) {
                GriverRVSnapshotUtils.saveSnapshot(app, appModel, str, str2, false, z2);
            }
            return BridgeResponse.SUCCESS;
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse deleteSnapshot(@BindingNode(App.class) App app, @BindingParam({"pagePath"}) String str, @BindingParam(name = {"progressive"}) boolean z) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e("AriverAPI:SnapshotBridgeExtension", "saveSnapshot pagePath is null");
            return BridgeResponse.INVALID_PARAM;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            RVLogger.d("AriverAPI:SnapshotBridgeExtension", "deleteSnapshot failed, appModel is null");
            return BridgeResponse.SUCCESS;
        } else if (GriverRVSnapshotUtils.deleteSnapshot(app, appModel, str, z)) {
            return BridgeResponse.SUCCESS;
        } else {
            return BridgeResponse.UNKNOWN_ERROR;
        }
    }

    @ActionFilter
    @AutoCallback
    public JSONObject getSnapshotConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app != null && app.getStartParams() != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("snapshotEnabled", (Object) Boolean.valueOf(app.getStartParams().getBoolean(RVStartParams.KEY_SNAPSHOT_ENABLED)));
            return jSONObject;
        }
        return BridgeResponse.NOT_FOUND.get();
    }
}
