package com.alipay.mobile.network.ccdn.jni;

import android.text.TextUtils;
import com.alipay.mobile.network.ccdn.api.AppInfo;
import com.alipay.mobile.network.ccdn.storage.MemLRUCache;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class JNIPort {
    private static final int APP_STATE_BACKGROUND = 2;
    private static final int APP_STATE_FOREGROUND = 1;
    private static final String TAG = "JNIPort";
    private static boolean initialized;

    private static native int nativeAppCacheClear();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheGetPackageResource(String str, PackageResource packageResource);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheInit(AppCacheConfig appCacheConfig, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeAppCacheIsLocalAvailable(AppInfo appInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheLoadPackage(AppInfo appInfo, String str, Object[] objArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheOnAppExit(AppInfo appInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheOnAppStart(AppInfo appInfo);

    private static native int nativeAppCachePerformCleanup();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCachePreloadPackage(AppInfo appInfo, String str, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheRemovePackage(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppCacheRemovePackages(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppCacheUpdateConfig(AppCacheConfig appCacheConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAppGetStatistics(AppCacheStatistics appCacheStatistics);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeHttpCacheAddEntry(String str, byte[] bArr, byte[] bArr2, int i, long j, int i2);

    private static native int nativeHttpCacheClear();

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeHttpCacheExistEntry(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeHttpCacheGetEntry(String str, H5CacheEntry h5CacheEntry);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeHttpCacheInit(HttpCacheConfig httpCacheConfig, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeHttpCacheIsManagedEntry(String str);

    private static native int nativeHttpCachePerformCleanup();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeHttpCacheRemoveEntry(String str);

    private static native void nativeHttpCacheUpdateConfig(HttpCacheConfig httpCacheConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeHttpGetStatistics(HttpCacheStatistics httpCacheStatistics);

    private static native int nativeInit(int i);

    private static native void nativeOnAppStateChange(int i);

    static /* synthetic */ int access$1000() {
        return nativeAppCacheClear();
    }

    static /* synthetic */ int access$1300() {
        return nativeAppCachePerformCleanup();
    }

    static /* synthetic */ int access$2100() {
        return nativeHttpCachePerformCleanup();
    }

    static /* synthetic */ int access$2200() {
        return nativeHttpCacheClear();
    }

    public static int initialize() {
        int i;
        synchronized (JNIPort.class) {
            if (initialized) {
                return 0;
            }
            try {
                System.loadLibrary("f68f");
                System.loadLibrary("ib9f");
                i = nativeInit(1);
            } catch (Throwable th) {
                InstrumentInjector.log_e(TAG, "native initialize failed", th);
                i = -9;
            }
            initialized = i == 0;
            return i;
        }
    }

    public static void onAppGoForeground() {
        try {
            if (initialized) {
                nativeOnAppStateChange(1);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("native onAppGoForeground error: ");
            sb.append(th.getMessage());
            InstrumentInjector.log_w(TAG, sb.toString(), th);
        }
    }

    public static void onAppGoBackground() {
        try {
            if (initialized) {
                nativeOnAppStateChange(2);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("native onAppGoBackground error: ");
            sb.append(th.getMessage());
            InstrumentInjector.log_w(TAG, sb.toString(), th);
        }
    }

    private static void log(int i, String str, String str2) {
        if (i == 0) {
            InstrumentInjector.log_v(str, str2);
        } else if (i == 1) {
            InstrumentInjector.log_d(str, str2);
        } else if (i == 2) {
            InstrumentInjector.log_i(str, str2);
        } else if (i == 3) {
            InstrumentInjector.log_w(str, str2);
        } else if (i != 4) {
        } else {
            InstrumentInjector.log_e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ensureState() {
        if (!initialized) {
            throw new IllegalStateException("uninitialized");
        }
    }

    /* loaded from: classes6.dex */
    public static class AppCache {
        private static MemLRUCache<Integer, PackageLoadCallback> activeApps = new MemLRUCache<>(8192, DefaultOcrConfigRepository.DEFAULT_SIZE_LIMIT_MB, 86400000);
        private static AtomicInteger counter = new AtomicInteger(1000);

        public static int init(AppCacheConfig appCacheConfig, boolean z) {
            JNIPort.ensureState();
            if (appCacheConfig == null) {
                return -2;
            }
            return JNIPort.nativeAppCacheInit(appCacheConfig, z);
        }

        public static void updateConfig(AppCacheConfig appCacheConfig) {
            if (appCacheConfig == null || !JNIPort.initialized) {
                return;
            }
            try {
                JNIPort.nativeAppCacheUpdateConfig(appCacheConfig);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("update app config error: ");
                sb.append(th.getMessage());
                InstrumentInjector.log_w(JNIPort.TAG, sb.toString(), th);
            }
        }

        public static int loadPackage(AppInfo appInfo, PackageLoadCallback packageLoadCallback) {
            return loadPackage(appInfo, packageLoadCallback, null);
        }

        public static int loadPackage(AppInfo appInfo, PackageLoadCallback packageLoadCallback, String str) {
            JNIPort.ensureState();
            if (appInfo == null) {
                return -2;
            }
            if (packageLoadCallback == null) {
                return JNIPort.nativeAppCacheLoadPackage(appInfo, str, null, 0);
            }
            int incrementAndGet = counter.incrementAndGet();
            try {
                StringBuilder sb = new StringBuilder("add package loading callback, sid=");
                sb.append(incrementAndGet);
                sb.append(", actives: ");
                sb.append(activeApps.entries());
                InstrumentInjector.log_i(JNIPort.TAG, sb.toString());
                activeApps.put(Integer.valueOf(incrementAndGet), packageLoadCallback);
                Set<String> monitorEntries = packageLoadCallback.getMonitorEntries();
                int nativeAppCacheLoadPackage = JNIPort.nativeAppCacheLoadPackage(appInfo, str, monitorEntries != null ? monitorEntries.toArray() : null, incrementAndGet);
                if (nativeAppCacheLoadPackage != 0) {
                    StringBuilder sb2 = new StringBuilder("remove package loading callback on error(");
                    sb2.append(nativeAppCacheLoadPackage);
                    sb2.append("), sid=");
                    sb2.append(incrementAndGet);
                    sb2.append(", actives: ");
                    sb2.append(activeApps.entries());
                    InstrumentInjector.log_w(JNIPort.TAG, sb2.toString());
                    activeApps.remove(Integer.valueOf(incrementAndGet));
                }
                return nativeAppCacheLoadPackage;
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder("remove package loading callback on error(-1), sid=");
                sb3.append(incrementAndGet);
                sb3.append(", actives: ");
                sb3.append(activeApps.entries());
                InstrumentInjector.log_w(JNIPort.TAG, sb3.toString());
                activeApps.remove(Integer.valueOf(incrementAndGet));
                throw th;
            }
        }

        public static int preloadPackage(AppInfo appInfo, String str, int i) {
            return preloadPackage(appInfo, null, str, i);
        }

        public static int preloadPackage(AppInfo appInfo, PackageLoadCallback packageLoadCallback, int i) {
            return preloadPackage(appInfo, packageLoadCallback, null, i);
        }

        public static int preloadPackage(AppInfo appInfo, PackageLoadCallback packageLoadCallback, String str, int i) {
            JNIPort.ensureState();
            if (appInfo == null) {
                return -2;
            }
            if (packageLoadCallback == null) {
                return JNIPort.nativeAppCachePreloadPackage(appInfo, str, 0, i);
            }
            int incrementAndGet = counter.incrementAndGet();
            try {
                StringBuilder sb = new StringBuilder("add package preloading callback, sid=");
                sb.append(incrementAndGet);
                sb.append(", actives: ");
                sb.append(activeApps.entries());
                InstrumentInjector.log_i(JNIPort.TAG, sb.toString());
                activeApps.put(Integer.valueOf(incrementAndGet), packageLoadCallback);
                int nativeAppCachePreloadPackage = JNIPort.nativeAppCachePreloadPackage(appInfo, str, incrementAndGet, i);
                if (nativeAppCachePreloadPackage != 0) {
                    StringBuilder sb2 = new StringBuilder("remove package preloading callback on error(");
                    sb2.append(nativeAppCachePreloadPackage);
                    sb2.append("), sid=");
                    sb2.append(incrementAndGet);
                    sb2.append(", actives: ");
                    sb2.append(activeApps.entries());
                    InstrumentInjector.log_w(JNIPort.TAG, sb2.toString());
                    activeApps.remove(Integer.valueOf(incrementAndGet));
                }
                return nativeAppCachePreloadPackage;
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder("remove package preloading callback on error(-1), sid=");
                sb3.append(incrementAndGet);
                sb3.append(", actives: ");
                sb3.append(activeApps.entries());
                InstrumentInjector.log_w(JNIPort.TAG, sb3.toString());
                activeApps.remove(Integer.valueOf(incrementAndGet));
                throw th;
            }
        }

        public static boolean isLocalAvailable(AppInfo appInfo) {
            JNIPort.ensureState();
            if (appInfo == null) {
                return false;
            }
            return JNIPort.nativeAppCacheIsLocalAvailable(appInfo);
        }

        public static PackageResource getPackageResource(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return null;
            }
            PackageResource packageResource = new PackageResource(str);
            if (JNIPort.nativeAppCacheGetPackageResource(str, packageResource) == 0) {
                return packageResource;
            }
            return null;
        }

        public static int removePackage(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return -2;
            }
            return JNIPort.nativeAppCacheRemovePackage(str);
        }

        public static int removePackages(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return -2;
            }
            return JNIPort.nativeAppCacheRemovePackages(str);
        }

        public static int clear() {
            JNIPort.ensureState();
            return JNIPort.access$1000();
        }

        public static int onAppStart(AppInfo appInfo) {
            JNIPort.ensureState();
            if (appInfo == null) {
                return -2;
            }
            return JNIPort.nativeAppCacheOnAppStart(appInfo);
        }

        public static int onAppExit(AppInfo appInfo) {
            JNIPort.ensureState();
            if (appInfo == null) {
                return -2;
            }
            return JNIPort.nativeAppCacheOnAppExit(appInfo);
        }

        public static int performCleanup() {
            JNIPort.ensureState();
            return JNIPort.access$1300();
        }

        public static AppCacheStatistics getStatistics() {
            AppCacheStatistics appCacheStatistics = new AppCacheStatistics();
            try {
                int nativeAppGetStatistics = JNIPort.nativeAppGetStatistics(appCacheStatistics);
                if (nativeAppGetStatistics != 0) {
                    InstrumentInjector.log_w(JNIPort.TAG, "get appcache statistics error: ".concat(String.valueOf(nativeAppGetStatistics)));
                    return null;
                }
                return appCacheStatistics;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("get appcache statistics error: ");
                sb.append(th.getMessage());
                InstrumentInjector.log_w(JNIPort.TAG, sb.toString(), th);
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class HttpCache {
        public static int init(HttpCacheConfig httpCacheConfig, boolean z) {
            JNIPort.ensureState();
            if (httpCacheConfig == null) {
                return -2;
            }
            return JNIPort.nativeHttpCacheInit(httpCacheConfig, z);
        }

        public static boolean existEntry(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return false;
            }
            return JNIPort.nativeHttpCacheExistEntry(str);
        }

        public static H5CacheEntry getEntry(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return null;
            }
            H5CacheEntry h5CacheEntry = new H5CacheEntry(str);
            int nativeHttpCacheGetEntry = JNIPort.nativeHttpCacheGetEntry(str, h5CacheEntry);
            if (nativeHttpCacheGetEntry != 0) {
                h5CacheEntry.setValid(false);
                h5CacheEntry.addMetrics("err", String.valueOf(nativeHttpCacheGetEntry));
            }
            h5CacheEntry.addMetrics("url", str);
            return h5CacheEntry;
        }

        public static int addEntry(String str, byte[] bArr, byte[] bArr2, int i, long j, int i2) {
            JNIPort.ensureState();
            if (str == null || bArr == null) {
                return -2;
            }
            return JNIPort.nativeHttpCacheAddEntry(str, bArr, bArr2, i, j, i2);
        }

        public static boolean isPushedEntry(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return false;
            }
            return JNIPort.nativeHttpCacheIsManagedEntry(str);
        }

        public static int removeEntry(String str) {
            JNIPort.ensureState();
            if (str == null) {
                return -2;
            }
            return JNIPort.nativeHttpCacheRemoveEntry(str);
        }

        public static int performCleanup() {
            JNIPort.ensureState();
            return JNIPort.access$2100();
        }

        public static int clear() {
            JNIPort.ensureState();
            return JNIPort.access$2200();
        }

        public static HttpCacheStatistics getStatistics() {
            HttpCacheStatistics httpCacheStatistics = new HttpCacheStatistics();
            try {
                int nativeHttpGetStatistics = JNIPort.nativeHttpGetStatistics(httpCacheStatistics);
                if (nativeHttpGetStatistics != 0) {
                    InstrumentInjector.log_w(JNIPort.TAG, "get httpcache statistics error: ".concat(String.valueOf(nativeHttpGetStatistics)));
                    return null;
                }
                return httpCacheStatistics;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("get httpcache statistics error: ");
                sb.append(th.getMessage());
                InstrumentInjector.log_w(JNIPort.TAG, sb.toString(), th);
                return null;
            }
        }
    }

    private static void onLoadPackageComplete(int i, int i2, String[] strArr) {
        try {
            Map<String, String> normalizeMetrics = normalizeMetrics(strArr);
            StringBuilder sb = new StringBuilder("onLoadPackageComplete(");
            sb.append(i2);
            sb.append("), sid=");
            sb.append(i);
            sb.append(", actives: ");
            sb.append(AppCache.activeApps.entries());
            sb.append(", metrics: ");
            sb.append(normalizeMetrics);
            InstrumentInjector.log_i(TAG, sb.toString());
            PackageLoadCallback packageLoadCallback = (PackageLoadCallback) AppCache.activeApps.remove(Integer.valueOf(i));
            if (packageLoadCallback != null) {
                packageLoadCallback.onComplete(i2, normalizeMetrics);
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("native callback[onLoadPackageComplete#");
            sb2.append(i);
            sb2.append("] error");
            InstrumentInjector.log_w(TAG, sb2.toString(), th);
        }
    }

    private static void onPackageEntryReady(int i, String str) {
        try {
            StringBuilder sb = new StringBuilder("onPackageEntryReady, sid=");
            sb.append(i);
            sb.append(", resource: ");
            sb.append(str);
            InstrumentInjector.log_i(TAG, sb.toString());
            PackageLoadCallback packageLoadCallback = (PackageLoadCallback) AppCache.activeApps.get(Integer.valueOf(i));
            if (packageLoadCallback != null) {
                packageLoadCallback.onEntryReady(str);
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("native callback[onPackageEntryReady#");
            sb2.append(i);
            sb2.append("] error");
            InstrumentInjector.log_w(TAG, sb2.toString(), th);
        }
    }

    private static void onStartDownloadPackage(int i) {
        try {
            InstrumentInjector.log_i(TAG, "onStartDownloadPackage, sid=".concat(String.valueOf(i)));
            PackageLoadCallback packageLoadCallback = (PackageLoadCallback) AppCache.activeApps.get(Integer.valueOf(i));
            if (packageLoadCallback != null) {
                packageLoadCallback.onStartDownload();
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("native callback[onStartDownloadPackage#");
            sb.append(i);
            sb.append("] error");
            InstrumentInjector.log_w(TAG, sb.toString(), th);
        }
    }

    private static void onMetrics(int i, String[] strArr) {
        StringBuilder sb = new StringBuilder("onMetrics(");
        sb.append(i);
        sb.append("): ");
        sb.append(normalizeMetrics(strArr));
        InstrumentInjector.log_i(TAG, sb.toString());
    }

    private static Map<String, String> normalizeMetrics(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < strArr.length - 1; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder("invalid metrics, key: ");
                sb.append(str);
                sb.append(", value: ");
                sb.append(str2);
                InstrumentInjector.log_w(TAG, sb.toString());
            } else {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }
}
