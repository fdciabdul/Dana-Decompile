package com.alibaba.ariver.resource.parser;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LowMemoryUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.parser.tar.TarEntry;
import com.alibaba.ariver.resource.parser.tar.TarFile;
import com.alibaba.ariver.resource.parser.tar.TarInputStream;
import com.alibaba.fastjson.JSONObject;
import io.split.android.client.service.ServiceConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class PackageParseUtils {
    private static final String LEGACY_TAR_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2y61svV7Q0gmvxprTt6YX76rps8R+q+C+Qtkkk2+njIABsf10sHnl/5aQBh2s+kdo6YGlJrnKdxVso2JRzy+QbRBUgTdJmKfm5uGPdcqYuO0ur4b/QCyHTMoKJjBT8iI3hYIGhn0hACDao4xIsgzJ39grRKUa6120WbInlOLWSQIDAQAB";
    private static final String NEW_SIGN_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl96KRuzoQDgt3q3478MYKwTGDV0Fz5w+sKOfz+Ar+/XkwqLjVW7bAk+/nOD9Z4mnwM+BsgU/G5KGQ9WMjcXAow/eRBSf93iqcBX5+DdlkbneNyQP7Mvcy8EwOAa3y7AetEpTeYrv5cppFUjq4TVu9w+DwV1qegfvJEAA+6gFJEcJPxD9fxJggCF02tL3k9/WDnaNYVN3dCq8fN4jWZLr6KWlAX5UW5ZVtXP9IWObFnvRNjgXQhW/LzJLdbcDlQ5U6ImFyIFf//vn3vEhzlpU6EkxdGr+FWwsRiMTY9aZ1fJiFlgAZQpInV6cbDM8LgNGPtDsYUibIi3rVFtYtHAxQwIDAQAB";
    public static final String TAG = "AriverRes:PackageParseUtils";
    private static LruCache<String, CachedParseResult> sParsedResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CachedParseResult {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f6230a;
        private String b;
        private Map<String, Resource> c;
        private ParseFailedException d;

        public CachedParseResult(boolean z) {
            if (z) {
                this.f6230a = new CountDownLatch(1);
            } else {
                this.f6230a = new CountDownLatch(0);
            }
        }
    }

    static {
        String config;
        int i = 10;
        try {
            config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_lru_pkg_count", "");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(config)) {
            int parseInt = Integer.parseInt(config);
            if (parseInt <= 10) {
                i = parseInt;
            }
            sParsedResult = new LruCache<>(i);
        }
        i = 3;
        sParsedResult = new LruCache<>(i);
    }

    public static void preParsePackage(AppModel appModel) {
        RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager == null || !rVResourceManager.isAvailable(appModel)) {
            RVLogger.d(TAG, "skip preParsePackage because not available!");
            return;
        }
        String installPath = ((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel);
        ParseContext parseContext = new ParseContext();
        parseContext.packagePath = installPath;
        parseContext.adaptAppModel(appModel);
        preParsePackage(parseContext);
    }

    public static void preParsePackage(ParseContext parseContext) {
        if (parseContext == null || TextUtils.isEmpty(parseContext.packagePath)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preParsePackage begin for ");
        sb.append(parseContext.packagePath);
        RVLogger.w(TAG, sb.toString());
        if (sParsedResult.get(getCacheKey(parseContext)) != null) {
            RVLogger.w(TAG, "preParsePackage but already contains in cache!");
            return;
        }
        CachedParseResult cachedParseResult = new CachedParseResult(true);
        cachedParseResult.b = parseContext.onlineHost;
        sParsedResult.put(getCacheKey(parseContext), cachedParseResult);
        try {
            Map<String, Resource> parsePackage = parsePackage(parseContext, true);
            if (parsePackage != null) {
                cachedParseResult.c = parsePackage;
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private static String getCacheKey(ParseContext parseContext) {
        return parseContext.packagePath;
    }

    static Map<String, Resource> getPreParsedPackage(ParseContext parseContext) throws ParseFailedException {
        String cacheKey = getCacheKey(parseContext);
        CachedParseResult cachedParseResult = sParsedResult.get(cacheKey);
        if (cachedParseResult == null) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            cachedParseResult.f6230a.await(5L, TimeUnit.SECONDS);
            StringBuilder sb = new StringBuilder();
            sb.append("getPreParsedPackage await preParse cost: ");
            sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.w(TAG, sb.toString());
            if (cachedParseResult.d != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getPreParsedPackage got exception!");
                sb2.append(cachedParseResult.d);
                RVLogger.w(TAG, sb2.toString());
                sParsedResult.remove(cacheKey);
                throw cachedParseResult.d;
            }
            if (LowMemoryUtils.onLowMemoryMode) {
                RVLogger.w(TAG, "onLowMemoryMode remove preParsedPackaged after use!");
                sParsedResult.remove(cacheKey);
            }
            if (cachedParseResult.c != null) {
                boolean z = !TextUtils.equals(parseContext.onlineHost, cachedParseResult.b);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getPreParsedPackage got data! size: ");
                sb3.append(cachedParseResult.c.size());
                sb3.append(" onlineHostChanged: ");
                sb3.append(z);
                RVLogger.d(TAG, sb3.toString());
                if (TextUtils.isEmpty(parseContext.templateAppId) && !z) {
                    return cachedParseResult.c;
                }
                if (!TextUtils.isEmpty(parseContext.onlineHost)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("getPreParsedPackage replace vhost ");
                    sb4.append(cachedParseResult.b);
                    sb4.append(" to ");
                    sb4.append(parseContext.onlineHost);
                    RVLogger.d(TAG, sb4.toString());
                    HashMap hashMap = new HashMap(cachedParseResult.c.size());
                    for (Map.Entry entry : cachedParseResult.c.entrySet()) {
                        String replace = ((String) entry.getKey()).replace(cachedParseResult.b, parseContext.onlineHost);
                        hashMap.put(replace, new OfflineResource(replace, ((Resource) entry.getValue()).getBytes()));
                    }
                    return hashMap;
                }
            }
            return null;
        } catch (InterruptedException e) {
            RVLogger.w(TAG, "getPreParsedPackage await preParse exception!", e);
            return null;
        }
    }

    public static Map<String, Resource> parsePackage(ParseContext parseContext) throws ParseFailedException {
        return parsePackage(parseContext, false);
    }

    public static Map<String, Resource> parsePackage(ParseContext parseContext, boolean z) throws ParseFailedException {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("parsePackage with ");
            sb.append(parseContext);
            RVLogger.d(TAG, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RVTraceKey.RV_ContentPackage_parse_);
            sb2.append(parseContext.appId);
            RVTraceUtils.traceBeginSection(sb2.toString());
            if (parseContext.packagePath == null) {
                throw new ParseFailedException(2, "PACKAGE_PATH_NULL");
            }
            if (!z) {
                try {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(RVTraceKey.RV_ContentPackage_waitPrepare_);
                    sb3.append(parseContext.appId);
                    RVTraceUtils.traceBeginSection(sb3.toString());
                    Map<String, Resource> preParsedPackage = getPreParsedPackage(parseContext);
                    if (preParsedPackage != null) {
                        parseContext.fromCache = true;
                        RVLogger.d(TAG, "parsePackage hit cache!");
                        return preParsedPackage;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(RVTraceKey.RV_ContentPackage_waitPrepare_);
                    sb4.append(parseContext.appId);
                    RVTraceUtils.traceEndSection(sb4.toString());
                } finally {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(RVTraceKey.RV_ContentPackage_waitPrepare_);
                    sb5.append(parseContext.appId);
                    RVTraceUtils.traceEndSection(sb5.toString());
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = parseContext.packagePath;
            if (str2 == null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("INVALID_PARAM packagePath is null, appId");
                sb6.append(parseContext.appId);
                throw new ParseFailedException(1, sb6.toString());
            }
            File file = new File(str2);
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                RVLogger.e(TAG, "childrenFiles length == 0");
                throw new ParseFailedException(2, "OFFLINE_PATH_NOT_EXIST");
            }
            if (parseContext.needVerify) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(RVTraceKey.RV_ContentPackage_verify_);
                sb7.append(parseContext.appId);
                RVTraceUtils.traceBeginSection(sb7.toString());
                verifyPackage(parseContext, str2, listFiles);
                StringBuilder sb8 = new StringBuilder();
                sb8.append(RVTraceKey.RV_ContentPackage_verify_);
                sb8.append(parseContext.appId);
                RVTraceUtils.traceEndSection(sb8.toString());
            }
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                long lastModified = file.lastModified();
                boolean lastModified2 = file.setLastModified(currentTimeMillis2);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("lastModified ");
                sb9.append(lastModified);
                sb9.append(" setResult:");
                sb9.append(lastModified2);
                sb9.append(" newTime:");
                sb9.append(currentTimeMillis2);
                sb9.append(" cost:");
                sb9.append(System.currentTimeMillis() - currentTimeMillis2);
                RVLogger.d(TAG, sb9.toString());
            } catch (Throwable th) {
                RVLogger.e(TAG, "lastModified exception!", th);
            }
            if (parseContext.mainFileName == null) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(parseContext.appId);
                sb10.append(".tar");
                str = sb10.toString();
            } else {
                str = parseContext.mainFileName;
            }
            String combinePath = FileUtils.combinePath(parseContext.packagePath, str);
            HashMap hashMap = new HashMap();
            try {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(RVTraceKey.RV_ContentPackage_read_);
                sb11.append(parseContext.appId);
                RVTraceUtils.traceBeginSection(sb11.toString());
                fastReadTarIntoMemory(hashMap, combinePath, parseContext);
                StringBuilder sb12 = new StringBuilder();
                sb12.append(RVTraceKey.RV_ContentPackage_read_);
                sb12.append(parseContext.appId);
                RVTraceUtils.traceEndSection(sb12.toString());
                if (!LowMemoryUtils.onLowMemoryMode && !z && hashMap.size() > 0 && parseContext.needCache) {
                    CachedParseResult cachedParseResult = new CachedParseResult(false);
                    cachedParseResult.b = parseContext.onlineHost;
                    cachedParseResult.c = hashMap;
                    sParsedResult.put(getCacheKey(parseContext), cachedParseResult);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("parse package ");
                sb13.append(parseContext.appId);
                sb13.append(" elapse ");
                sb13.append(System.currentTimeMillis() - currentTimeMillis);
                RVLogger.d(TAG, sb13.toString());
                return hashMap;
            } finally {
            }
        } finally {
            StringBuilder sb14 = new StringBuilder();
            sb14.append(RVTraceKey.RV_ContentPackage_parse_);
            sb14.append(parseContext.appId);
            RVTraceUtils.traceEndSection(sb14.toString());
        }
    }

    private static void verifyPackage(ParseContext parseContext, String str, File[] fileArr) {
        JSONObject parseObject;
        String legacySignPublicKey;
        String combinePath = FileUtils.combinePath(str, "CERT.json");
        String combinePath2 = FileUtils.combinePath(str, "SIGN.json");
        if (!FileUtils.exists(combinePath) && !FileUtils.exists(combinePath2)) {
            RVLogger.w(TAG, "cert not exists!");
            throw new ParseFailedException(4, "CERT_PATH_NOT_EXIST");
        }
        boolean exists = FileUtils.exists(combinePath2);
        StringBuilder sb = new StringBuilder();
        sb.append("useNewSignKey : ");
        sb.append(exists);
        RVLogger.d(TAG, sb.toString());
        if (exists) {
            parseObject = JSONUtils.parseObject(IOUtils.read(combinePath2));
            legacySignPublicKey = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getNewSignPublicKey(parseContext.appId);
            if (TextUtils.isEmpty(legacySignPublicKey)) {
                legacySignPublicKey = NEW_SIGN_PUBLIC_KEY;
            }
        } else {
            parseObject = JSONUtils.parseObject(FileUtils.read(combinePath));
            legacySignPublicKey = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getLegacySignPublicKey(parseContext.appId);
            if (TextUtils.isEmpty(legacySignPublicKey)) {
                legacySignPublicKey = LEGACY_TAR_PUBLIC_KEY;
            }
        }
        if (parseObject == null || parseObject.isEmpty()) {
            RVLogger.e(TAG, "joCert is empty");
            throw new ParseFailedException(5, "TAR_SIGNATURE_IS_EMPTY");
        }
        try {
            for (File file : fileArr) {
                String name = file.getName();
                long currentTimeMillis = System.currentTimeMillis();
                if (!inBlackList(parseContext, name)) {
                    Object obj = parseObject.get(name);
                    if (obj == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("entry ");
                        sb2.append(name);
                        sb2.append(" has no cert!");
                        throw new ParseFailedException(6, sb2.toString());
                    }
                    String obj2 = obj.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("/");
                    sb3.append(name);
                    boolean verify = RsaUtil.verify(sb3.toString(), legacySignPublicKey, obj2);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("signKey ");
                    sb4.append(name);
                    sb4.append(" signValue ");
                    sb4.append(obj2);
                    sb4.append(" result:");
                    sb4.append(verify);
                    sb4.append(" cost:");
                    sb4.append(System.currentTimeMillis() - currentTimeMillis);
                    RVLogger.d(TAG, sb4.toString());
                    if (!verify) {
                        throw new ParseFailedException(6, "VERIFY_FAIL");
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            throw new ParseFailedException(7, e.getMessage());
        }
    }

    private static boolean inBlackList(ParseContext parseContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (parseContext.ignorePatterns != null) {
            Iterator<Pattern> it = parseContext.ignorePatterns.iterator();
            while (it.hasNext()) {
                if (it.next().matcher(str).matches()) {
                    return true;
                }
            }
        }
        return TextUtils.equals(str, "CERT.json") || TextUtils.equals(str, "SIGN.json") || str.startsWith(RVConstants.PKG_EXT_PREFIX) || str.startsWith(RVConstants.PKG_XRIVER_EXT_PREFIX) || str.startsWith(RVConstants.SUB_PACKAGE_DIR_PREFIX) || str.contains("ios") || str.contains("hpmfile.json");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void fastReadTarIntoMemory(Map<String, Resource> map, String str, ParseContext parseContext) throws IOException {
        TarInputStream tarInputStream;
        long calculateSize = FileUtils.calculateSize(str);
        TarInputStream tarInputStream2 = null;
        if (IOUtils.isNIOEnabled() && calculateSize <= ServiceConstants.MAX_EVENTS_SIZE_BYTES && calculateSize >= 65536) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse tar file with NIO ");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            byte[] buf = IOUtils.getBuf(2048);
            try {
                TarFile tarFile = new TarFile(str);
                while (true) {
                    try {
                        TarEntry nextEntry = tarFile.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (!nextEntry.isDirectory() && !TextUtils.isEmpty(name) && !inBlackList(parseContext, name)) {
                                PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                                while (true) {
                                    int read = tarFile.read(buf);
                                    if (read == -1) {
                                        break;
                                    }
                                    poolingByteArrayOutputStream.write(buf, 0, read);
                                }
                                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                                IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                if (byteArray != null) {
                                    putData(map, parseContext, name, byteArray);
                                }
                            }
                        } else {
                            IOUtils.returnBuf(buf);
                            IOUtils.closeQuietly(tarFile);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        tarInputStream2 = tarFile;
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(tarInputStream2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parse tar file with Stream ");
            sb2.append(str);
            RVLogger.d(TAG, sb2.toString());
            try {
                tarInputStream = new TarInputStream(new BufferedInputStream(new FileInputStream(str)));
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                readTarStreamIntoMemory(map, tarInputStream, parseContext);
                IOUtils.closeQuietly(tarInputStream);
            } catch (Throwable th4) {
                th = th4;
                tarInputStream2 = tarInputStream;
                IOUtils.closeQuietly(tarInputStream2);
                throw th;
            }
        }
    }

    public static void readTarStreamIntoMemory(Map<String, Resource> map, TarInputStream tarInputStream, ParseContext parseContext) throws IOException {
        byte[] buf = IOUtils.getBuf(2048);
        while (true) {
            try {
                TarEntry nextEntry = tarInputStream.getNextEntry();
                if (nextEntry == null) {
                    return;
                }
                String name = nextEntry.getName();
                if (!nextEntry.isDirectory() && !TextUtils.isEmpty(name) && !inBlackList(parseContext, name)) {
                    PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                    while (true) {
                        int read = tarInputStream.read(buf);
                        if (read == -1) {
                            break;
                        }
                        poolingByteArrayOutputStream.write(buf, 0, read);
                    }
                    byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(poolingByteArrayOutputStream);
                    if (byteArray != null) {
                        putData(map, parseContext, name, byteArray);
                    }
                }
            } finally {
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(tarInputStream);
            }
        }
    }

    private static void putData(Map<String, Resource> map, ParseContext parseContext, String str, byte[] bArr) {
        if (!str.startsWith("_animation")) {
            if (TextUtils.isEmpty(parseContext.onlineHost)) {
                if (str.contains("/")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://");
                    sb.append(str);
                    str = sb.toString();
                }
            } else {
                str = FileUtils.combinePath(parseContext.onlineHost, str);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("readTarStreamIntoMemory entryName ");
        sb2.append(str);
        RVLogger.d(TAG, sb2.toString());
        map.put(str, new OfflineResource(str, bArr));
    }
}
