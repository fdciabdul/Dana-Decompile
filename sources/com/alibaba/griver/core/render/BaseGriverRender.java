package com.alibaba.griver.core.render;

import android.app.Activity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.BaseRenderImpl;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.EventPoint;
import com.alibaba.griver.base.api.NXH5WebViewAdapter;
import com.alibaba.griver.core.ui.GriverPage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class BaseGriverRender extends BaseRenderImpl {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f6446a;
    protected GriverPage h5Page;
    protected App mAriverApp;
    protected Page mAriverPage;
    protected NXH5WebViewAdapter webViewAdapter;

    public abstract H5WebView getH5WebView();

    public void insertJS(String str) {
    }

    public void setViewParams(String str, String str2) {
    }

    static {
        HashSet hashSet = new HashSet();
        f6446a = hashSet;
        hashSet.add("h5PageJsParam");
        f6446a.add("h5PageReload");
        f6446a.add("h5ToolbarMenuBt");
        f6446a.add("h5PageClose");
        f6446a.add("h5PageClose_tab");
        f6446a.add("stopLoading");
        f6446a.add("exitSession");
        f6446a.add(RVParams.LONG_SHOW_FAVORITES);
        f6446a.add("hideFavorites");
        f6446a.add("h5PageAbnormal");
        f6446a.add("h5PageDoLoadUrl");
    }

    public BaseGriverRender(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        super(rVEngine, activity, dataNode, createParams);
        if (!(dataNode instanceof Page)) {
            throw new IllegalArgumentException("node shoud must H5Page");
        }
        this.h5Page = (GriverPage) dataNode;
        Page page = (Page) dataNode;
        this.mAriverPage = page;
        this.mAriverApp = page.getApp();
    }

    public NXH5WebViewAdapter getWebViewAdapter() {
        return this.webViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setWebViewAdapter(NXH5WebViewAdapter nXH5WebViewAdapter) {
        this.webViewAdapter = nXH5WebViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean invokeEventPoint(String str, JSONObject jSONObject) {
        if (f6446a.contains(str)) {
            return ((EventPoint) ExtensionPoint.as(EventPoint.class).node(getPage()).resolve(new ResultResolver() { // from class: com.alibaba.griver.core.render.BaseGriverRender.1
                @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
                public Object resolve(List list) {
                    Boolean bool = Boolean.FALSE;
                    if (list == null) {
                        return bool;
                    }
                    for (Object obj : list) {
                        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                            return Boolean.TRUE;
                        }
                    }
                    return bool;
                }
            }).create()).sendEvent(str, jSONObject);
        }
        return false;
    }
}
