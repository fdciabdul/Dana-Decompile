package com.alibaba.griver.base.common.permission;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultPermission;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.DomainConfigProxy;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.permission.model.ApiPermissionInfo;
import com.alibaba.ariver.permission.service.LocalAuthPermissionManager;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import id.dana.data.socialshare.ShareAppKey;
import id.dana.sendmoney.summary.SummaryActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class DefaultAuthenticationProxyImpl implements AuthenticationProxy {
    public static final String SCAN_APP_ID = "10000007";

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6299a = {"navigateTo", "navigateBack", "switchTab", "reLaunch", "redirectTo", "getCurrentLocation", "getLocation", "webViewShare"};
    private static final List<String> b;
    private static String c;
    private static List<String> d;
    private final Map<String, Integer> e = new ConcurrentHashMap();
    private final Map<String, Map<String, PermissionModel>> f = new ConcurrentHashMap();
    private final Map<String, Map<String, ApiPermissionInfo>> g = new ConcurrentHashMap();
    private Map<String, ApiPermissionInfo> h = new ConcurrentHashMap();
    private Map<String, PermissionModel> i = new ConcurrentHashMap();
    private LocalAuthPermissionManager j = new LocalAuthPermissionManager();
    private JSONArray k = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("h5_white_jsapiList");
    private JSONArray l;

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        c = "AriverPermission:DefaultAuthenticationProxyImpl";
        ArrayList arrayList2 = new ArrayList();
        d = arrayList2;
        arrayList2.add(ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY);
        d.add("showUCFailDialog");
        d.add("setKeyboardType");
        d.add("monitorH5Performance");
        d.add("getStartupParams");
        d.add("inputBlurEvent");
        d.add("hideCustomKeyBoard");
        d.add("hideCustomInputMethod4NativeInput");
        d.add("updateNativeKeyBoardInput");
        d.add("setInputTextChanged");
        d.add(TinyAppLogUtil.TINY_APP_STANDARD_LOG);
        d.add(RDConstant.TINY_DEBUG_CONSOLE);
        d.add("needShowAuthSettingEntry");
        d.add("getDebugPerformance");
        d.add("pdsReportTracks");
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add(ShareAppKey.SMS);
        arrayList.add(BioDetector.EXT_KEY_GEO);
    }

    public DefaultAuthenticationProxyImpl() {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("h5_tinyapp_url_whitelist");
        this.l = configJSONArray;
        if (configJSONArray == null) {
            this.l = new JSONArray();
        }
        this.l.add("https://render.alipay.com/p/c/");
    }

    private void a(String str) {
        if (this.e.containsKey(str)) {
            Map<String, Integer> map = this.e;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            return;
        }
        this.e.put(str, 1);
    }

    private boolean b(String str) {
        if (this.e.containsKey(str)) {
            int intValue = this.e.get(str).intValue() - 1;
            this.e.put(str, Integer.valueOf(intValue));
            boolean z = intValue == 0;
            if (z) {
                this.e.remove(str);
            }
            return z;
        }
        String str2 = c;
        StringBuilder sb = new StringBuilder();
        sb.append("cannot detach ");
        sb.append(str);
        sb.append(" because it not attached!");
        RVLogger.w(str2, sb.toString());
        return true;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPermissionModel(String str, PermissionModel permissionModel) {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_app_permission_rewrite");
        boolean z = !CollectionUtils.isEmpty(configJSONArray) && (configJSONArray.contains(str) || configJSONArray.contains("all"));
        if (!this.i.containsKey(str) || z) {
            this.i.put(str, permissionModel);
            this.h.put(str, AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
        }
        a(str);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPluginPermissionModel(String str, PluginModel pluginModel, PermissionModel permissionModel) {
        String str2 = c;
        StringBuilder sb = new StringBuilder();
        sb.append("setPluginPermissionModel ");
        sb.append(str);
        sb.append(" plugin: ");
        sb.append(pluginModel.getAppId());
        RVLogger.d(str2, sb.toString());
        synchronized (this.f) {
            Map<String, PermissionModel> map = this.f.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f.put(str, map);
            }
            map.put(pluginModel.getAppId(), permissionModel);
        }
        synchronized (this.g) {
            Map<String, ApiPermissionInfo> map2 = this.g.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.g.put(str, map2);
            }
            map2.put(pluginModel.getAppId(), AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
        }
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public PermissionModel getPermissionModel(String str) {
        return this.i.get(str);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean hasPermissionModel(String str, Page page) {
        if (TextUtils.isEmpty(str)) {
            if (!a(page)) {
                return false;
            }
            str = page.getApp().getAppId();
        }
        return this.i.containsKey(str);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public List<Permission> getPermissions(String str) {
        Set<String> jsapiList;
        PermissionModel permissionModel = this.i.get(str);
        if (permissionModel != null && (jsapiList = permissionModel.getJsapiList()) != null && jsapiList.size() > 0) {
            ArrayList arrayList = new ArrayList(jsapiList.size());
            for (String str2 : jsapiList) {
                arrayList.add(new BridgePermission(str2, str2));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private boolean a(Page page, String str) {
        List<String> stringArray;
        if (page == null || TextUtils.isEmpty(str) || (stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_http_domain_blacklist"))) == null || stringArray.isEmpty()) {
            return false;
        }
        Iterator<String> it = stringArray.iterator();
        while (it.hasNext()) {
            Matcher matcher = Pattern.compile(it.next()).matcher(str);
            if (matcher != null && matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(NativeCallContext nativeCallContext, Page page) {
        if (((WorkerStore) page.getData(WorkerStore.class)) == null || NativeCallContext.FROM_WORKER.equals(nativeCallContext.getSource())) {
            return false;
        }
        String originalURI = page.getEmbedType() == EmbedType.SHARE ? page.getOriginalURI() : page.getPageURI();
        String string = BundleUtils.getString(page.getStartParams(), "onlineHost");
        if (TextUtils.isEmpty(originalURI) || TextUtils.isEmpty(string) || !originalURI.startsWith(string)) {
            String str = c;
            StringBuilder sb = new StringBuilder();
            sb.append("checkJsApiFormRender, pageEmbedType:");
            sb.append(page.getEmbedType());
            sb.append(" url: ");
            if (TextUtils.isEmpty(originalURI)) {
                originalURI = "";
            }
            sb.append(originalURI);
            sb.append(" onlineHost: ");
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            sb.append(string);
            RVLogger.d(str, sb.toString());
            return false;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_renderJsapiBList");
        return configJSONArray == null || !configJSONArray.contains(nativeCallContext.getName());
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean interceptForRender(String str) {
        JSONArray jSONArray;
        String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_jsapiCallFromRenderWhiteList", "");
        if (!TextUtils.isEmpty(configWithProcessCache)) {
            JSONObject parseObject = JSONUtils.parseObject(configWithProcessCache);
            return (!JSONUtils.getBoolean(parseObject, "enable", false) || (jSONArray = JSONUtils.getJSONArray(parseObject, "list", null)) == null || jSONArray.contains(str)) ? false : true;
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, Page page) {
        String str = c;
        StringBuilder sb = new StringBuilder();
        sb.append("checkJSApi ");
        sb.append(nativeCallContext.getName());
        sb.append(" source: ");
        sb.append(nativeCallContext.getSource());
        RVLogger.d(str, sb.toString());
        if (page == null && app == null) {
            RVLogger.d(c, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY_N22101;
        } else if (a(app.getStartParams(), nativeCallContext.getName())) {
            return ApiPermissionCheckResult.DENY_N22102;
        } else {
            String appId = app.getAppId();
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.contains(permission.authority())) {
                return ApiPermissionCheckResult.IGNORE;
            }
            if (!TextUtils.isEmpty(nativeCallContext.getPluginId())) {
                if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_checkAppxDomain", "yes"))) {
                    AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
                    AppModel appModel = (AppModel) app.getData(AppModel.class);
                    if (!(appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) || (appConfigModel != null && SummaryActivity.CHECKED.equalsIgnoreCase(appConfigModel.getUseDynamicPlugins()))) {
                        RVLogger.d(c, "checkForPlugin because use plugins");
                        return a(appId, nativeCallContext.getPluginId(), permission);
                    }
                } else {
                    return a(appId, nativeCallContext.getPluginId(), permission);
                }
            }
            boolean b2 = b(nativeCallContext, page);
            boolean callFromPageNotVhostAndNoWorker = AppPermissionUtils.callFromPageNotVhostAndNoWorker(page);
            if (b2 || (callFromPageNotVhostAndNoWorker && AppPermissionUtils.forceInnerWebViewPushWindowPageCheck())) {
                String str2 = c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(permission.authority());
                sb2.append(" call from webview ?");
                sb2.append(b2);
                sb2.append(", callFromPageNotVhostAndNoWorker?");
                sb2.append(callFromPageNotVhostAndNoWorker);
                RVLogger.d(str2, sb2.toString());
                String appId2 = page.getApp().getAppId();
                String string = BundleUtils.getString(page.getStartParams(), "appId");
                EmbedWebViewJsApiPermissionProxy embedWebViewJsApiPermissionProxy = (EmbedWebViewJsApiPermissionProxy) RVProxy.get(EmbedWebViewJsApiPermissionProxy.class);
                if (embedWebViewJsApiPermissionProxy != null) {
                    if (embedWebViewJsApiPermissionProxy.shouldInterceptJSApiCall(permission.authority(), page, appId2, string, nativeCallContext.getParams())) {
                        String str3 = c;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("embedwebviewjsapi_forbidden:EmbedWebViewJsApi interceptJSApiCall\t");
                        sb3.append(permission.authority());
                        RVLogger.d(str3, sb3.toString());
                        return ApiPermissionCheckResult.DENY_N22201;
                    }
                    String str4 = c;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" EmbedWebViewJsApi ignore\t");
                    sb4.append(permission.authority());
                    RVLogger.d(str4, sb4.toString());
                    return ApiPermissionCheckResult.IGNORE;
                }
                appId = appId2;
            }
            if (page != null && a(nativeCallContext, page)) {
                HashMap hashMap = new HashMap();
                hashMap.put("appId", page.getApp().getAppId());
                hashMap.put("action", nativeCallContext.getName());
                hashMap.put("url", page.getPageURI());
                ((RVMonitor) RVProxy.get(RVMonitor.class)).logNebulaTech("H5_JSAPI_CALL_FROM_RENDER", null, null, null, hashMap);
                if (interceptForRender(nativeCallContext.getName())) {
                    String str5 = c;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setPermission...api from render,safety not has permission ");
                    sb5.append(nativeCallContext.getName());
                    RVLogger.d(str5, sb5.toString());
                    return ApiPermissionCheckResult.DENY_N22209;
                }
                String str6 = c;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("commonCheckIgnorePermission IGNORE by hasJsApiPermissionCallFromRender ");
                sb6.append(nativeCallContext.getName());
                RVLogger.d(str6, sb6.toString());
                return ApiPermissionCheckResult.IGNORE;
            }
            PermissionModel permissionModel = this.i.get(appId);
            if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
                RVLogger.d(c, String.format("%s not have permission file", appId));
                return ApiPermissionCheckResult.IGNORE;
            } else if (d.contains(permission.authority()) || ("sendMtop".equalsIgnoreCase(nativeCallContext.getName()) && page.getInstanceType() == InstanceType.TAOBAO)) {
                return ApiPermissionCheckResult.IGNORE;
            } else {
                Set<String> jsapiList = permissionModel.getJsapiList();
                if (jsapiList != null && jsapiList.size() > 0) {
                    Iterator<String> it = jsapiList.iterator();
                    while (it.hasNext()) {
                        if (it.next().equalsIgnoreCase(permission.authority())) {
                            String str7 = c;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("permison is allowed \t ");
                            sb7.append(permission.authority());
                            RVLogger.d(str7, sb7.toString());
                            return ApiPermissionCheckResult.ALLOW;
                        }
                    }
                }
                String str8 = c;
                StringBuilder sb8 = new StringBuilder();
                sb8.append("jsapi_forbidden:checkJSAPI deny \t");
                sb8.append(permission.authority());
                RVLogger.d(str8, sb8.toString());
                return ApiPermissionCheckResult.DENY_N22104;
            }
        }
    }

    private ApiPermissionCheckResult a(String str, String str2, Permission permission) {
        Map<String, PermissionModel> map = this.f.get(str);
        if (map == null || !map.containsKey(str2)) {
            RVLogger.d(c, String.format("plugin %s not have permission field, just ignore", str2));
            return ApiPermissionCheckResult.IGNORE;
        }
        PermissionModel permissionModel = map.get(str2);
        if (permissionModel == null) {
            String str3 = c;
            StringBuilder sb = new StringBuilder();
            sb.append("permission is enabled by no permission file! ");
            sb.append(permission.authority());
            RVLogger.d(str3, sb.toString());
            return ApiPermissionCheckResult.ALLOW;
        }
        Set<String> jsapiList = permissionModel.getJsapiList();
        if (jsapiList != null && jsapiList.size() > 0) {
            Iterator<String> it = jsapiList.iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(permission.authority())) {
                    String str4 = c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("permission is allowed by plugin \t ");
                    sb2.append(permission.authority());
                    RVLogger.d(str4, sb2.toString());
                    return ApiPermissionCheckResult.ALLOW;
                }
            }
        }
        String str5 = c;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("plugin_forbidden:permission is disabled by plugin \t ");
        sb3.append(permission.authority());
        RVLogger.d(str5, sb3.toString());
        return ApiPermissionCheckResult.DENY_N22103;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkSPJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, Page page) {
        ApiPermissionInfo apiPermissionInfo;
        boolean z;
        ApiPermissionCheckResult hasPermission;
        Uri parseUrl;
        ApiPermissionCheckResult hasPermission2;
        ApiPermissionCheckResult hasPermission3;
        if (app == null) {
            return ApiPermissionCheckResult.DENY_N22207;
        }
        String appId = app.getAppId();
        String authority = permission.authority();
        if (TextUtils.isEmpty(nativeCallContext.getPluginId())) {
            apiPermissionInfo = this.h.get(appId);
            z = false;
        } else {
            apiPermissionInfo = this.g.get(appId) == null ? null : this.g.get(appId).get(nativeCallContext.getPluginId());
            String str = c;
            StringBuilder sb = new StringBuilder();
            sb.append("get ApiPermissionInfo from pluginId");
            sb.append(nativeCallContext.getPluginId());
            RVLogger.debug(str, sb.toString());
            z = true;
        }
        if (apiPermissionInfo == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("JSAPI_SP_Config_");
        sb2.append(authority);
        String obj = sb2.toString();
        List<String> apiLevelList = apiPermissionInfo.getApiLevelList(obj);
        if (TextUtils.equals(authority, PermissionConstant.HTTPREQUET) || TextUtils.equals(authority, PermissionConstant.UPLOAD_FILE) || TextUtils.equals(authority, "request")) {
            String string = JSONUtils.getString(nativeCallContext.getParams(), "url");
            Uri parseUrl2 = UrlUtils.parseUrl(string);
            if (parseUrl2 != null) {
                String host = parseUrl2.getHost();
                if (z) {
                    hasPermission = a(appId, apiPermissionInfo, host, "JSAPI_SP_Config_httpRequest_allowedDomain");
                } else {
                    hasPermission = hasPermission(appId, host, "JSAPI_SP_Config_httpRequest_allowedDomain", page);
                }
                if (hasPermission != ApiPermissionCheckResult.IGNORE) {
                    String str2 = c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("jsapi_sp_forbidden:");
                    sb3.append(authority);
                    sb3.append("\t is not allowed, in _allowedDomain: ");
                    sb3.append(host);
                    RVLogger.d(str2, sb3.toString());
                }
                if (TextUtils.equals(authority, PermissionConstant.HTTPREQUET) || TextUtils.equals(authority, PermissionConstant.UPLOAD_FILE) || TextUtils.equals(authority, "request")) {
                    if (hasPermission == ApiPermissionCheckResult.IGNORE) {
                        if (a(page, host)) {
                            String str3 = c;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("jsapi_sp_forbidden:");
                            sb4.append(authority);
                            sb4.append("\t is not allowed, in domain blacklist: ");
                            sb4.append(host);
                            sb4.append(" is not allowed");
                            RVLogger.d(str3, sb4.toString());
                            return ApiPermissionCheckResult.DENY_N22111;
                        }
                        return hasPermission;
                    }
                    boolean isDevSource = AppInfoScene.isDevSource(app.getStartParams());
                    boolean z2 = BundleUtils.getBoolean(app.getStartParams(), PermissionConstant.STARTPARAMS_IGNORE_HTTP_REQUEST_PERMISSION, false);
                    if (isDevSource && z2) {
                        DomainConfigProxy domainConfigProxy = (DomainConfigProxy) RVProxy.get(DomainConfigProxy.class);
                        String str4 = c;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(authority);
                        sb5.append("\t ignoreHttpReqPermission: ");
                        RVLogger.d(str4, sb5.toString());
                        return (domainConfigProxy == null || domainConfigProxy.isAlipayDomains(string) || domainConfigProxy.isSeriousAliDomains(string) || domainConfigProxy.isAliDomains(string)) ? hasPermission : ApiPermissionCheckResult.IGNORE;
                    }
                    return hasPermission;
                }
            }
        } else if (apiLevelList != null) {
            for (String str5 : apiLevelList) {
                String string2 = JSONUtils.getString(nativeCallContext.getParams(), str5, null);
                if (!TextUtils.isEmpty(string2)) {
                    if (z) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(obj);
                        sb6.append("_");
                        sb6.append(str5);
                        hasPermission3 = a(appId, apiPermissionInfo, string2, sb6.toString());
                    } else {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(obj);
                        sb7.append("_");
                        sb7.append(str5);
                        hasPermission3 = hasPermission(appId, string2, sb7.toString(), page);
                    }
                    if (hasPermission3 != ApiPermissionCheckResult.IGNORE) {
                        String str6 = c;
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("jsapi_sp_forbidden:");
                        sb8.append(authority);
                        sb8.append(" paramKey: ");
                        sb8.append(str5);
                        sb8.append(" content: ");
                        sb8.append(string2);
                        sb8.append(" is not allowed");
                        RVLogger.d(str6, sb8.toString());
                        return hasPermission3;
                    }
                }
            }
            if (TextUtils.equals(authority, "startApp") && (parseUrl = UrlUtils.parseUrl(JSONUtils.getString(JSONUtils.getJSONObject(nativeCallContext.getParams(), "param", null), "url"))) != null) {
                String host2 = parseUrl.getHost();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(obj);
                sb9.append("_url");
                String obj2 = sb9.toString();
                if (z) {
                    if (apiPermissionInfo.getApiLevelList(obj2) == null) {
                        return ApiPermissionCheckResult.IGNORE;
                    }
                    hasPermission2 = a(appId, apiPermissionInfo, host2, obj2);
                } else {
                    hasPermission2 = hasPermission(appId, host2, obj2, page);
                }
                if (hasPermission2 != ApiPermissionCheckResult.IGNORE) {
                    String str7 = c;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("jsapi_sp_forbidden:");
                    sb10.append(authority);
                    sb10.append(" host: ");
                    sb10.append(host2);
                    sb10.append(" is not allowed");
                    RVLogger.d(str7, sb10.toString());
                }
                return hasPermission2;
            }
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    private boolean a(Page page) {
        if (page == null) {
            return false;
        }
        EmbedWebViewJsApiPermissionProxy embedWebViewJsApiPermissionProxy = (EmbedWebViewJsApiPermissionProxy) RVProxy.get(EmbedWebViewJsApiPermissionProxy.class);
        if (embedWebViewJsApiPermissionProxy != null) {
            return embedWebViewJsApiPermissionProxy.callFromWebView(page);
        }
        return page.getEmbedType().isEmbedPage();
    }

    private boolean b(NativeCallContext nativeCallContext, Page page) {
        if (NativeCallContext.FROM_WORKER.equals(nativeCallContext.getSource())) {
            return false;
        }
        return a(page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkEventPermission(String str, String str2, Page page) {
        if (!this.h.containsKey(str)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        return hasPermission(str, str2, PermissionConstant.EVENT_LIST, page);
    }

    private ApiPermissionCheckResult a(String str, ApiPermissionInfo apiPermissionInfo, String str2, String str3) {
        if (TextUtils.equals(str3, PermissionConstant.VALID_SUB_RES_MIME_LIST) || str3.startsWith(PermissionConstant.JS_API_SP_CONFIG) || TextUtils.equals(str3, PermissionConstant.EVENT_LIST) || TextUtils.equals(str3, PermissionConstant.HTTP_LINK_SUB_RES_MIME_LIST) || TextUtils.equals(str3, PermissionConstant.VALID_DOMAIN)) {
            if (b(str2, apiPermissionInfo.getApiLevelList(str3))) {
                return ApiPermissionCheckResult.IGNORE;
            }
            String str4 = c;
            StringBuilder sb = new StringBuilder();
            sb.append("jsapi_sp_forbidden:");
            sb.append(str3);
            sb.append(" not have permssion ,not match regex");
            RVLogger.d(str4, sb.toString());
            if (TextUtils.equals(str3, PermissionConstant.VALID_SUB_RES_MIME_LIST)) {
                return ApiPermissionCheckResult.DENY_N22105;
            }
            if (str3.startsWith(PermissionConstant.JS_API_SP_CONFIG)) {
                return ApiPermissionCheckResult.DENY_N22106;
            }
            if (TextUtils.equals(str3, PermissionConstant.EVENT_LIST)) {
                return ApiPermissionCheckResult.DENY_N22107;
            }
            if (TextUtils.equals(str3, PermissionConstant.HTTP_LINK_SUB_RES_MIME_LIST)) {
                return ApiPermissionCheckResult.DENY_N22108;
            }
            if (TextUtils.equals(str3, PermissionConstant.VALID_DOMAIN)) {
                return ApiPermissionCheckResult.DENY_N22110;
            }
            return ApiPermissionCheckResult.DENY;
        } else if (str3.startsWith(PermissionConstant.WEB_VIEW_CONFIG)) {
            List<String> apiLevelList = apiPermissionInfo.getApiLevelList(str3);
            if (a()) {
                if (a(str2, apiLevelList)) {
                    return ApiPermissionCheckResult.IGNORE;
                }
            } else if (b(str2, apiLevelList)) {
                return ApiPermissionCheckResult.IGNORE;
            }
            return ApiPermissionCheckResult.DENY_N22109;
        } else {
            boolean contains = apiPermissionInfo.getApiLevelList(str3).contains(str2);
            if (!contains) {
                String str5 = c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("jsapi_sp_forbidden:");
                sb2.append(str3);
                sb2.append(" not have permssion");
                RVLogger.d(str5, sb2.toString());
            }
            return contains ? ApiPermissionCheckResult.IGNORE : ApiPermissionCheckResult.DENY_N22104;
        }
    }

    private boolean a() {
        return "yes".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ss_webview_allow_domain_by_wildcard", "no"));
    }

    private boolean a(String str, List<String> list) {
        String c2;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str2 : list) {
            if (str2 != null) {
                try {
                    if (!str2.trim().isEmpty() && (c2 = c(str2.trim())) != null) {
                        if (c2.length() == 0 || TextUtils.equals(c2, str)) {
                            return true;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(".");
                        sb.append(c2);
                        if (str.endsWith(sb.toString())) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    RVLogger.e(c, "hasPermission Regex Exception", e);
                }
            }
        }
        return false;
    }

    private String c(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int length = str.length();
        int i = 0;
        while (i < length && (str.charAt(i) == '.' || str.charAt(i) == '*')) {
            i++;
        }
        return i > 0 ? str.substring(i) : str;
    }

    private boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
            } catch (Exception e) {
                RVLogger.e(c, "hasPermission Regex Exception", e);
            }
            if (PatternUtils.compile(it.next().trim()).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult hasPermission(String str, String str2, String str3, Page page) {
        if (page == null || page.getApp() == null) {
            RVLogger.d(c, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY_N22101;
        }
        return hasPermission(str, str2, str3, page.getApp(), page);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0116 A[Catch: Exception -> 0x0142, TryCatch #0 {Exception -> 0x0142, blocks: (B:12:0x0066, B:14:0x006f, B:17:0x0086, B:20:0x0092, B:22:0x009c, B:24:0x00a2, B:26:0x00aa, B:28:0x00b2, B:30:0x00b5, B:33:0x00c1, B:35:0x00cf, B:37:0x00d5, B:39:0x00df, B:41:0x00e5, B:43:0x00eb, B:45:0x00f1, B:47:0x00f5, B:49:0x00fb, B:52:0x010a, B:55:0x0116, B:57:0x0119), top: B:62:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119 A[Catch: Exception -> 0x0142, TRY_LEAVE, TryCatch #0 {Exception -> 0x0142, blocks: (B:12:0x0066, B:14:0x006f, B:17:0x0086, B:20:0x0092, B:22:0x009c, B:24:0x00a2, B:26:0x00aa, B:28:0x00b2, B:30:0x00b5, B:33:0x00c1, B:35:0x00cf, B:37:0x00d5, B:39:0x00df, B:41:0x00e5, B:43:0x00eb, B:45:0x00f1, B:47:0x00f5, B:49:0x00fb, B:52:0x010a, B:55:0x0116, B:57:0x0119), top: B:62:0x0066 }] */
    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult hasPermission(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.alibaba.ariver.app.api.App r8, com.alibaba.ariver.app.api.Page r9) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl.hasPermission(java.lang.String, java.lang.String, java.lang.String, com.alibaba.ariver.app.api.App, com.alibaba.ariver.app.api.Page):com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult");
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public PermissionModel getPluginPermissionModel(String str, String str2) {
        Map<String, PermissionModel> map = this.f.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    public boolean shouldInterceptWebViewNaviJsApi(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : f6299a) {
            if (str2.equals(str3)) {
                return false;
            }
        }
        List<String> stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_webviewAppIdWhiteList"));
        if (stringArray != null) {
            Iterator<String> it = stringArray.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next(), str)) {
                    String str4 = c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("shouldInterceptWebViewNaviJsApi...appId in white list:");
                    sb.append(str2);
                    RVLogger.d(str4, sb.toString());
                    return false;
                }
            }
        }
        String str5 = c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("shouldInterceptWebViewNaviJsApi...not allowed: ");
        sb2.append(str2);
        RVLogger.d(str5, sb2.toString());
        return true;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void clearPermissionModel(String str, boolean z) {
        if (b(str)) {
            if (this.i.containsKey(str)) {
                this.i.remove(str);
            }
            if (this.h.get(str) != null) {
                this.h.get(str).clear();
                this.h.remove(str);
            }
            if (z) {
                this.f.remove(str);
            }
        }
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, final NativeCallContext nativeCallContext, final BridgeResponseHelper bridgeResponseHelper, final Page page) {
        return checkShowPermissionDialog(permission, nativeCallContext, new AuthenticationProxy.LocalPermissionCallback() { // from class: com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl.1
            @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback
            public void onPositive() {
                page.getApp().getEngineProxy().getBridge().sendToNative(nativeCallContext, bridgeResponseHelper.getInnerBridgeResponse(), false);
            }

            @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback
            public void onNegative(boolean z) {
                if (z) {
                    bridgeResponseHelper.sendUserNotGrantPermission();
                } else {
                    bridgeResponseHelper.sendSilentDenyPermission();
                }
            }

            @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback
            public void onError(int i, String str) {
                bridgeResponseHelper.sendError(i, str);
            }
        }, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, AuthenticationProxy.LocalPermissionCallback localPermissionCallback, Page page) {
        JSONObject extendInfos;
        JSONObject jSONObject;
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (tinyAppInnerProxy != null && page.getApp() != null && tinyAppInnerProxy.isInner(page.getApp()) && !page.getEmbedType().isEmbedPage()) {
            RVLogger.d(c, "checkShowPermissionDialog isInner ");
            AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
            if (appModel == null || (extendInfos = appModel.getExtendInfos()) == null || (jSONObject = JSONUtils.getJSONObject(extendInfos, RVConstants.EXTRA_RES_PARAM_MAP, null)) == null || !PermissionUtil.forceInnerPermissionCheck(jSONObject)) {
                return false;
            }
            RVLogger.d(c, "force check permission paramMap checkShowPermissionDialog");
            return this.j.checkShowPermissionDialog(permission, nativeCallContext, localPermissionCallback, page);
        }
        return this.j.checkShowPermissionDialog(permission, nativeCallContext, localPermissionCallback, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public Map<String, Boolean> getAllPermissions(String str, String str2, AppModel appModel, Page page) {
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        return this.j.getAllPermissions(str2, appModel, page, this.f);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public Map<String, Boolean> getAllPermissions(String str, String str2, AppModel appModel, String str3) {
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        return this.j.getAllPermissions(str2, appModel, this.f, str3);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPermissionState(String str, String str2, String str3, String str4, boolean z) {
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        this.j.changePermissionState(str2, str4, str3, z ? "1" : "0");
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPermissionState(String str, String str2, App app, String str3, String str4, boolean z) {
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        this.j.changePermissionState(str2, str4, str3, z ? "1" : "0");
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void removeAllPermissionInfo(String str, String str2) {
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        this.j.removeAllPermissionInfo(str, str2);
    }

    private ApiPermissionCheckResult a(String str, String str2, String str3, Page page) {
        String str4 = c;
        StringBuilder sb = new StringBuilder();
        sb.append("hasPermissionOnIframe...url=");
        sb.append(str2);
        RVLogger.d(str4, sb.toString());
        return hasPermission(str, str2, str3, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult interceptUrlForTiny(String str, String str2, Page page, boolean z) {
        String str3;
        JSONArray jSONArray;
        Uri parseUrl = UrlUtils.parseUrl(str);
        if (parseUrl != null) {
            String scheme = parseUrl.getScheme();
            if (scheme != null && b.contains(scheme.toLowerCase())) {
                return ApiPermissionCheckResult.IGNORE;
            }
            str3 = parseUrl.getHost();
        } else {
            str3 = "";
        }
        try {
            String purifyUrl = UrlUtils.purifyUrl(str);
            if (!TextUtils.isEmpty(purifyUrl) && (jSONArray = this.l) != null) {
                Iterator<Object> it = jSONArray.iterator();
                while (it.hasNext()) {
                    String obj = it.next().toString();
                    if (!TextUtils.isEmpty(obj) && purifyUrl.startsWith(obj)) {
                        RVLogger.d(c, " url in tiny app url white list, and ignore");
                        return ApiPermissionCheckResult.IGNORE;
                    }
                }
            }
        } catch (Throwable th) {
            String str4 = c;
            StringBuilder sb = new StringBuilder();
            sb.append(" check tiny app white list error: ");
            sb.append(th.getMessage());
            RVLogger.d(str4, sb.toString());
        }
        if (TextUtils.isEmpty(str2)) {
            if (!a(page)) {
                return ApiPermissionCheckResult.IGNORE;
            }
            str2 = page.getApp().getAppId();
        }
        PermissionModel permissionModel = this.i.get(str2);
        ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.IGNORE;
        if (permissionModel != null) {
            if (z) {
                return a(str2, str3, PermissionConstant.VALID_DOMAIN, page);
            }
            return hasPermission(str2, str3, PermissionConstant.VALID_DOMAIN, page);
        }
        return apiPermissionCheckResult;
    }

    private ApiPermissionCheckResult a(String str, Page page) {
        if (page == null || page.getStartParams() == null || TextUtils.isEmpty(str)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        String string = BundleUtils.getString(page.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
        if (!BundleUtils.getBoolean(page.getStartParams(), RVParams.isTinyApp, false) || TextUtils.isEmpty(string)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_webview_alipays_whitelist", "");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            configWithProcessCache = "none";
        }
        if ("all".equalsIgnoreCase(configWithProcessCache) || page == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        try {
            for (String str2 : configWithProcessCache.split(",")) {
                if (string.equalsIgnoreCase(str2)) {
                    String str3 = c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("interceptH5EmbedWebViewWithScheme appid in whiteList ");
                    sb.append(string);
                    RVLogger.d(str3, sb.toString());
                    return ApiPermissionCheckResult.IGNORE;
                }
            }
            String decode = UrlUtils.decode(str);
            if (!TextUtils.isEmpty(decode) && decode.contains("scheme=alipays://platformapi/startapp")) {
                RVLogger.d(c, "start_app_forbidden:url contain alipay schema");
                return ApiPermissionCheckResult.DENY_N22206;
            }
        } catch (Throwable th) {
            RVLogger.e(c, "interceptH5EmbedWebViewWithScheme: ", th);
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult interceptSchemeForTiny(String str, Page page) {
        if (str == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        ApiPermissionCheckResult a2 = a(str, page);
        if (a2 != ApiPermissionCheckResult.IGNORE) {
            return a2;
        }
        if (str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_allow_load_javascript", null)) && str.startsWith("javascript")) {
            return ApiPermissionCheckResult.IGNORE;
        }
        if ("no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_interceptSchemeForTiny", ""))) {
            return ApiPermissionCheckResult.IGNORE;
        }
        if (page == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        if (hasPermissionModel(BundleUtils.getString(page.getStartParams(), "appId"), page)) {
            return hasPermissionOnScheme(str, page);
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    public ApiPermissionCheckResult hasPermissionOnScheme(String str, Page page) {
        Uri parseUrl;
        if (!a(page)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        String appId = page.getApp().getAppId();
        if (TextUtils.isEmpty(str)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        try {
            boolean equals = "1".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_close_webviewSchemaWhiteList", "0"));
            String extractAppIdFromUrl = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).extractAppIdFromUrl(str);
            if (!equals && !TextUtils.isEmpty(extractAppIdFromUrl)) {
                ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.DENY;
                if (this.h != null) {
                    if (hasPermission(appId, "startApp", PermissionConstant.JS_API_LIST, page) != ApiPermissionCheckResult.IGNORE) {
                        RVLogger.d(c, "start_app_forbidden: not have (startApp) ");
                        return ApiPermissionCheckResult.DENY_N22202;
                    }
                    ApiPermissionCheckResult hasPermission = hasPermission(appId, extractAppIdFromUrl, "JSAPI_SP_Config_startApp_appId", page);
                    if (hasPermission != ApiPermissionCheckResult.IGNORE) {
                        String str2 = c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("start_app_forbidden: not have startApp: ");
                        sb.append(extractAppIdFromUrl);
                        RVLogger.d(str2, sb.toString());
                        return ApiPermissionCheckResult.DENY_N22203;
                    }
                    Uri parseUrl2 = UrlUtils.parseUrl(str);
                    if (TextUtils.equals(extractAppIdFromUrl, "10000007") && a(appId, extractAppIdFromUrl, parseUrl2, page)) {
                        return ApiPermissionCheckResult.DENY_N22204;
                    }
                    String queryParameter = parseUrl2 != null ? parseUrl2.getQueryParameter("url") : null;
                    if (TextUtils.isEmpty(queryParameter) || (parseUrl = UrlUtils.parseUrl(queryParameter)) == null) {
                        return hasPermission;
                    }
                    ApiPermissionCheckResult hasPermission2 = hasPermission(appId, parseUrl.getHost(), "JSAPI_SP_Config_startApp_url", page);
                    if (hasPermission2 != ApiPermissionCheckResult.IGNORE) {
                        String str3 = c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("start_app_forbidden: not have startApp: ");
                        sb2.append(queryParameter);
                        RVLogger.d(str3, sb2.toString());
                        return ApiPermissionCheckResult.DENY_N22204;
                    }
                    return hasPermission2;
                }
                return apiPermissionCheckResult;
            }
        } catch (Throwable th) {
            RVLogger.e(c, th);
        }
        if (!str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            RVLogger.d(c, "schema_forbidden: scheme is not http，https，alipay schema");
            RVLogger.d(c, "hasPermissionOnScheme...non-http url, no permission");
            return ApiPermissionCheckResult.DENY_N22205;
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    private boolean a(String str, String str2, Uri uri, Page page) {
        if (TextUtils.equals(str2, "10000007")) {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_scan_outer_jump_intercept", "0");
            if (TextUtils.equals("1", config) || TextUtils.equals("2", config)) {
                String str3 = c;
                StringBuilder sb = new StringBuilder();
                sb.append("open scan app , now start check qrcode params,uri=");
                sb.append(uri);
                RVLogger.d(str3, sb.toString());
                String queryParameter = uri != null ? uri.getQueryParameter("qrcode") : null;
                if (TextUtils.isEmpty(queryParameter) || UrlUtils.parseUrl(queryParameter) == null) {
                    return false;
                }
                if (TextUtils.equals("1", config)) {
                    String str4 = c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" this scan outer jump is illegal , but just record. target uri=");
                    sb2.append(uri);
                    RVLogger.d(str4, sb2.toString());
                    a(str, str2, uri);
                } else if (TextUtils.equals("2", config)) {
                    String str5 = c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("start_app_forbidden: not have startApp: qrcode ");
                    sb3.append(queryParameter);
                    RVLogger.d(str5, sb3.toString());
                    a(str, str2, uri);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void a(String str, String str2, Uri uri) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("targetAppId", str2);
        hashMap.put("uri", uri);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).logNebulaTech("H5_SCAN_OUTER_JUMP_ILLEGAL", null, null, null, hashMap);
    }

    private boolean a(Bundle bundle, String str) {
        if ("tyroRequest".equals(str) || "showRemoteDebugPanel".equals(str) || "showRemoteDebugMask".equals(str)) {
            int i = AnonymousClass2.$SwitchMap$com$alibaba$ariver$resource$api$models$AppInfoScene[AppInfoScene.extractScene(bundle).ordinal()];
            return (i == 1 || i == 2) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.base.common.permission.DefaultAuthenticationProxyImpl$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$resource$api$models$AppInfoScene;

        static {
            int[] iArr = new int[AppInfoScene.values().length];
            $SwitchMap$com$alibaba$ariver$resource$api$models$AppInfoScene = iArr;
            try {
                iArr[AppInfoScene.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$models$AppInfoScene[AppInfoScene.INSPECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public String getPermissionByScope(String str, String str2, String str3) {
        String aggregationMainAppId;
        if (this.j == null) {
            this.j = new LocalAuthPermissionManager();
        }
        String str4 = c;
        StringBuilder sb = new StringBuilder();
        sb.append("getPermissionByScope appId = ");
        sb.append(str);
        sb.append(", url = ");
        sb.append(str2);
        sb.append(", scope = ");
        sb.append(str3);
        RVLogger.d(str4, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("20000067".equals(str)) {
            aggregationMainAppId = AppPermissionUtils.getAggregationMainAppIdForH5Page("20000067", str2);
        } else {
            aggregationMainAppId = AppPermissionUtils.getAggregationMainAppId(((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str)));
        }
        return this.j.getPermissionByScope(str, aggregationMainAppId, str3);
    }
}
