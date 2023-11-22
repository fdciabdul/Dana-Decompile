package com.alibaba.griver.base.common.utils;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.ContainerModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.appinfo.AppType;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.h5.appinfo.GriverH5AppInfo;
import com.alibaba.griver.api.resource.ResourceConstants;
import com.alibaba.griver.api.resource.appcenter.storage.AppInfoDao;
import com.alibaba.griver.api.resource.appinfo.AppInfoConstants;
import com.alibaba.griver.api.resource.appinfo.GriverAppVirtualHostProxy;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class AppInfoUtils {
    public static final String DEFAULT_VIRTUAL_HOST = "saas.mini-program.com";

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<AppInfoDao> f6306a = new Comparator<AppInfoDao>() { // from class: com.alibaba.griver.base.common.utils.AppInfoUtils.1
        @Override // java.util.Comparator
        public final int compare(AppInfoDao appInfoDao, AppInfoDao appInfoDao2) {
            return RVResourceUtils.compareVersion(appInfoDao2.getVersion(), appInfoDao.getVersion());
        }
    };
    private static final List<String> b;
    private static GriverAppVirtualHostProxy c;

    public static int getDownloadType(AppModel appModel) {
        return 1;
    }

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        c = new GriverAppVirtualHostProxy() { // from class: com.alibaba.griver.base.common.utils.AppInfoUtils.2
            @Override // com.alibaba.griver.api.resource.appinfo.GriverAppVirtualHostProxy
            public final String getHost() {
                return AppInfoUtils.DEFAULT_VIRTUAL_HOST;
            }

            @Override // com.alibaba.griver.api.resource.appinfo.GriverAppVirtualHostProxy
            public final String getScheme() {
                return "https";
            }
        };
        arrayList.add("66666692");
    }

    public static boolean isValid(AppModel appModel) {
        boolean z = (appModel == null || TextUtils.isEmpty(appModel.getAppId()) || TextUtils.isEmpty(appModel.getAppInfoModel().getVersion())) ? false : true;
        if (z) {
            if (appModel.getExtendInfos() != null && getAppType(appModel) == 2) {
                appModel.getExtendInfos().put("usePresetPopmenu", "YES");
            }
            if (TextUtils.isEmpty(appModel.getAppInfoModel().getVhost())) {
                AppInfoModel appInfoModel = appModel.getAppInfoModel();
                StringBuilder sb = new StringBuilder();
                sb.append(c.getScheme());
                sb.append("://");
                sb.append(appModel.getAppId());
                sb.append(".");
                sb.append(c.getHost());
                appInfoModel.setVhost(sb.toString());
            }
        }
        if (isEmbeddedApp(appModel) && TextUtils.isEmpty(getEmbeddedAppMainUrl(appModel))) {
            return false;
        }
        return z;
    }

    public static Comparator<AppInfoDao> getAppInfoDaoDescComparator() {
        return f6306a;
    }

    public static boolean isOutOfTime(String str, long j) {
        return (System.currentTimeMillis() - GriverAppCenter.queryLastRefreshTimestamp(str)) / 1000 > j;
    }

    private static String a(boolean z) {
        String str = z ? "griver/ng/installed" : "griver/installed";
        Application applicationContext = GriverEnv.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getFilesDir());
        sb.append(File.separator);
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static String b(boolean z) {
        File file;
        String str = z ? "griver/ng/downloaded" : "griver/downloaded";
        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_DOWNLOAD_APP_PATH, GriverConfigConstants.DEFAULT_DOWNLOAD_APP_PATH);
        Application applicationContext = GriverEnv.getApplicationContext();
        if (GriverConfigConstants.DEFAULT_DOWNLOAD_APP_PATH.equalsIgnoreCase(config)) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationContext.getFilesDir());
            sb.append(File.separator);
            sb.append(str);
            file = new File(sb.toString());
        } else {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(applicationContext.getExternalFilesDir(""));
                sb2.append(File.separator);
                sb2.append(str);
                file = new File(sb2.toString());
            } catch (Exception unused) {
                GriverLogger.w("AppInfoUtils", "external file is not available, use inner storage");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(applicationContext.getFilesDir());
                sb3.append(File.separator);
                sb3.append(str);
                file = new File(sb3.toString());
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getInstallPath(AppModel appModel) {
        if (appModel.getAppInfoModel() == null) {
            return null;
        }
        return a(appModel.getAppId(), appModel.getAppVersion(), GriverAppxNgRuntimeChecker.getPackageUrl(appModel), isEmbeddedApp(appModel), GriverAppxNgRuntimeChecker.isUseAppxNg(appModel));
    }

    private static String a(String str, String str2, String str3, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (!z && TextUtils.isEmpty(str3))) {
            StringBuilder sb = new StringBuilder();
            sb.append("get install path, but parameter is empty, appId: ");
            sb.append(str);
            sb.append(", version: ");
            sb.append(str2);
            sb.append(", downloadUrl: ");
            sb.append(str3);
            GriverLogger.w("AppInfoUtils", sb.toString());
            return null;
        }
        return new File(new File(a(z2), str), a(str3, str2)).getAbsolutePath();
    }

    public static List<String> getAllInstallFiles(String str) {
        List<AppModel> queryAppInfo = GriverAppCenter.queryAppInfo(str);
        ArrayList arrayList = new ArrayList();
        if (queryAppInfo != null && queryAppInfo.size() > 0) {
            Iterator<AppModel> it = queryAppInfo.iterator();
            while (it.hasNext()) {
                String installPath = getInstallPath(it.next());
                if (FileUtils.exists(installPath)) {
                    arrayList.add(installPath);
                }
            }
        }
        return arrayList;
    }

    public static boolean isInstalled(AppModel appModel) {
        if (appModel == null) {
            GriverLogger.w("AppInfoUtils", "check install status, app griver info is null, return false");
            return false;
        }
        return installPathExist(appModel);
    }

    public static boolean installPathExist(AppModel appModel) {
        if (appModel == null) {
            return false;
        }
        return installPathValid(getInstallPath(appModel));
    }

    public static boolean installPathValid(String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.isDirectory() || !file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return false;
        }
        if (listFiles.length < 4) {
            boolean z = false;
            for (File file2 : listFiles) {
                if (file2.getName().contains("tar")) {
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    public static File getDownloadFile(AppModel appModel) {
        if (appModel.getAppInfoModel() == null) {
            return null;
        }
        String b2 = b(GriverAppxNgRuntimeChecker.isUseAppxNg(appModel));
        StringBuilder sb = new StringBuilder();
        sb.append(appModel.getAppId());
        sb.append("-");
        sb.append(a(GriverAppxNgRuntimeChecker.getPackageUrl(appModel), appModel.getAppVersion()));
        return new File(b2, sb.toString());
    }

    public static boolean isEmbeddedApp(Page page) {
        if (page == null || page.getApp() == null) {
            GriverLogger.w("AppInfoUtils", "check if embedded app but app model is null, return false");
            return false;
        }
        return isEmbeddedApp((AppModel) page.getApp().getData(AppModel.class));
    }

    public static boolean isEmbeddedApp(App app) {
        if (app == null) {
            GriverLogger.w("AppInfoUtils", "check if embedded app but app model is null, return false");
            return false;
        }
        return isEmbeddedApp((AppModel) app.getData(AppModel.class));
    }

    public static boolean isEmbeddedApp(AppModel appModel) {
        if (appModel == null || appModel.getExtendInfos() == null) {
            GriverLogger.w("AppInfoUtils", "check if embedded app but app model is null, return false");
            return false;
        }
        return "YES".equalsIgnoreCase(JSONUtils.getString(appModel.getExtendInfos(), GriverBaseConstants.GRIVER_IS_EMBEDDED_APP));
    }

    public static String getEmbeddedAppMainUrl(AppModel appModel) {
        if (appModel == null || appModel.getExtendInfos() == null) {
            GriverLogger.w("AppInfoUtils", "get embedded app main url but app model is null, return empty");
            return "";
        }
        return JSONUtils.getString(appModel.getExtendInfos(), GriverBaseConstants.GRIVER_EMBEDDED_URL);
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? FileUtils.getMD5(str) : str2;
    }

    public static boolean isCommonRes(String str) {
        return b.contains(str);
    }

    public static void setGriverAppVirtualHostProxy(GriverAppVirtualHostProxy griverAppVirtualHostProxy) {
        if (c != null) {
            c = griverAppVirtualHostProxy;
        }
    }

    public static GriverAppVirtualHostProxy getVhostProxy() {
        return c;
    }

    public static boolean isTinyApp(AppModel appModel) {
        return appModel != null && getAppType(appModel) == 2;
    }

    public static int getAppType(AppModel appModel) {
        if (appModel == null) {
            return 2;
        }
        try {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("isTiny..e=");
            sb.append(th);
            RVLogger.e("AppInfoUtils", sb.toString());
        }
        if (appModel.getExtendInfos() == null || !appModel.getExtendInfos().containsKey(AppInfoConstants.KEY_GRIVER_H5_EXTEND_KEY)) {
            if (appModel.getExtendInfos().containsKey(AppInfoConstants.KEY_GRIVER_APP_SCENE)) {
                appModel.getExtendInfos().put("appType", (Object) Integer.valueOf(JSONUtils.getInt(appModel.getExtendInfos(), AppInfoConstants.KEY_GRIVER_APP_SCENE)));
            }
            int i = JSONUtils.getInt(appModel.getExtendInfos(), "appType");
            if (i == 2 || i == 1) {
                return i;
            }
            return 2;
        }
        return 1;
    }

    public static void setAppType(AppModel appModel, int i) {
        if (appModel == null) {
            return;
        }
        if (appModel.getExtendInfos() == null) {
            appModel.setExtendInfos(new JSONObject());
        }
        appModel.getExtendInfos().put(AppInfoConstants.KEY_GRIVER_APP_SCENE, (Object) Integer.valueOf(i));
        appModel.getExtendInfos().put("appType", (Object) Integer.valueOf(i));
    }

    public static String getPublishingStatus(AppModel appModel) {
        String string;
        if (appModel == null) {
            return "PUBLISHED";
        }
        try {
            string = JSONUtils.getString(appModel.getExtendInfos(), "publishingStatus");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("isTiny..e=");
            sb.append(th);
            RVLogger.e("AppInfoUtils", sb.toString());
        }
        if (!TextUtils.equals(string, "PUBLISHED") && !TextUtils.equals(string, "REMOVED")) {
            if (!TextUtils.equals(string, "SUSPENDED")) {
                return "PUBLISHED";
            }
        }
        return string;
    }

    public static void setPublishingStatus(AppModel appModel, String str) {
        if (appModel == null) {
            return;
        }
        if (appModel.getExtendInfos() == null) {
            appModel.setExtendInfos(new JSONObject());
        }
        appModel.getExtendInfos().put("publishingStatus", (Object) str);
    }

    public static JSONObject getLanguages(AppModel appModel) {
        if (appModel == null) {
            return null;
        }
        try {
            return JSONUtils.getJSONObject(appModel.getExtendInfos(), "languages", null);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("isTiny..e=");
            sb.append(th);
            RVLogger.e("AppInfoUtils", sb.toString());
            return null;
        }
    }

    public static void setLanguages(AppModel appModel, JSONObject jSONObject) {
        if (appModel == null) {
            return;
        }
        if (appModel.getExtendInfos() == null) {
            appModel.setExtendInfos(new JSONObject());
        }
        appModel.getExtendInfos().put("languages", (Object) jSONObject);
    }

    public static void setDownloadType(AppModel appModel, int i) {
        if (appModel == null) {
            return;
        }
        if (appModel.getContainerInfo() == null) {
            appModel.setContainerInfo(new ContainerModel());
        }
        appModel.getContainerInfo().setDownloadType(i);
    }

    public static String getInstallThreadName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_install");
        return sb.toString();
    }

    public static AppModel convertToAppInfo(GriverH5AppInfo griverH5AppInfo) {
        AppModel appModel = new AppModel();
        if (griverH5AppInfo == null) {
            return appModel;
        }
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId(griverH5AppInfo.appId);
        appInfoModel.setVersion(griverH5AppInfo.version);
        appInfoModel.setDeveloperVersion(griverH5AppInfo.version);
        appInfoModel.setVhost(a(griverH5AppInfo.remoteURLPrefix));
        setAppType(appModel, 1);
        appInfoModel.setPackageUrl(griverH5AppInfo.downloadURL);
        appInfoModel.setMainUrl(griverH5AppInfo.index);
        appModel.setAppInfoModel(appInfoModel);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AppInfoConstants.KEY_GRIVER_H5_EXTEND_KEY, (Object) JSON.toJSONString(griverH5AppInfo));
        appModel.setExtendInfos(jSONObject);
        setPublishingStatus(appModel, griverH5AppInfo.publishingStatus);
        appModel.setContainerInfo(new ContainerModel());
        return appModel;
    }

    public static String getDeveloperVersion(AppModel appModel) {
        return (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getDeveloperVersion();
    }

    public static GriverH5AppInfo getH5AppFromAppInfo(AppModel appModel) {
        JSONObject extendInfos;
        if (appModel != null && getAppType(appModel) == 1 && (extendInfos = appModel.getExtendInfos()) != null && extendInfos.containsKey(AppInfoConstants.KEY_GRIVER_H5_EXTEND_KEY)) {
            try {
                return (GriverH5AppInfo) JSON.parseObject(extendInfos.getString(AppInfoConstants.KEY_GRIVER_H5_EXTEND_KEY), GriverH5AppInfo.class);
            } catch (Exception e) {
                GriverLogger.e("AppInfoUtils", "get h5app from app failed", e);
                return null;
            }
        }
        return null;
    }

    private static String a(String str) {
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb = new StringBuilder();
            sb.append(parse.getScheme());
            sb.append("://");
            sb.append(parse.getHost());
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("vhost = ");
            sb2.append(obj);
            GriverLogger.d("AppInfoUtils", sb2.toString());
            return obj;
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getVhost");
            sb3.append(e.getMessage());
            GriverLogger.w("AppInfoUtils", sb3.toString());
            return null;
        }
    }

    public static boolean shouldInstall(AppModel appModel) {
        GriverH5AppInfo h5AppFromAppInfo;
        if (appModel == null) {
            return false;
        }
        if (2 == getAppType(appModel) && (TextUtils.equals(getPublishingStatus(appModel), "REMOVED") || TextUtils.equals(getPublishingStatus(appModel), "SUSPENDED"))) {
            StringBuilder sb = new StringBuilder();
            sb.append("app is not published, should not install, appId: ");
            sb.append(appModel.getAppId());
            sb.append(", version: ");
            sb.append(appModel.getAppVersion());
            GriverLogger.d("AppInfoUtils", sb.toString());
            return false;
        }
        if (1 == getAppType(appModel) && (h5AppFromAppInfo = getH5AppFromAppInfo(appModel)) != null) {
            if (TextUtils.equals(h5AppFromAppInfo.publishingStatus, "REMOVED") || TextUtils.equals(h5AppFromAppInfo.publishingStatus, "SUSPENDED")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("app is not published, should not install, appId: ");
                sb2.append(h5AppFromAppInfo.appId);
                sb2.append(", version: ");
                sb2.append(h5AppFromAppInfo.version);
                GriverLogger.d("AppInfoUtils", sb2.toString());
                return false;
            } else if (h5AppFromAppInfo.shouldLoadRemote) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("app should load remote, should not install, appId: ");
                sb3.append(h5AppFromAppInfo.appId);
                sb3.append(", version: ");
                sb3.append(h5AppFromAppInfo.version);
                GriverLogger.d("AppInfoUtils", sb3.toString());
                return false;
            }
        }
        return true;
    }

    private static String c(boolean z) {
        File file;
        String str = z ? "griver/ng/preDownloaded" : "griver/preDownloaded";
        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_DOWNLOAD_APP_PATH, GriverConfigConstants.DEFAULT_DOWNLOAD_APP_PATH);
        Application applicationContext = GriverEnv.getApplicationContext();
        if (GriverConfigConstants.DEFAULT_DOWNLOAD_APP_PATH.equalsIgnoreCase(config)) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationContext.getFilesDir());
            sb.append(File.separator);
            sb.append(str);
            file = new File(sb.toString());
        } else {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(applicationContext.getExternalFilesDir(""));
                sb2.append(File.separator);
                sb2.append(str);
                file = new File(sb2.toString());
            } catch (Exception unused) {
                GriverLogger.w("AppInfoUtils", "preDownload external file is not available, use inner storage");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(applicationContext.getFilesDir());
                sb3.append(File.separator);
                sb3.append(str);
                file = new File(sb3.toString());
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static File getPreDownloadFile(AppModel appModel) {
        if (appModel.getAppInfoModel() == null) {
            return null;
        }
        String c2 = c(GriverAppxNgRuntimeChecker.isUseAppxNg(appModel));
        StringBuilder sb = new StringBuilder();
        sb.append(appModel.getAppId());
        sb.append("-");
        sb.append(a(GriverAppxNgRuntimeChecker.getPackageUrl(appModel), appModel.getAppVersion()));
        return new File(c2, sb.toString());
    }

    public static void deletePreDownloadFile(AppModel appModel) {
        if (TextUtils.isEmpty(appModel.getAppId())) {
            return;
        }
        File file = new File(c(GriverAppxNgRuntimeChecker.isUseAppxNg(appModel)));
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.getName().startsWith(appModel.getAppId())) {
                    file2.delete();
                }
            }
        }
    }

    public static boolean isPreDownloadFileExists(AppModel appModel) {
        if (appModel.getAppInfoModel() == null) {
            return false;
        }
        String c2 = c(GriverAppxNgRuntimeChecker.isUseAppxNg(appModel));
        StringBuilder sb = new StringBuilder();
        sb.append(appModel.getAppId());
        sb.append("-");
        sb.append(a(GriverAppxNgRuntimeChecker.getPackageUrl(appModel), appModel.getAppVersion()));
        return new File(c2, sb.toString()).exists();
    }

    public static String getEmbeddedAppMainUrl(App app) {
        Bundle sceneParams;
        if (app != null && (sceneParams = app.getSceneParams()) != null) {
            AppModel appModel = (AppModel) sceneParams.getParcelable("appInfo");
            if (isEmbeddedApp(appModel)) {
                return getEmbeddedAppMainUrl(appModel);
            }
        }
        return "";
    }

    public static AppType getAppTypeByModel(AppModel appModel) {
        if (appModel == null) {
            return AppType.UNKNOWN;
        }
        String a2 = a(appModel);
        if ("YES".equalsIgnoreCase(a2)) {
            return AppType.NATIVE_CUBE;
        }
        if ("SHARED".equalsIgnoreCase(a2)) {
            return AppType.TINY_HYBRID;
        }
        return getAppTypeWithoutCube(appModel);
    }

    private static String a(AppModel appModel) {
        String str;
        if (appModel == null) {
            return "NO";
        }
        if (appModel.getContainerInfo() != null) {
            str = JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), ResourceConstants.EXTRA_ENABLE_CUBE, null);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = "NO";
        }
        return appModel.getExtendInfos() != null ? JSONUtils.getString(appModel.getExtendInfos().getJSONObject(RVConstants.EXTRA_RES_LAUNCH_PARAMS), ResourceConstants.EXTRA_ENABLE_CUBE, "NO") : str;
    }

    public static AppType getAppTypeWithoutCube(AppModel appModel) {
        int appChannel = getAppChannel(appModel);
        if (appChannel == 4) {
            if (PaladinUtils.isTinyGameSubType(appModel)) {
                return AppType.TINY_GAME;
            }
            return AppType.WEB_TINY;
        } else if (isEnableDSL(appModel)) {
            return AppType.WEB_TINY_INNER;
        } else {
            if (appChannel == 5) {
                if (PaladinUtils.enablePaladin(appModel)) {
                    return AppType.TINY_GAME;
                }
                return AppType.WEB_TINY_INNER;
            }
            return AppType.WEB_H5;
        }
    }

    public static int getAppChannel(AppModel appModel) {
        return JSONUtils.getInt(appModel.getExtendInfos(), ResourceConstants.KEY_APP_CHANNEL);
    }

    public static boolean isEnableDSL(AppModel appModel) {
        if (appModel == null) {
            return false;
        }
        try {
            return "yes".equalsIgnoreCase(JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), "enableDSL"));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("isTiny..e=");
            sb.append(th);
            RVLogger.e("AppInfoUtils", sb.toString());
            return false;
        }
    }
}
