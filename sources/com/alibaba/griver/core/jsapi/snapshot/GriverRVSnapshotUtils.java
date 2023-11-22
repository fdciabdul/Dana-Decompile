package com.alibaba.griver.core.jsapi.snapshot;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.preload.PreloadInitializer;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes2.dex */
public class GriverRVSnapshotUtils {
    public static void saveSnapshot(App app, AppModel appModel, String str, String str2, boolean z, boolean z2) {
        if (!z2 && !PreloadInitializer.canSnapshot(app)) {
            RVLogger.e("AriverRes:SnapshotProvider", "only save progressive");
            return;
        }
        String a2 = a(str);
        try {
            String str3 = null;
            if (isHomePage2(app, str2) && app.isFirstPage() && app.getActivePage() != null && app.getActivePage().getPageContext() != null) {
                str3 = a(app, appModel, str2, true);
            }
            if (a2.indexOf("APPXNG_SNAPSHOT_{SNAPSHOT_HASH}") > 0) {
                long length = a2.length();
                StringBuilder sb = new StringBuilder();
                sb.append("APPXNG_SNAPSHOT_{");
                sb.append(length);
                sb.append("}");
                a2 = a2.replace("APPXNG_SNAPSHOT_{SNAPSHOT_HASH}", sb.toString());
            }
            writeToFile(a2, str3);
        } catch (Throwable th) {
            RVLogger.e("AriverRes:SnapshotProvider", "saveSnapshot exception: ", th);
        }
    }

    private static String a(String str) {
        JSONArray t2PreloadUrls = GriverAppConfig.getInstance().getT2PreloadUrls();
        for (int i = 0; i < t2PreloadUrls.size(); i++) {
            String string = t2PreloadUrls.getString(i);
            if (!TextUtils.isEmpty(string)) {
                StringBuilder sb = new StringBuilder();
                sb.append("<script charset=\"UTF-8\" src=\"");
                sb.append(string);
                sb.append("\"></script>");
                str = str.replace(sb.toString(), "").replace(string, "");
            }
        }
        JSONArray t2Urls = GriverAppConfig.getInstance().getT2Urls();
        for (int i2 = 0; i2 < t2Urls.size(); i2++) {
            String string2 = t2Urls.getString(i2);
            if (!TextUtils.isEmpty(string2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<script charset=\"UTF-8\" src=\"");
                sb2.append(string2);
                sb2.append("\"></script>");
                str = str.replace(sb2.toString(), "").replace(string2, "");
            }
        }
        return str;
    }

    public static boolean deleteSnapshot(App app, AppModel appModel, String str, boolean z) {
        if (PreloadInitializer.canSnapshot(app)) {
            String a2 = a(app, appModel, str, z);
            String[] strArr = {a2, a2.replace("index.snapshot.html", "titleBar.snapshot.json")};
            for (int i = 0; i < 2; i++) {
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
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {all -> 0x006f, blocks: (B:9:0x001e, B:11:0x0029, B:13:0x002f, B:15:0x0034, B:19:0x0060, B:16:0x0049), top: B:26:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] loadSnapshotFile(com.alibaba.ariver.app.api.App r2, com.alibaba.ariver.resource.api.models.AppModel r3, java.lang.String r4, boolean r5, boolean r6) {
        /*
            java.lang.String r4 = getPagePathFromPageUrl(r4)
            java.lang.String r2 = a(r2, r3, r4, r6)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "AriverRes:SnapshotProvider"
            r5 = 0
            if (r3 == 0) goto L17
            java.lang.String r2 = "snapshotFilePath is null"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r4, r2)
            return r5
        L17:
            boolean r3 = b(r2)
            if (r3 == 0) goto L1e
            return r5
        L1e:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L6f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r3.exists()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L49
            byte[] r3 = readFile(r3)     // Catch: java.lang.Throwable -> L6f
            if (r3 == 0) goto L5d
            int r0 = r3.length     // Catch: java.lang.Throwable -> L6f
            r1 = 100
            if (r0 <= r1) goto L5d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "snapshot file existed: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            r0.append(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L6f
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r4, r2)     // Catch: java.lang.Throwable -> L6f
            goto L5e
        L49:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r3.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = "snapshot file not existed: "
            r3.append(r0)     // Catch: java.lang.Throwable -> L6f
            r3.append(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L6f
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r4, r2)     // Catch: java.lang.Throwable -> L6f
        L5d:
            r3 = r5
        L5e:
            if (r6 == 0) goto L6e
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L6f
            java.lang.String r6 = "utf-8"
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L6f
            boolean r2 = c(r2)     // Catch: java.lang.Throwable -> L6f
            if (r2 != 0) goto L6e
            return r5
        L6e:
            return r3
        L6f:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = " loadSnapshotFile error: "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r4, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.snapshot.GriverRVSnapshotUtils.loadSnapshotFile(com.alibaba.ariver.app.api.App, com.alibaba.ariver.resource.api.models.AppModel, java.lang.String, boolean, boolean):byte[]");
    }

    private static boolean b(String str) {
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

    private static String a(App app, AppModel appModel, String str, boolean z) {
        try {
            return b(app, appModel, str, z);
        } catch (Exception e) {
            RVLogger.w("AriverRes:SnapshotProvider", "getSnapshotSavePath failed", e);
            return null;
        }
    }

    private static String b(App app, AppModel appModel, String str, boolean z) {
        String absolutePath;
        File extDirectory;
        String str2 = GriverAppxNgRuntimeChecker.isUseAppxNg(appModel) ? "appxV2_" : "appxV1_";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
        if (TextUtils.isEmpty(userId)) {
            userId = "000";
        }
        String replace = userId.replace('/', '_');
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
        String replace2 = str.replace('/', '_');
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("snapshot_");
            sb.append(str2);
            sb.append(replace2);
            sb.append("_");
            sb.append(replace);
            sb.append("_");
            sb.append("index.prerender.snapshot.html");
            return new File(absolutePath, sb.toString()).getAbsolutePath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("snapshot_");
        sb2.append(str2);
        sb2.append(replace2);
        sb2.append("_");
        sb2.append(replace);
        sb2.append("_");
        sb2.append("index.snapshot.html");
        return new File(absolutePath, sb2.toString()).getAbsolutePath();
    }

    private static boolean c(String str) {
        int indexOf;
        int indexOf2;
        int i;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("APPXNG_SNAPSHOT_{")) == -1 || (indexOf2 = str.indexOf("}", indexOf)) == -1 || indexOf2 <= indexOf) {
            return false;
        }
        String substring = str.substring(indexOf + 17, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        try {
            i = Integer.parseInt(substring);
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse hash_size error");
            sb.append(0);
            GriverLogger.w("AriverRes:SnapshotProvider", sb.toString());
            i = 0;
        }
        return i > 0 && i == (str.length() - substring.length()) + 13;
    }

    public static void writeToFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(str.getBytes());
        } catch (Throwable unused) {
            IOUtils.closeQuietly(fileOutputStream);
        }
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
