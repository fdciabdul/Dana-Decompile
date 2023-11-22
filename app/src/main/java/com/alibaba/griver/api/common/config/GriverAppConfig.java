package com.alibaba.griver.api.common.config;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.exthub.BuildConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.t2.AndroidT2Config;
import id.dana.danah5.customdialog.CustomDialogKey;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class GriverAppConfig {

    /* renamed from: a */
    private AndroidT2Config f6271a;
    private ConcurrentHashMap<String, WeakReference<Page>> b;
    private final String c;
    private final String d;
    private final String e;
    private int f;
    private int g;
    private GriverAppInfoConfig h;
    private final String i;

    private GriverAppConfig() {
        this.f6271a = null;
        this.c = GriverConfigConstants.KEY_INJECT_JST2;
        this.d = "inject_jst2_time";
        this.e = "isEmbedView";
        this.f = 3;
        this.g = 2500;
        this.i = "{\"h5_inject_jst2\":{\"tiny\":\"YES\",\"h5\":\"YES\",\"whitelist\":[],\"blacklist\":[],\"urls\":[\"https://gw.alipayobjects.com/os/lib/ali/t2/1.2.5/dist/alipay.min.js\"],\"preloadUrls\":[\"https://gw.alipayobjects.com/os/lib/ali/t2/1.2.5/dist/preload.min.js\"]},\"injectBase\":1}";
        a();
        this.b = new ConcurrentHashMap<>();
        this.h = new GriverAppInfoConfig(GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_APP_INFO_UPDATE_CONFIG));
    }

    private void a() {
        a(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_INJECT_JST2, "{\"h5_inject_jst2\":{\"tiny\":\"YES\",\"h5\":\"YES\",\"whitelist\":[],\"blacklist\":[],\"urls\":[\"https://gw.alipayobjects.com/os/lib/ali/t2/1.2.5/dist/alipay.min.js\"],\"preloadUrls\":[\"https://gw.alipayobjects.com/os/lib/ali/t2/1.2.5/dist/preload.min.js\"]},\"injectBase\":1}"));
    }

    public static GriverAppConfig getInstance() {
        return GriverAppConfigInner.sInstance;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if (parseObject == null) {
                parseObject = new JSONObject();
            }
            this.f6271a = new AndroidT2Config(JSONUtils.getJSONObject(parseObject, GriverConfigConstants.KEY_H5_INJECT_JST2, new JSONObject()));
            int i = JSONUtils.getInt(parseObject, GriverConfigConstants.KEY_INJECT_BASE, 3);
            if (i > 0) {
                this.f = i;
            }
            this.f6271a.initConfig();
        } catch (Exception e) {
            GriverLogger.w("GriverAppConfig", "GriverAppConfig#initAndroidT2Config", e);
        }
    }

    public boolean isCollectT2(Page page, String str, boolean z) {
        boolean z2 = false;
        if (page == null) {
            return false;
        }
        App app = page.getApp();
        Bundle sceneParams = app.getSceneParams();
        boolean z3 = page.getSceneParams().getBoolean("isEmbedView", false);
        if (sceneParams.containsKey(GriverConfigConstants.KEY_INJECT_JST2) && sceneParams.containsKey("inject_jst2_time")) {
            long j = sceneParams.getLong("inject_jst2_time");
            if (!z3 || app.getAlivePageCount() != 1 || SystemClock.elapsedRealtime() - j > this.g) {
                return false;
            }
            GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
            if (stageMonitor != null && !AppInfoUtils.isEmbeddedApp((AppModel) app.getData(AppModel.class))) {
                stageMonitor.addParam(GriverMonitorConstants.KEY_DSL_FIRST_PAGE_TYPE, GriverMonitorConstants.KEY_DSL_TYPE_EMBEDDED);
            }
        } else {
            GriverStageMonitor stageMonitor2 = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
            if (stageMonitor2 != null && !AppInfoUtils.isEmbeddedApp((AppModel) app.getData(AppModel.class))) {
                stageMonitor2.addParam(GriverMonitorConstants.KEY_DSL_FIRST_PAGE_TYPE, "Normal");
            }
            sceneParams.putBoolean(GriverConfigConstants.KEY_INJECT_JST2, true);
            sceneParams.putLong("inject_jst2_time", SystemClock.elapsedRealtime());
        }
        AndroidT2Config androidT2Config = this.f6271a;
        if (androidT2Config == null || androidT2Config.isEmpty()) {
            a(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_INJECT_JST2));
        }
        AndroidT2Config androidT2Config2 = this.f6271a;
        if (androidT2Config2 != null && !androidT2Config2.isEmpty()) {
            if (this.f6271a.isCollectT2(str, z) && b()) {
                z2 = true;
            }
            if (z2) {
                ConcurrentHashMap<String, WeakReference<Page>> concurrentHashMap = this.b;
                StringBuilder sb = new StringBuilder();
                sb.append(app.getAppId());
                sb.append(app.getStartToken());
                concurrentHashMap.put(sb.toString(), new WeakReference<>(page));
            }
        }
        return z2;
    }

    public boolean isKeepAliveT2() {
        AndroidT2Config androidT2Config = this.f6271a;
        if (androidT2Config == null || androidT2Config.isEmpty()) {
            a(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_INJECT_JST2));
        }
        AndroidT2Config androidT2Config2 = this.f6271a;
        if (androidT2Config2 == null || androidT2Config2.isEmpty()) {
            return false;
        }
        return b();
    }

    private boolean b() {
        double random = Math.random();
        int i = this.f;
        double d = i;
        Double.isNaN(d);
        return ((int) ((random * d) + 1.0d)) == i;
    }

    public String getAndroidT2ConfigParams(App app) {
        GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enableBase", (Object) 1);
        jSONObject.put("samplingBase", (Object) 1);
        jSONObject.put("frameDetail", (Object) Boolean.valueOf(griverAllRecordsExtension.canUseRecords(app)));
        jSONObject.put(BuildConfig.BUILD_TYPE, (Object) Boolean.valueOf(GriverEnv.isDebuggable()));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomDialogKey.Event.COMMON, (Object) jSONObject);
        return jSONObject2.toJSONString();
    }

    public JSONArray getT2Urls() {
        AndroidT2Config androidT2Config = this.f6271a;
        if (androidT2Config == null) {
            return new JSONArray();
        }
        return androidT2Config.getT2Urls();
    }

    public JSONArray getT2PreloadUrls() {
        AndroidT2Config androidT2Config = this.f6271a;
        if (androidT2Config == null) {
            return new JSONArray();
        }
        return androidT2Config.getT2PreloadUrls();
    }

    public Page removeT2Page(App app) {
        if (app == null) {
            return null;
        }
        ConcurrentHashMap<String, WeakReference<Page>> concurrentHashMap = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        WeakReference<Page> remove = concurrentHashMap.remove(sb.toString());
        if (remove != null) {
            return remove.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class GriverAppConfigInner {
        public static GriverAppConfig sInstance = new GriverAppConfig();

        private GriverAppConfigInner() {
        }
    }

    public boolean ifSyncUpdate(String str, String str2) {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_APP_INFO_UPDATE_CONFIG_OVERRIDING);
        if (configJSONObject != null) {
            try {
                if (configJSONObject.size() != 0 && configJSONObject.containsKey(str)) {
                    String string = JSONUtils.getString(configJSONObject, str, "");
                    if (TextUtils.isEmpty(string)) {
                        return false;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    return RVResourceUtils.compareVersion(str2, string) < 0;
                }
                return false;
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse app info update config failed, config: ");
                sb.append(configJSONObject);
                GriverLogger.e("GriverAppConfig", sb.toString());
            }
        }
        return false;
    }

    public long getSyncUpdatePeriod() {
        return this.h.getPreReqRate();
    }

    public long getAsyncUpdatePeriod() {
        return this.h.getUpdateReqRate();
    }

    public long getAppAsyncUpdateDelay() {
        return this.h.getAppAsyncUpdateDelay();
    }

    public long getExpireTime() {
        return this.h.getExpireTime();
    }
}
