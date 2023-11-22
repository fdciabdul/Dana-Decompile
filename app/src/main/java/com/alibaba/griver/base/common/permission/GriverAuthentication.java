package com.alibaba.griver.base.common.permission;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.h5.permission.GriverJSAPIPermissionProxy;

/* loaded from: classes6.dex */
public class GriverAuthentication extends DefaultAuthenticationProxyImpl {
    @Override // com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl, com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean hasPermissionModel(String str, Page page) {
        if (BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false)) {
            return true;
        }
        return super.hasPermissionModel(str, page);
    }

    @Override // com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl, com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, Page page) {
        if (BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false)) {
            GriverJSAPIPermissionProxy griverJSAPIPermissionProxy = (GriverJSAPIPermissionProxy) RVProxy.get(GriverJSAPIPermissionProxy.class);
            if (griverJSAPIPermissionProxy != null && griverJSAPIPermissionProxy.hasDomainPermission(permission.authority(), page.getOriginalURI())) {
                return ApiPermissionCheckResult.ALLOW;
            }
            return ApiPermissionCheckResult.DENY;
        }
        return super.checkJSApi(permission, nativeCallContext, bridgeResponseHelper, app, page);
    }

    @Override // com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl, com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page) {
        GriverJSAPIPermissionProxy griverJSAPIPermissionProxy;
        if (BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false) && (griverJSAPIPermissionProxy = (GriverJSAPIPermissionProxy) RVProxy.get(GriverJSAPIPermissionProxy.class)) != null && griverJSAPIPermissionProxy.hasDomainPermission(permission.authority(), page.getOriginalURI())) {
            page.getApp().getEngineProxy().getBridge().sendToNative(nativeCallContext, bridgeResponseHelper.getInnerBridgeResponse(), false);
            return true;
        }
        return super.checkShowPermissionDialog(permission, nativeCallContext, bridgeResponseHelper, page);
    }
}
