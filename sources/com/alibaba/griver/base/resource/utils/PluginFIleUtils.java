package com.alibaba.griver.base.resource.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.griver.base.common.env.GriverEnv;
import java.io.File;

/* loaded from: classes6.dex */
public class PluginFIleUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f6378a = "griver/ng/installed";
    private static String b = "griver/ng/downloaded";

    public static boolean installPathExist(PluginModel pluginModel) {
        if (pluginModel == null) {
            return false;
        }
        return installPathValid(getInstalledPath(pluginModel));
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

    public static String getInstalledPath(PluginModel pluginModel) {
        return new File(new File(a(), pluginModel.getAppId()), a(pluginModel.getNewPackageUrl(), pluginModel.getVersion())).getAbsolutePath();
    }

    private static String a() {
        String str = f6378a;
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

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? FileUtils.getMD5(str) : str2;
    }
}
