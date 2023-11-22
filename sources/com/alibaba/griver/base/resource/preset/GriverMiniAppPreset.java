package com.alibaba.griver.base.resource.preset;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ZipUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class GriverMiniAppPreset {
    private static int PlaceComponentResult = 1;

    /* renamed from: a  reason: collision with root package name */
    private static String f6374a = "Griver/preset/";
    private static final GriverMiniAppPresetConfig b = new GriverMiniAppPresetConfig(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_PRESET_APP_CONFIG, ""));
    private static int getAuthRequestContext;

    private static AppModel a(String str) {
        Object th;
        AppModel appModel;
        Resources resources;
        try {
            resources = GriverEnv.getResources();
        } catch (Throwable th2) {
            th = th2;
            appModel = null;
        }
        if (resources == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f6374a);
        sb.append(str);
        sb.append(".json");
        appModel = (AppModel) JSON.parseObject(a(resources, sb.toString()), AppModel.class);
        if (appModel != null) {
            try {
                if (appModel.getAppInfoModel() == null) {
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getPresetAppInfos error, e=");
                sb2.append(th);
                GriverLogger.e("GriverMiniAppPreset", sb2.toString());
                return appModel;
            }
        }
        return appModel;
    }

    private static InputStream a(String str, String str2, boolean z) {
        String obj;
        try {
            Resources resources = GriverEnv.getResources();
            if (resources == null) {
                return null;
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(f6374a);
                sb.append(str);
                sb.append("_");
                sb.append(str2);
                sb.append("_");
                sb.append("appx2");
                sb.append(".amr");
                obj = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f6374a);
                sb2.append(str);
                sb2.append("_");
                sb2.append(str2);
                sb2.append("_");
                sb2.append("appx1");
                sb2.append(".amr");
                obj = sb2.toString();
            }
            return b(resources, obj);
        } catch (Exception e) {
            GriverLogger.e("GriverMiniAppPreset", "get preset package failed", e);
            return null;
        }
    }

    public static AppModel getPresetAppModel(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && b(str) && AppInfoScene.ONLINE.toString().equalsIgnoreCase(BundleUtils.getString(bundle, AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()))) {
            if ((TextUtils.isEmpty(GriverEnv.getEnvironment()) || "prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim())) && GriverAppCenter.queryHighestAppInfo(str) == null) {
                return a(str);
            }
            return null;
        }
        return null;
    }

    private static boolean b(String str) {
        if (b.isDisable()) {
            return false;
        }
        return !r0.getBlacklist().contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v28, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.res.Resources r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.resource.preset.GriverMiniAppPreset.a(android.content.res.Resources, java.lang.String):java.lang.String");
    }

    private static InputStream b(Resources resources, String str) {
        int i = getAuthRequestContext + 1;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            try {
                Object[] objArr = {resources.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - Color.blue(0)), (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 50 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                int i3 = PlaceComponentResult + 69;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return inputStream;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable unused) {
            RVLogger.e("not found resource");
            return null;
        }
    }

    public static boolean installPresetPackage(AppModel appModel) {
        String installPath;
        if (b(appModel.getAppId())) {
            InputStream a2 = a(appModel.getAppId(), appModel.getAppVersion(), GriverAppxNgRuntimeChecker.isUseAppxNg(appModel));
            try {
                if (a2 == null) {
                    return false;
                }
                try {
                    installPath = AppInfoUtils.getInstallPath(appModel);
                } catch (Exception unused) {
                    FileUtils.delete(AppInfoUtils.getInstallPath(appModel));
                }
                if (ZipUtils.unZip(a2, installPath) && AppInfoUtils.installPathValid(installPath)) {
                    for (String str : AppInfoUtils.getAllInstallFiles(appModel.getAppId())) {
                        if (!TextUtils.equals(str, installPath)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("delete old install path: ");
                            sb.append(str);
                            GriverLogger.d("GriverMiniAppPreset", sb.toString());
                            FileUtils.delete(str);
                        }
                    }
                    IOUtils.closeQuietly(a2);
                    return true;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unzip preset failed for appId: ");
                sb2.append(appModel.getAppId());
                sb2.append(", version: ");
                sb2.append(appModel.getAppVersion());
                GriverLogger.d("GriverMiniAppPreset", sb2.toString());
                FileUtils.delete(installPath);
                return false;
            } finally {
                IOUtils.closeQuietly(a2);
            }
        }
        return false;
    }

    public static void setPresetDir(String str) {
        if (GriverEnv.isDebuggable()) {
            f6374a = str;
        }
    }
}
