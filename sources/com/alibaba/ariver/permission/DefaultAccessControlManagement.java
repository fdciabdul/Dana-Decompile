package com.alibaba.ariver.permission;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultGroup;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.api.proxy.JsapiInterceptorProxy;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class DefaultAccessControlManagement implements AccessControlManagement {
    public static String TAG = "AriverPermission:DefaultAccessControlManagement";
    private static List<String> d;

    /* renamed from: a  reason: collision with root package name */
    private NativeCallContext f6174a;
    private BridgeResponseHelper b;
    private BridgeAccessPoint c;
    private boolean e = "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_checkInnerAppPermissionForH5", "no"));

    static {
        ArrayList arrayList = new ArrayList();
        d = arrayList;
        arrayList.add("handleLoggingAction");
        d.add("initialTraceDebug");
        d.add("postMethodTrace");
    }

    public DefaultAccessControlManagement(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ExtensionManager extensionManager) {
        this.f6174a = nativeCallContext;
        this.b = bridgeResponseHelper;
        this.c = (BridgeAccessPoint) ExtensionPoint.as(BridgeAccessPoint.class).extensionManager(extensionManager).useCache(true).node(nativeCallContext.getNode()).create();
        String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_ignorePermissionList", "");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return;
        }
        JSONObject parseObject = JSONUtils.parseObject(configWithProcessCache);
        JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, "whiteList", null);
        if (jSONArray != null && !jSONArray.isEmpty()) {
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof String) {
                    d.add((String) next);
                }
            }
        }
        JSONArray jSONArray2 = JSONUtils.getJSONArray(parseObject, "blockList", null);
        if (jSONArray2 == null || jSONArray2.isEmpty()) {
            return;
        }
        Iterator<Object> it2 = jSONArray2.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (next2 instanceof String) {
                d.remove((String) next2);
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
        if (d.contains(this.f6174a.getName())) {
            RVLogger.d(TAG, "needPermissionCheck ignore by WHITE_LIST");
            return false;
        } else if (!TextUtils.isEmpty(this.f6174a.getPluginId())) {
            return !a(true);
        } else if (a(false)) {
            return false;
        } else {
            return this.c.needPermissionCheck(accessor, list);
        }
    }

    private boolean a(boolean z) {
        App app;
        JSONObject extendInfos;
        JSONObject jSONObject;
        Page page = (Page) this.f6174a.getNode().bubbleFindNode(Page.class);
        if (page == null || (app = page.getApp()) == null) {
            return false;
        }
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ExtensionPoint.as(IgnorePermissionPoint.class).node(app).useCache(true).create();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(app.getAppId())) {
            RVLogger.d(TAG, "commonCheckIgnorePermission ignore by IgnorePermissionPoint");
            return true;
        }
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (!z && tinyAppInnerProxy != null) {
            if (tinyAppInnerProxy.isInner(app) && !tinyAppInnerProxy.isEmbedWebViewInnerAppBlack(page)) {
                if (this.e) {
                    if (app.isTinyApp()) {
                        if (page.getEmbedType() != EmbedType.NO && PermissionUtil.forceInnerWebViewCheck()) {
                            RVLogger.d(TAG, "not ignore Inner embed app");
                            return false;
                        } else if (AppPermissionUtils.callFromPageNotVhostAndNoWorker(page) && AppPermissionUtils.forceInnerWebViewPushWindowPageCheck()) {
                            RVLogger.d(TAG, "not ignore Inner push page");
                            return false;
                        } else {
                            AppModel appModel = (AppModel) app.getData(AppModel.class);
                            if (appModel != null && (extendInfos = appModel.getExtendInfos()) != null && (jSONObject = JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_PARAM_MAP, null)) != null && PermissionUtil.forceInnerPermissionCheck(jSONObject)) {
                                RVLogger.d(TAG, "force check permission paramMap");
                                return false;
                            }
                            RVLogger.d(TAG, "commonCheckIgnorePermission ignore by isInner");
                            return true;
                        }
                    }
                } else {
                    RVLogger.d(TAG, "commonCheckIgnorePermission ignore by isInner");
                    return true;
                }
            }
            if (RVResourceUtils.needSkipPermissionCheck(app) && !tinyAppInnerProxy.isEmbedWebViewInnerAppBlack(page)) {
                RVLogger.d(TAG, "commonCheckIgnorePermission ignore by checkPermission");
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public Group manageAccessorGroup(Accessor accessor) {
        if (TextUtils.isEmpty(this.f6174a.getPluginId())) {
            return this.c.manageAccessorGroup(accessor);
        }
        return DefaultGroup.EXTERNAL;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean bizPermissionCheck(Permission permission, Accessor accessor) {
        return this.c.bizCheckPermission(permission, accessor, this.f6174a, this.b);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public ApiPermissionCheckResult permissionCheck(Permission permission, Accessor accessor) {
        return this.c.checkPermission(permission, accessor, this.f6174a, this.b);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean asyncPermissionCheck(Permission permission, Accessor accessor) {
        return this.c.asyncCheckPermission(permission, accessor, this.f6174a, this.b);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean asyncInterceptJsapi(Permission permission, Accessor accessor) {
        Page page;
        if (this.f6174a.getNode() instanceof App) {
            page = ((App) this.f6174a.getNode()).getActivePage();
        } else {
            page = this.f6174a.getNode() instanceof Page ? (Page) this.f6174a.getNode() : null;
        }
        boolean asyncInterceptor = page != null ? ((JsapiInterceptorProxy) RVProxy.get(JsapiInterceptorProxy.class)).asyncInterceptor(permission, this.f6174a, this.b, page) : false;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("asyncInterceptJsapi: ");
        sb.append(asyncInterceptor);
        RVLogger.d(str, sb.toString());
        return asyncInterceptor;
    }
}
