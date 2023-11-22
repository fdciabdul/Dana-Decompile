package com.iap.ac.android.loglite.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.iap.ac.android.loglite.a.b;
import com.iap.ac.android.loglite.api.AnalyticsHelper;
import com.iap.ac.android.loglite.config.ConfigurationManager;
import com.iap.ac.android.loglite.storage.AnalyticsStorage;
import com.iap.ac.android.loglite.storage.AnalyticsStorageManager;
import com.iap.ac.android.loglite.upload.HttpUploader;
import com.iap.ac.android.loglite.utils.ContextInfo;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class AnalyticsContext {
    public static final String KEY_MONTH = "month_";
    public static final String KEY_WEEK = "week_";
    public static AnalyticsContext p;

    /* renamed from: a  reason: collision with root package name */
    public Application f7586a;
    public String b;
    public String c;
    public String d;
    public Map<String, String> e;
    public Map<String, String> f;
    public ContextInfo g;
    public AnalyticsStorageManager h;
    public ConfigurationManager j;
    public ExecutorService m;

    /* renamed from: o  reason: collision with root package name */
    public LogEncryptClient f7587o;
    public boolean n = false;
    public Set<String> i = new HashSet();
    public HttpUploader k = new HttpUploader();
    public Map<String, String> l = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f7588a;

        public a(File file) {
            this.f7588a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpUploader httpUploader = AnalyticsContext.this.k;
            File file = this.f7588a;
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(" will upload, count of all mdap files= ");
                sb.append(listFiles.length);
                sb.append(" ,uploadDir= ");
                sb.append(file.getAbsolutePath());
                LoggerWrapper.i(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, sb.toString());
                Arrays.sort(listFiles, Collections.reverseOrder());
                int i = 0;
                for (int i2 = 0; i2 < listFiles.length && i2 < 64; i2++) {
                    File file2 = listFiles[i2];
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        String name = file2.getName();
                        try {
                            AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
                            String logHost = analyticsContext.getLogHost();
                            String str = analyticsContext.getConfigurationManager().c;
                            if (!TextUtils.isEmpty(str)) {
                                logHost = str;
                            }
                            try {
                                String urlByBizType = analyticsContext.getUrlByBizType(httpUploader.a(name));
                                if (!TextUtils.isEmpty(urlByBizType)) {
                                    logHost = urlByBizType;
                                }
                            } catch (Exception e) {
                                LoggerWrapper.w(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, e);
                            }
                            httpUploader.a(file2, logHost);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" HttpUploader upload success: ");
                            sb2.append(name);
                            sb2.append(" ,uploadDir= ");
                            sb2.append(file);
                            sb2.append(",upload url = ");
                            sb2.append(logHost);
                            LoggerWrapper.i(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, sb2.toString());
                        } catch (Throwable th) {
                            i++;
                            String obj = th.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(" upload failed: ");
                            sb3.append(name);
                            sb3.append(" at ");
                            sb3.append(obj);
                            sb3.append(", uploadDir= ");
                            sb3.append(file.getAbsolutePath());
                            LoggerWrapper.e(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, sb3.toString());
                            if (i == 1) {
                                if ((th instanceof NullPointerException) || (th.getCause() != null && (th.getCause() instanceof NullPointerException))) {
                                    LoggerWrapper.e(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, "uploadLog", th);
                                }
                                if (name.contains(LogCategory.LOG_CATEGORY_HIGHAVAIL)) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("errorMessage", obj);
                                    AnalyticsHelper.sendPerformanceLog("keyBiztraceLogUploadFail", hashMap);
                                }
                            }
                        }
                    }
                }
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(" do not need upload HttpUploader,uploadDir= ");
            sb4.append(file.getAbsolutePath());
            LoggerWrapper.i(com.alipay.iap.android.aplog.core.uploader.HttpUploader.TAG, sb4.toString());
        }
    }

    public AnalyticsContext(Application application, String str, String str2) {
        this.g = new ContextInfo(application);
        this.f7586a = application;
        this.b = str;
        this.c = str2;
        this.h = new AnalyticsStorageManager(application);
        this.j = new ConfigurationManager(application);
        LoggerWrapper.init(application);
        refreshSessionId();
        a();
        b();
        this.m = Executors.newSingleThreadExecutor();
        CrashReporter.a();
        c();
    }

    public static AnalyticsContext getInstance() {
        AnalyticsContext analyticsContext = p;
        if (analyticsContext != null) {
            return analyticsContext;
        }
        throw new IllegalStateException("You should call init before getInstance");
    }

    public static void init(Context context, String str, String str2) {
        synchronized (AnalyticsContext.class) {
            if (p == null) {
                p = new AnalyticsContext((Application) context.getApplicationContext(), str, str2);
            }
        }
    }

    public final void a() {
        String str;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.e = concurrentHashMap;
        concurrentHashMap.put(H5GetLogInfoBridge.RESULT_TIMEZONE, TimeZone.getDefault().getID());
        try {
            str = Build.BRAND.toLowerCase();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.put(H5GetLogInfoBridge.RESULT_BRAND, str);
    }

    public void addCrashWhiteList(String str) {
        this.i.add(str);
    }

    public final void b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7586a.getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append("liteLog");
        File file = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7586a.getFilesDir());
        sb2.append(str);
        sb2.append("loglite");
        sb2.append(str);
        sb2.append(this.b);
        File file2 = new File(sb2.toString());
        if (file2.exists()) {
            return;
        }
        file2.mkdirs();
        file.renameTo(file2);
    }

    public final void c() {
        if (this.j.e) {
            this.m.execute(new com.iap.ac.android.loglite.a.a(this));
        } else {
            this.m.execute(new b(this));
        }
    }

    public void flushLogs() {
        AnalyticsStorageManager analyticsStorageManager = this.h;
        if (getInstance().getConfigurationManager().e) {
            Iterator<AnalyticsStorage> it = analyticsStorageManager.f7596a.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public Application getApplication() {
        return this.f7586a;
    }

    public ConfigurationManager getConfigurationManager() {
        return this.j;
    }

    public ContextInfo getContextInfo() {
        return this.g;
    }

    public Map<String, String> getExtraParamMap() {
        return this.e;
    }

    public Map<String, String> getGlobalExtParam() {
        return this.f;
    }

    public LogEncryptClient getLogEncryptClient() {
        return this.f7587o;
    }

    public String getLogHost() {
        String str;
        synchronized (this) {
            str = this.c;
        }
        return str;
    }

    public String getProductId() {
        String str;
        synchronized (this) {
            str = this.b;
        }
        return str;
    }

    public String getSessionId() {
        return this.d;
    }

    public AnalyticsStorageManager getStorageManager() {
        return this.h;
    }

    public String getUrlByBizType(String str) {
        String str2 = this.l.get(str);
        if (TextUtils.isEmpty(str2)) {
            for (String str3 : this.l.keySet()) {
                String[] split = str3.split("\\*");
                boolean z = false;
                if (split.length > 0 && str3.contains("*")) {
                    z = str.startsWith(split[0]);
                }
                if (z) {
                    return this.l.get(str3);
                }
            }
            return str2;
        }
        return str2;
    }

    public boolean isNeedEncryptLog() {
        return this.n && this.f7587o != null;
    }

    public void refreshSessionId() {
        this.d = UUID.randomUUID().toString();
    }

    public void registerBizTypeToUploadUrl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.l.put(str, str2);
    }

    public void setGlobalExtParam(Map<String, String> map) {
        if (LoggerWrapper.isDebuggable(this.f7586a)) {
            this.f = map;
        }
    }

    public void setNeedEncryptLog(boolean z) {
        this.n = z;
        if (z) {
            this.f7587o = new DefaultLogEncryptClient();
        } else {
            this.f7587o = null;
        }
    }

    public void setStrategyConfig(String str) {
        this.j.b(str);
    }

    public void update(String str, String str2) {
        synchronized (this) {
            this.b = str;
            this.c = str2;
        }
    }

    public void uploadLog(File file) {
        this.m.execute(new a(file));
    }
}
