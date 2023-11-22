package com.alipay.mobile.jsengine;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes6.dex */
public class JSEngine2 {
    public static String LIBV8UC_SO = "libv8uc.so";
    public static String LIBWEBVIEWUC_SO = "libwebviewuc.so";
    private static final String PLUGINS_LIB = "plugins_lib";
    private static String SHARED_SO_NAMES = "libv8uc.so:libjsengine-platform.so:libjsengine-api.so";
    public static String TAG = "jsengine";
    private static volatile boolean mInitialized;
    private static volatile boolean mJ2V8Loaded;
    public static long sCopySoCost;
    public static long sInitUCCost;
    private static String sLibWebViewUCSoPath;
    public static long sLoadSoCost;

    public static boolean initializeForV8Test(Delegate delegate) {
        return false;
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (JSEngine2.class) {
            z = mInitialized;
        }
        return z;
    }

    public static JSEngineStatus getStatus(Context context, boolean z) {
        if (mInitialized) {
            return JSEngineStatus.HOT;
        }
        if (context != null && z && JSEngine.file_exists(getV8SoAbsolutePath(context))) {
            return JSEngineStatus.WARM;
        }
        return JSEngineStatus.COLD;
    }

    public static boolean Initialize(Delegate delegate) {
        boolean Initialize;
        synchronized (JSEngine2.class) {
            Initialize = Initialize(delegate, JSEngine.class.getClassLoader(), true);
        }
        return Initialize;
    }

    public static boolean Initialize(Delegate delegate, ClassLoader classLoader, boolean z) {
        synchronized (JSEngine2.class) {
            if (mInitialized) {
                if (z && !mJ2V8Loaded) {
                    if (!loadLibraryEx(delegate, "jsengine-api")) {
                        return false;
                    }
                    mJ2V8Loaded = true;
                }
                return true;
            }
            synchronized (JSEngine.class) {
                if (mInitialized) {
                    return true;
                }
                System.loadLibrary("heb4cb");
                try {
                    cloneUCSoFilesIfNeeded(delegate);
                    loadV8SoFiles(delegate, classLoader, z);
                    setOptions(delegate);
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
    }

    public static boolean linkAndroidNamespace(ClassLoader classLoader, String str) {
        return classLoader == JSEngine.class.getClassLoader() || Build.VERSION.SDK_INT <= 23;
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
        if (TextUtils.isEmpty(webViewCoreSoPath) || !JSEngine.file_exists(webViewCoreSoPath)) {
            String str = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebViewCoreSoPath => ");
            sb2.append(webViewCoreSoPath);
            delegate.d(str, sb2.toString());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            delegate.unzipWebViewCoreSo();
            sInitUCCost = SystemClock.elapsedRealtime() - elapsedRealtime;
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
            if (!JSEngine.file_exists(webViewCoreSoPath)) {
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
        sb.append(LIBV8UC_SO);
        return sb.toString();
    }

    public static String getLibWebViewUCSoPath() {
        return sLibWebViewUCSoPath;
    }

    private static void showDiskInfo(Delegate delegate) {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = ((statFs.getAvailableBlocks() * blockSize) / ConvertUtils.KB) / ConvertUtils.KB;
            long blockCountLong = (((Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : statFs.getBlockCount()) * blockSize) / ConvertUtils.KB) / ConvertUtils.KB;
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("availableSpace: ");
            sb.append(availableBlocks);
            sb.append("MB, totalSpace: ");
            sb.append(blockCountLong);
            sb.append("MB");
            delegate.d(str, sb.toString());
        } catch (Throwable th) {
            delegate.e(TAG, "showDiskInfo", th);
        }
    }

    private static boolean checkAndVerifySoIfNeeded(Delegate delegate, String str, String str2) {
        if (new File(delegate.getContext().getFilesDir(), "v8loading").exists()) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" not exists");
            delegate.d(str3, sb.toString());
            return false;
        }
        if (delegate.isDebug()) {
            File file2 = new File(str2);
            if (file.length() != file2.length()) {
                String str4 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("length of so file mismatch: ");
                sb2.append(file.length());
                sb2.append(" vs ");
                sb2.append(file2.length());
                delegate.d(str4, sb2.toString());
                return false;
            } else if (file.lastModified() < file2.lastModified()) {
                String str5 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("old timestamp: ");
                sb3.append(file.lastModified());
                sb3.append(" vs ");
                sb3.append(file2.lastModified());
                delegate.d(str5, sb3.toString());
                return false;
            }
        }
        int config = delegate.getConfig("ta_v8_verify_so", 1);
        if (config == 0) {
            String str6 = TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("VerifySo disabled, ta_v8_verify_so => ");
            sb4.append(config);
            delegate.d(str6, sb4.toString());
            return true;
        }
        if (config > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("_");
            sb5.append(file.lastModified());
            sb5.append("_");
            sb5.append(file.length());
            String obj = sb5.toString();
            File file3 = new File(obj);
            String str7 = TAG;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(obj);
            sb6.append(" exists => ");
            sb6.append(file3.exists());
            delegate.d(str7, sb6.toString());
            if (!file3.exists()) {
                return false;
            }
        }
        return true;
    }

    private static void createStampIfNeeded(Delegate delegate, String str) {
        int config = delegate.getConfig("ta_v8_verify_so", 1);
        if (config == 0) {
            return;
        }
        File file = new File(str);
        if (config > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(file.lastModified());
            sb.append("_");
            sb.append(file.length());
            String obj = sb.toString();
            File file2 = new File(obj);
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(" exists => ");
            sb2.append(file2.exists());
            delegate.d(str2, sb2.toString());
            if (file2.exists()) {
                return;
            }
            try {
                boolean createNewFile = file2.createNewFile();
                String str3 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append(" creating success => ");
                sb3.append(createNewFile);
                delegate.d(str3, sb3.toString());
            } catch (Throwable th) {
                String str4 = TAG;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj);
                sb4.append(" creating exception");
                delegate.e(str4, sb4.toString(), th);
            }
        }
    }

    public static void cloneUCSoFilesIfNeeded(Delegate delegate) {
        int i;
        String webViewCoreSoPath = getWebViewCoreSoPath(delegate);
        sLibWebViewUCSoPath = webViewCoreSoPath;
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(v8SoAbsolutePath);
        sb.append(".lock");
        Object takeProcessLock = delegate.takeProcessLock(sb.toString());
        if (delegate.getConfig("config_enable_storage_opt", 0) == 1) {
            if (delegate.getConfig("ta_v8_delete_temp_files", 1) == 1) {
                try {
                    for (File file : delegate.getContext().getDir(PLUGINS_LIB, 0).listFiles(new FilenameFilter() { // from class: com.alipay.mobile.jsengine.JSEngine2.1
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file2, String str) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(JSEngine2.LIBV8UC_SO);
                            sb2.append("_t");
                            return str.startsWith(sb2.toString());
                        }
                    })) {
                        file.delete();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (checkAndVerifySoIfNeeded(delegate, v8SoAbsolutePath, webViewCoreSoPath)) {
            i = JSEngine.nativeVerifyElf(v8SoAbsolutePath, LIBV8UC_SO);
            if (i == 0) {
                delegate.releaseProcessLock(takeProcessLock);
                return;
            }
            String str = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LIBV8UC_SO);
            sb2.append(" is invalid, err: ");
            sb2.append(i);
            delegate.e(str, sb2.toString());
            JSEngine.safeDeleteFile(v8SoAbsolutePath);
        } else {
            i = -1;
        }
        showDiskInfo(delegate);
        for (int i2 = 0; i2 < 10; i2++) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                i = JSEngine.nativeHackElf(webViewCoreSoPath, v8SoAbsolutePath, LIBV8UC_SO);
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
                    i = JSEngine.nativeVerifyElf(v8SoAbsolutePath, LIBV8UC_SO);
                    if (i == 0) {
                        break;
                    }
                    String str3 = TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(LIBV8UC_SO);
                    sb4.append(" is invalid, err: ");
                    sb4.append(i);
                    delegate.e(str3, sb4.toString());
                }
                JSEngine.safeDeleteFile(v8SoAbsolutePath);
                JSEngine.safeSleep(200L);
            } catch (Throwable th) {
                String str4 = TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("modifySoname exception ");
                sb5.append(th);
                delegate.d(str4, sb5.toString());
            }
        }
        delegate.releaseProcessLock(takeProcessLock);
        sCopySoCost = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (i == 0) {
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("modifySoname failed rc=");
        sb6.append(i);
        throw new IllegalStateException(sb6.toString());
    }

    public static void loadV8SoFiles(Delegate delegate, ClassLoader classLoader, boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String v8SoAbsolutePath = getV8SoAbsolutePath(delegate.getContext());
        File file = new File(delegate.getContext().getFilesDir(), "v8loading");
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
        NativeLibs.addExtraNativeLibraryDirectories(delegate, delegate.getContext(), classLoader);
        if (!loadLibraryEx(delegate, "v8uc") && JSEngine.nativeLoadSo(v8SoAbsolutePath) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("failed to load ");
            sb.append(LIBV8UC_SO);
            String obj = sb.toString();
            delegate.e(TAG, obj);
            throw new IllegalStateException(obj);
        }
        createStampIfNeeded(delegate, v8SoAbsolutePath);
        try {
            file.delete();
        } catch (Throwable unused2) {
        }
        if (!loadLibraryEx(delegate, "jsengine-platform")) {
            delegate.e(TAG, "failed to load jsengine-platform");
            throw new IllegalStateException("failed to load jsengine-platform");
        }
        if (z) {
            if (!loadLibraryEx(delegate, "jsengine-api")) {
                delegate.e(TAG, "failed to load jsengine-api");
                throw new IllegalStateException("failed to load jsengine-api");
            }
            mJ2V8Loaded = true;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        sLoadSoCost = elapsedRealtime2;
        if (classLoader != null) {
            sLoadSoCost = elapsedRealtime2 + 0;
        }
        delegate.d(TAG, "successfully loaded V8 library");
    }

    public static void setOptions(Delegate delegate) {
        File filesDir = delegate.getContext().getFilesDir();
        if (filesDir != null) {
            File file = new File(filesDir, "code_cache");
            if (!file.exists()) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Creating code-cache dir ");
                sb.append(file.toString());
                delegate.d(str, sb.toString());
                file.mkdirs();
            }
            int config = delegate.getConfig("ta_v8_cache_mode", 1);
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("V8 Cache Mode: ");
            sb2.append(config);
            delegate.d(str2, sb2.toString());
            int config2 = delegate.getConfig("ta_v8_snapshot_mem_threshold", 12);
            int config3 = delegate.getConfig("ta_v8_cache_expires", 7);
            String str3 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("V8 Cache Expires: ");
            sb3.append(config3);
            delegate.d(str3, sb3.toString());
            int config4 = delegate.getConfig("ta_v8_worker_threads", 1);
            String str4 = TAG;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("V8 Worker Threads: ");
            sb4.append(config4);
            delegate.d(str4, sb4.toString());
            JSEngine.setJSEngineOptions(file.toString(), config3 * 24 * 60 * 60, config, config2, config4);
        }
    }

    private static boolean loadLibraryEx(Delegate delegate, String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            delegate.e(TAG, "Runtime loadLibrary exception", th);
            LogData seedId = LogData.seedId("TINY_APP_JS_ENGINE");
            seedId.param1().add("type", "exception").param2().add("message", th.toString());
            delegate.log(seedId);
            return false;
        }
    }
}
