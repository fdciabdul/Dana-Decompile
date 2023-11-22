package com.alibaba.ariver.permission.api;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.JsapiInterceptorProxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AppPermissionManager implements PermissionManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6175a;
    private static List<String> b;
    private AuthenticationProxy c;
    private JsapiInterceptorProxy d;
    private BizPermissionManager e;
    private String f;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("AriverPermission:");
        sb.append("AppPermissionManager");
        f6175a = sb.toString();
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add("registerWorker");
        b.add("handleLoggingAction");
    }

    public AppPermissionManager(BizPermissionManager bizPermissionManager) {
        this.e = bizPermissionManager;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public void init(Accessor accessor) {
        this.f = AppPermissionUtils.getPermissionAppId(accessor);
        this.c = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        this.d = (JsapiInterceptorProxy) RVProxy.get(JsapiInterceptorProxy.class);
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public ApiPermissionCheckResult checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        App app;
        Page page = null;
        if (accessor instanceof Page) {
            page = (Page) accessor;
            app = page.getApp();
        } else {
            app = accessor instanceof App ? (App) accessor : null;
        }
        if (page == null && app == null) {
            return ApiPermissionCheckResult.DENY;
        }
        ApiPermissionCheckResult checkJSApi = this.c.checkJSApi(permission, nativeCallContext, bridgeResponseHelper, app, page);
        if (ApiPermissionCheckResult.ALLOW == checkJSApi) {
            String str = f6175a;
            StringBuilder sb = new StringBuilder();
            sb.append("checkPermission allowed:\t ");
            sb.append(nativeCallContext.getName());
            RVLogger.d(str, sb.toString());
            return this.c.checkSPJSApi(permission, nativeCallContext, bridgeResponseHelper, app, page);
        }
        if (ApiPermissionCheckResult.IGNORE == checkJSApi) {
            String str2 = f6175a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkPermission ignored:\t ");
            sb2.append(nativeCallContext.getName());
            RVLogger.d(str2, sb2.toString());
        }
        return checkJSApi;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        if (accessor instanceof Page) {
            Page page = (Page) accessor;
            if (this.c.checkShowPermissionDialog(permission, nativeCallContext, bridgeResponseHelper, page)) {
                return true;
            }
            boolean asyncInterceptor = this.d.asyncInterceptor(permission, nativeCallContext, bridgeResponseHelper, page);
            String str = f6175a;
            StringBuilder sb = new StringBuilder();
            sb.append("JsapiInterceptorProxy need intercepted ");
            sb.append(asyncInterceptor);
            RVLogger.d(str, sb.toString());
            return asyncInterceptor;
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        BizPermissionManager bizPermissionManager = this.e;
        if (bizPermissionManager == null || bizPermissionManager.checkBizParamPermission(permission.authority(), this.f, nativeCallContext.getParams())) {
            return false;
        }
        String str = f6175a;
        StringBuilder sb = new StringBuilder();
        sb.append(permission.authority());
        sb.append(" is not supported by param!");
        RVLogger.d(str, sb.toString());
        if (bridgeResponseHelper != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(permission.authority());
            sb2.append(" is not supported by param!");
            bridgeResponseHelper.sendError(2, sb2.toString());
            return false;
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public Group manageAccessorGroup(Accessor accessor) {
        return RVGroup.LEVEL_APP_DEFAULT;
    }
}
