package com.alipay.zoloz.config;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alipay.zoloz.config.util.ConfigLog;
import com.alipay.zoloz.config.util.ConfigZipUtil;
import com.alipay.zoloz.config.util.FileUtil;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ConfigCenter {
    public static final int ENV_ONLINE = 0;
    public static final int ENV_TEST = 1;
    public static final String TAG = "ConfigCenter";
    private static final long WAITING_CONFIG_TIME = 100;
    private static ConfigCenter sInstance;
    private String baseTargetPath;
    private long configConsumeTime;
    private Context mAppContext;
    private String mConfigPath;
    private String uiConfigPath;
    public static final byte[] getAuthRequestContext = {Ascii.ESC, -74, -29, -66, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 35;
    private String assetsPath = "config";
    private CountDownLatch lockCount = new CountDownLatch(1);
    private ConfigDataParser configDataParser = new ConfigDataParser();
    private boolean isDebug = false;
    private String endPath = "/zoloz_config/";
    private boolean isConfigReady = false;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r9 = r9 * 12
            int r9 = 15 - r9
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.alipay.zoloz.config.ConfigCenter.getAuthRequestContext
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r7
            goto L38
        L1a:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1e:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r8) goto L2f
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2f:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L38:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.config.ConfigCenter.a(short, byte, short, java.lang.Object[]):void");
    }

    public static ConfigCenter getInstance() {
        ConfigCenter configCenter;
        synchronized (ConfigCenter.class) {
            if (sInstance == null) {
                sInstance = new ConfigCenter();
            }
            configCenter = sInstance;
        }
        return configCenter;
    }

    public Object getFrameworkValue(String str) {
        return this.configDataParser.getValueFromFramework(str);
    }

    public Object getFrameworkValueSync(String str) {
        if (this.isConfigReady) {
            return this.configDataParser.getValueFromFramework(str);
        }
        synchronized (this.lockCount) {
            try {
                this.lockCount.await(100L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                ConfigLog.e(TAG, e);
            }
        }
        return this.configDataParser.getValueFromFramework(str);
    }

    public Object getH5Value(String str) {
        if (this.isConfigReady) {
            return this.configDataParser.getValueFromH5(str);
        }
        synchronized (this.lockCount) {
            try {
                this.lockCount.await(100L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                ConfigLog.e(TAG, e);
            }
        }
        return this.configDataParser.getValueFromH5(str);
    }

    public String getUiConfigPath() {
        return this.uiConfigPath;
    }

    public String getFeUIConfig() {
        ConfigDataParser configDataParser = this.configDataParser;
        if (configDataParser != null) {
            return configDataParser.getFeUIConfig();
        }
        return null;
    }

    public String getRSAPublicKey(int i) {
        Context context;
        String str = (String) getBizConfig().get("public_key");
        if (str == null) {
            if (i == 1) {
                str = (String) getFrameworkValueSync(ConfigConstants.PUBLIC_KEY_T);
            } else {
                str = (String) getFrameworkValueSync("public_key");
            }
        }
        return (str != null || (context = this.mAppContext) == null) ? str : RSAKeyParser.getPublicKey(context, i);
    }

    public String getRSAPublicKey() {
        Object frameworkValue = getFrameworkValue("env");
        if (frameworkValue == null) {
            frameworkValue = getFrameworkValue("ENV");
        }
        if (frameworkValue == null) {
            return getRSAPublicKey(0);
        }
        if (frameworkValue instanceof String) {
            return getRSAPublicKey(Integer.parseInt((String) frameworkValue));
        }
        if (frameworkValue instanceof Integer) {
            return getRSAPublicKey(((Integer) frameworkValue).intValue());
        }
        return getRSAPublicKey(0);
    }

    public void init(Context context, final String str, final IConfigCenterCallback iConfigCenterCallback) {
        this.mAppContext = context.getApplicationContext();
        this.mConfigPath = str;
        synchronized (this) {
            if (!this.isConfigReady) {
                new Thread(new Runnable() { // from class: com.alipay.zoloz.config.ConfigCenter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConfigCenter.this) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            ConfigCenter.this.deleteOldCache();
                            if (!TextUtils.isEmpty(str)) {
                                if (!str.contains("/") && !str.contains(PhotoContext.FILE_SCHEME)) {
                                    ConfigCenter.this.assetsPath = str;
                                    ConfigCenter configCenter = ConfigCenter.this;
                                    configCenter.unZipConfigByAssets(configCenter.mAppContext, str);
                                }
                                ConfigCenter configCenter2 = ConfigCenter.this;
                                configCenter2.unzipConfigByLocalFile(configCenter2.mAppContext, str);
                            }
                            ConfigCenter configCenter3 = ConfigCenter.this;
                            configCenter3.isConfigReady = configCenter3.configDataParser.parseAndVerifyConfig(iConfigCenterCallback);
                            ConfigCenter.this.configConsumeTime = SystemClock.uptimeMillis() - uptimeMillis;
                            long unused = ConfigCenter.this.configConsumeTime;
                            ConfigCenter.this.lockCount.countDown();
                        }
                    }
                }).start();
            } else {
                iConfigCenterCallback.onConfigSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOldCache() {
        if (this.baseTargetPath == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getApplicationContext().getFilesDir().getPath());
            sb.append(this.endPath);
            this.baseTargetPath = sb.toString();
        }
        FileUtil.delete(this.baseTargetPath);
    }

    public void init(Context context, IConfigCenterCallback iConfigCenterCallback) {
        init(context, null, iConfigCenterCallback);
    }

    public String getBaseTargetPath() {
        return this.baseTargetPath;
    }

    public void addAll(HashMap hashMap) {
        this.configDataParser.addAll(hashMap);
    }

    public void add(String str, Object obj) {
        this.configDataParser.addOne(str, obj);
    }

    public void disableConfig() {
        this.isConfigReady = false;
        this.configDataParser.disable();
        this.lockCount = new CountDownLatch(1);
    }

    public void reloadConfigByPath(final String str, final IConfigCenterCallback iConfigCenterCallback) {
        this.isConfigReady = false;
        new Thread(new Runnable() { // from class: com.alipay.zoloz.config.ConfigCenter.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ConfigCenter.this) {
                    ConfigCenter.this.unZipConfig(str);
                    ConfigCenter configCenter = ConfigCenter.this;
                    configCenter.isConfigReady = configCenter.configDataParser.parseAndVerifyConfig(iConfigCenterCallback);
                    ConfigCenter.this.lockCount.countDown();
                }
            }
        }).start();
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isConfigReady() {
        return this.isConfigReady;
    }

    public void setUiConfigPath(String str) {
        this.uiConfigPath = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUIConfigExist() {
        if (TextUtils.isEmpty(this.mConfigPath)) {
            AssetManager assets = getInstance().getApplicationContext().getAssets();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(getInstance().getAssetsPath());
                sb.append("/");
                return assets.list(sb.toString()).length > 0;
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unZipConfigByAssets(Context context, String str) {
        boolean copyAssetsToTarget;
        ConfigLog.d(TAG, "unZipConfig");
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        sb.append(this.endPath);
        sb.append(this.assetsPath);
        this.baseTargetPath = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getPath());
        sb2.append(this.endPath);
        String obj = sb2.toString();
        this.configDataParser.setBaseTargetPath(this.baseTargetPath);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" unzip base path ");
        sb3.append(this.baseTargetPath);
        ConfigLog.d(TAG, sb3.toString());
        if (str.contains(".zip")) {
            copyAssetsToTarget = ConfigZipUtil.unzip(context, str, this.baseTargetPath);
        } else {
            copyAssetsToTarget = ConfigZipUtil.copyAssetsToTarget(context, str, obj);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" unzip base path ok? ");
        sb4.append(copyAssetsToTarget);
        ConfigLog.d(TAG, sb4.toString());
        this.isConfigReady = copyAssetsToTarget;
        return copyAssetsToTarget;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unZipConfig(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(" unZipConfig by hot reload from ");
        sb.append(str);
        ConfigLog.d(TAG, sb.toString());
        boolean unzip = ConfigZipUtil.unzip(str, this.baseTargetPath);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" unzip base path ok? ");
        sb2.append(unzip);
        ConfigLog.d(TAG, sb2.toString());
        this.isConfigReady = unzip;
        return unzip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unzipConfigByLocalFile(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("unZipConfig by local file path ");
        sb.append(str);
        ConfigLog.d(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getPath());
        sb2.append(this.endPath);
        sb2.append(this.assetsPath);
        String obj = sb2.toString();
        this.baseTargetPath = obj;
        this.configDataParser.setBaseTargetPath(obj);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" unzip base path ");
        sb3.append(this.baseTargetPath);
        ConfigLog.d(TAG, sb3.toString());
        boolean unzip = ConfigZipUtil.unzip(str, this.baseTargetPath);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" unzip base path ok? ");
        sb4.append(unzip);
        ConfigLog.d(TAG, sb4.toString());
        this.isConfigReady = unzip;
        return unzip;
    }

    public Context getApplicationContext() {
        return this.mAppContext;
    }

    public void setApplicationContext(Context context) {
        try {
            byte b = (byte) (getAuthRequestContext[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = getAuthRequestContext[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            if (context instanceof Activity) {
                this.mAppContext = context.getApplicationContext();
            } else {
                this.mAppContext = context;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public void release() {
        disableConfig();
        sInstance = null;
    }

    public long getConfigConsumeTime() {
        return this.configConsumeTime;
    }

    public HashMap<String, Object> getBizConfig() {
        return this.configDataParser.getBizConfig();
    }

    public HashMap<String, Object> getFrameworkConfigs() {
        return this.configDataParser.getFrameworkConfigs();
    }

    public String getAssetsPath() {
        return this.assetsPath;
    }

    public void setAssetsPath(String str) {
        this.assetsPath = str;
    }
}
