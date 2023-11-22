package com.alibaba.griver.core.render;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.nebula.H5DevConfig;
import com.alibaba.griver.base.nebula.H5PatternHelper;
import com.alibaba.griver.base.t2.T2PageInfo;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.preload.PreloadInitializer;
import com.alibaba.griver.core.utils.GriverWebRenderUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class H5ScriptLoader {
    public static final String TAG = "H5ScriptLoader";

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6450a = null;
    private static JSONArray b = null;
    private static Boolean c = null;
    private static JSONArray d = null;
    public static final String startupParams = "startupParams";
    public boolean bizLoaded;
    public boolean bridgeLoaded;
    private Object e;
    private boolean f;
    private HashMap<String, String> g;
    private H5WebView h;
    private String i;
    private String j;
    private String k;
    private Bundle l;
    private Page m;
    private boolean n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6451o;

    private void c() {
    }

    public H5ScriptLoader() {
    }

    public H5ScriptLoader(Page page, H5WebView h5WebView) {
        this.m = page;
        this.h = h5WebView;
        this.bizLoaded = false;
        this.bridgeLoaded = false;
        Bundle startParams = page.getStartParams();
        this.l = startParams;
        this.j = BundleUtils.getString(startParams, GriverParam.PUBLIC_ID);
        this.i = BundleUtils.getString(this.l, "appId");
        this.n = BundleUtils.getBoolean(this.l, RVParams.isTinyApp, false);
        this.e = new Object();
        this.f = false;
        this.g = new HashMap<>();
        a();
        JSONObject jSONObject = BundleUtils.toJSONObject(this.l);
        if (GriverParam.SCAN_APP.equals(JSONUtils.getString(jSONObject, "bizScenario"))) {
            a(true);
        }
        if (PreloadInitializer.canPrerender(page.getApp())) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("snapshot", (Object) Boolean.TRUE);
            jSONObject.put("progressiveRendering", (Object) jSONObject2);
        }
        setParamsToWebPage(startupParams, jSONObject.toJSONString());
        if (f6450a == null) {
            JSONObject parseObject = JSONUtils.parseObject(GriverConfig.getConfigWithProcessCache("h5_nativeInput4Android", ""));
            if (parseObject != null) {
                JSONObject jSONObject3 = JSONUtils.getJSONObject(parseObject, "textArea", null);
                f6450a = Boolean.valueOf("yes".equalsIgnoreCase(JSONUtils.getString(jSONObject3, GriverConfigConstants.KEY_PRESET_APP_CONFIG_DISABLE)));
                b = JSONUtils.getJSONArray(jSONObject3, "appId", null);
            }
            c = Boolean.valueOf("yes".equalsIgnoreCase(GriverConfig.getConfigWithProcessCache("h5_EnableInpageInput", "")));
            d = JSONUtils.parseArray(GriverConfig.getConfigWithProcessCache("h5_inPageInputBlackList", ""));
        }
    }

    private void a(boolean z) {
        this.f = z;
    }

    public void resetBridge() {
        StringBuilder sb = new StringBuilder();
        sb.append("resetBridge ");
        sb.append(System.currentTimeMillis());
        RVLogger.d(TAG, sb.toString());
        this.bizLoaded = false;
        this.bridgeLoaded = false;
    }

    public boolean loadScript() {
        StringBuilder sb = new StringBuilder();
        sb.append("loadScript");
        sb.append(System.currentTimeMillis());
        GriverLogger.d("PRELOAD", sb.toString());
        H5WebView h5WebView = this.h;
        if (h5WebView == null) {
            RVLogger.e(TAG, "invalid web view parameter!");
            return false;
        }
        this.k = h5WebView.getUrl();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.e) {
            b(this.h);
            if (this.bridgeLoaded && this.bizLoaded) {
                return true;
            }
            if (!BundleUtils.getBoolean(this.l, GriverParam.LONG_ISPRERENDER, false) && this.m != null) {
                RVLogger.d(TAG, "injectPageReady when normal window present");
                injectPageReady();
            }
            if (!this.bridgeLoaded) {
                a(this.h);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load javascript elapse [");
            sb2.append(currentTimeMillis2 - currentTimeMillis);
            sb2.append("] for ");
            sb2.append(this.k);
            RVLogger.d(TAG, sb2.toString());
            return true;
        }
    }

    public void injectPageReady() {
        H5WebView h5WebView = this.h;
        if (h5WebView != null) {
            h5WebView.loadUrl("javascript:(function(){window.ALIPAYVIEWAPPEARED=1})();");
        }
        Page page = this.m;
        if (page == null || page.getRender() == null) {
            return;
        }
        EngineUtils.sendToRender(this.m.getRender(), "appearAfterPreRender", null, null);
    }

    public void setParamsToWebPage(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            RVLogger.e(TAG, "invalid js parameters!");
            return;
        }
        synchronized (this.e) {
            this.g.put(str, str2);
            if (!this.bridgeLoaded) {
                RVLogger.d(TAG, "bridge not loaded.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setParamsToWebPage [key] ");
            sb.append(str);
            sb.append(" [value] ");
            sb.append(str2);
            RVLogger.d(TAG, sb.toString());
            H5WebView h5WebView = this.h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("javascript:if(typeof AlipayJSBridge === 'object'){AlipayJSBridge.");
            sb2.append(str);
            sb2.append("=");
            sb2.append(str2);
            sb2.append("}");
            h5WebView.loadUrl(sb2.toString());
        }
    }

    private void a() {
        GriverAppConfig griverAppConfig = GriverAppConfig.getInstance();
        Page page = this.m;
        boolean isCollectT2 = griverAppConfig.isCollectT2(page, this.i, page.getApp().isTinyApp());
        this.f6451o = isCollectT2;
        if (isCollectT2) {
            T2PageInfo t2PageInfo = new T2PageInfo(true, false);
            JSONArray t2PreloadUrls = GriverAppConfig.getInstance().getT2PreloadUrls();
            if (!CollectionUtils.isEmpty(t2PreloadUrls)) {
                for (int i = 0; i < t2PreloadUrls.size(); i++) {
                    String string = t2PreloadUrls.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        t2PageInfo.getPreInjectUrls().add(string);
                    }
                }
            }
            JSONArray t2Urls = GriverAppConfig.getInstance().getT2Urls();
            if (!CollectionUtils.isEmpty(t2Urls)) {
                for (int i2 = 0; i2 < t2Urls.size(); i2++) {
                    String string2 = t2Urls.getString(i2);
                    if (!TextUtils.isEmpty(string2)) {
                        t2PageInfo.getInjectUrls().add(string2);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("androidT2: page = ");
            sb.append(this.m);
            sb.append(" setT2PageInfo = ");
            sb.append(t2PageInfo);
            RVLogger.d(TAG, sb.toString());
            this.m.setData(T2PageInfo.class, t2PageInfo);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("androidT2: mTaPageT2Switch = ");
        sb2.append(this.f6451o);
        sb2.append(",androidT2AppId");
        sb2.append(this.i);
        RVLogger.d(TAG, sb2.toString());
    }

    private void a(H5WebView h5WebView) {
        long currentTimeMillis = System.currentTimeMillis();
        String composeBridge = composeBridge(h5WebView);
        StringBuilder sb = new StringBuilder();
        sb.append("bridgeStr ");
        sb.append(composeBridge);
        RVLogger.d(TAG, sb.toString());
        if (this.f6451o) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(composeBridge);
            sb2.append("\n");
            sb2.append(b());
            composeBridge = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(RDConstant.JAVASCRIPT_SCHEME);
        sb3.append(composeBridge);
        h5WebView.loadUrl(sb3.toString());
        GriverLogger.d("GriverBridgeInjectExtension", "loadScript start");
        RVLogger.d(TAG, "bridge data loaded!");
        c();
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("load bridge delta time ");
        sb4.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(TAG, sb4.toString());
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        JSONArray t2PreloadUrls = GriverAppConfig.getInstance().getT2PreloadUrls();
        if (this.f6451o && !CollectionUtils.isEmpty(t2PreloadUrls)) {
            for (int i = 0; i < t2PreloadUrls.size(); i++) {
                String string = t2PreloadUrls.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    sb.append(com.alibaba.griver.base.t2.JSScriptBuildHelper.buildJSStringOfHeader(string));
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("androidT2: load T2 JsScript,androidT2AppId");
            sb2.append(this.i);
            RVLogger.d(TAG, sb2.toString());
        }
        JSONArray t2Urls = GriverAppConfig.getInstance().getT2Urls();
        if (this.f6451o && !CollectionUtils.isEmpty(t2Urls)) {
            for (int i2 = 0; i2 < t2Urls.size(); i2++) {
                String string2 = t2Urls.getString(i2);
                if (!TextUtils.isEmpty(string2)) {
                    sb.append(com.alibaba.griver.base.t2.JSScriptBuildHelper.buildJSStringEndOfBody(string2, false));
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("androidT2: load T2 JsScript,androidT2AppId");
            sb3.append(this.i);
            RVLogger.d(TAG, sb3.toString());
        }
        return sb.toString();
    }

    public String composeBridge(H5WebView h5WebView) {
        if (this.bridgeLoaded) {
            RVLogger.d(TAG, "bridge already loaded!");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("composeBridge ");
        sb.append(System.currentTimeMillis());
        RVLogger.d(TAG, sb.toString());
        this.bridgeLoaded = true;
        HashMap<String, String> hashMap = this.g;
        Page page = this.m;
        return GriverWebRenderUtils.loadJsBridge(hashMap, page, page.getRender().getRenderId());
    }

    private void b(final H5WebView h5WebView) {
        final String configWithProcessCache = GriverConfig.getConfigWithProcessCache(this.n ? "h5_dsRulesForTinyApp" : "h5_dsRules", "");
        if (BundleUtils.getBoolean(this.m.getStartParams(), RVParams.isTinyApp, false)) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.H5ScriptLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    H5ScriptLoader.this.loadDynamicJs(h5WebView, configWithProcessCache);
                }
            }, 1000L);
        } else {
            loadDynamicJs(h5WebView, configWithProcessCache);
        }
    }

    public void loadDynamicJs(H5WebView h5WebView, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = a(h5WebView, str).toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        b(h5WebView, a(obj));
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("load dynamic delta time ");
        sb.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(TAG, sb.toString());
    }

    public void loadDynamicJs4Jsapi(H5WebView h5WebView, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(H5DevConfig.H5_LOAD_JS)) {
            str = H5DevConfig.H5_LOAD_JS;
        }
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(TAG, "load loadDynamicJs4Jsapi none return");
            return;
        }
        StringBuilder a2 = a(h5WebView, str);
        StringBuilder sb = new StringBuilder();
        sb.append("(function(){function onDOMReady(callback){var readyRE=/complete|loaded|interactive/;if(readyRE.test(document.readyState)){setTimeout(function(){callback()},1);}else{document.defaultView.addEventListener(\"DOMContentLoaded\",function(){callback()},false);}}onDOMReady(function(){");
        sb.append((Object) a2);
        sb.append("console.log(\"load insertJS success\")});})();");
        b(h5WebView, sb.toString());
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("load dynamic4jsapi delta time ");
        sb2.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d(TAG, sb2.toString());
    }

    private StringBuilder a(H5WebView h5WebView, String str) {
        StringBuilder sb = new StringBuilder();
        if (h5WebView == null || TextUtils.isEmpty(str)) {
            RVLogger.d(TAG, "no config found for dynamic script");
            return sb;
        }
        JSONArray parseArray = JSONUtils.parseArray(str);
        if (parseArray == null || parseArray.isEmpty()) {
            RVLogger.w(TAG, "invalid dynamic script.");
            return sb;
        }
        for (int i = 0; i < parseArray.size(); i++) {
            List<String> list = null;
            try {
                list = a(parseArray.getJSONObject(i));
            } catch (Throwable th) {
                RVLogger.e(TAG, "parse dynamic script exception.", th);
            }
            if (list != null && !list.isEmpty()) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(b(str2));
                    }
                }
            }
        }
        return sb;
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("(function(){if(window.HASINJECTDRNAMICSCRIPT){console.log(\"has load h5_dsRulesV2: \"+window.HASINJECTDRNAMICSCRIPT);return}window.HASINJECTDRNAMICSCRIPT=false;function onDOMReady(callback){var readyRE=/complete|loaded|interactive/;if(readyRE.test(document.readyState)){setTimeout(function(){callback()},1)}else{document.defaultView.addEventListener(\"DOMContentLoaded\",function(){callback()},false)}}onDOMReady(function(){if(!window.HASINJECTDRNAMICSCRIPT){");
        sb.append(str);
        sb.append("console.log(\"load h5_dsRulesV2 success\");window.HASINJECTDRNAMICSCRIPT=true}})})();");
        return sb.toString();
    }

    private String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("load dynamicV2 script ");
        sb.append(str);
        RVLogger.d(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("var script,head=document.head||document.documentElement;script=document.createElement(\"script\");script.async=true;script.charset=\"UTF-8\";script.src=\"");
        sb2.append(str);
        sb2.append("\";");
        sb2.append(c(str));
        sb2.append("head.insertBefore(script,head.firstChild);");
        return sb2.toString();
    }

    private String c(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("nebula-addcors")) ? "" : "script.setAttribute('crossorigin','');";
    }

    private List<String> a(JSONObject jSONObject) {
        if (this.h == null || jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : jSONObject.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                if (jSONArray == null || jSONArray.isEmpty()) {
                    arrayList.add(str);
                } else {
                    int i = 0;
                    while (true) {
                        if (i < jSONArray.size()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string = JSONUtils.getString(jSONObject2, "appId");
                            String string2 = JSONUtils.getString(jSONObject2, GriverParam.PUBLIC_ID);
                            String string3 = JSONUtils.getString(jSONObject2, "url");
                            if ((TextUtils.isEmpty(string) || a(this.i, string)) && (TextUtils.isEmpty(string2) || a(this.j, string2)) && (TextUtils.isEmpty(string3) || a(this.k, string3))) {
                                arrayList.add(str);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean a(String str, String str2) {
        Pattern compile = H5PatternHelper.compile(str2);
        if (compile == null) {
            return false;
        }
        return compile.matcher(str).find();
    }

    private void b(H5WebView h5WebView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.JAVASCRIPT_SCHEME);
        sb.append(str);
        h5WebView.loadUrl(sb.toString());
    }
}
