package com.alibaba.ariver.permission.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class EventSendInterceptorExtension implements EventSendInterceptorPoint, NodeAware<Page> {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f6178a;
    private AuthenticationProxy b;
    private WeakReference<Page> c;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6178a = arrayList;
        arrayList.add("JSPlugin_AlipayH5Share");
        f6178a.add(RVEvents.BEFORE_UNLOAD);
        f6178a.add("message");
        f6178a.add(RVEvents.NBCOMPONENT_CANRENDER);
    }

    @Override // com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint
    public boolean needIntercept(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("send event permission check action=");
        sb.append(str);
        RVLogger.d("EventSendInterceptorExtension", sb.toString());
        Page page = this.c.get();
        if (page == null) {
            RVLogger.d("EventSendInterceptorExtension", "  page is recycle ,intercept event send");
            return true;
        }
        String string = BundleUtils.getString(page.getStartParams(), "appId");
        ApiPermissionCheckResult checkEventPermission = this.b.checkEventPermission(string, str, page);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("app:");
        sb2.append(string);
        sb2.append("  send event permission check result is ");
        sb2.append(checkEventPermission);
        RVLogger.d("EventSendInterceptorExtension", sb2.toString());
        if (checkEventPermission == ApiPermissionCheckResult.IGNORE || f6178a.contains(str)) {
            return false;
        }
        RVLogger.d("EventSendInterceptorExtension", " event is no send permission and not in white list ,intercept");
        return true;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.b = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.c = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }
}
