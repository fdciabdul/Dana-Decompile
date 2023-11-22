package com.alibaba.ariver.resource.api.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.appxng.AppxNgRuntimeChecker;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/* loaded from: classes3.dex */
public class RVSnapshotUtils {
    public static boolean isSnapshotEnabled(App app) {
        if (app != null && !TextUtils.isEmpty(app.getAppId())) {
            String appId = app.getAppId();
            if (RVProxy.get(ISnapshotProxy.class, true) != null) {
                return ((ISnapshotProxy) RVProxy.get(ISnapshotProxy.class)).isSnapshotEnable(app);
            }
            if ("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework"))) {
                JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList_appxng");
                JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotBlackList_appxng");
                if (configJSONArray2 != null && (configJSONArray2.contains("all") || configJSONArray2.contains(appId))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ta_snapshotBlackList_appxng hit, appId: ");
                    sb.append(appId);
                    RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
                    return false;
                } else if (configJSONArray != null && (configJSONArray.contains("all") || configJSONArray.contains(appId))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ta_snapshotWhiteList_appxng hit, appId: ");
                    sb2.append(appId);
                    RVLogger.d("AriverRes:SnapshotProvider", sb2.toString());
                    return true;
                }
            } else {
                JSONArray configJSONArray3 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList");
                JSONArray configJSONArray4 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotBlackList");
                if (configJSONArray4 != null && (configJSONArray4.contains("all") || configJSONArray4.contains(appId))) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("ta_snapshotBlackList hit, appId: ");
                    sb3.append(appId);
                    RVLogger.d("AriverRes:SnapshotProvider", sb3.toString());
                    return false;
                } else if (configJSONArray3 != null && (configJSONArray3.contains("all") || configJSONArray3.contains(appId))) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("ta_snapshotWhiteList hit, appId: ");
                    sb4.append(appId);
                    RVLogger.d("AriverRes:SnapshotProvider", sb4.toString());
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPreRenderSnapshotOpen(String str) {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_prerender_snapshot_blacklist");
        if (CollectionUtils.isEmpty(configJSONArray)) {
            return true;
        }
        return (configJSONArray.contains(str) || configJSONArray.contains("all")) ? false : true;
    }

    public static void saveSnapshot(App app, AppModel appModel, String str, String str2, boolean z) {
        TitleBar titleBar;
        if (!isSnapshotEnabled(app)) {
            RVLogger.e("AriverRes:SnapshotProvider", "saveSnapshot, snapshot switch is disabled");
            return;
        }
        boolean supportCrocssVersion = supportCrocssVersion(app, appModel);
        if (!isValidSnapshot(str)) {
            RVLogger.e("AriverRes:SnapshotProvider", "saveSnapshot invalid snapshot string");
            return;
        }
        String str3 = null;
        try {
            if (isHomePage2(app, str2) && app.isFirstPage() && app.getActivePage() != null && app.getActivePage().getPageContext() != null && (titleBar = app.getActivePage().getPageContext().getTitleBar()) != null) {
                JSONObject jSONObject = new JSONObject();
                String title = titleBar.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    jSONObject.put("defaultTitle", (Object) title);
                }
                String subTitle = titleBar.getSubTitle();
                if (!TextUtils.isEmpty(subTitle)) {
                    jSONObject.put(RVParams.LONG_SUB_TITLE, (Object) subTitle);
                }
                jSONObject.put("titleBarColor", (Object) Integer.valueOf(titleBar.getTitleColor() | (-16777216)));
                String transparentTitle = titleBar.getTransparentTitle();
                if (!TextUtils.isEmpty(transparentTitle)) {
                    jSONObject.put("transparentTitle", (Object) transparentTitle);
                }
                Bitmap imgTitle = titleBar.getImgTitle();
                if (imgTitle != null) {
                    jSONObject.put("titleImage", (Object) ImageUtil.bitmapToString(imgTitle, "PNG"));
                }
                String jSONUtils = JSONUtils.toString(jSONObject);
                str3 = a(app, appModel, str2, z, supportCrocssVersion);
                if (!TextUtils.isEmpty(str3)) {
                    writeToFile(jSONUtils, str3.replace(z ? "index.prerender.snapshot.html" : "index.snapshot.html", "titleBar.snapshot.json"));
                }
            }
        } catch (Throwable th) {
            RVLogger.e("AriverRes:SnapshotProvider", "saveSnapshot exception!", th);
        }
        try {
            if (TextUtils.isEmpty(str3)) {
                str3 = a(app, appModel, str2, z, supportCrocssVersion);
            }
            writeToFile(str, str3);
            if (supportCrocssVersion(app, appModel)) {
                return;
            }
            deleteSnapshot(app, appModel, str2, true);
        } catch (Throwable th2) {
            RVLogger.e("AriverRes:SnapshotProvider", "saveSnapshot exception: ", th2);
        }
    }

    public static boolean deleteSnapshot(App app, AppModel appModel, String str, boolean z) {
        if (!isSnapshotEnabled(app)) {
            RVLogger.d("AriverRes:SnapshotProvider", "deleteSnapshot, snapshot switch is disabled");
            return true;
        }
        String a2 = a(app, appModel, str, false, z);
        String[] strArr = {a2, a(app, appModel, str, true, z), a2.replace("index.snapshot.html", "titleBar.snapshot.json")};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            try {
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("deleteSnapshot ");
                sb.append(str2);
                sb.append(" exception: ");
                RVLogger.e("AriverRes:SnapshotProvider", sb.toString(), th);
            }
        }
        return true;
    }

    public static boolean hitPageLevelWhiteList(String str) {
        JSONArray configJSONArray;
        if (TextUtils.isEmpty(str) || (configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshot2WhiteList")) == null || (!configJSONArray.contains("all") && !configJSONArray.contains(str))) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PageLevel snapshot hit whitelist, appId: ");
        sb.append(str);
        RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
        return true;
    }

    public static byte[] loadSnapshotFile(App app, AppModel appModel, String str, boolean z) {
        app.getAppId();
        if (!isSnapshotEnabled(app)) {
            RVLogger.e("AriverRes:SnapshotProvider", "snapshot switch is disabled");
            return null;
        }
        String a2 = a(app, appModel, getPagePathFromPageUrl(str), z, supportCrocssVersion(app, appModel));
        if (TextUtils.isEmpty(a2)) {
            RVLogger.e("AriverRes:SnapshotProvider", "snapshotFilePath is null");
            return null;
        } else if (a(a2)) {
            return null;
        } else {
            try {
                File file = new File(a2);
                if (file.exists()) {
                    byte[] readFile = readFile(file);
                    if (readFile == null || readFile.length <= 100) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("snapshot file existed: ");
                    sb.append(a2);
                    RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
                    return readFile;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("snapshot file not existed: ");
                sb2.append(a2);
                RVLogger.e("AriverRes:SnapshotProvider", sb2.toString());
                return null;
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" loadSnapshotFile error: ");
                sb3.append(th);
                RVLogger.e("AriverRes:SnapshotProvider", sb3.toString());
                return null;
            }
        }
    }

    public static String loadTitleBarSnapshot(App app, AppModel appModel, String str) {
        app.getAppId();
        if (isHomePage(app, str)) {
            String a2 = a(app, appModel, getPagePathFromPageUrl(str), false, supportCrocssVersion(app, appModel));
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String replace = a2.replace("index.snapshot.html", "titleBar.snapshot.json");
            if (!isSnapshotEnabled(app)) {
                RVLogger.e("AriverRes:SnapshotProvider", "titleBar snapshot switch is disabled");
                return null;
            } else if (TextUtils.isEmpty(replace)) {
                RVLogger.e("AriverRes:SnapshotProvider", "titleBar snapshotFilePath is null");
                return null;
            } else if (a(replace)) {
                return null;
            } else {
                try {
                    File file = new File(replace);
                    if (file.exists()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("titleBar snapshot file existed: ");
                        sb.append(replace);
                        RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
                        byte[] readFile = readFile(file);
                        if (readFile != null) {
                            String str2 = new String(readFile, StandardCharsets.UTF_8);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("titleBar snapshot file : ");
                            sb2.append(str2);
                            RVLogger.d("AriverRes:SnapshotProvider", sb2.toString());
                            return str2;
                        }
                        return null;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("titleBar snapshot file not existed: ");
                    sb3.append(replace);
                    RVLogger.e("AriverRes:SnapshotProvider", sb3.toString());
                    return null;
                } catch (Throwable th) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("titleBar loadSnapshotFile error: ");
                    sb4.append(th);
                    RVLogger.e("AriverRes:SnapshotProvider", sb4.toString());
                    return null;
                }
            }
        }
        return null;
    }

    private static boolean a(String str) {
        File file;
        try {
            file = new File(str);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteFileIfExpired: ");
            sb.append(str);
            sb.append("  error: ");
            sb.append(th);
            RVLogger.e("AriverRes:SnapshotProvider", sb.toString());
        }
        if (file.exists()) {
            String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_snapshotExpiredDays", "7");
            if (new Date().getTime() - file.lastModified() > Integer.parseInt(configWithProcessCache) * 24 * 60 * 60 * 1000) {
                file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("snapshot file ");
                sb2.append(str);
                sb2.append(" expired ");
                sb2.append(configWithProcessCache);
                sb2.append(" days and delete success");
                RVLogger.d("AriverRes:SnapshotProvider", sb2.toString());
                return true;
            }
            return false;
        }
        return false;
    }

    public static String getPagePathFromPageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parseUrl = UrlUtils.parseUrl(str);
        if (parseUrl == null) {
            return null;
        }
        try {
            String fragment = parseUrl.getFragment();
            if (fragment == null) {
                return null;
            }
            int indexOf = fragment.indexOf("?");
            return indexOf != -1 ? fragment.substring(0, indexOf) : fragment;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getPagePathFromPageUrl error: ");
            sb.append(th);
            RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
            return "";
        }
    }

    public static boolean supportCrocssVersion(App app, AppModel appModel) {
        if (app.containsKey("supportCrocssVersion")) {
            return app.getBooleanValue("supportCrocssVersion");
        }
        boolean checkAppxSupportCrossVersionSnapshot = new AppxNgRuntimeChecker("68687209").checkAppxSupportCrossVersionSnapshot(app, appModel);
        StringBuilder sb = new StringBuilder();
        sb.append("getSnapshotSavePath checkAppxSupportCrossVersionSnapshot:");
        sb.append(checkAppxSupportCrossVersionSnapshot);
        RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
        app.putBooleanValue("supportCrocssVersion", checkAppxSupportCrossVersionSnapshot);
        return checkAppxSupportCrossVersionSnapshot;
    }

    private static String a(App app, AppModel appModel, String str, boolean z, boolean z2) {
        try {
            if (z2) {
                return a(app, str, z);
            }
            return a(app, appModel, str, z);
        } catch (Exception e) {
            RVLogger.w("AriverRes:SnapshotProvider", "getSnapshotSavePath failed", e);
            return null;
        }
    }

    private static String a(App app, String str, boolean z) {
        String str2 = "YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework")) ? "appxV2_" : "appxV1_";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        if (TextUtils.isEmpty(userId)) {
            userId = "000";
        }
        ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class, true);
        String snapshotExtDir = iSnapshotProxy != null ? iSnapshotProxy.getSnapshotExtDir(app) : null;
        if (TextUtils.isEmpty(snapshotExtDir)) {
            snapshotExtDir = ((RVResourceManager) RVProxy.get(RVResourceManager.class)).getRootInstallPath(app.getAppId());
        }
        if (snapshotExtDir == null) {
            return null;
        }
        File file = new File(snapshotExtDir);
        if (file.exists() || file.mkdirs()) {
            String replace = str.replace('/', '_');
            StringBuilder sb = new StringBuilder();
            sb.append("snapshot_");
            sb.append(str2);
            sb.append(replace);
            sb.append("_");
            sb.append(userId);
            sb.append("_");
            sb.append(z ? "index.prerender.snapshot.html" : "index.snapshot.html");
            return new File(snapshotExtDir, sb.toString()).getAbsolutePath();
        }
        return null;
    }

    private static String a(App app, AppModel appModel, String str, boolean z) {
        String absolutePath;
        File extDirectory;
        String str2 = "YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework")) ? "appxV2_" : "appxV1_";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        if (TextUtils.isEmpty(userId)) {
            userId = "000";
        }
        ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class, true);
        if (iSnapshotProxy != null) {
            absolutePath = iSnapshotProxy.getSnapshotExtDir(app);
        } else {
            File extDirectory2 = RVResourceUtils.getExtDirectory(appModel, true);
            absolutePath = extDirectory2 != null ? extDirectory2.getAbsolutePath() : null;
        }
        if (absolutePath == null && (extDirectory = RVResourceUtils.getExtDirectory(appModel, true)) != null) {
            absolutePath = extDirectory.getAbsolutePath();
        }
        if (absolutePath == null) {
            return null;
        }
        String replace = str.replace('/', '_');
        StringBuilder sb = new StringBuilder();
        sb.append("snapshot_");
        sb.append(str2);
        sb.append(replace);
        sb.append("_");
        sb.append(userId);
        sb.append("_");
        sb.append(z ? "index.prerender.snapshot.html" : "index.snapshot.html");
        return new File(absolutePath, sb.toString()).getAbsolutePath();
    }

    public static boolean isValidSnapshot(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.w("AriverRes:SnapshotProvider", "isValidSnapshot...invalid snapshot, string is null");
            return false;
        } else if (!str.contains("<div id=\"__react-content\">")) {
            RVLogger.w("AriverRes:SnapshotProvider", "isValidSnapshot...invalid snapshot, string has no root node");
            return false;
        } else if (str.contains("<div class=\"a-cp-loading-indicator\" aria-hidden=\"true\">") && str.contains("<div class=\"a-cp-loading-item\"></div>")) {
            RVLogger.w("AriverRes:SnapshotProvider", "isValidSnapshot...invalid snapshot, snapshot is loading view");
            return false;
        } else if (str.contains("<div id=\"__react-content\"><div class=\"a-page tiny-page\"></div></div>\n")) {
            RVLogger.w("AriverRes:SnapshotProvider", "isValidSnapshot...invalid snapshot, dom tree no ready");
            return false;
        } else {
            return true;
        }
    }

    public static void writeToFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2), false);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        StringBuilder sb = new StringBuilder();
        sb.append("saveSnapshot success, file: ");
        sb.append(str2);
        RVLogger.d("AriverRes:SnapshotProvider", sb.toString());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static byte[] readFile(File file) {
        FileInputStream fileInputStream;
        ?? isFile = file.isFile();
        Closeable closeable = null;
        try {
            if (isFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            IOUtils.closeQuietly(fileInputStream);
                            return byteArray;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("readFile，error:");
                    sb.append(e);
                    RVLogger.e("AriverRes:SnapshotProvider", sb.toString());
                    IOUtils.closeQuietly(fileInputStream);
                    return null;
                }
            } else {
                RVLogger.e("AriverRes:SnapshotProvider", "readFile failed");
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable = isFile;
        }
    }

    private static String a(App app) {
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel == null || appConfigModel.getPages() == null || appConfigModel.getPages().size() <= 0) {
            return null;
        }
        return appConfigModel.getPages().get(0);
    }

    public static void handleSnapshotEvent(Page page) {
        if (page == null || page.isExited() || page.getApp() == null || page.getApp().isExited() || page.getEmbedType() != EmbedType.NO) {
            return;
        }
        if (!isSnapshotEnabled(page.getApp())) {
            RVLogger.e("AriverRes:SnapshotProvider", "snapshot switch is disabled");
            return;
        }
        String pageURI = page.getPageURI();
        if (!isHomePage(page.getApp(), pageURI)) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleSnapshotEvent non first page, pageUrl: ");
            sb.append(pageURI);
            RVLogger.e("AriverRes:SnapshotProvider", sb.toString());
            return;
        }
        Render render = page.getRender();
        if (render != null) {
            render.triggerSaveSnapshot();
        }
    }

    public static boolean isHomePage(App app, String str) {
        if (app != null && !TextUtils.isEmpty(app.getAppId()) && !TextUtils.isEmpty(str)) {
            String a2 = a(app);
            try {
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("index.html#");
                sb.append(a2);
                if (str.contains(sb.toString())) {
                    return true;
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isHomePage.. e: ");
                sb2.append(e);
                RVLogger.e("AriverRes:SnapshotProvider", sb2.toString());
            }
        }
        return false;
    }

    public static boolean isHomePage2(App app, String str) {
        if (!TextUtils.isEmpty(app.getAppId()) && !TextUtils.isEmpty(str)) {
            String a2 = a(app);
            try {
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                if (str.equals(a2)) {
                    return true;
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("isHomePage.. e: ");
                sb.append(e);
                RVLogger.e("AriverRes:SnapshotProvider", sb.toString());
            }
        }
        return false;
    }
}
