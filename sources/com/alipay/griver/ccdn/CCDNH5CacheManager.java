package com.alipay.griver.ccdn;

import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.performance.PerformanceAmcsManager;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.network7.PerformanceNetwork7Monitor;
import com.alipay.mobile.network.ccdn.jni.H5CacheEntry;
import com.alipay.mobile.network.ccdn.jni.HttpCacheConfig;
import com.alipay.mobile.network.ccdn.jni.JNIPort;
import com.alipay.plus.android.ccdn.CCDN;
import com.alipay.plus.android.ccdn.ICCDNLog;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.here.HereOauthManager;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import o.getCallingPid;

/* loaded from: classes6.dex */
public class CCDNH5CacheManager {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static final String CACHE_FILE = "/griver/ccdn/httpcache";
    static final int CODE_API_ERROR = 6;
    static final int CODE_RESOURCE_IS_EXPIRED = 3;
    static final int CODE_RESOURCE_NOT_EXIST = 2;
    static final int CODE_RESOURCE_PRESET_ERROR = 7;
    static final int CODE_RESOURCE_RESPONSE_IS_NULL = 4;
    static final int CODE_RESOURCE_RESPONSE_PARSE_ERROR = 5;
    static final int CODE_URL_ILLEGAL = 1;
    private static final String COLON = ":";
    public static final String CONTENT_LENGTH = "content-length";
    private static final String CRLF = "\r\n";
    private static final String CS_UTF8;
    private static final int ERROR_CODE_IMAGE_CACHE_DATA = -5;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static char[] PlaceComponentResult = null;
    private static final String TAG = "CCDNH5CacheManager";
    private static final String THREAD_NAME_CCDN_H5 = "thread_name_ccdn_h5";
    private CCDNH5Config h5Config;
    private boolean isInitSuccess;
    private NetWorkerManager netWorkerManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface GRVCCDNManagerFactory {
        public static final CCDNH5CacheManager mInstance = new CCDNH5CacheManager();
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(new char[]{5, 2, 0, 3, 13776}, (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 46), ExpandableListView.getPackedPositionGroup(0L) + 5, objArr);
        CS_UTF8 = ((String) objArr[0]).intern();
        int i = MyBillsEntityDataFactory + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 42070;
        PlaceComponentResult = new char[]{37346, 37358, 37274, 37359, 37356, 37357, 37257, 37367, 37275};
    }

    static /* synthetic */ CCDNH5Config access$000(CCDNH5CacheManager cCDNH5CacheManager) {
        CCDNH5Config cCDNH5Config;
        int i = MyBillsEntityDataFactory + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 21 : 'F') != 'F') {
            try {
                cCDNH5Config = cCDNH5CacheManager.h5Config;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            cCDNH5Config = cCDNH5CacheManager.h5Config;
        }
        int i2 = MyBillsEntityDataFactory + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return cCDNH5Config;
    }

    static /* synthetic */ CCDNH5Config access$002(CCDNH5CacheManager cCDNH5CacheManager, CCDNH5Config cCDNH5Config) {
        int i = MyBillsEntityDataFactory + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            cCDNH5CacheManager.h5Config = cCDNH5Config;
            int i3 = MyBillsEntityDataFactory + 77;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return cCDNH5Config;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$100(CCDNH5CacheManager cCDNH5CacheManager) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        cCDNH5CacheManager.init();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? '?' : '.') != '.') {
            Object obj = null;
            obj.hashCode();
        }
    }

    static /* synthetic */ NetWorkerManager access$300(CCDNH5CacheManager cCDNH5CacheManager) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        MyBillsEntityDataFactory = i % 128;
        boolean z = i % 2 == 0;
        NetWorkerManager netWorkerManager = cCDNH5CacheManager.netWorkerManager;
        if (z) {
            int i2 = 48 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            return netWorkerManager;
        }
        return netWorkerManager;
    }

    private CCDNH5CacheManager() {
        try {
            this.isInitSuccess = false;
            try {
                this.h5Config = new CCDNH5Config(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_CCDN_H5_CONFIG));
                init();
                GriverInnerConfig.getConfig(GriverConfigConstants.KEY_CCDN_H5_CONFIG, "", new GriverConfigProxy.OnConfigChangeListener() { // from class: com.alipay.griver.ccdn.CCDNH5CacheManager.1
                    @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnConfigChangeListener
                    public void onChange(String str) {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            CCDNH5CacheManager.access$002(CCDNH5CacheManager.this, new CCDNH5Config(str));
                            CCDNH5CacheManager.access$100(CCDNH5CacheManager.this);
                            CCDNH5CacheManager.this.presetEntry();
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("CCDNH5CacheManager#getConfig error ");
                            sb.append(th);
                            GriverLogger.e(CCDNH5CacheManager.TAG, sb.toString());
                        }
                    }
                });
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static CCDNH5CacheManager getInstance() {
        CCDNH5CacheManager cCDNH5CacheManager;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? (char) 14 : 'N') != 14) {
                cCDNH5CacheManager = GRVCCDNManagerFactory.mInstance;
            } else {
                cCDNH5CacheManager = GRVCCDNManagerFactory.mInstance;
                int i2 = 62 / 0;
            }
            int i3 = MyBillsEntityDataFactory + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return cCDNH5CacheManager;
        } catch (Exception e) {
            throw e;
        }
    }

    private void init() {
        synchronized (this) {
            try {
            } finally {
            }
            if (this.h5Config.isEnable() && !this.isInitSuccess) {
                if (CCDN.getInstance().init()) {
                    CCDN.getInstance().setLog(new ICCDNLog() { // from class: com.alipay.griver.ccdn.CCDNH5CacheManager.2
                        @Override // com.alipay.plus.android.ccdn.ICCDNLog
                        public void d(String str, String str2) {
                        }

                        @Override // com.alipay.plus.android.ccdn.ICCDNLog
                        public void e(String str, String str2) {
                            GriverLogger.e(str, str2);
                        }
                    });
                    HttpCacheConfig httpCacheConfig = new HttpCacheConfig();
                    StringBuilder sb = new StringBuilder();
                    sb.append(GriverEnv.getApplicationContext().getCacheDir().getAbsolutePath());
                    sb.append(CACHE_FILE);
                    httpCacheConfig.cacheDir = sb.toString();
                    httpCacheConfig.volume = this.h5Config.getVolume();
                    httpCacheConfig.maxEntries = this.h5Config.getMaxEntries();
                    httpCacheConfig.maxMemEntries = this.h5Config.getMaxMemEntries();
                    httpCacheConfig.maxMemSize = this.h5Config.getMaxMemSize();
                    httpCacheConfig.cleanupInterval = this.h5Config.getCleanupInterval();
                    httpCacheConfig.ipcSockId = "http_ipc_sock";
                    int init = JNIPort.HttpCache.init(httpCacheConfig, true);
                    if (init != 0) {
                        monitCCDNFailed(6, null, "http_cache_init", String.valueOf(init), null, null);
                    } else {
                        this.isInitSuccess = true;
                    }
                    this.netWorkerManager = new NetWorkerManager();
                }
            }
        }
    }

    public void presetEntry() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            if ("wifi".equalsIgnoreCase(NetworkUtil.getSimpleNetworkType(GriverEnv.getApplicationContext())) && this.h5Config.isEnable() && this.isInitSuccess) {
                GriverExecutors.getScheduledExecutor().schedule(new Runnable() { // from class: com.alipay.griver.ccdn.CCDNH5CacheManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf;
                        Uri parse;
                        JSONArray urls = CCDNH5CacheManager.access$000(CCDNH5CacheManager.this).getUrls();
                        for (int i = 0; i < urls.size(); i++) {
                            try {
                                Object obj = urls.get(i);
                                if (obj != null && (parse = Uri.parse((valueOf = String.valueOf(obj)))) != null && ((SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) && (!JNIPort.HttpCache.existEntry(valueOf) || JNIPort.HttpCache.getEntry(valueOf).isExpired()))) {
                                    HttpResponse preLoadResource = CCDNH5CacheManager.access$300(CCDNH5CacheManager.this).preLoadResource(valueOf);
                                    if (preLoadResource != null) {
                                        if (preLoadResource.getStatusCode() != 200 && preLoadResource.getStatusCode() != 304) {
                                            CCDNH5CacheManager.this.monitCCDNFailed(7, valueOf, null, null, String.valueOf(preLoadResource.getStatusCode()), "Invalid StatusCode");
                                        }
                                        if (preLoadResource.getInputStream() != null) {
                                            InputStream inputStream = preLoadResource.getInputStream();
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            byte[] buf = IOUtils.getBuf(1024);
                                            while (true) {
                                                int read = inputStream.read(buf);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(buf, 0, read);
                                            }
                                            CCDNH5CacheManager.this.presetEntry(valueOf, preLoadResource.getHeaders(), CCDNH5CacheManager.access$300(CCDNH5CacheManager.this).parseStatusLine(preLoadResource.getProtocol(), preLoadResource.getStatusCode(), preLoadResource.getReasonPhrase()), byteArrayOutputStream.toByteArray(), byteArrayOutputStream.size());
                                            IOUtils.closeQuietly(inputStream);
                                            IOUtils.closeQuietly(byteArrayOutputStream);
                                        } else {
                                            CCDNH5CacheManager.this.monitCCDNFailed(7, valueOf, null, null, "-1", "Invalid Response");
                                        }
                                    } else {
                                        CCDNH5CacheManager.this.monitCCDNFailed(7, valueOf, null, null, "-1", "Invalid Response");
                                    }
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("presetEntry error");
                                sb.append(th);
                                GriverLogger.w(CCDNH5CacheManager.TAG, sb.toString());
                            }
                        }
                    }
                }, 5L, TimeUnit.SECONDS);
            }
        }
    }

    public WebResourceResponse getEntry(String str, String str2, String str3, Map<String, String> map) {
        Uri uri;
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("CCDN getEntry, appId=");
        sb.append(str);
        sb.append(",url=");
        sb.append(str2);
        sb.append(",method=");
        sb.append(str3);
        GriverLogger.d(TAG, sb.toString());
        if (Build.VERSION.SDK_INT < 21) {
            int i = MyBillsEntityDataFactory + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                int i2 = 62 / 0;
            }
            return null;
        } else if (canUseCCDN(str)) {
            if (!"get".equalsIgnoreCase(str3)) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                int i5 = MyBillsEntityDataFactory + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
                    int i6 = 93 / 0;
                    return null;
                }
                return null;
            }
            try {
                uri = Uri.parse(str2);
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parse error");
                sb2.append(th);
                GriverLogger.w(TAG, sb2.toString());
                monitCCDNFailed(1, null, null, null, null, null);
                uri = null;
            }
            if (uri == null) {
                return null;
            }
            try {
                String scheme = uri.getScheme();
                if (!(SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(scheme))) {
                    if ((!"https".equalsIgnoreCase(scheme) ? (char) 30 : 'V') == 30) {
                        return null;
                    }
                }
                if (PerformanceAmcsManager.getInstance().canMonitorNetWorker7() && !TextUtils.isEmpty(str2)) {
                    PerformanceNetwork7Monitor performanceNetwork7Monitor = (PerformanceNetwork7Monitor) PerformanceMonitorFactory.getPerformanceMonitor(str, PerformanceMonitorFactory.PerformanceType.NETWORK_7);
                    if ((performanceNetwork7Monitor == null ? Typography.quote : ']') != '\"') {
                        performanceNetwork7Monitor.setNetWorkHttp(str2);
                    }
                }
                if (JNIPort.HttpCache.existEntry(str2)) {
                    H5CacheEntry entry = JNIPort.HttpCache.getEntry(str2);
                    if (!entry.isExpired()) {
                        byte[] content = entry.getContent();
                        Map<String, String> httpHeaders = entry.getHttpHeaders();
                        if (httpHeaders != null) {
                            try {
                                String[] mineAndEncoding = this.netWorkerManager.getMineAndEncoding(httpHeaders);
                                str4 = mineAndEncoding[0];
                                str5 = mineAndEncoding[1];
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            str5 = HereOauthManager.ENC;
                            str4 = null;
                        }
                        if (TextUtils.isEmpty(str4) ? false : true) {
                            if (!TextUtils.isEmpty(str5)) {
                                WebResourceResponse webResourceResponse = new WebResourceResponse(str4, str5, new ByteArrayInputStream(content));
                                webResourceResponse.setStatusCodeAndReasonPhrase(200, "OK");
                                httpHeaders.put("access-control-allow-origin", "*");
                                webResourceResponse.setResponseHeaders(httpHeaders);
                                return webResourceResponse;
                            }
                        }
                        return null;
                    }
                    monitCCDNFailed(3, str2, null, null, null, null);
                }
                if (this.h5Config.getUrls().contains(str2) || !TextUtils.isEmpty(MimeTypeMap.getFileExtensionFromUrl(str2))) {
                    return this.netWorkerManager.loadResource(str, str2, str3, map);
                }
                return null;
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            return null;
        }
    }

    public boolean canUseCCDN(String str) {
        boolean contains;
        if (this.h5Config.isEnable()) {
            if ((!this.isInitSuccess ? 'F' : Typography.less) != 'F') {
                if (this.h5Config.isDisableWhitelist()) {
                    return true;
                }
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                MyBillsEntityDataFactory = i % 128;
                if (i % 2 == 0) {
                    contains = this.h5Config.getAppsWhitelist().contains(str);
                    Object obj = null;
                    obj.hashCode();
                } else {
                    contains = this.h5Config.getAppsWhitelist().contains(str);
                }
                int i2 = MyBillsEntityDataFactory + 99;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                return contains;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEntry(final String str, final String str2, Map<String, List<String>> map, String str3, final byte[] bArr, long j) {
        byte[] serializeHttpHeader;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (Build.VERSION.SDK_INT < 21) {
            int i3 = MyBillsEntityDataFactory + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 30 : InputCardNumberView.DIVIDER) != ' ') {
                int i4 = 19 / 0;
            }
        } else if (TextUtils.isEmpty(str2) || map == null || bArr == null) {
        } else {
            if (!(j <= 0)) {
                int i5 = MyBillsEntityDataFactory + 17;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
                    serializeHttpHeader = serializeHttpHeader(map, str3, j);
                    int i6 = 83 / 0;
                    if (serializeHttpHeader == null) {
                        return;
                    }
                } else {
                    serializeHttpHeader = serializeHttpHeader(map, str3, j);
                    if (serializeHttpHeader == null) {
                        return;
                    }
                }
                final byte[] bArr2 = serializeHttpHeader;
                GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME_CCDN_H5).execute(new Runnable() { // from class: com.alipay.griver.ccdn.CCDNH5CacheManager.4
                    @Override // java.lang.Runnable
                    public void run() {
                        PerformanceNetwork7Monitor performanceNetwork7Monitor;
                        int addEntry = JNIPort.HttpCache.addEntry(str2, bArr2, bArr, 0, 0L, 0);
                        if (addEntry != 0) {
                            CCDNH5CacheManager.this.monitCCDNFailed(6, null, "http_cache_add", String.valueOf(addEntry), null, null);
                        }
                        if (addEntry == -5 && PerformanceAmcsManager.getInstance().canMonitorNetWorker7() && (performanceNetwork7Monitor = (PerformanceNetwork7Monitor) PerformanceMonitorFactory.getPerformanceMonitor(str, PerformanceMonitorFactory.PerformanceType.NETWORK_7)) != null) {
                            performanceNetwork7Monitor.setImageCacheData(str2);
                        }
                    }
                });
            }
        }
    }

    void presetEntry(final String str, Map<String, List<String>> map, String str2, final byte[] bArr, long j) {
        int i = MyBillsEntityDataFactory + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            if (Build.VERSION.SDK_INT < 126) {
                return;
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            if ((!TextUtils.isEmpty(str) ? '7' : '`') != '`') {
                int i2 = MyBillsEntityDataFactory + 49;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if ((i2 % 2 != 0 ? 'S' : Typography.greater) != '>') {
                    int i3 = 41 / 0;
                    if ((map != null ? '9' : (char) 22) != '9') {
                        return;
                    }
                } else if (map == null) {
                    return;
                }
                if ((bArr == null) || j <= 0) {
                    return;
                }
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
                final byte[] serializeHttpHeader = serializeHttpHeader(map, str2, j);
                if (serializeHttpHeader == null) {
                    int i6 = MyBillsEntityDataFactory + 11;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                    int i7 = i6 % 2;
                    monitCCDNFailed(5, str, null, null, null, null);
                    return;
                }
                try {
                    GriverExecutors.getSingleOrderThreadExecutorByName(THREAD_NAME_CCDN_H5).execute(new Runnable() { // from class: com.alipay.griver.ccdn.CCDNH5CacheManager.5
                        @Override // java.lang.Runnable
                        public void run() {
                            int addEntry = JNIPort.HttpCache.addEntry(str, serializeHttpHeader, bArr, 2, 0L, 0);
                            if (addEntry != 0) {
                                CCDNH5CacheManager.this.monitCCDNFailed(6, null, "http_cache_add", String.valueOf(addEntry), null, null);
                            }
                        }
                    });
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private byte[] serializeHttpHeader(Map<String, List<String>> map, String str, long j) {
        Object[] objArr;
        Map<String, String> header = NetWorkerManager.toHeader(map);
        StringBuilder sb = new StringBuilder(2048);
        if (TextUtils.isEmpty(str)) {
            sb.append("HTTP/1.1 200 OK");
            sb.append(CRLF);
        } else {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            sb.append(str);
            sb.append(CRLF);
            int i3 = MyBillsEntityDataFactory + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        }
        Iterator<Map.Entry<String, String>> it = header.entrySet().iterator();
        boolean z = false;
        while (true) {
            objArr = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!TextUtils.isEmpty(key)) {
                String lowerCase = key.toLowerCase();
                sb.append(lowerCase);
                sb.append(COLON);
                sb.append(next.getValue());
                sb.append(CRLF);
                if (z) {
                    continue;
                } else {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                    MyBillsEntityDataFactory = i5 % 128;
                    if (i5 % 2 != 0) {
                        if (!(!CONTENT_LENGTH.equals(lowerCase))) {
                            z = true;
                        }
                    } else {
                        boolean equals = CONTENT_LENGTH.equals(lowerCase);
                        int length = objArr.length;
                        if (!(!equals)) {
                            z = true;
                        }
                    }
                }
            }
        }
        if ((!z ? (char) 30 : (char) 14) == 30) {
            if ((j <= 0 ? '6' : 'P') == '6') {
                int i6 = MyBillsEntityDataFactory + 91;
                KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                if (i6 % 2 != 0) {
                    objArr.hashCode();
                    return null;
                }
                return null;
            }
            sb.append(CONTENT_LENGTH);
            sb.append(COLON);
            sb.append(j);
            sb.append(CRLF);
        }
        sb.append(CRLF);
        try {
            String obj = sb.toString();
            Object[] objArr2 = new Object[1];
            a(new char[]{5, 2, 0, 3, 13776}, (byte) (TextUtils.lastIndexOf("", '0') + 47), 6 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr2);
            return obj.getBytes(((String) objArr2[0]).intern());
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("serializeHttpHeader error");
            sb2.append(e);
            GriverLogger.w(TAG, sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void monitCCDNFailed(int i, String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorType", String.valueOf(i));
        if (!(TextUtils.isEmpty(str))) {
            hashMap.put("url", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            int i2 = MyBillsEntityDataFactory + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            hashMap.put("ccdnAPIName", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                hashMap.put("ccdnAPIErrorCode", str3);
            } catch (Exception e) {
                throw e;
            }
        }
        if (!(TextUtils.isEmpty(str4))) {
            hashMap.put("errorCode", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
            MyBillsEntityDataFactory = i4 % 128;
            if (i4 % 2 == 0) {
                hashMap.put("errorMessage", str5);
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                hashMap.put("errorMessage", str5);
            }
        }
        try {
            GriverMonitor.event(GriverMonitorConstants.KEY_CCDN_FAILURE, "GriverAppContainer", hashMap);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = PlaceComponentResult;
        if (cArr2 != null) {
            int i3 = $10 + 93;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ BuiltInFictitiousFunctionClassFactory);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            try {
                int i6 = $10 + 19;
                $11 = i6 % 128;
                if (i6 % 2 == 0) {
                    i2 = i + 119;
                    cArr4[i2] = (char) (cArr[i2] / b);
                } else {
                    i2 = i - 1;
                    cArr4[i2] = (char) (cArr[i2] - b);
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if (!(getcallingpid.getAuthRequestContext < i2)) {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    int i7 = $11 + 95;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                    } else if (!(getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                    } else {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i15 = 0;
        while (true) {
            if ((i15 < i ? '+' : (char) 1) != '+') {
                objArr[0] = new String(cArr4);
                return;
            } else {
                cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                i15++;
            }
        }
    }
}
