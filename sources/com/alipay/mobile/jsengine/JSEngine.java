package com.alipay.mobile.jsengine;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes6.dex */
public class JSEngine {
    public static String LIBV8LC_SO = "libv8lc.so";
    public static String LIBWEBVIEWUC_SO = "libwebviewuc.so";
    private static final String PLUGINS_LIB = "plugins_lib";
    public static String TAG = "jsengine";
    private static boolean mInitialized;
    private static String sLibWebViewUCSoPath;

    public static native int nativeHackElf(String str, String str2, String str3);

    public static native boolean nativeLinkAndroidNamespace(ClassLoader classLoader, ClassLoader classLoader2, String str);

    public static native long nativeLoadSo(String str);

    public static native int nativeVerifyElf(String str, String str2);

    public static native void setJSEngineOptions(String str, long j, int i, int i2, int i3);

    public static boolean Initialize(Delegate delegate) {
        if (mInitialized) {
            return true;
        }
        synchronized (JSEngine.class) {
            if (mInitialized) {
                return true;
            }
            System.loadLibrary("heb4cb");
            try {
                cloneUCSoFilesIfNeeded(delegate);
                loadV8SoFiles(delegate);
                mInitialized = true;
                return true;
            } catch (Throwable th) {
                LogData seedId = LogData.seedId("TINY_APP_JS_ENGINE");
                seedId.param1().add("type", "exception").param2().add("message", th.getMessage().replace("\n", " ")).param3().add("diskInfo", delegate.getDiskInfo());
                delegate.log(seedId);
                delegate.e(TAG, "JSEngine failed to initialize", th);
                return false;
            }
        }
    }

    public static String getWebViewCoreSoPath(Delegate delegate) {
        String webViewCoreSoPath = delegate.getWebViewCoreSoPath();
        if (!TextUtils.isEmpty(webViewCoreSoPath) && !webViewCoreSoPath.contains(LIBWEBVIEWUC_SO)) {
            StringBuilder sb = new StringBuilder();
            sb.append(webViewCoreSoPath);
            sb.append("/");
            sb.append(LIBWEBVIEWUC_SO);
            webViewCoreSoPath = sb.toString();
        }
        if (TextUtils.isEmpty(webViewCoreSoPath) || !file_exists(webViewCoreSoPath)) {
            String str = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebViewCoreSoPath => ");
            sb2.append(webViewCoreSoPath);
            delegate.d(str, sb2.toString());
            delegate.unzipWebViewCoreSo();
            webViewCoreSoPath = delegate.getWebViewCoreSoPath();
            if (TextUtils.isEmpty(webViewCoreSoPath)) {
                LogData seedId = LogData.seedId("TINY_APP_JS_ENGINE");
                seedId.param1().add("type", "exception").param2().add("message", "getWebViewCoreSoPath return null");
                delegate.log(seedId);
                throw new IllegalStateException("getWebViewCoreSoPath return null");
            }
            if (!webViewCoreSoPath.contains(LIBWEBVIEWUC_SO)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(webViewCoreSoPath);
                sb3.append("/");
                sb3.append(LIBWEBVIEWUC_SO);
                webViewCoreSoPath = sb3.toString();
            }
            if (!file_exists(webViewCoreSoPath)) {
                throw new IllegalStateException("UC library can not found");
            }
        }
        return webViewCoreSoPath;
    }

    private static String getPluginsLibDir(Context context) {
        return context.getDir(PLUGINS_LIB, 0).getAbsolutePath();
    }

    public static String getV8SoAbsolutePath(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPluginsLibDir(context));
        sb.append("/");
        sb.append(LIBV8LC_SO);
        return sb.toString();
    }

    public static String getLibWebViewUCSoPath() {
        return sLibWebViewUCSoPath;
    }

    public static void cloneUCSoFilesIfNeeded(Delegate delegate) {
        int i;
        String webViewCoreSoPath = getWebViewCoreSoPath(delegate);
        sLibWebViewUCSoPath = webViewCoreSoPath;
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        StringBuilder sb = new StringBuilder();
        sb.append(v8SoAbsolutePath);
        sb.append(".lock");
        Object takeProcessLock = delegate.takeProcessLock(sb.toString());
        if (file_exists(v8SoAbsolutePath)) {
            i = nativeVerifyElf(v8SoAbsolutePath, LIBV8LC_SO);
            if (i == 0) {
                delegate.releaseProcessLock(takeProcessLock);
                return;
            }
            String str = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LIBV8LC_SO);
            sb2.append(" is invalid, err: ");
            sb2.append(i);
            delegate.e(str, sb2.toString());
            safeDeleteFile(v8SoAbsolutePath);
        } else {
            i = -1;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                i = nativeHackElf(webViewCoreSoPath, v8SoAbsolutePath, LIBV8LC_SO);
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("modifySoname ");
                sb3.append(webViewCoreSoPath);
                sb3.append(" -> ");
                sb3.append(v8SoAbsolutePath);
                sb3.append(" : ");
                sb3.append(i);
                sb3.append(", cost: ");
                sb3.append(System.currentTimeMillis() - currentTimeMillis);
                delegate.d(str2, sb3.toString());
                if (i == 0) {
                    i = nativeVerifyElf(v8SoAbsolutePath, LIBV8LC_SO);
                    if (i == 0) {
                        break;
                    }
                    String str3 = TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(LIBV8LC_SO);
                    sb4.append(" is invalid, err: ");
                    sb4.append(i);
                    delegate.e(str3, sb4.toString());
                }
                safeDeleteFile(v8SoAbsolutePath);
                safeSleep(200L);
            } catch (Throwable th) {
                String str4 = TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("modifySoname exception ");
                sb5.append(th);
                delegate.d(str4, sb5.toString());
            }
        }
        delegate.releaseProcessLock(takeProcessLock);
        if (i == 0) {
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("modifySoname failed rc=");
        sb6.append(i);
        throw new IllegalStateException(sb6.toString());
    }

    public static void loadV8SoFiles(Delegate delegate) {
        if (!loadLibraryEx(delegate, "v8lc") && nativeLoadSo(getV8SoAbsolutePath(delegate.getContext())) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed to load ");
            sb.append(LIBV8LC_SO);
            String obj = sb.toString();
            delegate.e(TAG, obj);
            throw new IllegalStateException(obj);
        }
        delegate.d(TAG, "successfully loaded V8 library");
    }

    private static boolean loadLibraryEx(Delegate delegate, String str) {
        try {
            System.loadLibrary(str);
            return false;
        } catch (Throwable th) {
            delegate.e(TAG, "Runtime loadLibrary exception", th);
            LogData seedId = LogData.seedId("TINY_APP_JS_ENGINE");
            seedId.param1().add("type", "exception").param2().add("message", th.getMessage().replace("\n", " "));
            delegate.log(seedId);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void safeSleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void safeDeleteFile(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean file_exists(String str) {
        return new File(str).exists();
    }
}
