package com.alibaba.griver.core.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class PrefetchManager {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<PrefetchInner, PrefetchInfo> f6437a;

    private PrefetchManager() {
        this.f6437a = new ConcurrentHashMap<>();
    }

    public static PrefetchManager getInstance() {
        return PrefetchManagerHolder.f6438a;
    }

    /* loaded from: classes6.dex */
    static class PrefetchManagerHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PrefetchManager f6438a = new PrefetchManager();

        private PrefetchManagerHolder() {
        }
    }

    public void prefetchData(String str, String str2, String str3) {
        AppInfoModel appInfoModel;
        String str4;
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.APP_PREFETCH_CONFIG);
        if (configJSONObject == null) {
            GriverLogger.e("PrefetchManager", "no prefetch config");
            return;
        }
        JSONArray jSONArray = JSONUtils.getJSONArray(configJSONObject, "list", null);
        if (jSONArray == null) {
            GriverLogger.e("PrefetchManager", "no prefetch data in config");
            return;
        }
        AppModel queryAppInfo = GriverAppCenter.queryAppInfo(str, str3);
        if (queryAppInfo == null || (appInfoModel = queryAppInfo.getAppInfoModel()) == null) {
            return;
        }
        String mainUrl = appInfoModel.getMainUrl();
        if (str2 == null || mainUrl.endsWith(str2)) {
            str2 = mainUrl.split("#")[1];
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (str.equals(jSONObject.getString("appId"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("dependencies");
                    String string = jSONObject.getString("path");
                    String requestType = getRequestType(jSONObject2);
                    if (a(string, str2)) {
                        PrefetchInner prefetchInner = new PrefetchInner(str, str2, requestType);
                        if (!(this.f6437a.containsKey(prefetchInner) && this.f6437a.get(prefetchInner).getDownloadStatus() == PrefetchDownloadStatus.PREFETCH_DOWNLOADING) && a(jSONObject)) {
                            PrefetchInfo prefetchInfo = new PrefetchInfo(jSONObject2, jSONArray2);
                            try {
                                str4 = Uri.parse(str2).getQuery();
                            } catch (Exception unused) {
                                str4 = null;
                            }
                            PrefetchUtils.setPathParams(str4);
                            prefetchInfo.initMonitor(str);
                            this.f6437a.put(prefetchInner, prefetchInfo);
                            prefetchInfo.getBackPrefetch(str);
                            return;
                        }
                        return;
                    }
                } else {
                    continue;
                }
            } catch (Exception unused2) {
                GriverLogger.e("PrefetchManager", "parse prefetch data failed");
            }
        }
    }

    public String getRequestType(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("config");
        return jSONObject2 == null ? "" : jSONObject2.getString("fetchType");
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str).matcher(str2).matches();
    }

    public PrefetchInfo getPrefetchInfo(PrefetchInner prefetchInner) {
        return this.f6437a.get(prefetchInner);
    }

    public String getPath(String str, String str2) {
        for (PrefetchInner prefetchInner : this.f6437a.keySet()) {
            if (prefetchInner.getAppId().equals(str)) {
                String path = prefetchInner.getPath();
                if (!TextUtils.isEmpty(path) && (path.endsWith(str2) || str2.endsWith(path))) {
                    return path;
                }
            }
        }
        return str2;
    }

    public void removePrefetchInfo(String str) {
        for (PrefetchInner prefetchInner : this.f6437a.keySet()) {
            if (str.equals(prefetchInner.getAppId())) {
                this.f6437a.remove(prefetchInner);
            }
        }
        PrefetchUtils.clearJSAPICache();
    }

    public void removePrefetchInfo(String str, String str2, String str3) {
        this.f6437a.remove(new PrefetchInner(str, str2, str3));
    }

    private boolean a(JSONObject jSONObject) {
        if ("F&B.home.homepageAggregation.v1".equals(jSONObject.getString("uniqueId"))) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", (Object) OAuthService.SCOPE_USER_INFO);
            JSONObject infoFromJSApi = PrefetchUtils.getInfoFromJSApi(jSONObject2, JSApiCachePoint.GET_LOCAL_STORAGE);
            return (infoFromJSApi == null || infoFromJSApi.isEmpty()) ? false : true;
        }
        return true;
    }
}
