package com.alibaba.griver.base.common.env;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.env.GriverEnvExtension;
import com.alibaba.griver.api.common.env.GriverVerifyPublicKeyProxy;
import com.alibaba.griver.api.ui.GriverAppExtension;
import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.KitUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.android.iaptinylog.IAPTinyLogger;
import com.iap.android.iaptinylog.data.IAPTinyLogType;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

/* loaded from: classes.dex */
public class GriverEnv {

    /* renamed from: a  reason: collision with root package name */
    private static String f6287a;
    private static Application b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static volatile IAPTinyLogger g;
    private static Stack<Activity> h = new Stack<>();
    private static Boolean i = null;
    private static boolean j = false;
    private static boolean k = true;
    private static Boolean l = null;
    private static String m = null;
    private static DefaultConfig n = new DefaultConfig();

    /* renamed from: o  reason: collision with root package name */
    private static GriverVerifyPublicKeyProxy f6288o = new GriverVerifyPublicKeyProxy() { // from class: com.alibaba.griver.base.common.env.GriverEnv.1
        @Override // com.alibaba.griver.api.common.env.GriverVerifyPublicKeyProxy
        public final String getPublicKey() {
            return null;
        }
    };

    public static String defaultPlatform() {
        return "AP";
    }

    public static boolean isBackgroundRunning() {
        return false;
    }

    public static void openUrl(String str) {
    }

    public static Application getApplicationContext() {
        if (b == null) {
            Application a2 = a();
            b = a2;
            a(a2);
        }
        return b;
    }

    public static WeakReference<Activity> getTopActivity() {
        if (h.size() == 0) {
            return null;
        }
        return new WeakReference<>(h.peek());
    }

    public static int getLpid() {
        try {
        } catch (Exception e2) {
            GriverLogger.e("GriverEnv", "getLpid faild", e2);
        }
        if (ProcessUtils.isMainProcess()) {
            return 0;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getApplicationContext().getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getRunningAppProcesses()) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 = runningAppProcessInfo;
            if (runningAppProcessInfo.pid == myPid) {
                String str = runningAppProcessInfo.processName;
                StringBuilder sb = new StringBuilder();
                sb.append("get lpid, process name: ");
                sb.append(str);
                GriverLogger.d("GriverEnv", sb.toString());
                if (!TextUtils.isEmpty(str)) {
                    return Integer.valueOf(str.substring(str.length() - 1)).intValue();
                }
            }
        }
        return 0;
    }

    public static Resources getResources() {
        Application application = b;
        if (application == null) {
            return null;
        }
        return application.getResources();
    }

    public static String getProductVersion() {
        try {
            return getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (Exception e2) {
            GriverLogger.e("GriverEnv", "getVersion error!", e2);
            return null;
        }
    }

    public static String convertPlatform(String str) {
        if ("1".equals(str)) {
            return "AP";
        }
        if ("2".equals(str)) {
            return "TB";
        }
        return null;
    }

    public static String getAppName() {
        String appName = ((GriverEnvExtension) RVProxy.get(GriverEnvExtension.class)).getAppName();
        if (TextUtils.isEmpty(appName)) {
            if (!TextUtils.isEmpty(m)) {
                return m;
            }
            JSONObject parseObject = JSON.parseObject(KitUtils.getAssetContent(getApplicationContext(), GriverBaseConstants.GRIVER_APP_ASSET_PATH));
            if (parseObject != null && parseObject.containsKey("appName")) {
                m = parseObject.getString("appName");
            }
        } else {
            m = appName;
        }
        return m;
    }

    public static boolean isUseSignV2Request() {
        JSONObject parseObject;
        if (l == null && (parseObject = JSON.parseObject(KitUtils.getAssetContent(getApplicationContext(), GriverBaseConstants.GRIVER_APP_ASSET_PATH))) != null && parseObject.containsKey(GriverBaseConstants.KEY_USE_SIGN_V2_REQUEST)) {
            l = parseObject.getBoolean(GriverBaseConstants.KEY_USE_SIGN_V2_REQUEST);
        }
        if (l == null) {
            l = Boolean.FALSE;
        }
        return l.booleanValue();
    }

    public static String getAppLanguage() {
        return ((GriverAppLanguageExtension) RVProxy.get(GriverAppLanguageExtension.class)).getAppLanguage();
    }

    public static void setApplication(Application application) {
        if (application == null) {
            GriverLogger.e("GriverEnv", "application is null, return directly", null);
        } else if (b != null) {
            GriverLogger.w("GriverEnv", "application has been set, ignore this", null);
        } else {
            b = application;
            a(application);
        }
    }

    private static void a(Application application) {
        if (application == null) {
            GriverLogger.w("GriverEnv", "application is null, can not register lifecycle");
        } else {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.griver.base.common.env.GriverEnv.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    GriverEnv.h.push(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                    boolean unused = GriverEnv.j = true;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                    boolean unused = GriverEnv.j = false;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                    GriverEnv.h.remove(activity);
                }
            });
        }
    }

    public static boolean isForeground() {
        return j;
    }

    public static String getVerifyPulickey() {
        return f6288o.getPublicKey();
    }

    public static void setVerifyPublicKeyProxy(GriverVerifyPublicKeyProxy griverVerifyPublicKeyProxy) {
        if (griverVerifyPublicKeyProxy != null) {
            f6288o = griverVerifyPublicKeyProxy;
        }
    }

    private static Application a() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e2) {
            GriverLogger.e("GriverEnv", "get application failed", e2);
            return null;
        }
    }

    public static boolean isDebuggable() {
        Boolean bool = i;
        if (bool == null) {
            try {
                Boolean valueOf = Boolean.valueOf((getApplicationContext().getApplicationInfo().flags & 2) != 0);
                i = valueOf;
                return valueOf.booleanValue();
            } catch (Throwable th) {
                InstrumentInjector.log_e("GriverEnv", "exception detail", th);
                return false;
            }
        }
        return bool.booleanValue();
    }

    public static String getAppId() {
        return f6287a;
    }

    public static void setAppId(String str) {
        f6287a = str;
    }

    public static String getWorkSpaceId() {
        return c;
    }

    public static void setWorkSpaceId(String str) {
        c = str;
    }

    public static String getEnvironment() {
        return d;
    }

    public static void setEnvironment(String str) {
        d = str;
    }

    public static App getAppByUrl(String str) {
        return ((GriverAppExtension) RVProxy.get(GriverAppExtension.class)).getAppByUrl(str);
    }

    public static String getGateway() {
        return e;
    }

    public static void setGateway(String str) {
        e = str;
    }

    public static void setDebuggable(boolean z) {
        synchronized (GriverEnv.class) {
            k = z;
        }
    }

    public static IAPTinyLogger getLogger() {
        if (g == null) {
            synchronized (GriverEnv.class) {
                if (g == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(TextUtils.isEmpty(getAppId()) ? "GRIVER" : getAppId());
                    stringBuffer.append("_");
                    stringBuffer.append(TextUtils.isEmpty(getEnvironment()) ? "PROD" : getEnvironment());
                    stringBuffer.append("_");
                    stringBuffer.append("Android");
                    g = new IAPTinyLogger(stringBuffer.toString(), "GriverAppContainer");
                    IAPTinyLogger.PlaceComponentResult(IAPTinyLogType.LOG_TYPE_DIAGNOSE);
                }
            }
        }
        return g;
    }

    public static boolean getDebuggable() {
        boolean z;
        synchronized (GriverEnv.class) {
            z = k;
        }
        return z;
    }

    public static String getAlwaysShowDiagnosticTool() {
        return f;
    }

    public static void setAlwaysShowDiagnosticTool(String str) {
        f = str;
    }

    public static void setAppName(String str) {
        m = str;
    }

    public static String getUtdid(Context context) {
        return InstanceInfo.getInstanceId(context);
    }

    public static DefaultConfig getDefaultConfig() {
        return n;
    }

    public static void setDefaultConfig(DefaultConfig defaultConfig) {
        n = defaultConfig;
    }
}
