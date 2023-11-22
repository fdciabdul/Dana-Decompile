package com.alibaba.griver.core.preload.impl.render;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.webview.AndroidWebView;
import id.dana.data.here.HereOauthManager;

/* loaded from: classes6.dex */
public class RenderPreloadNgResources {

    /* renamed from: a */
    private AndroidWebView f6442a;
    private long b;
    private String c;

    public RenderPreloadNgResources(AndroidWebView androidWebView, long j) {
        this.f6442a = androidWebView;
        this.b = j;
    }

    public AndroidWebView getWebView() {
        return this.f6442a;
    }

    public long getNodeId() {
        return this.b;
    }

    private String a(App app) {
        String obj;
        try {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel == null || appModel.getAppInfoModel() == null) {
                return null;
            }
            String vhost = appModel.getAppInfoModel().getVhost();
            ResourceLoadContext.Builder newBuilder = ResourceLoadContext.newBuilder();
            StringBuilder sb = new StringBuilder();
            sb.append(vhost);
            sb.append("/index.js");
            ResourceLoadContext.Builder uri = newBuilder.uri(UrlUtils.parseUrl(sb.toString()));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(vhost);
            sb2.append("/index.js");
            String str = new String(((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(app).create()).load(uri.originUrl(sb2.toString()).forceAppxNg(true).build()).getBytes(), HereOauthManager.ENC);
            String readAsset = IOUtils.readAsset(GriverEnv.getResources(), "appx_inline_bootstrap_min.js");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(";\n");
            sb3.append(readAsset);
            sb3.append(";");
            if (TextUtils.isEmpty(vhost)) {
                obj = "";
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\n//# sourceURL=");
                sb4.append(vhost);
                sb4.append("/index.js");
                obj = sb4.toString();
            }
            sb3.append(obj);
            return JSONObject.toJSONString(sb3.toString());
        } catch (Exception e) {
            RVLogger.w("RenderPreloadNgResource", "prerenderng loadIndexJs failed", e);
            return null;
        }
    }

    public String getIndexJs(App app) {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        String a2 = a(app);
        this.c = a2;
        return a2;
    }
}
