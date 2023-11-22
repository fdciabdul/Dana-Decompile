package com.alibaba.griver.base.common.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PluginInfoUtil {

    /* renamed from: a  reason: collision with root package name */
    private static String f6316a = "PluginInfoUtil";
    private static String b = "griver/plugin/installed";
    private static String c = "griver/plugin/downloaded";

    public static File getDownloadFile(PluginModel pluginModel) {
        String b2 = b();
        StringBuilder sb = new StringBuilder();
        sb.append(pluginModel.getAppId());
        sb.append("-");
        sb.append(a(pluginModel.getNewPackageUrl(), pluginModel.getVersion()));
        return new File(b2, sb.toString());
    }

    public static boolean installPathExits(PluginModel pluginModel) {
        if (pluginModel == null) {
            return false;
        }
        return installPathValid(a(pluginModel));
    }

    private static String a(PluginModel pluginModel) {
        return new File(new File(a(), pluginModel.getAppId()), a(pluginModel.getNewPackageUrl(), pluginModel.getVersion())).getAbsolutePath();
    }

    public static List<String> getAllInstallFIles(String str) {
        return new ArrayList();
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

    public static String getInstallPath(PluginModel pluginModel) {
        if (pluginModel == null) {
            return null;
        }
        return b(pluginModel.getAppId(), pluginModel.getVersion(), pluginModel.getNewPackageUrl());
    }

    public static String getInstallParentPath(PluginModel pluginModel) {
        if (pluginModel == null) {
            return null;
        }
        return a(pluginModel.getAppId(), pluginModel.getVersion(), pluginModel.getNewPackageUrl());
    }

    public static boolean installPathExist(PluginModel pluginModel) {
        if (pluginModel == null) {
            return false;
        }
        return installPathValid(getInstallPath(pluginModel));
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            String str4 = f6316a;
            StringBuilder sb = new StringBuilder();
            sb.append("get install path, but parameter is empty, pluginId: ");
            sb.append(str);
            sb.append(", version: ");
            sb.append(str2);
            sb.append(", downloadUrl: ");
            sb.append(str3);
            GriverLogger.w(str4, sb.toString());
            return null;
        }
        String a2 = a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        return new File(a2, sb2.toString()).getAbsolutePath();
    }

    private static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            String str4 = f6316a;
            StringBuilder sb = new StringBuilder();
            sb.append("get install path, but parameter is empty, pluginId: ");
            sb.append(str);
            sb.append(", version: ");
            sb.append(str2);
            sb.append(", downloadUrl: ");
            sb.append(str3);
            GriverLogger.w(str4, sb.toString());
            return null;
        }
        String a2 = a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        return new File(new File(a2, sb2.toString()), a(str3, str2)).getAbsolutePath();
    }

    private static String a() {
        String str = b;
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

    private static String b() {
        File file;
        String str = c;
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
                GriverLogger.w(f6316a, "external file is not available, use inner storage");
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

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? FileUtils.getMD5(str) : str2;
    }
}
