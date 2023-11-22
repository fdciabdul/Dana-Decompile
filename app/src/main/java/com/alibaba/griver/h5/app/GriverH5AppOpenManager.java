package com.alibaba.griver.h5.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.appinfo.AppType;
import com.alibaba.griver.api.h5.appinfo.GriverH5AppInfo;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.StartupParamsUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import id.dana.danah5.DanaH5Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverH5AppOpenManager {
    public static final String PURE_ONLINE_APPID = "null_online";

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, GriverH5AppInfo> f6544a = new HashMap();
    private static final Map<String, AppModel> b = new HashMap();

    public static void openUrl(Context context, String str, Bundle bundle) {
        AppModel queryLastInstall;
        if (context == null) {
            GriverLogger.w("GriverH5AppOpenManager", "Context is null, can not open url");
        } else if (TextUtils.isEmpty(str)) {
            GriverLogger.w("GriverH5AppOpenManager", "url is empty, can not open url");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle filterBundle = StartupParamsUtils.filterBundle("", str, bundle);
            Bundle a2 = a(str);
            a2.putAll(filterBundle);
            String b2 = b(str);
            if (TextUtils.equals("null_online", b2)) {
                a2.putString("appId", b2);
                StringBuilder sb = new StringBuilder();
                sb.append("open pure online url: ");
                sb.append(str);
                GriverLogger.d("GriverH5AppOpenManager", sb.toString());
                a(context, "null_online", a2);
                return;
            }
            a2.putString("appId", b2);
            GriverH5AppInfo griverH5AppInfo = f6544a.get(b2);
            Map<String, AppModel> map = b;
            AppModel appModel = map.get(b2);
            if (!TextUtils.isEmpty(AppInfoUtils.getPublishingStatus(appModel)) && !"PUBLISHED".equals(AppInfoUtils.getPublishingStatus(appModel))) {
                String errorUrl = ErrorPageUtils.getErrorUrl(griverH5AppInfo.appId, griverH5AppInfo.publishingStatus, "H5");
                a2.putString("url", errorUrl);
                a2.putString("u", errorUrl);
                a2.putString("appId", "");
                a(context, "", a2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("app is not published: ");
                sb2.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb2.toString());
            } else if (griverH5AppInfo == null) {
                a2.putString("appVersion", appModel.getAppVersion());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("open h5 page with new configuration: ");
                sb3.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb3.toString());
                a(context, b2, a2);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("open h5 page with old configuration: ");
                sb4.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb4.toString());
                if (griverH5AppInfo.shouldLoadRemote) {
                    String appendOnlineSuffix = OpenManagerUtils.appendOnlineSuffix(b2);
                    a2.putString("appId", appendOnlineSuffix);
                    a2.putString("appVersion", griverH5AppInfo.version);
                    a(context, appendOnlineSuffix, a2);
                    return;
                }
                boolean isInstalled = AppInfoUtils.isInstalled(map.get(b2));
                a2.putString("appVersion", map.get(b2).getAppVersion());
                if (!isInstalled && TextUtils.equals(griverH5AppInfo.updatePolicy, GriverH5AppInfo.UpdatePolicy.LOAD_PREVIOUS) && (queryLastInstall = GriverAppCenter.queryLastInstall(b2)) != null) {
                    a2.putString("appVersion", queryLastInstall.getAppVersion());
                    a(context, b2, a2);
                    return;
                }
                a(context, b2, a2);
            }
        }
    }

    private static Bundle a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("u", str);
        bundle.putString("url", str);
        bundle.putBoolean(RVParams.isH5App, true);
        bundle.putString("backBehavior", "back");
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean("showProgress", true);
        bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "yes");
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                for (String str2 : parse.getQueryParameterNames()) {
                    bundle.putString(str2, parse.getQueryParameter(str2));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse url error");
            sb.append(th);
            GriverLogger.w("GriverH5AppOpenManager", sb.toString());
        }
        return bundle;
    }

    private static void a(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("appType", AppType.WEB_H5.name());
        RVMain.startPage(context, RVAppRecord.generate(str, bundle, bundle2), false);
    }

    public static void createFragment(Context context, String str, Bundle bundle, RVMain.Callback callback) {
        AppModel queryLastInstall;
        if (context == null) {
            GriverLogger.w("GriverH5AppOpenManager", "Context is null, can not open url");
        } else if (TextUtils.isEmpty(str)) {
            GriverLogger.w("GriverH5AppOpenManager", "url is empty, can not open url");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle filterBundle = StartupParamsUtils.filterBundle("", str, bundle);
            Bundle a2 = a(str);
            a2.putAll(filterBundle);
            String b2 = b(str);
            if (TextUtils.equals("null_online", b2)) {
                a2.putString("appId", b2);
                StringBuilder sb = new StringBuilder();
                sb.append("open pure online url: ");
                sb.append(str);
                GriverLogger.d("GriverH5AppOpenManager", sb.toString());
                a(context, "null_online", a2, callback);
                return;
            }
            a2.putString("appId", b2);
            GriverH5AppInfo griverH5AppInfo = f6544a.get(b2);
            Map<String, AppModel> map = b;
            AppModel appModel = map.get(b2);
            if (!TextUtils.isEmpty(AppInfoUtils.getPublishingStatus(appModel)) && !"PUBLISHED".equals(AppInfoUtils.getPublishingStatus(appModel))) {
                String errorUrl = ErrorPageUtils.getErrorUrl(griverH5AppInfo.appId, griverH5AppInfo.publishingStatus, "H5");
                a2.putString("url", errorUrl);
                a2.putString("u", errorUrl);
                a2.putString("appId", "");
                a(context, "", a2, callback);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("app is not published: ");
                sb2.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb2.toString());
            } else if (griverH5AppInfo == null) {
                a2.putString("appVersion", appModel.getAppVersion());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("open h5 page with new configuration: ");
                sb3.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb3.toString());
                a(context, b2, a2, callback);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("open h5 page with old configuration: ");
                sb4.append(b2);
                GriverLogger.d("GriverH5AppOpenManager", sb4.toString());
                if (griverH5AppInfo.shouldLoadRemote) {
                    String appendOnlineSuffix = OpenManagerUtils.appendOnlineSuffix(b2);
                    a2.putString("appId", appendOnlineSuffix);
                    a2.putString("appVersion", griverH5AppInfo.version);
                    a(context, appendOnlineSuffix, a2, callback);
                    return;
                }
                boolean isInstalled = AppInfoUtils.isInstalled(map.get(b2));
                a2.putString("appVersion", map.get(b2).getAppVersion());
                if (!isInstalled && TextUtils.equals(griverH5AppInfo.updatePolicy, GriverH5AppInfo.UpdatePolicy.LOAD_PREVIOUS) && (queryLastInstall = GriverAppCenter.queryLastInstall(b2)) != null) {
                    a2.putString("appVersion", queryLastInstall.getAppVersion());
                    a(context, b2, a2, callback);
                    return;
                }
                a(context, b2, a2, callback);
            }
        }
    }

    private static void a(Context context, String str, Bundle bundle, RVMain.Callback callback) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("appType", AppType.WEB_H5.name());
        RVMain.createFragment(context, str, bundle, bundle2, callback);
    }

    private static String b(String str) {
        List<AppModel> queryAppInfos = GriverAppCenter.queryAppInfos();
        if (queryAppInfos == null || queryAppInfos.size() == 0) {
            return "null_online";
        }
        ArrayList arrayList = new ArrayList();
        for (AppModel appModel : queryAppInfos) {
            if (appModel != null && AppInfoUtils.getAppType(appModel) == 1 && !TextUtils.isEmpty(appModel.getAppInfoModel().getVhost()) && str.startsWith(appModel.getAppInfoModel().getVhost())) {
                GriverH5AppInfo h5AppFromAppInfo = AppInfoUtils.getH5AppFromAppInfo(appModel);
                if (h5AppFromAppInfo != null && !TextUtils.equals("resource", h5AppFromAppInfo.type)) {
                    if (str.startsWith(h5AppFromAppInfo.remoteURLPrefix)) {
                        arrayList.add(appModel);
                    }
                } else {
                    arrayList.add(appModel);
                }
            }
        }
        if (arrayList.size() > 0) {
            Collections.sort(arrayList, new Comparator<AppModel>() { // from class: com.alibaba.griver.h5.app.GriverH5AppOpenManager.1
                @Override // java.util.Comparator
                public final int compare(AppModel appModel2, AppModel appModel3) {
                    return RVResourceUtils.compareVersion(appModel3.getAppVersion(), appModel2.getAppVersion());
                }
            });
            AppModel appModel2 = (AppModel) arrayList.get(0);
            f6544a.put(appModel2.getAppId(), AppInfoUtils.getH5AppFromAppInfo(appModel2));
            b.put(appModel2.getAppId(), appModel2);
            return appModel2.getAppId();
        }
        return "null_online";
    }
}
