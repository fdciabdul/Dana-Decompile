package com.alibaba.ariver.permission;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PermissionUtil;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.model.ApiPermissionInfo;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class AppPermissionUtils {
    public static final String ALIPAY_WEB_COMMON_APPID = "20000067";
    public static final String TAG = "AriverPermission:AppPermissionUtils";

    public static boolean isAppPermission(Accessor accessor) {
        String permissionAppId = getPermissionAppId(accessor);
        if (permissionAppId != null) {
            return ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getPermissionModel(permissionAppId) != null || isNoPermissionConfigAndAllow(accessor, permissionAppId);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isAppPermission getAppId return null!!! accessor: ");
        sb.append(accessor);
        RVLogger.d(TAG, sb.toString());
        return false;
    }

    public static boolean isNoPermissionConfigAndAllow(Accessor accessor, String str) {
        if (!PermissionUtil.forceDomainCheck(str) && (accessor instanceof Page)) {
            boolean z = BundleUtils.getBoolean(((Page) accessor).getStartParams(), RVParams.isTinyApp, false);
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (z && rVConfigService != null && !"no".equals(rVConfigService.getConfig("h5_enableTinyIgnorePermission", "yes"))) {
                return true;
            }
        }
        return false;
    }

    public static String getPermissionAppId(Accessor accessor) {
        App app = getApp(accessor);
        if (app != null) {
            return app.getAppId();
        }
        return null;
    }

    public static PermissionModel getPermissionModel(App app) {
        AppModel appModel = (AppModel) BundleUtils.getParcelable(app.getSceneParams(), "appInfo");
        if (appModel != null) {
            return appModel.getPermissionModel();
        }
        return null;
    }

    public static PermissionModel parsePermissionJson(byte[] bArr) {
        return PermissionModel.generateFromJSON(bArr);
    }

    public static PermissionModel parsePermissionModel(App app) {
        AppInfoQuery appInfoQuery = new AppInfoQuery(app.getAppId());
        if (AppInfoScene.isDevSource(app.getStartParams())) {
            appInfoQuery.scene(AppInfoScene.extractScene(app.getStartParams()));
            appInfoQuery.version(AppInfoScene.extractSceneVersion(app.getStartParams()));
        }
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(appInfoQuery);
        if (appModel != null) {
            return appModel.getPermissionModel();
        }
        return null;
    }

    public static PermissionModel getPermissionModel(Accessor accessor) {
        App app;
        if (accessor instanceof Node) {
            Node node = (Node) accessor;
            for (int i = 5; node != null && i > 0; i--) {
                if (node instanceof App) {
                    app = (App) node;
                    break;
                }
                node = node.getParentNode();
            }
            app = null;
            if (app == null) {
                return null;
            }
            return getPermissionModel(app);
        }
        return null;
    }

    public static App getApp(Accessor accessor) {
        if (accessor instanceof Node) {
            Node node = (Node) accessor;
            for (int i = 5; node != null && i > 0; i--) {
                if (node instanceof App) {
                    return (App) node;
                }
                node = node.getParentNode();
            }
            return null;
        }
        return null;
    }

    public static ApiPermissionInfo convert2ApiPermissionInfo(PermissionModel permissionModel) {
        JSONArray jSONArray;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("convert2ApiPermissionInfo ");
            sb.append(permissionModel);
            RVLogger.debug(TAG, sb.toString());
            if (permissionModel != null) {
                ApiPermissionInfo apiPermissionInfo = new ApiPermissionInfo();
                apiPermissionInfo.setApiLevelStr(PermissionConstant.ENABLE_PROXY, permissionModel.getEnableProxy());
                Set<String> jsapiList = permissionModel.getJsapiList();
                if (jsapiList != null && !jsapiList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : jsapiList) {
                        if (str instanceof String) {
                            arrayList.add(str);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(PermissionConstant.JS_API_LIST, arrayList);
                }
                Set<String> eventList = permissionModel.getEventList();
                if (eventList != null && !eventList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (String str2 : eventList) {
                        if (str2 instanceof String) {
                            arrayList2.add(str2);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(PermissionConstant.EVENT_LIST, arrayList2);
                }
                Set<String> validDomains = permissionModel.getValidDomains();
                if (validDomains != null && !validDomains.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList();
                    for (String str3 : validDomains) {
                        if (str3 instanceof String) {
                            arrayList3.add(str3);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(PermissionConstant.VALID_DOMAIN, arrayList3);
                }
                JSONObject specialConfigs = permissionModel.getSpecialConfigs();
                if (specialConfigs != null && !specialConfigs.isEmpty()) {
                    for (String str4 : specialConfigs.keySet()) {
                        JSONObject jSONObject = JSONUtils.getJSONObject(specialConfigs, str4, null);
                        if (jSONObject != null) {
                            ArrayList arrayList4 = new ArrayList();
                            for (String str5 : jSONObject.keySet()) {
                                arrayList4.add(str5);
                                JSONArray jSONArray2 = JSONUtils.getJSONArray(jSONObject, str5, null);
                                if (jSONArray2 != null && !jSONArray2.isEmpty()) {
                                    ArrayList arrayList5 = new ArrayList();
                                    Iterator<Object> it = jSONArray2.iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        if (next instanceof String) {
                                            arrayList5.add((String) next);
                                        }
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("JSAPI_SP_Config_");
                                    sb2.append(str4);
                                    sb2.append("_");
                                    sb2.append(str5);
                                    apiPermissionInfo.setApiLevelList(sb2.toString(), arrayList5);
                                }
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("JSAPI_SP_Config_");
                            sb3.append(str4);
                            apiPermissionInfo.setApiLevelList(sb3.toString(), arrayList4);
                        }
                    }
                }
                Set<String> validSubResMimeList = permissionModel.getValidSubResMimeList();
                if (validSubResMimeList != null && !validSubResMimeList.isEmpty()) {
                    ArrayList arrayList6 = new ArrayList();
                    for (String str6 : validSubResMimeList) {
                        if (str6 instanceof String) {
                            arrayList6.add(str6);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(PermissionConstant.VALID_SUB_RES_MIME_LIST, arrayList6);
                }
                Set<String> httpLinkSubResMimeList = permissionModel.getHttpLinkSubResMimeList();
                if (httpLinkSubResMimeList != null && !httpLinkSubResMimeList.isEmpty()) {
                    ArrayList arrayList7 = new ArrayList();
                    for (String str7 : httpLinkSubResMimeList) {
                        if (str7 instanceof String) {
                            arrayList7.add(str7);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(PermissionConstant.HTTP_LINK_SUB_RES_MIME_LIST, arrayList7);
                }
                JSONObject webviewConfigs = permissionModel.getWebviewConfigs();
                if (!webviewConfigs.isEmpty() && (jSONArray = webviewConfigs.getJSONArray(PermissionConstant.ALLOWED_DOMAIN)) != null) {
                    ArrayList arrayList8 = new ArrayList();
                    Iterator<Object> it2 = jSONArray.iterator();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        if (next2 instanceof String) {
                            arrayList8.add((String) next2);
                        }
                    }
                    apiPermissionInfo.setApiLevelList("Webview_Config_allowedDomain", arrayList8);
                }
                apiPermissionInfo.setApiLevelStr(PermissionConstant.FORCE_USE_SSL, permissionModel.getForceUseSsl());
                apiPermissionInfo.setHasPermissionFile(true);
                return apiPermissionInfo;
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
        return null;
    }

    public static List<Permission> parseJsApiPermission(PermissionModel permissionModel) {
        Set<String> jsapiList = permissionModel.getJsapiList();
        if (jsapiList == null || jsapiList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : jsapiList) {
            arrayList.add(new BridgePermission(str, str));
        }
        return arrayList;
    }

    public static String getAggregationMainAppId(AppModel appModel) {
        JSONObject jSONObject;
        if (appModel == null || appModel.getExtendInfos() == null || (jSONObject = JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_LAUNCH_PARAMS, null)) == null) {
            return null;
        }
        return JSONUtils.getString(jSONObject, "aggregationMainAppId");
    }

    public static String getAggregationMainAppIdForH5Page(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(UrlUtils.getHost(str2));
        return sb.toString();
    }

    public static boolean forceInnerWebViewPushWindowPageCheck() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_forceInnerWebviewPushWindowPageCheck", "yes"));
    }

    public static boolean callFromPageNotVhostAndNoWorker(Page page) {
        if (page == null) {
            RVLogger.d(TAG, "callFromPageNotVhostAndNoWorker  page==null");
            return false;
        } else if (page.getApp() == null) {
            RVLogger.d(TAG, "callFromPageNotVhostAndNoWorker  app==null");
            return false;
        } else {
            if (page.getApp().isTinyApp()) {
                String string = BundleUtils.getString(page.getApp().getStartParams(), "onlineHost");
                if (TextUtils.isEmpty(string)) {
                    RVLogger.d(TAG, "callFromPageNotVhostAndNoWorker  vhost is empty");
                    return false;
                }
                String pageURI = page.getPageURI();
                if (pageURI == null) {
                    RVLogger.d(TAG, "callFromPageNotVhostAndNoWorker  page url  is null");
                    return false;
                } else if (!pageURI.startsWith(string) && page.getData(WorkerStore.class) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("callFromPageNotVhostAndNoWorker  url not start with vhost and worker is null. vhost=");
                    sb.append(string);
                    sb.append("url=");
                    sb.append(pageURI);
                    RVLogger.d(TAG, sb.toString());
                    return true;
                }
            }
            return false;
        }
    }
}
