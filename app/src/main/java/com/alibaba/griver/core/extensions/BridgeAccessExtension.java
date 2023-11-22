package com.alibaba.griver.core.extensions;

import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.api.AppPermissionManager;
import com.alibaba.ariver.permission.api.PermissionManager;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.model.RVGroupInit;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.nebula.H5DevConfig;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes6.dex */
public class BridgeAccessExtension implements BridgeAccessPoint, NodeAware<Page> {

    /* renamed from: a  reason: collision with root package name */
    private PermissionManager f6405a;
    private Page b = null;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
        Page page;
        JSONObject extendInfos;
        JSONObject jSONObject;
        if (((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean(H5DevConfig.H5_JSAPI_PERMISSION, false)) {
            StringBuilder sb = new StringBuilder();
            sb.append("accessor");
            sb.append(accessor.hashCode());
            sb.append(" debug app permission check switch is close");
            RVLogger.d("AriverPermission:BridgeAccessExtension", sb.toString());
            return false;
        }
        if (this.f6405a == null) {
            AppPermissionManager appPermissionManager = new AppPermissionManager(null);
            this.f6405a = appPermissionManager;
            appPermissionManager.init(accessor);
        }
        Page page2 = this.b;
        if (page2 != null && page2.getApp() != null && !((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).hasPermissionModel(this.b.getApp().getAppId(), this.b)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("accessor");
            sb2.append(accessor.hashCode());
            sb2.append(" dont have permission model");
            RVLogger.d("AriverPermission:BridgeAccessExtension", sb2.toString());
            return false;
        }
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (tinyAppInnerProxy == null || (page = this.b) == null || page.getApp() == null || !tinyAppInnerProxy.isInner(this.b.getApp())) {
            return true;
        }
        if (this.b.getEmbedType() != EmbedType.NO && PermissionUtil.forceInnerWebViewCheck()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("accessor");
            sb3.append(accessor.hashCode());
            sb3.append(" isInner app but web-view , need check permission ");
            RVLogger.d("AriverPermission:BridgeAccessExtension", sb3.toString());
            return true;
        } else if (AppPermissionUtils.callFromPageNotVhostAndNoWorker(this.b) && AppPermissionUtils.forceInnerWebViewPushWindowPageCheck()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("accessor");
            sb4.append(accessor.hashCode());
            sb4.append(" isInner app but from web-view push window , need check permission ");
            RVLogger.d("AriverPermission:BridgeAccessExtension", sb4.toString());
            return true;
        } else {
            AppModel appModel = (AppModel) this.b.getApp().getData(AppModel.class);
            if (appModel != null && (extendInfos = appModel.getExtendInfos()) != null && (jSONObject = JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_PARAM_MAP, null)) != null && PermissionUtil.forceInnerPermissionCheck(jSONObject)) {
                RVLogger.d("AriverPermission:BridgeAccessExtension", "force check permission paramMap");
                return true;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("accessor");
            sb5.append(accessor.hashCode());
            sb5.append("isInner app ");
            RVLogger.d("AriverPermission:BridgeAccessExtension", sb5.toString());
            return false;
        }
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean bizCheckPermission = this.f6405a.bizCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        StringBuilder sb = new StringBuilder();
        sb.append("accessor");
        sb.append(accessor.hashCode());
        sb.append(" bizCheckPermission check permission = ");
        sb.append(permission.authority());
        sb.append(", result=");
        sb.append(bizCheckPermission);
        RVLogger.d("AriverPermission:BridgeAccessExtension", sb.toString());
        return bizCheckPermission;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public ApiPermissionCheckResult checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        ApiPermissionCheckResult checkPermission = this.f6405a.checkPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        StringBuilder sb = new StringBuilder();
        sb.append("accessor");
        sb.append(accessor.hashCode());
        sb.append(" custom check permission = ");
        sb.append(permission.authority());
        sb.append(", result=");
        sb.append(checkPermission);
        RVLogger.d("AriverPermission:BridgeAccessExtension", sb.toString());
        return checkPermission;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean asyncCheckPermission = this.f6405a.asyncCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        StringBuilder sb = new StringBuilder();
        sb.append("accessor");
        sb.append(accessor.hashCode());
        sb.append(" asyncCheckPermission = ");
        sb.append(permission.authority());
        sb.append(", result=");
        sb.append(asyncCheckPermission);
        RVLogger.d("AriverPermission:BridgeAccessExtension", sb.toString());
        return asyncCheckPermission;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public Group manageAccessorGroup(Accessor accessor) {
        RVGroupInit.init(null);
        Group manageAccessorGroup = this.f6405a.manageAccessorGroup(accessor);
        StringBuilder sb = new StringBuilder();
        sb.append("accessor");
        sb.append(accessor.hashCode());
        sb.append(" group=");
        sb.append(manageAccessorGroup.groupName());
        RVLogger.d("AriverPermission:BridgeAccessExtension", sb.toString());
        return manageAccessorGroup;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.b = weakReference.get();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }
}
