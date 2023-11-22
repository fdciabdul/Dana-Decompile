package com.alibaba.ariver.resource.content;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.fastjson.JSONObject;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class BaseStoragePackage implements ResourcePackage {
    private String b;

    /* renamed from: a */
    private final Map<String, Map<String, String>> f6223a = new ConcurrentHashMap();
    private boolean c = false;
    protected Map<String, Resource> mStorage = new ConcurrentHashMap();
    protected CountDownLatch mSetupLock = new CountDownLatch(1);
    protected CountDownLatch mParseLock = new CountDownLatch(1);

    public void afterParsePackage(ParseContext parseContext) {
    }

    public void beforeParsePackage(ParseContext parseContext) {
    }

    protected abstract String getLogTag();

    protected boolean needWaitSetupWhenGet() {
        return false;
    }

    public void onParsePackageSuccess(ParseContext parseContext) {
    }

    protected void setStorage(Map<String, Resource> map) {
        this.mStorage = map;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void add(Resource resource) {
        this.mStorage.put(resource.getUrl(), resource);
        Uri parseUrl = UrlUtils.parseUrl(resource.getUrl());
        if ("header.json".equals(resource.getUrl()) || "header.json".equals(parseUrl.getLastPathSegment())) {
            a(resource.getBytes());
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void remove(String str) {
        this.mStorage.remove(str);
    }

    public void onVerifyError(ParseFailedException parseFailedException) {
        ParseContext parseContext = parseFailedException.getParseContext();
        if (parseContext != null) {
            String logTag = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("onVerifyError, delete packagePath: ");
            sb.append(parseContext.packagePath);
            RVLogger.w(logTag, sb.toString());
            FileUtils.delete(parseContext.packagePath);
        }
    }

    public void parseContent(final String str, String str2) {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("parseContent installPath:");
        sb.append(str2);
        sb.append(" appId:");
        sb.append(str);
        RVLogger.d(logTag, sb.toString());
        if (TextUtils.isEmpty(str2)) {
            String logTag2 = getLogTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parseContent installPath is null, appId:");
            sb2.append(str);
            RVLogger.e(logTag2, sb2.toString());
        }
        try {
            final ParseContext parseContext = new ParseContext();
            parseContext.appId = str;
            parseContext.packagePath = str2;
            beforeParsePackage(parseContext);
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.content.BaseStoragePackage.1
                {
                    BaseStoragePackage.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map<String, String> map;
                    try {
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(RVTraceKey.RV_Package_parse_);
                            sb3.append(str);
                            RVTraceUtils.traceBeginSection(sb3.toString());
                            Iterator<Resource> it = PackageParseUtils.parsePackage(parseContext).values().iterator();
                            while (it.hasNext()) {
                                BaseStoragePackage.this.add(it.next());
                            }
                            BaseStoragePackage.this.onParsePackageSuccess(parseContext);
                            BaseStoragePackage.this.onPrepareDone(true);
                        } catch (ParseFailedException e) {
                            e.setParseContext(parseContext);
                            BaseStoragePackage.this.onVerifyError(e);
                            BaseStoragePackage.this.onPrepareDone(false);
                        }
                        BaseStoragePackage.this.onParseDone();
                        for (String str3 : BaseStoragePackage.this.getResourceHeaderMap().keySet()) {
                            Resource resource = BaseStoragePackage.this.get(ResourceQuery.asUrl(str3));
                            if (resource != null && (map = BaseStoragePackage.this.getResourceHeaderMap().get(str3)) != null) {
                                for (Map.Entry<String, String> entry : map.entrySet()) {
                                    resource.addHeader(entry.getKey(), entry.getValue());
                                }
                            }
                        }
                        BaseStoragePackage.this.afterParsePackage(parseContext);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(RVTraceKey.RV_Package_parse_);
                        sb4.append(str);
                        RVTraceUtils.traceEndSection(sb4.toString());
                    } catch (Throwable th) {
                        BaseStoragePackage.this.onPrepareDone(true);
                        BaseStoragePackage.this.onParseDone();
                        throw th;
                    }
                }
            });
        } catch (Exception e) {
            RVLogger.e(getLogTag(), "parseContent exception!", e);
            onParseDone();
            onPrepareDone(false);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void waitForSetup() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("waitForSetup (");
        sb.append(this.mSetupLock.getCount());
        sb.append(") with stack: ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.w(logTag, sb.toString());
        try {
            this.mSetupLock.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RVLogger.e(getLogTag(), "waitForSetup error", e);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void waitForParse() {
        try {
            this.mParseLock.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RVLogger.e(getLogTag(), "waitForSetup error", e);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean isPrepareDone() {
        return this.mSetupLock.getCount() == 0;
    }

    public void onPrepareDone(boolean z) {
        this.mSetupLock.countDown();
    }

    public void onParseDone() {
        this.mParseLock.countDown();
    }

    protected Map<String, Map<String, String>> getResourceHeaderMap() {
        return this.f6223a;
    }

    private void a(byte[] bArr) {
        this.f6223a.clear();
        String str = new String(bArr);
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("addHeader from header.json: ");
        sb.append(str);
        RVLogger.d(logTag, sb.toString());
        JSONObject parseObject = JSONUtils.parseObject(str);
        if (parseObject == null || parseObject.size() <= 0) {
            return;
        }
        for (String str2 : new HashSet(parseObject.keySet())) {
            JSONObject jSONObject = JSONUtils.getJSONObject(parseObject, str2, null);
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                for (String str3 : jSONObject.keySet()) {
                    String string = JSONUtils.getString(jSONObject, str3);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str3, string);
                    }
                }
                this.f6223a.put(str2, hashMap);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        return getFromStorage(resourceQuery.pureUrl);
    }

    public Resource getFromStorage(String str) {
        if (this.mSetupLock.getCount() > 0) {
            if (needWaitSetupWhenGet()) {
                RVLogger.d(getLogTag(), "get resource wait for mSetupLock!");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    this.mSetupLock.await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
                String logTag = getLogTag();
                StringBuilder sb = new StringBuilder();
                sb.append("wait for mSetupLock cost: ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                RVLogger.d(logTag, sb.toString());
            }
            if (this.mParseLock.getCount() > 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                RVLogger.d(getLogTag(), "get resource wait for parseLock!");
                try {
                    this.mParseLock.await(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    RVLogger.w(getLogTag(), "wait parse exception ", e);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                String logTag2 = getLogTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("wait for parseLock cost: ");
                sb2.append(System.currentTimeMillis() - currentTimeMillis2);
                RVLogger.d(logTag2, sb2.toString());
                if (currentTimeMillis3 - currentTimeMillis2 >= 3000) {
                    this.b = "wait_appParse_timeout";
                    this.mParseLock.countDown();
                }
            }
        }
        Resource resource = this.mStorage.get(str);
        if (resource == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = "notMatch";
            }
        } else {
            String logTag3 = getLogTag();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("load response ");
            sb3.append(str);
            RVLogger.d(logTag3, sb3.toString());
        }
        return resource;
    }

    public boolean contains(String str) {
        return this.mStorage.containsKey(str);
    }

    public CountDownLatch getSetupLock() {
        return this.mSetupLock;
    }

    public CountDownLatch getParseLock() {
        return this.mParseLock;
    }

    public boolean isDetached() {
        return this.c;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void teardown() {
        RVLogger.d(getLogTag(), "release storage");
        this.c = true;
        this.mStorage.clear();
    }

    protected boolean isEmpty() {
        return this.mStorage.isEmpty();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public Set<String> keySet() {
        return this.mStorage.keySet();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public int count() {
        return this.mStorage.size();
    }
}
