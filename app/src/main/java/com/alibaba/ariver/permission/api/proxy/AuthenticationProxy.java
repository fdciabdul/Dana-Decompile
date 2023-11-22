package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.util.List;
import java.util.Map;

@DefaultImpl("com.alibaba.ariver.permission.service.DefaultAuthenticationProxyImpl")
/* loaded from: classes2.dex */
public interface AuthenticationProxy extends Proxiable {

    /* loaded from: classes6.dex */
    public interface LocalPermissionCallback {
        void onError(int i, String str);

        void onNegative(boolean z);

        void onPositive();
    }

    ApiPermissionCheckResult checkEventPermission(String str, String str2, Page page);

    ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, Page page);

    ApiPermissionCheckResult checkSPJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, Page page);

    boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, Page page);

    boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, LocalPermissionCallback localPermissionCallback, Page page);

    void clearPermissionModel(String str, boolean z);

    Map<String, Boolean> getAllPermissions(String str, String str2, AppModel appModel, Page page);

    Map<String, Boolean> getAllPermissions(String str, String str2, AppModel appModel, String str3);

    String getPermissionByScope(String str, String str2, String str3);

    PermissionModel getPermissionModel(String str);

    List<Permission> getPermissions(String str);

    PermissionModel getPluginPermissionModel(String str, String str2);

    ApiPermissionCheckResult hasPermission(String str, String str2, String str3, App app, Page page);

    ApiPermissionCheckResult hasPermission(String str, String str2, String str3, Page page);

    boolean hasPermissionModel(String str, Page page);

    boolean interceptForRender(String str);

    ApiPermissionCheckResult interceptSchemeForTiny(String str, Page page);

    ApiPermissionCheckResult interceptUrlForTiny(String str, String str2, Page page, boolean z);

    void removeAllPermissionInfo(String str, String str2);

    void setPermissionModel(String str, PermissionModel permissionModel);

    void setPermissionState(String str, String str2, App app, String str3, String str4, boolean z);

    void setPermissionState(String str, String str2, String str3, String str4, boolean z);

    void setPluginPermissionModel(String str, PluginModel pluginModel, PermissionModel permissionModel);
}
